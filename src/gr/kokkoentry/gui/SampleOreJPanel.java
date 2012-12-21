package gr.kokkoentry.gui;

import gr.kokkoentry.dao.Constants.ORIKTA_ENUM;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


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
public class SampleOreJPanel extends JPanel implements ActionListener {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private JLabel jLabelKoskino0;
  private JLabel jLabelKoskino1;
  private JLabel jLabelKoskino2;
  private JLabel jLabelKoskino3;
  private JLabel jLabelKoskino4;
  
  private JLabel[] jLabelOrikta = new JLabel[ORIKTA_ENUM.values().length];
  
  private JTextField[] jTextFieldKoskino0 = new JTextField[ORIKTA_ENUM.values().length];
  private JTextField[] jTextFieldKoskino1 = new JTextField[ORIKTA_ENUM.values().length];
  private JTextField[] jTextFieldKoskino2 = new JTextField[ORIKTA_ENUM.values().length];
  private JTextField[] jTextFieldKoskino3 = new JTextField[ORIKTA_ENUM.values().length];
  private JTextField[] jTextFieldKoskino4 = new JTextField[ORIKTA_ENUM.values().length];
  private JCheckBox[]  jCheckBoxOrikta = new JCheckBox[ORIKTA_ENUM.values().length];  
  
  
  JPanel jpanelOreSelection ;
  static private SampleOreJPanel sampleOreJPanel_IL;


  public SampleOreJPanel() {
    super();

    //  jPanelSampleOre = new JPanel();
    GridBagLayout jPanelSamleOreLayout = new GridBagLayout();
    jPanelSamleOreLayout.columnWidths = new int[] {7, 7, 7, 7, 7 ,7};
    //  jPanelSamleOreLayout.rowHeights = new int[] {7, 7, 7, 7, 7 ,7};
    jPanelSamleOreLayout.columnWeights = new double[] {0.0, 0.1, 0.1, 0.1, 0.1, 0.1};
    //  jPanelSamleOreLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1};
    setLayout(jPanelSamleOreLayout);
//    setBorder(BorderFactory.createTitledBorder("Sample"));
    this.setPreferredSize(new java.awt.Dimension(600, 1100));

    jpanelOreSelection = new JPanel(new FlowLayout());
    for(ORIKTA_ENUM orikto :ORIKTA_ENUM.values()){
      jCheckBoxOrikta[orikto .ordinal()]= new JCheckBox(orikto.getUniqueName());
      jCheckBoxOrikta[orikto .ordinal()].addActionListener(this);
      jpanelOreSelection.add(jCheckBoxOrikta[orikto .ordinal()]);
    }
    this.add(jpanelOreSelection, new GridBagConstraints(0, 0, 6, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    jLabelKoskino0 = new JLabel("Koskino 0");
    jLabelKoskino1 = new JLabel("Koskino 1");
    jLabelKoskino2 = new JLabel("Koskino 2");
    jLabelKoskino3 = new JLabel("Koskino 3");
    jLabelKoskino4 = new JLabel("Koskino 4");
    
    

    add(jLabelKoskino0, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    add(jLabelKoskino1, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    add(jLabelKoskino2, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    add(jLabelKoskino3, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    add(jLabelKoskino4, new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    


    //  jPanelSampleOre.add(jTextField1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
    //  jPanelSampleOre.add(jTextField2, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
    //  jPanelSampleOre.add(jTextField3, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
    //  jPanelSampleOre.add(jTextField4, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    //  jPanelSampleOre.add(jTextField5, new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    
    for(ORIKTA_ENUM orikto :ORIKTA_ENUM.values()){
      jLabelOrikta[orikto .ordinal()]= new JLabel();
      jLabelOrikta[orikto .ordinal()].setText(orikto.getUniqueName());
      add(jLabelOrikta[orikto .ordinal()], new GridBagConstraints(0, 2 + orikto .ordinal(), 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
    }


    for(ORIKTA_ENUM orikto :ORIKTA_ENUM.values()){
      jTextFieldKoskino0[orikto .ordinal()]= new JTextField();
      add(jTextFieldKoskino0[orikto .ordinal()], new GridBagConstraints(1, 2 + orikto .ordinal(), 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
    }
    for(ORIKTA_ENUM orikto :ORIKTA_ENUM.values()){
      jTextFieldKoskino1[orikto .ordinal()]= new JTextField();
      add(jTextFieldKoskino1[orikto .ordinal()], new GridBagConstraints(2, 2 + orikto .ordinal(), 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
    }
    for(ORIKTA_ENUM orikto :ORIKTA_ENUM.values()){
      jTextFieldKoskino2[orikto .ordinal()]= new JTextField();
      add(jTextFieldKoskino2[orikto .ordinal()], new GridBagConstraints(3, 2 + orikto .ordinal(), 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
    }
    for(ORIKTA_ENUM orikto :ORIKTA_ENUM.values()){
      jTextFieldKoskino3[orikto .ordinal()]= new JTextField();
      add(jTextFieldKoskino3[orikto .ordinal()], new GridBagConstraints(4, 2 + orikto .ordinal(), 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
    }
    for(ORIKTA_ENUM orikto :ORIKTA_ENUM.values()){
      jTextFieldKoskino4[orikto .ordinal()]= new JTextField();
      add(jTextFieldKoskino4[orikto .ordinal()], new GridBagConstraints(5, 2 + orikto .ordinal(), 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
    }
    
    
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println("SampleOreJPanel ActionEvent:"+e.getSource());
    
  }
  
  private static void createAndShowGUI() {
    //Create and set up the window.
    JFrame frame = new JFrame("SampleOreJPanel" );
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //Add content to the window.

    //Display the window.
    frame.pack();
    frame.setVisible(true);
    {
      sampleOreJPanel_IL = new SampleOreJPanel();
      JScrollPane j = new JScrollPane(sampleOreJPanel_IL);
      frame.getContentPane().add(j, BorderLayout.CENTER);
      frame.setSize(800, 600);
//      sampleOreJPanel_IL.setPreferredSize(new java.awt.Dimension(670, 365));
    }
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
