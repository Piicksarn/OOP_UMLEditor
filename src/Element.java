import java.util.ArrayList;

public class Element{

	private int width = 100;
	private int hight = 120;
	private int xPosition;
	private int yPosition;
	private int elementId;
	private int mode = 0;
	private int eleId;
	private int drag = 0;
	private int flag = 0;
	private ArrayList<int[]> point = new ArrayList<int[]>();
	private int[] sideDone = new int[]{0,0,0,0};
	private String name;
	public Element(int x, int y, int w, int h) {
		width = w;
		hight = h;
		xPosition = x;
		yPosition = y;
		for (int i = 0; i < 4; i++) {
			int[] p = new int[2];
			point.add(p);	
		}
		setFourPoint(x, y);
	}
		
	public void setEleId(int index) {
		eleId = index;
	}
	
	public void setSize(int w, int h) {
		width = w;
		hight = h;
	}
	
	public int getW() {
		return width;
	}
	
	public int getH() {
		return hight;
	}
	
	public int getEleId() {
		return eleId;
	}
	
	public void setMode(int index) {
		mode = index;
	}
	
	public int getX() {
		return xPosition;
	}
	
	public int getY() {
		return yPosition;
	}

	public int getType() {
		return mode;
	}
	
	public int getFlag() {
		return flag;
	}
	
	public void setFlag() {
		flag ^= 1;
	}
	
	public void setPosition(int x, int y) {
		xPosition = x;
		yPosition = y;
		setFourPoint(x, y);
	}
	
	public void setDrag(int d) {
		drag = d;
	}
	
	public void setName(String s) {
		name = s;
	}
	
	public int getDrag() {
		return drag;
	}
	
	public int[] getSide() {
		return sideDone;
	}
	
	public int[] getSideItem(int i) {
		return point.get(i);
	}
	
	public void setSideDone(int i) {
		sideDone[i] = 1;
	}
	
	public int getSideDone(int i) {
		return sideDone[i];
	}
	
	public boolean sideStatus(int i ) {
		if(sideDone[i] == 1)
			return true;
		else 
			return false;
	}
	
	public int checkNear(int x, int y) {
		int[] p = new int[2];
		int index = 0;
		double min = Math.hypot(point.get(0)[0] - x, point.get(0)[1] - y);
		for (int i = 1; i < 4; i++) {
			if(min > Math.hypot(point.get(i)[0] - x, point.get(i)[1] - y)) {
				min = Math.hypot(point.get(i)[0] - x, point.get(i)[1] - y);
				index = i;
			}
		}
		return index;
	}
	
	public int[] getTagPos(int i) {
		return point.get(i);
	}
	
	private void setFourPoint(int x, int y) {
		point.get(0)[0] = x + width; 
		point.get(0)[1] = y + hight / 2;
		point.get(1)[0] = x; 
		point.get(1)[1] = y + hight / 2;
		point.get(2)[0] = x + width / 2;
		point.get(2)[1] = y;
		point.get(3)[0] = x + width / 2;
		point.get(3)[1] = y + hight;
	}

	public ArrayList<int[]> getFourPoint() {
		return point;
	}
	public String getName() {
		return name;
	}

	public void resetFlag() {
		flag = 0;
	}
}
