import java.util.ArrayList;

public class BoxMode {
	private int x = 0;
	private int y = 0;
	private int idCounter = 0;
	private static ArrayList<Element> elementList;
	private Mode mode;
	private MyPanel panel;
	
	public BoxMode(ArrayList<Element> elementList, MyPanel panel) {
		this.panel = panel;
		this.elementList = elementList;
	}
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void setMode(Mode mode) {
		this.mode = mode;
	}
	public void doAdd(){
		Element element;
		if(mode.getMode() == 4) {
			element= new Element(x, y, 120, 100);
			element.setName("Class");
		}
		else {
			element = new Element(x, y, 120, 70);
			element.setName("Use Case");
		}
		element.setMode(mode.getMode());
		element.setEleId(idCounter);
		idCounter++;
		elementList.add(element);
	}
}
