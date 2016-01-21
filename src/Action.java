
public class Action {

	private static Mode mode;
	private MyPanel panel;
	private SelectMode selectMode;
	private BoxMode boxMode;
	private int modeId;
	public Action(Mode mode) {
		this.mode = mode;
		System.out.println("Setting mode2:"+ this);

	}
	public void actionInit(SelectMode selectMode, BoxMode boxMode, AssoMode assoMode, MyPanel panel) {
		this.selectMode = selectMode;
		this.boxMode = boxMode;
		this.panel = panel;
	}

	public void click(int x, int y) {
		System.out.println("Setting mode:"+ mode.getMode());

		if(mode.getMode() == 5 || mode.getMode() == 4) {
   			boxMode.setPos(x,y);
   			boxMode.setMode(mode);
   			boxMode.doAdd();
   		}
   		else if (mode.getMode() == 0) {
   			selectMode.setPos(x,y);
   			selectMode.doSelect();
   		}
		panel.repaint();
	}
	
	public void drag(int xI, int yI, int xE, int yE) {	
		if(mode.getMode() == 1 || mode.getMode() == 2 || mode.getMode() == 3)
			panel.drawLine(xI, yI, xE, yE);
		else if(mode.getMode() == 0) {
			selectMode.selectElement(xI, yI, xE, yE, panel.listener.getStartX(), panel.listener.getStartY());	
			panel.listener.setStartX(selectMode.setX());
			panel.listener.setStartY(selectMode.setY());
		}
		panel.repaint();
	}

	public void setModeObject(Mode mode) {
		this.mode = mode;
	} 

}
