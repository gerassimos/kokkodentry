package gr.kokkoentry.gui;
//: gui/Button1.java
// Putting buttons on a Swing application.
import javax.swing.*;
import java.awt.*;
import static gr.kokkoentry.util.SwingConsole.*;

public class Button1 extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JButton
	b1 = new JButton("Button 1"),
	b2 = new JButton("Button 2");
	public Button1() {
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
	}
	public static void main(String[] args) {
		run(new Button1(), 200, 100);
	}
} ///:~
