package gr.kokkoentry.gui;

import gr.kokkoentry.dao.Constants;
import gr.kokkoentry.dao.Constants.ORIKTA_ENUM;
import gr.kokkoentry.model.BeanPerOre;
import gr.kokkoentry.model.OresPerSieve;
import gr.kokkoentry.model.Sample;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
public class OresFieldsJPanel extends JPanel implements ActionListener {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private JLabel[] jLabelOrikta = new JLabel[ORIKTA_ENUM.values().length];

  private JTextField[] jTextFieldKoskino0 = new JTextField[ORIKTA_ENUM.values().length];
  private JTextField[] jTextFieldKoskino1 = new JTextField[ORIKTA_ENUM.values().length];
  private JTextField[] jTextFieldKoskino2 = new JTextField[ORIKTA_ENUM.values().length];
  private JTextField[] jTextFieldKoskino3 = new JTextField[ORIKTA_ENUM.values().length];
  private JTextField[] jTextFieldKoskino4 = new JTextField[ORIKTA_ENUM.values().length];

  private JTextField[][] jTextFieldKoskina = { 
      jTextFieldKoskino0, jTextFieldKoskino1, jTextFieldKoskino2, jTextFieldKoskino3, jTextFieldKoskino4 };

  public OresFieldsJPanel() {
    super();
    GridBagLayout gridBagLayout = new GridBagLayout();
    gridBagLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
    gridBagLayout.rowHeights = new int[] {7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
    gridBagLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
    gridBagLayout.columnWidths = new int[] {7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
    this.setLayout(gridBagLayout);
    this.setBorder(BorderFactory.createTitledBorder("ORIKTA"));


    this.add(new JLabel("Kosk0"), new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(new JLabel("Kosk1"), new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(new JLabel("Kosk2"), new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(new JLabel("Kosk3"), new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(new JLabel("Kosk4"), new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));


    this.add(new JLabel("Kosk0"), new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(new JLabel("Kosk1"), new GridBagConstraints(8, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(new JLabel("Kosk2"), new GridBagConstraints(9, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(new JLabel("Kosk3"), new GridBagConstraints(10, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(new JLabel("Kosk4"), new GridBagConstraints(11, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));



    for(ORIKTA_ENUM orikto :ORIKTA_ENUM.values()){
      jLabelOrikta[orikto .ordinal()]= new JLabel();
      jLabelOrikta[orikto .ordinal()].setText(orikto.getUniqueName());
      if(orikto .ordinal() <25 ){
        this.add(jLabelOrikta[orikto .ordinal()], new GridBagConstraints(0, 1 + +orikto.ordinal(), 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
      }else{
        this.add(jLabelOrikta[orikto .ordinal()], new GridBagConstraints(6, 1 + +orikto.ordinal() -25 , 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
      }
    }
    addOriktaFieldsToGridBag(this,jTextFieldKoskino0,1);
    addOriktaFieldsToGridBag(this,jTextFieldKoskino1,2);
    addOriktaFieldsToGridBag(this,jTextFieldKoskino2,3);
    addOriktaFieldsToGridBag(this,jTextFieldKoskino3,4);
    addOriktaFieldsToGridBag(this,jTextFieldKoskino4,5);

  }

  private void addOriktaFieldsToGridBag(JPanel jpanel ,JTextField[] jTextFieldKoskino, int columnIndex ){
    for(ORIKTA_ENUM orikto :ORIKTA_ENUM.values()){
      jTextFieldKoskino[orikto .ordinal()]= new JTextField();
      if(orikto .ordinal() <25 ){
        jpanel.add(jTextFieldKoskino[orikto .ordinal()], new GridBagConstraints(columnIndex, 1 + +orikto.ordinal(), 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
      }else{
        jpanel.add(jTextFieldKoskino[orikto .ordinal()], new GridBagConstraints(columnIndex+6, 1 + +orikto.ordinal() -25 , 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
      }
    }
  }

  public Sample getSample(){
    Sample sample = new Sample();
    OresPerSieve [] oresPerSieveArray = sample.getOresPerSieveArray();
    for (int i = 0; i < Constants.NR_OF_KOSKINA; i++) {
      JTextField[] jTextFieldKoskino =  jTextFieldKoskina[i];
      OresPerSieve oresPerSieve = oresPerSieveArray[i];
      BeanPerOre[] beanPerOreArray = oresPerSieve.getBeanPerOreArray();
      int index =0;
      for (BeanPerOre beanPerOre : beanPerOreArray) {
        JTextField oreJTextField = jTextFieldKoskino[index];
        Integer nrOfBeans = null;
        try{
          nrOfBeans = Integer.parseInt((oreJTextField.getText()));
          beanPerOre.setNrOfBeans(nrOfBeans);
          System.out.println( beanPerOre.getOreName()+" : "+ beanPerOre.getNrOfBeans());
        }catch(NumberFormatException e){
          //System.out.println( beanPerOre.getOreName()+" : "+ beanPerOre.getNrOfBeans());
        }
        catch(Exception e){
          e.printStackTrace();
        }
        beanPerOre.setNrOfBeans(nrOfBeans);
        index++;
      }
    }
    return sample;
  }
  
  public void updateModelFromSample(Sample sample){
    OresPerSieve [] oresPerSieveArray = sample.getOresPerSieveArray();
    for (int i = 0; i < Constants.NR_OF_KOSKINA; i++) {
      JTextField[] jTextFieldKoskino =  jTextFieldKoskina[i];
      OresPerSieve oresPerSieve = oresPerSieveArray[i];
      BeanPerOre[] beanPerOreArray = oresPerSieve.getBeanPerOreArray();
      int index =0;
      for (BeanPerOre beanPerOre : beanPerOreArray) {
        JTextField oreJTextField = jTextFieldKoskino[index];
        if(beanPerOre!=null  && beanPerOre.getNrOfBeans()!=null ){
          oreJTextField.setText(beanPerOre.getNrOfBeans().toString() );
          
        }else{
          oreJTextField.setText("");
        }
        
        index++;
      }
    }
  }

  public void setAllOresToZero(){
    for(JTextField[] jTextFieldKoskino :jTextFieldKoskina){
      for(JTextField ore:jTextFieldKoskino){
        ore.setText("0");
      }
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println("OresFieldsJPanel ActionEvent:"+e.getSource());

  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("OresFieldsJPanel" );
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
    final OresFieldsJPanel oresFieldsJPanel = new OresFieldsJPanel();
    JButton save = new JButton("save");
    JButton initToZero = new JButton("init to 0");
    save.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent arg0) {
        
        oresFieldsJPanel.getSample();
      }
    });
    initToZero.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent arg0) {
        
        oresFieldsJPanel.setAllOresToZero();
      }
    });

    frame.getContentPane().add(oresFieldsJPanel , BorderLayout.CENTER);
    frame.getContentPane().add(save, BorderLayout.EAST);
    frame.getContentPane().add(initToZero, BorderLayout.WEST);
    frame.setSize(800, 600);
  }

}
