package gr.kokkoentry.test;


import java.io.File;
import java.io.IOException;
import java.util.Locale;

import jxl.Cell;
import jxl.CellView;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ParseExcelFileCreateUpdateSqlStatementForAlarmId {

	private String inputFile;
	
  private WritableCellFormat timesBoldUnderline;
  private WritableCellFormat times;
  

	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	public void read() throws IOException  {
		File inputWorkbook = new File(inputFile);
		Workbook w;
		try {
//			WorkbookSettings ws = new WorkbookSettings();
//			ws.setEncoding("Cp1252");
//			w = Workbook.getWorkbook(inputWorkbook, ws);
			w = Workbook.getWorkbook(inputWorkbook);
			
			// Get the first sheet
			Sheet sheet = w.getSheet(0);
			// Loop over first 10 column and lines


			for (int i = 1; i < sheet.getRows(); i++) {
				int columnId = 0;
				int columnCondDesc = 5;
				int columnPropAction = 6;
				Cell cellId = sheet.getCell(columnId, i);
				Cell cellCondDesc = sheet.getCell(columnCondDesc, i);
				Cell cellPropAction= sheet.getCell(columnPropAction, i);

				 
				String idStr = cellId.getContents();
				String condDescStr = cellCondDesc.getContents();
				String propActionStr = cellPropAction.getContents();
				
				System.out.println("idStr " + idStr + "condDescStr :"
						+ condDescStr + "condDescStr :" + propActionStr);
				

			}
			
			
			

		} catch (BiffException e) {
			e.printStackTrace();
		}
	}
	
	
	public void write() throws IOException, WriteException {
    File file = new File(inputFile);
    WorkbookSettings wbSettings = new WorkbookSettings();

    wbSettings.setLocale(new Locale("en", "EN"));

    WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
    workbook.createSheet("Report", 0);
    WritableSheet excelSheet = workbook.getSheet(0);
    createLabel(excelSheet);
    createContent(excelSheet);

    workbook.write();
    workbook.close();
  }

  private void createLabel(WritableSheet sheet)
      throws WriteException {
    // Lets create a k font
    WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
    // Define the cell format
    times = new WritableCellFormat(times10pt);
    // Lets automatically wrap the cells
    times.setWrap(true);

    // Create create a bold font with unterlines
    WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, false,
        UnderlineStyle.SINGLE);
    timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
    // Lets automatically wrap the cells
    timesBoldUnderline.setWrap(true);

    CellView cv = new CellView();
    cv.setFormat(times);
    cv.setFormat(timesBoldUnderline);
    cv.setAutosize(true);

    // Write a few headers
    addCaption(sheet, 0, 0, "Header 1");
    addCaption(sheet, 1, 0, "This is another header");
    

  }

  private void createContent(WritableSheet sheet) throws WriteException,
      RowsExceededException {
    // Write a few number
    for (int i = 1; i < 10; i++) {
      // First column
      addNumber(sheet, 0, i, i + 10);
      // Second column
      addNumber(sheet, 1, i, i * i);
    }
    // Lets calculate the sum of it
    StringBuffer buf = new StringBuffer();
    buf.append("SUM(A2:A10)");
    Formula f = new Formula(0, 10, buf.toString());
    sheet.addCell(f);
    buf = new StringBuffer();
    buf.append("SUM(B2:B10)");
    f = new Formula(1, 10, buf.toString());
    sheet.addCell(f);

    // Now a bit of text
    for (int i = 12; i < 20; i++) {
      // First column
      addLabel(sheet, 0, i, "Boring text " + i);
      // Second column
      addLabel(sheet, 1, i, "Another text");
    }
  }

  private void addCaption(WritableSheet sheet, int column, int row, String s)
      throws RowsExceededException, WriteException {
    Label label;
    label = new Label(column, row, s, timesBoldUnderline);
    sheet.addCell(label);
  }

  public void addNumber(WritableSheet sheet, int column, int row,
      Integer integer) throws WriteException, RowsExceededException {
    Number number;
    number = new Number(column, row, integer, times);
    sheet.addCell(number);
  }

  public void addLabel(WritableSheet sheet, int column, int row, String s)
      throws WriteException, RowsExceededException {
    Label label;
    label = new Label(column, row, s, times);
    sheet.addCell(label);
  }
  
  public void addFormula(WritableSheet sheet, int column, int row, String formulaStr)
	      throws WriteException, RowsExceededException {
	  Formula formula;
	  formula = new Formula(column, row, formulaStr );
	    sheet.addCell(formula);
	  }
  

	public static void main(String[] args) throws IOException {
	  try{
		String filePathWindosOS = "C:\\Users\\gerassimos\\Devel\\kokkodentry\\files\\test1.xls";
//		String filePathLinuxOS = "/home/gerassimos/workspace/kokkodentry/files/test1.xls";
		ParseExcelFileCreateUpdateSqlStatementForAlarmId test = new ParseExcelFileCreateUpdateSqlStatementForAlarmId();
		test.setInputFile(filePathWindosOS);
//		test.read();
		test.write();
	  }catch(Exception e){
	    e.printStackTrace();
	  }
	}
	
	public static void dumpString(String text)
	{
	    for (int i=0; i < text.length(); i++)
	    {
	        System.out.println("U+" + Integer.toString(text.charAt(i), 16) 
	                           + " " + text.charAt(i));
	    }
	}

} 