package DataStore;

public class Array_Cell {
	private int [][] arrayCell;    	//ϸ������
	private int row;	  			// ��
	private int column; 			// ��
	
	public Array_Cell(int row,int column) {  //����ϸ������
		this.row = row;
		this.column = column;
		arrayCell = new int [row][column];
	}
	public int get_Row() {  //�õ���
		return row;
	}
	
	public int get_Column() {  //�õ���
		return column;
	}
	
	public void set_Row(int row) {  //�����к���
		this.row = row;
	}
	
	public void set_Column(int column) {  //�����к���
		this.column = column;
	}
	
	public int get_Cell(int x,int y) {    //�õ�ϸ������
		if(x>= 0&&x<row&&y>=0&&y<column)
			return arrayCell[x][y];
		return 0;
	}
	
	public void set_Cell(int x,int y,int cell) {   //����ϸ������
		this.arrayCell[x][y] = cell;
	}
	
	
}
