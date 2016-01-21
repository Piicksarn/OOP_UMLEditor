import java.util.ArrayList;

public class SelectMode {

	private int x = 0;
	private int y = 0;
	private int selectedIndex;
	private static ArrayList<Element> elementList;
	private MyPanel panel;

	public SelectMode(ArrayList<Element> elementList, MyPanel panel) {
		this.panel = panel;
		this.elementList = elementList;
	}
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void doSelect() {
		int index = checkElement(x, y);
		if(index != -1) {
			for (int i = 0; i < elementList.size(); i++) {
	   			elementList.get(i).resetFlag();
	   		}
			elementList.get(index).setFlag();
			selectedIndex = index;
		}
		else {
			for (int i = 0; i < elementList.size(); i++) {
	   			elementList.get(i).resetFlag();
	   		}
		}	
	}
	
	public int seleced() {
		return selectedIndex;
	}
	public int startX = 0;
	public int startY = 0;
	
	public void selectElement(int xI, int yI, int xE, int yE, int startX, int startY) {
   		if(checkElement(startX, startY)!= -1) {
   			for (int i = 0; i < elementList.size(); i++) {
	   			elementList.get(i).resetFlag();
	   		}
   			Element ele = elementList.get(checkElement(startX, startY));
   			int delX = xE - startX;
   			int delY = yE - startY;
			
   			if(checkElement(startX, startY) != -1)
   				ele.setPosition(ele.getX() + delX, ele.getY() + delY);
   			this.startX = xE;
   			this.startY = yE;
   		}
   		else {
   			findArea(xI, yI, xE, yE);
   		}
	}
	private int checkElement(int x, int y) {
		for (int i = 0; i < elementList.size(); i++) {
			Element ele = elementList.get(i);
			if(x >= ele.getX() && x <= ele.getX() + ele.getW())
				if(y >= ele.getY() && y <= ele.getY() + ele.getH()) {
				
					System.out.println(ele.getFlag());
					return i;
				}
		}
		return -1;		
	}
	public int setX() {
		return startX;
	}
	public int setY() {
		return startY;
	}
	private void findArea(int xI, int yI, int xE, int yE) {
		for (int i = 0; i < elementList.size(); i++) {
			if(elementList.get(i).getX() < xE && elementList.get(i).getX() > xI
					&& elementList.get(i).getY() > yI
					&& elementList.get(i).getY() < yE){
				elementList.get(i).setFlag();
				//group.addElement(elementList.get(i));
			}
		}
		//group.setArea(xI, yI, xE, yE);
		int[] p = new int[4];
		p[0] = xI;
		p[1] = yI;
		p[2] = xE;
		p[3] = yE;
		//rectangleList.add(p);
	}

}
