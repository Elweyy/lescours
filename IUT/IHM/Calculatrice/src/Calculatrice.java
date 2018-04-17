import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Calculatrice extends JPanel  {

	public static void main(String[] args) {
		JPanel jp=new JPanel();
		jp.setLayout(new GridLayout(5,4));
		jp.add(new JButton("1"));
		jp.add(new JButton("2"));
		jp.add(new JButton("3"));
		jp.add(new JButton("+"));

		jp.add(new JButton("5"));
		jp.add(new JButton("6"));
		jp.add(new JButton("7"));
		jp.add(new JButton("-"));

		jp.add(new JButton("8"));
		jp.add(new JButton("9"));
		jp.add(new JButton("0"));
		jp.add(new JButton("*"));
		
		jp.add(new JButton(""));
		jp.add(new JButton("sqrt"));
		jp.add(new JButton("x2"));
		jp.add(new JButton("/"));

		jp.add(new JButton(""));
		jp.add(new JButton("="));
		jp.add(new JButton("clear"));
		jp.add(new JButton(""));



		this.setLayout(new BorderLayout());
		




		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp.setPreferredSize(new Dimension(400,250));
		f.setContentPane(jp);
		f.pack();
		f.setVisible(true);
	}
}
