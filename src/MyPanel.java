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
	public static int mode;
	private int seletedEleId = 0;
	private int idCounter = 0;
	public Color gray = new Color(237, 237, 237);
	private Dimension d = new Dimension(600, 600); 
	AllActionListioner listener = new AllActionListioner(this);
	private static int selected = 0;
	private Group group = new Group();
	
	public MyPanel(int index) {
       	this.setBackground(gray);
       	this.addMouseListener(listener);
    }   
	
   	public void setBtnList(ArrayList<Buttons> list) {
   		btnList = list;
   	}
   	
   	public void setMode(int index) {
   		this.mode = index;
   		ImageIcon img;
   		for (int i = 0; i < btnList.size(); i++) {
			if (i == mode) {
				img = new ImageIcon("/Users/yangenci/Desktop/pic/" + (i + 1) + "p.png");
				btnList.get(index).setFlag(true);
			}
			else {
				img = new ImageIcon("/Users/yangenci/Desktop/pic/" + (i + 1) + ".png");
				btnList.get(index).setFlag(false);
			}
			btnList.get(i).setImg(img);
   		}
   		repaint();
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
   			System.out.println(headId + "-" + endId + "-" + headTag + "-" + endTag);
   			int[] p1 = elementList.get(headId).getSideItem(headTag);
   			int[] p2 = elementList.get(endId).getSideItem(endTag);
   			g.drawLine(p1[0], p1[1], p2[0], p2[1]);
   			
   			if(line.getMode() == 3)
   				g.fillRect(p2[0] - 5, p2[1] - 5, 10, 10);
   			
   			if(line.getMode() == 2) {
   				int[] xPoints = new int[3];
   		   		int[] yPoints = new int[3];
   				xPoints[0] = p2[0];
   				xPoints[1] = p2[0] - 8;
   				xPoints[2] = p2[0] + 8;
   				yPoints[0] = p2[1];
   				yPoints[1] = p2[1] + 10;
   				yPoints[2] = p2[1] + 10;
   				g.fillPolygon(xPoints, yPoints, 3);
   				//g.drawLine(p2[0], p2[1], p2[0]+5, p2[1]+5);
   			}
   		}
   		/*if(rectangleList.size()!= 0) {
   			//for (int i = 0; i < rectangleList.size(); i++) {
   				g.drawRect(rectangleList.get(rectangleList.size()-1)[0], 
   						rectangleList.get(rectangleList.size()-1)[1], 
   						Math.abs(rectangleList.get(rectangleList.size()-1)[2] - rectangleList.get(rectangleList.size()-1)[0]),
   						Math.abs(rectangleList.get(rectangleList.size()-1)[3] - rectangleList.get(rectangleList.size()-1)[1]));
   			//}
   		}*/
   		
   	}
  
   

	private void drawClass(Graphics g, int i) {
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
   					tmpLine = new Line(checkElement(xI, yI), checkElement(xE, yE), htag, etag, mode);
   					lineList.add(tmpLine);
   				}
   			}
   		}
   	}
   	
   	private int startX = 0;
   	private int startY = 0;
   	
   	public void setActStartXY(int startX2, int startY2) {
		startX = startX2;
		startY = startY2;	
	}
   	
   	private void selectElement(int xI, int yI, int xE, int yE) {
   		if(checkElement(startX, startY)!= -1) {
   			for (int i = 0; i < elementList.size(); i++) {
	   			elementList.get(i).resetFlag();
	   		}
   			Element ele = elementList.get(checkElement(startX, startY));
   			int delX = xE - startX;
   			int delY = yE - startY;
			
   			if(checkElement(startX, startY) != -1)
   				ele.setPosition(ele.getX() + delX, ele.getY() + delY);
   			startX = xE;
   			startY = yE;
   			repaint();
   		}
   		else {
   			findArea(xI, yI, xE, yE);
   		}
	}
   	
   	/*
   	 * The part below is for the action which controled by mouse event.  
   	 *     # setElement	Function											 
   	 *     # press Function															 
   	 * 																     
   	 * 																     
   	 */
   	
	private void findArea(int xI, int yI, int xE, int yE) {
		for (int i = 0; i < elementList.size(); i++) {
			if(elementList.get(i).getX() < xE && elementList.get(i).getX() > xI
					&& elementList.get(i).getY() > yI
					&& elementList.get(i).getY() < yE){
				elementList.get(i).setFlag();
				group.addElement(elementList.get(i));
			}
		}
		group.setArea(xI, yI, xE, yE);
		int[] p = new int[4];
		p[0] = xI;
		p[1] = yI;
		p[2] = xE;
		p[3] = yE;
		rectangleList.add(p);
	}

	public void click(int x, int y) {
   		if(mode == 5 || mode == 4) {
   			Element element;
   			if(mode == 4) {
   				element= new Element(x, y, 120, 100);
   				element.setName("Class");
   			}
   			else {
   				element = new Element(x, y, 120, 70);
   				element.setName("Use Case");
   			}
   			element.setMode(mode);
   			element.setEleId(idCounter);
   			idCounter++;
   			elementList.add(element);  			
   		}
   		else if (mode == 0) {
   			int index = checkElement(x, y);
   			if(index != -1) {
   				for (int i = 0; i < elementList.size(); i++) {
   		   			elementList.get(i).resetFlag();
   		   		}
   				elementList.get(index).setFlag();
   				selected = index;
   			}
   			else {
   				for (int i = 0; i < elementList.size(); i++) {
   		   			elementList.get(i).resetFlag();
   		   		}
   				for (int i = 0; i < rectangleList.size(); i++) {
   					rectangleList.remove(i);
   				}
   				
   			}	
   		}
		repaint();
   	}
   	
	public void drag(int xI, int yI, int xE, int yE) {	
		if(mode == 1 || mode == 2 || mode == 3)
			drawLine(xI, yI, xE, yE);
		else if(mode == 0)
			selectElement(xI, yI, xE, yE);	
		repaint();
	}

	public void move(int x, int y) {
		
	}
	
	public void startPress(int x, int y) {
		
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

	@Override
	public Dimension getPreferredSize() {
		return d;
    }

	public void release(int startX2, int startY2, int x, int y) {
		if(checkElement(startX, startY)!= -1) {
			
		}
	}

	



	
	
       
}
