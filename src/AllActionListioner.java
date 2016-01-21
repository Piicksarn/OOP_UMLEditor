import java.awt.Color;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class AllActionListioner implements MouseListener {

	private ArrayList<Element> eltList = new ArrayList<Element>();
	MyPanel panel;
	Action action;
	private int startX = 0;
	private int startY = 0;
	private int press = 0;
	private int release = 1;
	
	public AllActionListioner(MyPanel myPanel) {
		panel = myPanel;
		this.action = action;

		panel.addMouseMotionListener( new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent arg0) {	
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				action.drag(startX, startY, e.getX(), e.getY());
			}
		});
	}
	
	public void setAction(Action action) {
	this.action = action;
	}
	public int getStartX() {
		return startX;
	}
	
	public int getStartY() {
		return startY;
	}
	public void setStartX(int x) {
		startX = x;;
	}
	
	public void setStartY(int y) {
		startY = y;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		action.click(e.getX(), e.getY());		
	}

	@Override
	public void mousePressed(MouseEvent e) {	
		startX = e.getX();
		startY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
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
