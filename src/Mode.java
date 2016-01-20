import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Mode {

	private int mode = 0;
	MyPanel panel;
	public Mode(MyPanel panel) {
		this.panel = panel;
	}
	
	private void resetEnviroment(int index, ArrayList<Buttons> btnList) {
		this.mode = index;
   		ImageIcon img;
   		for (int i = 0; i < btnList.size(); i++) {
			if (i == mode) {
				img = new ImageIcon("/Users/yangenci/Desktop/pic/" + (i + 1) + "p.png");
				btnList.get(index).setFlag(true);
			}
			else {
				img = new ImageIcon("/Users/yangenci/Desktop/pic/" + (i + 1) + ".png");
				btnList.get(index).setFlag(false);
			}
			btnList.get(i).setImg(img);
   		}
	}

	public void setMode(MyPanel panel,int mode) {
		panel.setMode(mode);
	}

	public int getMode() {
		return mode;
	}
}
