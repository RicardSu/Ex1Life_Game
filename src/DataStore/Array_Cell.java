package DataStore;

public class Array_Cell {
	private int [][] arrayCell;    	//细胞矩阵
	private int row;	  			// 行
	private int column; 			// 列
	
	public Array_Cell(int row,int column) {  //构造细胞函数
		this.row = row;
		this.column = column;
		arrayCell = new int [row][column];
	}
	public int get_Row() {  //得到行
		return row;
	}
	
	public int get_Column() {  //得到列
		return column;
	}
	
	public void set_Row(int row) {  //设置行函数
		this.row = row;
	}
	
	public void set_Column(int column) {  //设置列函数
		this.column = column;
	}
	
	public int get_Cell(int x,int y) {    //得到细胞数组
		if(x>= 0&&x<row&&y>=0&&y<column)
			return arrayCell[x][y];
		return 0;
	}
	
	public void set_Cell(int x,int y,int cell) {   //设置细胞数组
		this.arrayCell[x][y] = cell;
	}
	
	
}
