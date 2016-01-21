import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Mode {

	private int mode = 0;
	ArrayList<Buttons> btnList;
	Action action ;
	public Mode(MyPanel panel, ArrayList<Buttons> btnList) {
		this.btnList = btnList;
		action = new Action(this);
		panel.setModeObject(this, action);
		action.setModeObject(this);
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

	public void setMode(int mode) {
		this.mode = mode;
		resetEnviroment(mode, btnList);
	}

	public int getMode() {
		return mode;
	}
	public Action getAction() {
		return action;
	}
}
