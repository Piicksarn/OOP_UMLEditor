
public class Line {

	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private int headEleId;
	private int endEleId;
	private int headEleTag;
	private int endEleTag;
	private int mode = 1;
	
	public Line(int head, int end, int hTag, int eTag, int mode) {
		headEleId = head;
		endEleId = end;
		headEleTag = hTag;
		endEleTag = eTag;
		this.mode = mode;
	}
	
	public void changeInt(int x, int y) {
		startX = x;
		startY = y;
	}

	public int getMode() {
		return mode;
	}
	public void changeEnd(int x, int y) {
		endX = x;
		endY = y;
	}
	
	public int getIniX() {
		return startX;
	}
	
	public int getEndX() {
		return endX;
	}
	
	public int getIniY() {
		return startY;
	}
	
	public int getEndY() {
		return endY;
	}
	
	public void setHeadIdd(int h) {
		headEleId = h;
	}
	
	public int getHeadId() {
		return headEleId;
	}
	
	public void setendId(int e) {
		endEleId = e;
	}
	
	public int getendId() {
		return endEleId;
	}
	
	public void setTags(int h, int e) {
		headEleTag = h;
		endEleTag = e;
	}
	
	public int getendTag() {
		return endEleTag;
	}
	
	public int getheadTag() {
		return headEleTag;
	}
}
