import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class EditPanel extends JPanel{

	private MyPanel mypanel;
	public EditPanel(MyPanel mypanel) {
		this.mypanel = mypanel;
	      
        JButton btnFile = new JButton("File");
        JButton btnEdit = new JButton("Edit");
       
	    final JComboBox jcb = new JComboBox(new Object[]{
			"Edit", "group", "Change object name", "Ungroup",
		});
	    
	    jcb.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		int k = jcb.getSelectedIndex();
	    		callback(k);
	    	}
	    });
	    this.add(btnEdit);
	    this.add(btnFile);
	}

	private void callback(int k) {
		if(k == 2)
			mypanel.changeName();;
		System.out.println("*:" + k);
	}
}
