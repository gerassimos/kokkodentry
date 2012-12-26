package gr.kokkoentry.gui;

import gr.kokkoentry.model.SampleIndex;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
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
public class HeadJPanel extends JPanel implements ActionListener{

  private static final long serialVersionUID = 1L;
  
  private JLabel jLabelArea;
  private JLabel jLabelDate;
  private JLabel jLabelDepth;
  private JLabel jLabelTopDist;
  private JLabel jLabelSCV;
  private JLabel jLabelAA;
  private JLabel jLabelColor;

  private JTextField jTextFieldDepth;
  private JTextField jTextFieldTopDist;
  private JTextField jTextFieldArea;
  private JTextField jTextFieldDate;
  private JTextField jTextFieldSCV;
  private JTextField jTextFieldAA;
  private JTextField jTextFieldColor;
  
  

  public HeadJPanel() {
    super();
    GridBagLayout jPanelHeadLayout = new GridBagLayout();
    jPanelHeadLayout.rowWeights = new double[] {0.0, 0.0};
    jPanelHeadLayout.rowHeights = new int[] {7, 7};
    jPanelHeadLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
    jPanelHeadLayout.columnWidths = new int[] {7, 7, 7, 7, 7, 7, 7, 7};
    this.setLayout(jPanelHeadLayout);
    this.setBorder(BorderFactory.createTitledBorder("INDEX"));

    jLabelArea = new JLabel("AREA");
    jLabelAA = new JLabel("A/A");
    jLabelSCV = new JLabel("S-C-V");
    jLabelTopDist = new JLabel("TOPDIST");
    jLabelDate = new JLabel("Date");
    jLabelDepth = new JLabel("DEPTH");
    jLabelColor= new JLabel("Color");

    jTextFieldAA = new JTextField();
    jTextFieldSCV = new JTextField();
    jTextFieldArea = new JTextField();
    jTextFieldTopDist = new JTextField();
    jTextFieldDepth = new JTextField();
    jTextFieldDate =   new JTextField();
    jTextFieldColor =   new JTextField();
    
//    jCalendar.set

    this.add(jLabelArea, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabelAA, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabelSCV, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabelTopDist, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabelDate, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabelDepth, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabelColor, new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    this.add(jTextFieldArea, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jTextFieldAA, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jTextFieldSCV, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jTextFieldTopDist, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jTextFieldDate , new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jTextFieldDepth, new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jTextFieldColor, new GridBagConstraints(6, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }

  public JTextField getjTextFieldDepth() {
    return jTextFieldDepth;
  }

  public JTextField getjTextFieldColor() {
    return jTextFieldColor;
  }

  public JTextField getjTextFieldTopDist() {
    return jTextFieldTopDist;
  }

  public JTextField getjTextFieldArea() {
    return jTextFieldArea;
  }

  public JTextField getjTextFieldDate() {
    return jTextFieldDate;
  }

  public JTextField getjTextFieldSCV() {
    return jTextFieldSCV;
  }

  public JTextField getjTextFieldAA() {
    return jTextFieldAA;
  }

  public void updateModelFromSample(SampleIndex sampleIndex) {
    getjTextFieldArea().setText(sampleIndex.getArea()) ;
    getjTextFieldAA().setText(sampleIndex.getAa()) ;
    getjTextFieldDate().setText(sampleIndex.getDate()) ;
    getjTextFieldDepth().setText(sampleIndex.getDepth()) ;
    getjTextFieldSCV().setText(sampleIndex.getScv()) ;
    getjTextFieldTopDist().setText(sampleIndex.getTopdist()) ;
    getjTextFieldColor().setText(sampleIndex.getColor());
  }

  public SampleIndex getSampleIndex() {
    SampleIndex sampleIndex = new SampleIndex();
    sampleIndex.setArea(getjTextFieldArea().getText()) ;
    sampleIndex.setAa(getjTextFieldAA().getText()) ;
    sampleIndex.setDate(getjTextFieldDate().getText()) ;
    sampleIndex.setDepth(getjTextFieldDepth().getText()) ;
    sampleIndex.setScv(getjTextFieldSCV().getText()) ;
    sampleIndex.setTopdist( getjTextFieldTopDist().getText()) ;
    sampleIndex.setColor(getjTextFieldColor().getText());
    return sampleIndex;
  }
  
  

}
