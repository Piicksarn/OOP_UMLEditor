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

	private Panel center;
    private Panel left;
    private Panel editPan;
    public Color blue = new Color(0, 90, 124);
    private static ArrayList<Buttons> btnList =  new ArrayList<Buttons>();
    private MyPanel myPanel = new MyPanel(1);
    
	public LayoutBoard(double width, double hight) {
		super("UML");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
  
	    EditPanel editPan = new EditPanel(myPanel);
        center = new Panel();
        left = new Panel();
        
        center.add("Draw UML", myPanel);
        addButtons(left);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        
        center.setBackground(blue);
        left.setBackground(blue);
        editPan.setBackground(Color.red);
   
        
        this.add(editPan, BorderLayout.NORTH);
        this.add(left, BorderLayout.WEST);
        this.add(center, BorderLayout.CENTER);
        
        this.setLocationByPlatform(true);  
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
	}

	
	private void addButtons(Panel buttonPanel) {	
		for(int i  = 0; i < 6; i++) {
			Buttons btn = new Buttons(i, myPanel);
			btnList.add(btn);
			buttonPanel.add(btn);
		}
		myPanel.setBtnList(btnList);
	}
}
