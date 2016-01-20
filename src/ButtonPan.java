import java.awt.Panel;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ButtonPan extends JPanel {

    private static ArrayList<Buttons> btnList =  new ArrayList<Buttons>();
    private Mode mode;
	public ButtonPan(MyPanel mypanel) {
		mode = new Mode(mypanel, btnList);
		addButtons(mypanel);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	private void addButtons(MyPanel mypanel) {	
		for(int i  = 0; i < 6; i++) {
			Buttons btn = new Buttons(i, mypanel, mode);
			btnList.add(btn);
			this.add(btn);
		}
		mypanel.setBtnList(btnList);
	}
	public ArrayList<Buttons> getbtnList() {
		return btnList;
	}
}
