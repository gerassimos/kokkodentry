package gr.kokkoentry.gui;
import static gr.kokkoentry.util.SwingConsole.run;
import gr.kokkoentry.dao.Constants.ORIKTA_ENUM;
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
  private JLabel jLabelKoskino0;
  private JLabel jLabelKoskino1;
  private JLabel jLabelKoskino2;
  private JLabel jLabelKoskino3;
  private JLabel jLabelKoskino4;
  private JLabel jLabelSCV;
  private JLabel jLabelAA;
  
  private JTextField jTextFieldArea;
//  private JTextField jTextField1 = new JTextField();
//  private JTextField jTextField2 = new JTextField();
//  private JTextField jTextField3 = new JTextField();
//  private JTextField jTextField4 = new JTextField();
//  private JTextField jTextField5 = new JTextField();
  
  private JButton jButtonSave;
  
  private JTextField[] jTextFieldKoskino0 = new JTextField[ORIKTA_ENUM.values().length];
  private JTextField[] jTextFieldKoskino1 = new JTextField[ORIKTA_ENUM.values().length];
  private JTextField[] jTextFieldKoskino2 = new JTextField[ORIKTA_ENUM.values().length];
  private JTextField[] jTextFieldKoskino3 = new JTextField[ORIKTA_ENUM.values().length];
  private JTextField[] jTextFieldKoskino4 = new JTextField[ORIKTA_ENUM.values().length];
  
  private JLabel[] jLabelOrikta = new JLabel[ORIKTA_ENUM.values().length];

  private MainGUI() {
    super();
    GridBagLayout thisLayout = new GridBagLayout();
    thisLayout.columnWeights = new double[] {0.1, 0.1, 0.1};
    thisLayout.columnWidths = new int[] {7, 7, 7};
    thisLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0};
    thisLayout.rowHeights = new int[] {20, 7, 7, 7, 7};
    getContentPane().setLayout(thisLayout);
    setSize(800 , 600);

    jPanelFileChooser = new FileChooser();
    getContentPane().add(jPanelFileChooser, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    jPanelHead = getJPanelHead();
    getContentPane().add(jPanelHead, new GridBagConstraints(0, 1, 3, 1, 0.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

    jPanelSampleOre = getJPanelSampleOre();
    getContentPane().add(jPanelSampleOre, new GridBagConstraints(0, 2, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

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
            
            JTextField[][] jTextFieldKoskina = {jTextFieldKoskino0, jTextFieldKoskino1, jTextFieldKoskino2, jTextFieldKoskino3 ,jTextFieldKoskino4};
            Sample sample = convertToSample(jTextFieldKoskina);
            
            test.addSample(sample, 5, 3);
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
    jPanelSampleOre = new JPanel();
    GridBagLayout jPanelSamleOreLayout = new GridBagLayout();
    jPanelSamleOreLayout.columnWidths = new int[] {7, 7, 7, 7, 7 ,7};
//    jPanelSamleOreLayout.rowHeights = new int[] {7, 7, 7, 7, 7 ,7};
    jPanelSamleOreLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
//    jPanelSamleOreLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1};
    jPanelSampleOre.setLayout(jPanelSamleOreLayout);
    jPanelSampleOre.setBorder(BorderFactory.createTitledBorder("Sample"));

    jLabelKoskino0 = new JLabel("Koskino 0");
    jLabelKoskino1 = new JLabel("Koskino 1");
    jLabelKoskino2 = new JLabel("Koskino 2");
    jLabelKoskino3 = new JLabel("Koskino 3");
    jLabelKoskino4 = new JLabel("Koskino 4");

    jPanelSampleOre.add(jLabelKoskino0, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelSampleOre.add(jLabelKoskino1, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelSampleOre.add(jLabelKoskino2, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelSampleOre.add(jLabelKoskino3, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanelSampleOre.add(jLabelKoskino4, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    
    for(ORIKTA_ENUM orikto :ORIKTA_ENUM.values()){
      jLabelOrikta[orikto .ordinal()]= new JLabel();
      jLabelOrikta[orikto .ordinal()].setText(orikto.getDisplayString());
      jPanelSampleOre.add(jLabelOrikta[orikto .ordinal()], new GridBagConstraints(0, 1 + orikto .ordinal(), 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
    }
    
    
//    jPanelSampleOre.add(jTextField1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
//    jPanelSampleOre.add(jTextField2, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
//    jPanelSampleOre.add(jTextField3, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
//    jPanelSampleOre.add(jTextField4, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//    jPanelSampleOre.add(jTextField5, new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    
    
    for(ORIKTA_ENUM orikto :ORIKTA_ENUM.values()){
      jTextFieldKoskino0[orikto .ordinal()]= new JTextField();
      jPanelSampleOre.add(jTextFieldKoskino0[orikto .ordinal()], new GridBagConstraints(1, 1 + orikto .ordinal(), 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
    }
    for(ORIKTA_ENUM orikto :ORIKTA_ENUM.values()){
      jTextFieldKoskino1[orikto .ordinal()]= new JTextField();
      jPanelSampleOre.add(jTextFieldKoskino1[orikto .ordinal()], new GridBagConstraints(2, 1 + orikto .ordinal(), 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
    }
    for(ORIKTA_ENUM orikto :ORIKTA_ENUM.values()){
      jTextFieldKoskino2[orikto .ordinal()]= new JTextField();
      jPanelSampleOre.add(jTextFieldKoskino2[orikto .ordinal()], new GridBagConstraints(3, 1 + orikto .ordinal(), 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
    }
    for(ORIKTA_ENUM orikto :ORIKTA_ENUM.values()){
      jTextFieldKoskino3[orikto .ordinal()]= new JTextField();
      jPanelSampleOre.add(jTextFieldKoskino3[orikto .ordinal()], new GridBagConstraints(4, 1 + orikto .ordinal(), 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
    }
    for(ORIKTA_ENUM orikto :ORIKTA_ENUM.values()){
      jTextFieldKoskino4[orikto .ordinal()]= new JTextField();
      jPanelSampleOre.add(jTextFieldKoskino4[orikto .ordinal()], new GridBagConstraints(5, 1 + orikto .ordinal(), 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
    }


    return jPanelSampleOre;
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
    run(new MainGUI(), 800, 600);
  }

}
