package gr.kokkoentry.gui;

import gr.kokkoentry.manager.ManageGUIActions;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/*
 * FileChooserDemo.java uses these files:
 *   images/Open16.gif
 *   images/Save16.gif
 */

/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class FileChooserJPanel extends JPanel implements ActionListener {

  private static final long serialVersionUID = 1L;
  static private final String newline = "\n";
  private static final int SELECTED_ROW_ON_STARTUP = 1;
  private static final int SAMPLE_COLUMN_OFFSET = 7;
  //previous logo
  JButton openButton, saveButton, nextButton, previousButton; 
  //  JTextArea log;
  JFileChooser fc;
  private File selectedFile;
  private JLabel jLabelSelectedFileName ;

  private int selectedRow;

  public FileChooserJPanel() {
    super(new BorderLayout());
    //For layout purposes, put the buttons in a separate panel
    JPanel buttonPanel = new JPanel(); //use FlowLayout
    //Add the buttons and the log to this panel.
    add(buttonPanel, BorderLayout.PAGE_START);

    openButton = new JButton("Open a File...", createImageIcon("images/Open16.gif"));
    saveButton = new JButton("Save", createImageIcon("images/Save16.gif"));
    nextButton = new JButton("Next", createImageIcon("images/Forward16.gif"));
    previousButton = new JButton("Previous", createImageIcon("images/Back16.gif"));
    jLabelSelectedFileName = new JLabel("No File selected");


    openButton.addActionListener(this);
    saveButton.addActionListener(this);
    nextButton.addActionListener(this);
    previousButton.addActionListener(this);

    fc = new JFileChooser();
    //Uncomment one of the following lines to try a different
    //file selection mode.  The first allows just directories
    //to be selected (and, at least in the Java look and feel,
    //shown).  The second allows both files and directories
    //to be selected.  If you leave these lines commented out,
    //then the default mode (FILES_ONLY) will be used.
    //
    //fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    //fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

    //Create the open button.  We use the image from the JLF
    //Graphics Repository (but we extracted it from the jar).

    //Create the save button.  We use the image from the JLF
    //Graphics Repository (but we extracted it from the jar).

    buttonPanel.add(openButton);
    buttonPanel.add(saveButton);
    buttonPanel.add(previousButton);
    buttonPanel.add(nextButton);
    buttonPanel.add(jLabelSelectedFileName);
  }

  public void actionPerformed(ActionEvent e) {

    //=================================
    // OPEN
    //=================================
    if (e.getSource() == openButton) {
      int returnVal = fc.showOpenDialog(FileChooserJPanel.this);

      if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fc.getSelectedFile();
        selectedFile = fc.getSelectedFile();
        jLabelSelectedFileName.setText("Selected File: "+selectedFile.getName());
        if (isValid(selectedFile)){
          setSelectedRow(SELECTED_ROW_ON_STARTUP);
          boolean initializeFileWithCaption =true;
          updateSampleModel(initializeFileWithCaption);
        }
        else{
          JOptionPane.showMessageDialog(new JFrame(),
              "Invalid file",
              "INFO",
              JOptionPane.INFORMATION_MESSAGE);
        }
        System.out.println("Opening: " + file.getName() + "." + newline);
      } else {
        System.out.println("Open command cancelled by user." + newline);
      }
    }

    // =================================
    // SAVE
    //=================================
    else if (e.getSource() == saveButton) {
      saveSample();
    }
    // =================================
    // NEXT
    //=================================
    else if (e.getSource() == nextButton ){
      //      if(!(selectedRow < TOTAL_NR_OF_ROWS) )
      //        return;
      int selectedRowC =selectedRow+1;
      setSelectedRow(selectedRowC);
      boolean initializeFileWithCaption =false;
      updateSampleModel(initializeFileWithCaption);
    }

    // =================================
    // NEXT
    //=================================
    else if (e.getSource() == previousButton ){
      if((selectedRow == SELECTED_ROW_ON_STARTUP) ){
        return;
      }
      int selectedRowC =selectedRow-1;
      setSelectedRow(selectedRowC);
      boolean initializeFileWithCaption =false;
      updateSampleModel(initializeFileWithCaption);
    }

  }

  private void saveSample() {
    try {
      ManageGUIActions.saveGUIModel();
    } catch (Exception e1) {
      e1.printStackTrace();
      JOptionPane.showMessageDialog(new JFrame(), e1.getMessage(), "ERROR",
          JOptionPane.ERROR_MESSAGE);
    }
  }

  private void updateSampleModel(boolean initializeFileWithCaption) {

    try {

      if(initializeFileWithCaption){
        ManageGUIActions.initializeFileWithCaption();
      }
      ManageGUIActions.updateGUIModel();
    } catch (Exception e1) {
      e1.printStackTrace();
      JOptionPane.showMessageDialog(new JFrame(),
          e1.getMessage(),
          "ERROR",
          JOptionPane.ERROR_MESSAGE);
    }
  }

  private boolean isValid(File selectedFile2) {
    // TODO Auto-generated method stub
    return true;
  }

  /** Returns an ImageIcon, or null if the path was invalid. */
  public static ImageIcon createImageIcon(String path) {
    java.net.URL imgURL = FileChooserJPanel.class.getResource(path);
    if (imgURL != null) {
      return new ImageIcon(imgURL);
    } else {
      System.err.println("Couldn't find file: " + path);

      return null;
    }
  }

  public File getSelectedFile() {
    return selectedFile;
  }

  public void setSelectedFile(File selectedFile) {
    this.selectedFile = selectedFile;
  }

  public int getSelectedRow() {
    return selectedRow;
  }

  public void setSelectedRow(int selectedRow) {
    this.selectedRow = selectedRow;
  }

  public int getSelectedColumnOffset() {
    return SAMPLE_COLUMN_OFFSET;
  }

  /**
   * Create the GUI and show it.  For thread safety,
   * this method should be invoked from the
   * event dispatch thread.
   */
  private static void createAndShowGUI() {
    //Create and set up the window.
    JFrame frame = new JFrame("FileChooserDemo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Add content to the window.
    frame.getContentPane().add(new FileChooserJPanel(), BorderLayout.EAST);

    //Display the window.
    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    //Schedule a job for the event dispatch thread:
    //creating and showing this application's GUI.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        //Turn off metal's use of bold fonts
        UIManager.put("swing.boldMetal", Boolean.FALSE); 
        createAndShowGUI();
      }
    });
  }
}
