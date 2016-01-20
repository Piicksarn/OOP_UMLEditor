import java.awt.Color;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class AllActionListioner implements MouseListener {

	private ArrayList<Element> eltList = new ArrayList<Element>();
	private int mode;
	MyPanel panel;
	private int startX = 0;
	private int startY = 0;
	private int press = 0;
	private int release = 1;
	public AllActionListioner(MyPanel myPanel) {
		panel = myPanel;
		panel.addMouseMotionListener( new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent arg0) {	
				
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				panel.drag(startX, startY, e.getX(), e.getY());
				//panel.setFlagDown(e.getX(), e.getY());
				System.out.println("drageing");
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		panel.click(e.getX(), e.getY());
		System.out.println("click!");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		startX = e.getX();
		startY = e.getY();
		panel.setActStartXY(startX, startY);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		panel.release(startX, startY, e.getX(), e.getY());
		System.out.println("drag end");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
			
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public int getRelease() {
		return release;
	}

}
