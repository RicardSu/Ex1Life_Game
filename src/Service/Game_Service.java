package Service;
import DataStore.Array_Cell;
import DataStore.State_Cell;
import java.util.Random;

public class Game_Service {
	public static int[] temp = {-1,0,1};
	public static Array_Cell initMap(int row,int column) {
		Array_Cell cells = new Array_Cell(row,column);
		for(int i = 0;i<row;i++) {
			for(int j = 0; j<column;j++) { 
				Random r = new Random();
				int a = r.nextInt(4);
				if(a == 1) {
					cells.set_Cell(i, j, State_Cell.LIVE.get_Value());
				}else {
					cells.set_Cell(i, j, State_Cell.DEAD.get_Value());
				}
			}
		}
		return cells;
	}

	public static Array_Cell generate(Array_Cell cells) {
		Array_Cell next_Cells = new Array_Cell(cells.get_Row(),cells.get_Column());
	for(int i = 0;i<next_Cells.get_Row();i++) {
		for(int j=0;j<next_Cells.get_Column();j++) {
			int count =countNumber(cells,i,j);
			if(count == 3) {
				next_Cells.set_Cell(i, j, State_Cell.LIVE.get_Value());
			}
			else if(count==2&&cells.get_Cell(i, j)==State_Cell.LIVE.get_Value()) {
				next_Cells.set_Cell(i, j, State_Cell.LIVE.get_Value());
			}else {
				next_Cells.set_Cell(i, j, State_Cell.DEAD.get_Value());
			}
		}
	}
		return next_Cells;
	}
	public static int countNumber(Array_Cell cells,int x,int y) {
		int count = 0;
		for(int i =0;i<3;++i) {
			for(int j = 0;j<3;++j) {
				if(State_Cell.LIVE.get_Value()== cells.get_Cell(x+temp[i], y+temp[j])) {
					++count;//判断细胞周围是否有多少个活着的细胞，有的++
				}
			}
		}
		if(State_Cell.LIVE.get_Value()==cells.get_Cell(x, y)) {
			--count;
		}
		return count;
	}
}

