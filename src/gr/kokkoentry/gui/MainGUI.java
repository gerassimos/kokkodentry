package gr.kokkoentry.gui;
import static gr.kokkoentry.util.SwingConsole.run;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
public class MainGUI extends JFrame {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private  static  MainGUI runningInstanceOFMainGUI;
  private JPanel headJPanel;
  private JPanel oresFieldsJPanel;
  private JPanel fileChooserJPanel;
    
  
  private JLabel jLabelLogo;

  private MainGUI() {
    super("kokkodentry 1.0");
    
    GridBagLayout thisLayout = new GridBagLayout();
    thisLayout.columnWeights = new double[] {0.1, 0.1, 0.1};
    thisLayout.columnWidths = new int[] {7, 7, 7};
    thisLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0};
    thisLayout.rowHeights = new int[] {7, 7, 7, 7, 7};
    getContentPane().setLayout(thisLayout);
    

    fileChooserJPanel = new FileChooserJPanel();
    getContentPane().add(fileChooserJPanel, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(10, 10, 0, 10), 0, 0));
    
    jLabelLogo = new JLabel(new ImageIcon(MainGUI.class.getResource("images/geek--gh-.gif")));
    getContentPane().add(jLabelLogo, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 10), 0, 0));

    headJPanel = new HeadJPanel();
    getContentPane().add(headJPanel, new GridBagConstraints(0, 1, 3, 1, 0.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 10, 0, 10), 0, 0));

    oresFieldsJPanel = new OresFieldsJPanel();
    getContentPane().add(oresFieldsJPanel, new GridBagConstraints(0, 2, 3, 1, 10.0, 10.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 0, 0));
  }
  
  public JPanel getHeadJPanel() {
    return headJPanel;
  }

  public JPanel getOresFieldsJPanel() {
    return oresFieldsJPanel;
  }

  public JPanel getFileChooserJPanel() {
    return fileChooserJPanel;
  }

  public static MainGUI getRunningInstanceOFMainGUI() {
    return runningInstanceOFMainGUI;
  }

  public static void main(String [] args){
    runningInstanceOFMainGUI =new MainGUI(); 
    run(runningInstanceOFMainGUI, 1024, 768);
  }

}
