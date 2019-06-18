package DataStore;

public enum State_Cell {
	DEAD(0),
	LIVE(1);
	
	private int value;
	
	State_Cell(int value){
		this.value = value;
	}
	
	public int get_Value() {
		return value;
	}
}
