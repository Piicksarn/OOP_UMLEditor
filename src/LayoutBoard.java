import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class LayoutBoard extends JFrame{

    public Color blue = new Color(0, 90, 124);
	public LayoutBoard(double width, double hight) {
		super("UML2");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        
        MyPanel myPanel = new MyPanel(1);
	    EditPanel editPan = new EditPanel(myPanel);
	    ButtonPan btnPan = new ButtonPan(myPanel);
        Panel center = new Panel();
        
        center.add("Draw UML", myPanel);        
        center.setBackground(blue);
        btnPan.setBackground(blue);
        editPan.setBackground(Color.red);
     
        this.add(editPan, BorderLayout.NORTH);
        this.add(btnPan, BorderLayout.WEST);
        this.add(center, BorderLayout.CENTER);
        
        this.setLocationByPlatform(true);  
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
	}

}
