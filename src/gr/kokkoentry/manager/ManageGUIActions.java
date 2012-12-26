package gr.kokkoentry.manager;

import gr.kokkoentry.dao.ExcelFileBasicOperations;
import gr.kokkoentry.gui.FileChooserJPanel;
import gr.kokkoentry.gui.HeadJPanel;
import gr.kokkoentry.gui.MainGUI;
import gr.kokkoentry.gui.OresFieldsJPanel;
import gr.kokkoentry.model.Sample;

import java.io.File;
import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class ManageGUIActions {

  public static void updateGUIModel() throws BiffException, WriteException, IOException {
    ExcelFileBasicOperations excelFileBasicOperations = new ExcelFileBasicOperations();
    
    MainGUI runningInstanceOFMainGUI = MainGUI.getRunningInstanceOFMainGUI();
//    HeadJPanel headJPanel = runningInstanceOFMainGUI.getJ
    HeadJPanel headJPanel = (HeadJPanel) runningInstanceOFMainGUI.getHeadJPanel() ;
    OresFieldsJPanel oresFieldsJPanel = (OresFieldsJPanel) runningInstanceOFMainGUI.getOresFieldsJPanel() ;
    FileChooserJPanel fileChooserJPanel = (FileChooserJPanel) runningInstanceOFMainGUI.getFileChooserJPanel() ;
    
    //AAA
    File selectedFile = fileChooserJPanel .getSelectedFile();
    int selectedRow = fileChooserJPanel .getSelectedRow();
    int selectedColumnOffset = fileChooserJPanel .getSelectedColumnOffset();
    
    excelFileBasicOperations.setInputFile(selectedFile .getAbsolutePath());
    
    Sample sample = excelFileBasicOperations.readSample(selectedColumnOffset, selectedRow);
    System.out.println("Sample : "+sample.toString());
    
    headJPanel.updateModelFromSample(sample.getSampleIndex() );
    oresFieldsJPanel.updateModelFromSample(sample);
    
    
  }
  
  public static void initializeFileWithCaption() throws BiffException, WriteException, IOException {
    ExcelFileBasicOperations excelFileBasicOperations = new ExcelFileBasicOperations();
    MainGUI runningInstanceOFMainGUI = MainGUI.getRunningInstanceOFMainGUI();
    FileChooserJPanel fileChooserJPanel = (FileChooserJPanel) runningInstanceOFMainGUI.getFileChooserJPanel() ;
    File selectedFile = fileChooserJPanel .getSelectedFile();
    int selectedColumnOffset = fileChooserJPanel .getSelectedColumnOffset();
    excelFileBasicOperations.setInputFile(selectedFile .getAbsolutePath());
    excelFileBasicOperations.initializeFileWithCaption(selectedColumnOffset);
  }
  
  
  public static void saveGUIModel() throws BiffException, WriteException, IOException {
    ExcelFileBasicOperations excelFileBasicOperations = new ExcelFileBasicOperations();
    
    MainGUI runningInstanceOFMainGUI = MainGUI.getRunningInstanceOFMainGUI();
//    HeadJPanel headJPanel = runningInstanceOFMainGUI.getJ
    HeadJPanel headJPanel = (HeadJPanel) runningInstanceOFMainGUI.getHeadJPanel() ;
    OresFieldsJPanel oresFieldsJPanel = (OresFieldsJPanel) runningInstanceOFMainGUI.getOresFieldsJPanel() ;
    FileChooserJPanel fileChooserJPanel = (FileChooserJPanel) runningInstanceOFMainGUI.getFileChooserJPanel() ;
    
    //AAA
    File selectedFile = fileChooserJPanel .getSelectedFile();
    int selectedRow = fileChooserJPanel .getSelectedRow();
    int selectedColumnOffset = fileChooserJPanel .getSelectedColumnOffset();
    
    excelFileBasicOperations.setInputFile(selectedFile .getAbsolutePath());
    
    Sample sample = oresFieldsJPanel.getSample();
    sample.setSampleIndex(headJPanel.getSampleIndex());
    excelFileBasicOperations.addSample(sample, selectedColumnOffset, selectedRow);
    
  }

}
