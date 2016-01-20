import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Buttons extends JButton {

	private ImageIcon img;
	private int id;
	private boolean flag = false;
	private Mode mode;
	private MyPanel panel;
	public Buttons(int id, MyPanel panel){
		img = new ImageIcon("/Users/yangenci/Desktop/pic/" + (id + 1) + ".png");
		this.id = id;
		this.setIcon(img);
		this.addActionListener(new btnListener());
		mode = new Mode(panel);
		this.panel = panel;
	}
	
	public boolean getFlag() {
		return flag;
	}
	
	public int getId() {
		return id;
	}
	
	public void setImg(ImageIcon img) {
		this.img = img;
		this.setIcon(img);
	}
	
	class btnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			flag = true;
			mode.setMode(panel,id);
		}	
	}

	public void setFlag(boolean b) {
		flag = b;
	}
}
