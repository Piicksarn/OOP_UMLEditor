import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyPanel extends JPanel{
	private static ArrayList<Buttons> btnList =  new ArrayList<Buttons>();
	private static ArrayList<Element> elementList =  new ArrayList<Element>();
	private static ArrayList<Line> lineList =  new ArrayList<Line>();
	private static ArrayList<int[]> rectangleList =  new ArrayList<int[]>();
	private static Line tmpLine;
	private Mode modeObj;
	private SelectMode selectMode;
	private BoxMode boxMode;

	public static int mode;
	private int seletedEleId = 0;
	public Color gray = new Color(237, 237, 237);
	private Dimension d = new Dimension(600, 600); 
	AllActionListioner listener;
	private static int selected = 0;
	private Group group = new Group();
	
	public MyPanel(int index) {
       	this.setBackground(gray);
       	listener = new AllActionListioner(this,modeObj);
       	this.addMouseListener(listener);
       	selectMode = new SelectMode(elementList, this);
       	boxMode = new BoxMode(elementList, this);

    }   
	
   	public void setBtnList(ArrayList<Buttons> list) {
   		btnList = list;
   	}
   	
   	public void changeName() {
   		String name;
   		name = JOptionPane.showInputDialog(null, "Enter name:");
   		if(name !=null)
   		elementList.get(selected).setName(name);
   		repaint();
   	}
   	
   	@Override
   	protected void paintComponent(Graphics g) {
   		super.paintComponent(g);
   		if(elementList.size() != 0)
   		for (int i = 0; i < elementList.size(); i++) {
   			if(elementList.get(i).getType() == 4)
   				drawClass(g, i);
   			else if(elementList.get(i).getType() == 5)
   				drawUserCase(g, i);
   		}
   		if(lineList.size() != 0)
   		for (int i = 0; i < lineList.size(); i++) {
   			Line line = lineList.get(i);
   			int headId = line.getHeadId();
   			int endId = line.getendId();
   			int headTag = line.getheadTag();
   			int endTag = line.getendTag();
   			int[] p1 = elementList.get(headId).getSideItem(headTag);
   			int[] p2 = elementList.get(endId).getSideItem(endTag);
   			g.drawLine(p1[0], p1[1], p2[0], p2[1]);
   			
   			if(line.getMode() == 3)
   				g.fillRect(p2[0] - 5, p2[1] - 5, 10, 10);
   			
   			else if(line.getMode() == 2) {
   	   			System.out.println("line MOde:" + line.getMode());

   				int[] xPoints = new int[3];
   		   		int[] yPoints = new int[3];
   				xPoints[0] = p2[0];
   				xPoints[1] = p2[0] - 8;
   				xPoints[2] = p2[0] + 8;
   				yPoints[0] = p2[1];
   				yPoints[1] = p2[1] + 10;
   				yPoints[2] = p2[1] + 10;
   				g.fillPolygon(xPoints, yPoints, 3);
   			}
   		}
   	}
  
   

	private void drawClass(Graphics g, int i) {
			System.out.println(elementList.size());

		Element ele = elementList.get(i);
		g.drawRect(ele.getX(), ele.getY(), ele.getW(), ele.getH());
		g.drawLine(ele.getX(), ele.getY() + ele.getH() / 2, ele.getX() + ele.getW(), ele.getY() + ele.getH() / 2);
		g.drawLine(ele.getX(), ele.getY() + ele.getH() * 3 / 4, ele.getX() + ele.getW(), ele.getY() + ele.getH() *3 / 4);
		g.drawString(ele.getName(), ele.getX() + ele.getW()/ 3, ele.getY() + ele.getH() / 6);
		if(ele.getFlag() == 1)
			draw4Points(g, i);
   	}

	private void drawUserCase(Graphics g, int i) {
		Element ele = elementList.get(i);
		g.drawOval(ele.getX(), ele.getY(), ele.getW(), ele.getH());
		g.drawString(ele.getName(), ele.getX() + ele.getW()/ 4, ele.getY() + ele.getH() / 2);
		if(ele.getFlag() == 1)
			draw4Points(g, i);
   	}
	

   	private void draw4Points(Graphics g, int index) {
   		Element ele = elementList.get(index);
   		ArrayList<int[]> point = ele.getFourPoint();
   		for (int i = 0; i < point.size(); i++) {
   			g.fillRect(point.get(i)[0] - 4, point.get(i)[1] - 4, 8, 8);
   		}
   		repaint();
	}
   	
   	private void drawLine(int xI, int yI, int xE, int yE) {
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
   					tmpLine = new Line(checkElement(xI, yI), checkElement(xE, yE), htag, etag, modeObj.getMode());
   					lineList.add(tmpLine);
   				}
   			}
   		}
   	}
   
   	/*
   	 * The part below is for the action which controled by mouse event.  
   	 *     # setElement	Function											 
   	 *     # press Function															 
   	 * 																     
   	 * 																     
   	 */
   	
	public ArrayList<Element> getEleList() {
		return elementList;
	}
	public void click(int x, int y) {
   		if(modeObj.getMode() == 5 || modeObj.getMode() == 4) {
   			boxMode.setPos(x,y);
   			boxMode.setMode(modeObj);
   			boxMode.doAdd();
   		}
   		else if (modeObj.getMode() == 0) {
   			selectMode.setPos(x,y);
   			selectMode.doSelect();
   		}
		repaint();
   	}
   	
	public void drag(int xI, int yI, int xE, int yE) {	
		if(modeObj.getMode() == 1 || modeObj.getMode() == 2 || modeObj.getMode() == 3)
			drawLine(xI, yI, xE, yE);
		else if(modeObj.getMode() == 0) {
			selectMode.selectElement(xI, yI, xE, yE, listener.getStartX(), listener.getStartY());	
			listener.setStartX(selectMode.setX());
			listener.setStartY(selectMode.setY());

		}
		repaint();
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

	@Override
	public Dimension getPreferredSize() {
		return d;
    }


	public void setModeObject(Mode mode) {
		this.modeObj = mode;
	}    
}
