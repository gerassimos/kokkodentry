package gr.kokkoentry.dao;

import gr.kokkoentry.dao.Constants.ORIKTA_ENUM;
import gr.kokkoentry.model.BeanPerOre;
import gr.kokkoentry.model.OresPerSieve;
import gr.kokkoentry.model.Sample;
import gr.kokkoentry.model.SampleIndex;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellView;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Colour;
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

  private WritableCellFormat cellFormatForHeadCaption;
  private WritableCellFormat cellFormat;

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
  public void initializeFileWithCaption(int selectedColumnOffset) throws IOException, BiffException,
  WriteException {
    File inputWorkbook = new File(inputFile);
    Workbook workbook = Workbook.getWorkbook(inputWorkbook);
    // Get the first sheet
    Sheet sheet = workbook.getSheet(0);

    if (!isCaptionAvailable(sheet, selectedColumnOffset)) {
      write(null, selectedColumnOffset,0, ACTION_CREATE_CAPTION);
    }

  }

  public void addSample(Sample sample,int offset, int row) throws IOException, BiffException,	WriteException {
    write(sample, offset,row, ACTION_ADD_SAMLE);
  }

  public Sample readSample(int offset, int row) throws IOException, BiffException, WriteException {
    Sample sample = new Sample();
    File inputWorkbook = new File(inputFile);
    Workbook workbook = Workbook.getWorkbook(inputWorkbook);
    Sheet sheet = workbook.getSheet(0);
    SampleIndex sampleIndex  =sample.getSampleIndex();
    sampleIndex.setArea(sheet.getCell(0, row).getContents());
    sampleIndex.setAa(sheet.getCell(1, row).getContents());
    sampleIndex.setScv(sheet.getCell(2, row).getContents());
    sampleIndex.setTopdist(sheet.getCell(3, row).getContents());
    sampleIndex.setDate(sheet.getCell(4, row).getContents());
    sampleIndex.setDepth(sheet.getCell(5, row).getContents());
    sampleIndex.setColor(sheet.getCell(6, row).getContents());

    int column = 0;
    OresPerSieve [] oresPerSieveArray = sample.getOresPerSieveArray();
    for (int i = 0; i < Constants.NR_OF_KOSKINA; i++) {
      OresPerSieve oresPerSieve = oresPerSieveArray[i];
      BeanPerOre[] beanPerOreArray = oresPerSieve.getBeanPerOreArray();
      for (BeanPerOre beanPerOre : beanPerOreArray) {
        column = offset + ORIKTA_ENUM.getEnumFromUniqueName( beanPerOre.getOreName()) .ordinal() + (i * ORIKTA_ENUM.values().length);
        Cell cellId = sheet.getCell(column, row);
        String cellStr = cellId.getContents();
        try{
          beanPerOre.setNrOfBeans(Integer.parseInt(cellStr));
        }
        catch (NumberFormatException e) {
          beanPerOre.setNrOfBeans(null);
        }catch (Exception e) {
          e.printStackTrace();
        }
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
        createCaption(excelSheet, offset , row);
        break;
      }
      case ACTION_ADD_SAMLE: {
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
    WritableFont times10pt = new WritableFont(WritableFont.ARIAL, 10);
    // Define the cell format
    cellFormat = new WritableCellFormat(times10pt);
    // Lets automatically wrap the cells
    cellFormat.setWrap(true);

    // Create create a bold font with unterlines
    WritableFont arial8ptRed = new WritableFont(
        WritableFont.ARIAL, 8, WritableFont.NO_BOLD, true,  UnderlineStyle.NO_UNDERLINE, Colour.RED);
    cellFormatForHeadCaption = new WritableCellFormat(arial8ptRed);
    // Lets automatically wrap the cells
    cellFormatForHeadCaption.setWrap(true);

    CellView cv = new CellView();
    cv.setFormat(cellFormat);
    cv.setFormat(cellFormatForHeadCaption);
    cv.setAutosize(true);

    // Write a few headers
    // addCaption(sheet, 0, 0, "Header 1");
    // addCaption(sheet, 1, 0, "This is another header");

  }

  private void createCaption(WritableSheet sheet,int columnOffset, int rowOffset) throws WriteException {
    int column = 0;


    for (int i = 0; i < Constants.NR_OF_KOSKINA; i++) {
      int j = 0;
      for (String header : ORIKTA_ENUM.getDisplayNames()) {
        column = columnOffset + j + (i * ORIKTA_ENUM.values().length);

        addCaption(sheet, column, rowOffset  , header + " k"+i);
        j++;
      }
    }

  }

  private boolean isCaptionAvailable(Sheet sheet, int offset) {
    boolean result = true;
    int column = 0;
    try{
      for (int i = 0; i < Constants.NR_OF_KOSKINA; i++) {
        int j = 0;
        for (String header : ORIKTA_ENUM.getDisplayNames()) {
          column = offset + j + (i * ORIKTA_ENUM.values().length);
          // addCaption(sheet, column, 0, header + i );
          String header_Plus_Koskino = header + " +"+i;
          Cell cellId = sheet.getCell(column, 0);
          String cellStr = cellId.getContents();
          //System.out.println(header_Plus_Koskino + " - " + cellStr);
          if (!header_Plus_Koskino.equals(cellStr)) {
            result = false;
            System.out.println("Caption is NOT available");
            break;
          }
          j++;
        }
        if(result==false){
          break;
        }
      }}
    catch (Exception e) {
      result = false;
    }
    return result;

  }


  private void addSamle(WritableSheet sheet, Sample sample ,int offset, int row) throws WriteException,	RowsExceededException {

    SampleIndex sampleIndex  =sample.getSampleIndex();
    addLabel(sheet, 0, row, sampleIndex.getArea());
    addLabel(sheet, 1, row, sampleIndex.getAa() );
    addLabel(sheet, 2, row, sampleIndex.getScv());
    addLabel(sheet, 3, row, sampleIndex.getTopdist());
    addLabel(sheet, 4, row, sampleIndex.getDate());
    addLabel(sheet, 5, row, sampleIndex.getDepth());
    addLabel(sheet, 6, row, sampleIndex.getColor());

    int column = 0;
    OresPerSieve [] oresPerSieveArray = sample.getOresPerSieveArray();
    for (int i = 0; i < Constants.NR_OF_KOSKINA; i++) {
      OresPerSieve oresPerSieve = oresPerSieveArray[i];
      BeanPerOre[] beanPerOreArray = oresPerSieve.getBeanPerOreArray();
      for (BeanPerOre beanPerOre : beanPerOreArray) {
        column = offset +ORIKTA_ENUM.getEnumFromUniqueName( beanPerOre.getOreName()).ordinal() + (i * ORIKTA_ENUM.values().length);
        if(beanPerOre.getNrOfBeans()!=null ){
          addNumber(sheet, column, row, beanPerOre.getNrOfBeans());
        }
      }
    }


  }

  public void addCaption(WritableSheet sheet, int column, int row, String s)
      throws RowsExceededException, WriteException {
    Label label;
    label = new Label(column, row, s, cellFormatForHeadCaption);
    sheet.addCell(label);
  }

  public void addNumber(WritableSheet sheet, int column, int row,
      Integer integer) throws WriteException, RowsExceededException {
    Number number;
    number = new Number(column, row, integer, cellFormat);
    sheet.addCell(number);
  }

  public void addLabel(WritableSheet sheet, int column, int row, String s)
      throws WriteException, RowsExceededException {
    Label label;
    label = new Label(column, row, s, cellFormat);
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
      //      String filePathLinuxOS =	 "/home/gerassimos/workspace/kokkodentry/files/test1.xls";
      ExcelFileBasicOperations test = new ExcelFileBasicOperations();
      test.setInputFile(filePathWindosOS);
      test.read();
      test.initializeFileWithCaption(10);
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