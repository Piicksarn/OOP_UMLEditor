import java.util.ArrayList;

public class AssoMode {

	private static ArrayList<Line> lineList =  new ArrayList<Line>();
	private static Line tmpLine;
	private static ArrayList<Element> elementList;
	private Mode mode;
	
	
	public AssoMode(ArrayList<Element> elementList) {
		this.elementList = elementList;		
	}
	
	public void setMode(Mode mode) {
		this.mode = mode;
	}
	
	public void doAdd(int xI, int yI, int xE, int yE) {
		int htag = 0;
		int etag = 0;
		Element ele1 = elementList.get(checkElement(xI, yI));
		Element ele2 = elementList.get(checkElement(xE, yE));
   		if(checkElement(xI, yI)!= -1 && checkElement(xE, yE) != -1 ) {
   			if(checkElement(xI, yI) != checkElement(xE, yE)) {
   				htag = ele1.checkNear(xI, yI);
   				etag = ele2.checkNear(xE, yE);
   				if(ele1.getSideDone(htag) != 1 && ele2.getSideDone(etag) != 1) {
   					ele1.setSideDone(htag);
   					ele2.setSideDone(etag);
   					tmpLine = new Line(checkElement(xI, yI), checkElement(xE, yE), htag, etag, mode.getMode());
   					lineList.add(tmpLine);
   				}
   			}
   		}
		
	}
	public ArrayList<Line> getLineList() {
		return lineList;
	}
	
	private int checkElement(int x, int y) {
		for (int i = 0; i < elementList.size(); i++) {
			Element ele = elementList.get(i);
			if(x >= ele.getX() && x <= ele.getX() + ele.getW())
				if(y >= ele.getY() && y <= ele.getY() + ele.getH()) {
					return i;
				}
		}
		return -1;		
	}

}
