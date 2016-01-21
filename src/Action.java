
public class Action {

	Mode mode;
	MyPanel panel;
	private SelectMode selectMode;
	private BoxMode boxMode;
	
	public Action(Mode mode, SelectMode selectMode, BoxMode boxMode, AssoMode assoMode, MyPanel panel) {
		this.mode = mode;
		this.selectMode = selectMode;
		this.boxMode = boxMode;
	}

}
