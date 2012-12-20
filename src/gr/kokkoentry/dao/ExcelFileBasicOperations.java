package gr.kokkoentry.dao;

import gr.kokkoentry.dao.Constants.ORIKTA_ENUM;
import gr.kokkoentry.model.BeanPerOre;
import gr.kokkoentry.model.OresPerSieve;
import gr.kokkoentry.model.Sample;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellView;
import jxl.Sheet;
import jxl.Workbook;
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

public class ExcelFileBasicOperations {

  private static final int ACTION_CREATE_CAPTION = 1;
  private static final int ACTION_ADD_SAMLE = 2;

  private String inputFile;

  private WritableCellFormat timesBoldUnderline;
  private WritableCellFormat times;

  public void setInputFile(String inputFile) {
    this.inputFile = inputFile;
  }

  public void read() throws IOException, BiffException {
    File inputWorkbook = new File(inputFile);
    Workbook w;
    // WorkbookSettings ws = new WorkbookSettings();
    // ws.setEncoding("Cp1252");
    // w = Workbook.getWorkbook(inputWorkbook, ws);
    w = Workbook.getWorkbook(inputWorkbook);
    // Get the first sheet
    Sheet sheet = w.getSheet(0);
    // Loop over first 10 column and lines
    System.out.println("Nr of Rows: " + sheet.getRows());
  }

  // initialize file with caption
  public void initializeFileWithCaption() throws IOException, BiffException,
  WriteException {
    File inputWorkbook = new File(inputFile);
    Workbook workbook = Workbook.getWorkbook(inputWorkbook);
    // Get the first sheet
    Sheet sheet = workbook.getSheet(0);

    if (!isCaptionAvailable(sheet, 4)) {
      write(null, 0,0, ACTION_CREATE_CAPTION);
    }

  }

  public void addSample(Sample sample,int offset, int row) throws IOException, BiffException,	WriteException {
    write(sample, 0,0, ACTION_ADD_SAMLE);
  }
  
  public Sample readSample(int offset, int row) throws IOException, BiffException, WriteException {
    Sample sample = new Sample();
    File inputWorkbook = new File(inputFile);
    Workbook workbook = Workbook.getWorkbook(inputWorkbook);
    Sheet sheet = workbook.getSheet(0);
    int column = 0;
    OresPerSieve [] oresPerSieveArray = sample.getOresPerSieveArray();
    for (int i = 0; i < Constants.NR_OF_KOSKINA; i++) {
      OresPerSieve oresPerSieve = oresPerSieveArray[i];
      BeanPerOre[] beanPerOreArray = oresPerSieve.getBeanPerOreArray();
      for (BeanPerOre beanPerOre : beanPerOreArray) {
        column = offset + beanPerOre.getRelativePosition() + (i * ORIKTA_ENUM.values().length);
        Cell cellId = sheet.getCell(column, row);
        String cellStr = cellId.getContents();
        beanPerOre.setNrOfBeans(new Integer(cellStr));
      }
    }
    return  sample;
  }

  private void write(Sample sample,int offset, int row,int action) throws IOException, WriteException, BiffException {
    WritableWorkbook workbook = null;
    try {
      File file = new File(inputFile);
      Workbook workbookRead = Workbook.getWorkbook(file);
      workbook = Workbook.createWorkbook(file, workbookRead);
      WritableSheet excelSheet = workbook.getSheet(0);
      createLabel(excelSheet);

      switch (action) {
      case ACTION_CREATE_CAPTION: {
        createCaption(excelSheet);
        break;
      }
      case ACTION_ADD_SAMLE: {
        createContent(excelSheet);
        addSamle(excelSheet, sample, offset, row);
        break;
      }
      }

      workbook.write();

    } finally {
      if (workbook != null) {
        workbook.close();
      }
    }
  }

  public WritableSheet getWritableSheet() throws IOException, WriteException,
  BiffException {
    File file = new File(inputFile);
    Workbook workbookRead = Workbook.getWorkbook(file);
    WritableWorkbook workbook = Workbook.createWorkbook(file, workbookRead);
    WritableSheet excelSheet = workbook.getSheet(0);
    createLabel(excelSheet);
    return excelSheet;
  }

  private void createLabel(WritableSheet sheet) throws WriteException {
    // Lets create a k font
    WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
    // Define the cell format
    times = new WritableCellFormat(times10pt);
    // Lets automatically wrap the cells
    times.setWrap(true);

    // Create create a bold font with unterlines
    WritableFont times10ptBoldUnderline = new WritableFont(
        WritableFont.TIMES, 10, WritableFont.BOLD, false,
        UnderlineStyle.SINGLE);
    timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
    // Lets automatically wrap the cells
    timesBoldUnderline.setWrap(true);

    CellView cv = new CellView();
    cv.setFormat(times);
    cv.setFormat(timesBoldUnderline);
    cv.setAutosize(true);

    // Write a few headers
    // addCaption(sheet, 0, 0, "Header 1");
    // addCaption(sheet, 1, 0, "This is another header");

  }

  private void createCaption(WritableSheet sheet) throws WriteException {
    int column = 0;
    int offset = 4;

    for (int i = 0; i < Constants.NR_OF_KOSKINA; i++) {
      int j = 0;
      for (String header : ORIKTA_ENUM.getDisplayNames()) {
        column = offset + j + (i * ORIKTA_ENUM.values().length);
        addCaption(sheet, column, 0, header + i);
        j++;
      }
    }

  }

  private boolean isCaptionAvailable(Sheet sheet, int offset) {
    boolean result = true;
    int column = 0;
    for (int i = 0; i < Constants.NR_OF_KOSKINA; i++) {
      int j = 0;
      for (String header : ORIKTA_ENUM.getDisplayNames()) {
        column = offset + j + (i * ORIKTA_ENUM.values().length);
        // addCaption(sheet, column, 0, header + i );
        String header_Plus_Koskino = header + i;
        Cell cellId = sheet.getCell(column, 0);
        String cellStr = cellId.getContents();
        System.out.println(header_Plus_Koskino + " - " + cellStr);
        if (!header_Plus_Koskino.equals(cellStr)) {
          result = false;
          break;
        }
        j++;
      }
    }
    return result;

  }

  private void createContent(WritableSheet sheet) throws WriteException,
  RowsExceededException {
    // Write a few number
    for (int i = 1; i < 10; i++) {

      int startingColumn = 4;
      int column = i;
      int row = 8;

      addNumber(sheet, startingColumn + column, row, i + 8);
      // Second column
      // addNumber(sheet, 1, i, i * i);
    }

  }

  private void addSamle(WritableSheet sheet, Sample sample ,int offset, int row) throws WriteException,	RowsExceededException {
    int column = 0;
    OresPerSieve [] oresPerSieveArray = sample.getOresPerSieveArray();
    for (int i = 0; i < Constants.NR_OF_KOSKINA; i++) {
      OresPerSieve oresPerSieve = oresPerSieveArray[i];
      BeanPerOre[] beanPerOreArray = oresPerSieve.getBeanPerOreArray();
      for (BeanPerOre beanPerOre : beanPerOreArray) {
        column = offset + beanPerOre.getRelativePosition() + (i * ORIKTA_ENUM.values().length);
        // addCaption(sheet, column, 0, header + i );
        System.out.println("add "+ beanPerOre.getOreName()+" : "+ beanPerOre.getNrOfBeans());
        addNumber(sheet, column, row, beanPerOre.getNrOfBeans());
      }
    }


  }

  public void addCaption(WritableSheet sheet, int column, int row, String s)
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

  public void addFormula(WritableSheet sheet, int column, int row,
      String formulaStr) throws WriteException, RowsExceededException {
    Formula formula;
    formula = new Formula(column, row, formulaStr);
    sheet.addCell(formula);
  }

  public static void main(String[] args) throws IOException {
    try {
      String filePathWindosOS = "C:\\Users\\gerassimos\\Devel\\kokkodentry\\files\\test1.xls";
      String filePathLinuxOS =	 "/home/gerassimos/workspace/kokkodentry/files/test1.xls";
      ExcelFileBasicOperations test = new ExcelFileBasicOperations();
      test.setInputFile(filePathWindosOS);
      test.read();
      test.initializeFileWithCaption();
      Sample sample = generateSample();
      test.write(sample, 3, 20, ACTION_ADD_SAMLE);
      // successfully
      System.out.println("Write successfully");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static Sample generateSample() {
    Sample result = new Sample();

    OresPerSieve [] oresPerSieveArray = result.getOresPerSieveArray();
    for (int i = 0; i < Constants.NR_OF_KOSKINA; i++) {
      OresPerSieve oresPerSieve = oresPerSieveArray[i];
      BeanPerOre[] beanPerOreArray = oresPerSieve.getBeanPerOreArray();
      for (BeanPerOre beanPerOre : beanPerOreArray) {
        beanPerOre .setNrOfBeans(2);
        // addCaption(sheet, column, 0, header + i );
        System.out.println("add "+ beanPerOre.getOreName()+" : "+ beanPerOre.getNrOfBeans());

      }
    }

    return result;
  }
}