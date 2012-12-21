package gr.kokkoentry.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/*
 * FileChooserDemo.java uses these files:
 *   images/Open16.gif
 *   images/Save16.gif
 */
public class FileChooser extends JPanel implements ActionListener {

  private static final long serialVersionUID = 1L;
  static private final String newline = "\n";
  JButton openButton, saveButton;
  //  JTextArea log;
  JFileChooser fc;
  private File selectedFile;
  private JLabel jLabelSelectedFileName;

  public FileChooser() {
    super(new BorderLayout());
    //For layout purposes, put the buttons in a separate panel
    JPanel buttonPanel = new JPanel(); //use FlowLayout
    //Add the buttons and the log to this panel.
    add(buttonPanel, BorderLayout.PAGE_START);
    
    openButton = new JButton("Open a File...", createImageIcon("images/Open16.gif"));
    saveButton = new JButton("Save", createImageIcon("images/Save16.gif"));
    jLabelSelectedFileName = new JLabel("No File selected");
    openButton.addActionListener(this);
    saveButton.addActionListener(this);

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
    buttonPanel.add(jLabelSelectedFileName);
  }

  public void actionPerformed(ActionEvent e) {

    //Handle open button action.
    if (e.getSource() == openButton) {
      int returnVal = fc.showOpenDialog(FileChooser.this);

      if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fc.getSelectedFile();
        selectedFile = fc.getSelectedFile();
        jLabelSelectedFileName.setText("Selected File: "+selectedFile.getName());
        //This is where a real application would open the file.
        System.out.println("Opening: " + file.getName() + "." + newline);
      } else {
        System.out.println("Open command cancelled by user." + newline);
      }
      //      log.setCaretPosition(log.getDocument().getLength());

      //Handle save button action.
    } else if (e.getSource() == saveButton) {
      int returnVal = fc.showSaveDialog(FileChooser.this);
      if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fc.getSelectedFile();
        //This is where a real application would save the file.
        System.out.println("Saving: " + file.getName() + "." + newline);
      } else {
        System.out.println("Save command cancelled by user." + newline);
      }
      //      log.setCaretPosition(log.getDocument().getLength());
    }
  }

  /** Returns an ImageIcon, or null if the path was invalid. */
  protected static ImageIcon createImageIcon(String path) {
    java.net.URL imgURL = FileChooser.class.getResource(path);
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
    frame.add(new FileChooser());

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