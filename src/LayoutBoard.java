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
    private Panel top;
    public Color blue = new Color(0, 90, 124);
    private static ArrayList<Buttons> btnList =  new ArrayList<Buttons>();
    private MyPanel myPanel = new MyPanel(1);
    
	public LayoutBoard(double width, double hight) {
		super("UML");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        
        JButton btnFile = new JButton("File");
        JButton btnEdit = new JButton("Edit");
       
	    final JComboBox jcb = new JComboBox(new Object[]{
			"Edit", "group", "Change object name", "Ungroup",
		});
	    
	    jcb.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int k = jcb.getSelectedIndex();
			callback(k);
		}
	});
	     
	  //  jcb.getModel().getElementAt(k);
	    
	    
        top = new Panel();
        center = new Panel();
        left = new Panel();
        
        center.add("Draw UML", new MyPanel(1));
        addButtons(left);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        
        center.setBackground(blue);
        left.setBackground(blue);
        top.setBackground(Color.red);
        top.add(btnFile);
        top.add(jcb);
        
        this.add(top, BorderLayout.NORTH);
        this.add(left, BorderLayout.WEST);
        this.add(center, BorderLayout.CENTER);
        
        this.setLocationByPlatform(true);  
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
	}

	private void callback(int k) {
		if(k == 2)
			myPanel.changeName();;
		System.out.println("*:" + k);
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
