import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Mode {

	private int mode = 0;
	MyPanel panel;
	ArrayList<Buttons> btnList;
	public Mode(MyPanel panel, ArrayList<Buttons> btnList) {
		this.panel = panel;
		this.btnList = btnList;
		panel.setModeObject(this);
	}
	
	private void resetEnviroment(int index, ArrayList<Buttons> btnList) {
		System.out.print("mode: "+index);
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
		this.mode = mode;
		resetEnviroment(mode, btnList);
	}

	public int getMode() {
		return mode;
	}
}
