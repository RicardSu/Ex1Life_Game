package GamePlay;
/*
	����Ϊ��������Ҳ����Ӧ�ò㣬DateStore��Ϊ���ݴ���㣬�����
	����ҪΪ���ݴ洢��GamePlay��ΪӦ�ò㣬��Ҫ���н�����UI��ƣ�
	Service��Ϊ����㣬������Ϸ�ĸ��ֹ��ܽ��д���.
*/
			//֮ǰ�����ĸ�������
import DataStore.Array_Cell;
import DataStore.State_Cell;
import Service.Game_Service;
			//����
import java.awt.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class Life_Game extends JFrame {
	private JButton[][] key;
	private JPanel jp0;
	private JPanel jp1;
	private JPanel jp2;
	private JPanel jp3;
    private Container window;
	private int row = 15;
	private int column = 15;
	private Array_Cell cells;
	private Array_Cell cells1;
	private int generation = 0;
	
	public Life_Game(String title) {
		super(title);
		//������Ϸ���ڳ���λ�����С
		setLocation(500,200);   //λ��
		setSize(900,900);		//��С
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window = getContentPane();
	}
	
	public void initGUI() { 
		jp0 = new JPanel();
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		jp0.setLayout(new BorderLayout(0,0));
		jp1.setLayout(new GridLayout(row,column,0,0));
		
		JLabel label0 = new JLabel("The number of cell rows: ");
		JTextField textField0 = new JTextField(2);
		
		JLabel label1 = new JLabel("The number of cell columns: ");
		JTextField textField1 = new JTextField(2);
		
		JButton Bu = new JButton("Yes");
		
		final JLabel label2 = new JLabel("Generation number: 0");
		
		jp2.add(label0);
		jp2.add(label1);
		jp3.add(label2);
		jp2.add(textField0);
		jp2.add(textField1);
		jp2.add(Bu);
		
		jp0.add(jp3,BorderLayout.SOUTH);
		
		window.add(jp0,BorderLayout.NORTH);
		window.add(jp1, BorderLayout.CENTER);
		
		key = new JButton[row][column];
		cells = Game_Service.initMap(row,column);
		generation = 1;
		int i,j;
		label2.setText("Generation Numbers��" + generation);
		for(i = 0;i<row;i++) {
			for(j = 0;j < column;j++) {
				key[i][j] = new JButton();
				key[i][j].setMargin(new Insets(0,0,0,0));
				if(cells.get_Cell(i, j) == State_Cell.LIVE.get_Value()) {
					key[i][j].setBackground(Color.blue);
					jp1.add(key[i][j]);
				} else {
					key[i][j].setBackground(Color.white);
					jp1.add(key[i][j]);
				}
			}
		}
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				cells = Game_Service.generate(cells);
				++generation;
				label2.setText("Generation Numbers: " + generation);
				for(int i =0;i<row;i++) {
					for(int j = 0;j<column;j++) {
						if(cells.get_Cell(i, j) == State_Cell.LIVE.get_Value()) {
							key[i][j].setBackground(Color.blue);
						}else {
							key[i][j].setBackground(Color.white);
						}
					}
				}
			}
		},0,500);
		setVisible(true);		
	}	
	public static void main(String args[]) {
		Life_Game life_game = new Life_Game("������̻���ʵ��1����������Ϸ");
		life_game.initGUI();
	}
	protected String[] a = null;

	public void test(String[] str){

	    this.a = str;

	}
}
