import java.util.ArrayList;

public class Group {

	private ArrayList<Group> group = new ArrayList<Group>();
	private ArrayList<Element> element = new ArrayList<Element>();
	private int xI = 0;
	private int xE = 0;
	private int yI = 0;
	private int yE = 0;

	public Group() {
		
	}
    public void addElement(Element e) {
    	element.add(e);
    }

	public void setArea(int xI, int yI, int xE, int yE) {
		this.xE = xE;
		this.xI = xI;
		this.yE = yE;
		this.yI = yI;		
	}
	
	public boolean inGroupArea(int x, int y) {
		if(x < xE && x > xI && y > yI && y < yE){
			return true;
		}
		return false;
	}
}
