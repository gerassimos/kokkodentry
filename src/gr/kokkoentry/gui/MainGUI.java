package gr.kokkoentry.gui;
import static gr.kokkoentry.util.SwingConsole.run;
import gr.kokkoentry.dao.ExcelFileBasicOperations;
import gr.kokkoentry.model.Sample;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

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
  private JPanel jPanelHead;
  private JPanel jPanelSampleOre;
  private JPanel jPanelFileChooser;
  private JLabel jLabelArea;
  private JLabel jLabelSCV;
  private JLabel jLabelAA;
  
  private JTextField jTextFieldArea;
  
  private JButton jButtonSave;
  
  
  


  private MainGUI() {
    super();
    GridBagLayout thisLayout = new GridBagLayout();
    thisLayout.columnWeights = new double[] {0.1, 0.1, 0.1};
    thisLayout.columnWidths = new int[] {7, 7, 7};
    thisLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0};
    thisLayout.rowHeights = new int[] {7, 7, 7, 7, 7};
    getContentPane().setLayout(thisLayout);
    setSize(800 , 600);

    jPanelFileChooser = new FileChooser();
    getContentPane().add(jPanelFileChooser, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));

    jPanelHead = getJPanelHead();
    getContentPane().add(jPanelHead, new GridBagConstraints(0, 1, 3, 1, 0.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

    jPanelSampleOre = getJPanelSampleOre();
    JScrollPane jScrollPaneOres =new JScrollPane(jPanelSampleOre);
    jScrollPaneOres.setBorder(BorderFactory.createTitledBorder("ORIKTA"));
    getContentPane().add( jScrollPaneOres, new GridBagConstraints(0, 2, 3, 1, 10.0, 10.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 0, 0));

    {
      jButtonSave = new JButton();
      getContentPane().add(jButtonSave, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
      jButtonSave.setText("Save");

      jButtonSave.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
          System.out.println("test");

          try {
//            String filePathWindosOS = "C:\\Users\\gerassimos\\Devel\\kokkodentry\\files\\test1.xls";
//            String filePathLinuxOS =  "/home/gerassimos/workspace/kokkodentry/files/test1.xls";
            File selectedFile = ((FileChooser) jPanelFileChooser).getSelectedFile();
            ExcelFileBasicOperations test = new ExcelFileBasicOperations();
            test.setInputFile(selectedFile.getAbsolutePath());
            test.read();
            test.initializeFileWithCaption();
            
//            JTextField[][] jTextFieldKoskina = {jTextFieldKoskino0, jTextFieldKoskino1, jTextFieldKoskino2, jTextFieldKoskino3 ,jTextFieldKoskino4};
//            Sample sample = convertToSample(jTextFieldKoskina);
            
//            test.addSample(sample, 5, 3);
            // successfully
            System.out.println("Write successfully");
          } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(),
                e.getMessage(),
                "ERROR",
                JOptionPane.ERROR_MESSAGE);
          }

        }

        private Sample convertToSample(JTextField[][] jTextFieldKoskina) {
          // TODO Auto-generated method stub
//          Sample sample = new Sample();
//          int i=0;
//          for(JTextField[]jTextFieldKoskino : jTextFieldKoskina){
//            
//            
//          }
          return null;
        }
      });
    }


  }



  private JPanel getJPanelSampleOre()
  {
    return new SampleOreJPanel();
  }



  private JPanel getJPanelHead()
  {
    jPanelHead = new JPanel();
    GridBagLayout jPanelHeadLayout = new GridBagLayout();
    jPanelHeadLayout.rowWeights = new double[] {0.1, 0.1};
    jPanelHeadLayout.rowHeights = new int[] {7, 7};
    jPanelHeadLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
    jPanelHeadLayout.columnWidths = new int[] {7, 7, 7, 7, 7, 7, 7, 7};
    jPanelHead.setLayout(jPanelHeadLayout);
    jPanelHead.setBorder(BorderFactory.createTitledBorder("INDEX"));

    jLabelArea = new JLabel("AREA");
    jLabelAA = new JLabel("A/A");
    jLabelSCV = new JLabel("S-C-V");

    jTextFieldArea = new JTextField();
    jPanelHead.add(jLabelArea, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(10, 10, 0, 10), 0, 0));
    jPanelHead.add(jLabelAA, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelHead.add(jLabelSCV, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelHead.add(jTextFieldArea, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

    return jPanelHead;
  }



  public static void main(String [] args){
    run(new MainGUI(), 1024, 768);
  }

}
