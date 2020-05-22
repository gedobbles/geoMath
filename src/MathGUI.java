import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 19.07.2018
 * @author
 */

public class MathGUI extends JFrame {
  // Anfang Attribute

  private java.util.LinkedList<Geo> objects;
  private Canvas canvas1;
  String[] ausw = {"Vektor","Gerade","Ebene"};
  private JComboBox jComboBox1;

  private JButton jButton1 = new JButton();
  private JButton jButton2 = new JButton();
  // Ende Attribute

  public MathGUI() {
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 579;
    int frameHeight = 545;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("MathGUI");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);

    objects = new java.util.LinkedList<Geo>();

    // Anfang Komponenten

    canvas1 = new Canvas();
    canvas1.setBounds(20, 48, 500, 500);
    cp.add(canvas1);

    jComboBox1 = new JComboBox(ausw);
    jComboBox1.setBounds(16, 8, 161, 25);
    cp.add(jComboBox1);

    jButton1.setBounds(192, 8, 49, 25);
    jButton1.setText("Add");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    jButton2.setBounds(256, 8, 97, 25);
    jButton2.setText("Refresh");
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButton2_ActionPerformed(evt);
      }
    });
    cp.add(jButton2);
    // Ende Komponenten

    setVisible(true);
    this.redraw();
  } // end of public MathGUI

  // Anfang Methoden

  public void jButton1_ActionPerformed(ActionEvent evt) {
    switch(jComboBox1.getSelectedIndex()){
      case 0:
        Vektor v = new Vektor();
        v.input();
        objects.add(v);
        break;
      case 1:

        break;
      case 2:
        Ebene e = new Ebene();
        e.input();
        objects.add(e);
        break;
    }
    this.redraw();

  } // end of jButton1_ActionPerformed

  public void redraw(){
    Graphics g = canvas1.getGraphics();
    g.clearRect(0,0,500,500);
    koordinatensystem(g);

    for (Geo geo: objects) {
      geo.draw(g);
    } // end of for
  }

  private void koordinatensystem(Graphics g){
    g.drawLine(0,250,500,250);
    g.drawLine(250,0,250,500);
    g.drawLine(400,100,100,400);
  }


  public void jButton2_ActionPerformed(ActionEvent evt) {
    this.redraw();
  } // end of jButton2_ActionPerformed

  // Ende Methoden
} // end of class MathGUI
