package DataStore;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Array_CellTest {
	public static Array_Cell demo = new Array_Cell(10,10);
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testArray_Cell() {
		
	}
	
	@Test
	public void testGet_Row() {
		int test0 = demo.get_Row();
		assertEquals(10,test0);
		System.out.println("getRow方法测试成功");
	}

	@Test
	public void testGet_Column() {
		int test1 = demo.get_Column();
		assertEquals(10,test1);
		System.out.println("getColumn方法测试成功");
	}

	@Test
	public void testSet_Row() {
		demo.set_Row(20);
		int test2 = demo.get_Row();
		assertEquals(20,test2);
		System.out.println("setCell方法测试成功");
	}

	@Test
	public void testSet_Column() {
		demo.set_Column(30);
		int test3 = demo.get_Column();
		assertEquals(30,test3);
		System.out.println("setColumn方法测试成功");
	}

	@Test
	public void testGet_Cell() {
		demo.set_Cell(5, 5, 9);
		int test4 = demo.get_Cell(5, 5);
		assertEquals(9,test4);
		System.out.println("getCell方法测试成功");
	}

	@Test
	public void testSet_Cell() {
		demo.set_Cell(6, 6, 6);
		int test4 = demo.get_Cell(6, 6);
		assertEquals(6,test4);
		System.out.println("setCell方法测试成功");
	}
}
