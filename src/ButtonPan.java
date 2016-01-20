import java.awt.Panel;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ButtonPan extends JPanel {

    private static ArrayList<Buttons> btnList =  new ArrayList<Buttons>();

	public ButtonPan(MyPanel mypanel) {
		addButtons(mypanel);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	private void addButtons(MyPanel mypanel) {	
		for(int i  = 0; i < 6; i++) {
			Buttons btn = new Buttons(i, mypanel);
			btnList.add(btn);
			this.add(btn);
		}
		mypanel.setBtnList(btnList);
	}
}
