package A2JUnit;

/**
 * Author: Elnifio
 * Date: Oct. 22, 2019
 */

import BST_A2.*; // 请务必自行更改这里的import package名
import static org.junit.Assert.*; // 使用JUnit 5，运行前请自行import JUnit 5

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class JUnitMain {
	
	private BST bst;
	private String[] arr;
	private static Random rn = new Random(); 

	@Before
	public void setUp() {
		bst = new BST();
		arr = new String[50];
	}
	
	@Test
	public void testEmpty() {
		assertEquals(bst.empty(), true);
		assertEquals(-1, bst.height());
	}

	@Test
	public void testInsertReturn() {
		boolean[] bool = {
				bst.insert("g"),
				bst.insert("a"),
				bst.insert("s"),
				bst.insert("d"),
				bst.insert("f"),
				bst.insert("t"),
				bst.insert("p")
				};
		
		for (int i = 0; i < bool.length; i++ ) {
			assertEquals(true, bool[i]);
		}
		
		assertEquals(false, bst.insert("g"));
		assertEquals(bst.insert("g"), !bst.contains("g"));
		assertEquals(bst.empty(), false);
		assertEquals(bst.size(), 7);
		assertEquals(bst.height(), 3);
	}
	
	@Test
	public void testInsert() {
		bst = new BST();
		int actual_size = 0;
		
		for (int i = 0; i < 50; i++) {
			arr[i] = nextString();
			boolean contains = bst.contains(arr[i]);
			boolean insert_success = bst.insert(arr[i]);
			assertEquals(insert_success, !contains);
			actual_size = (insert_success)?(actual_size + 1):(actual_size);
		}
		assertEquals(bst.size(), actual_size);
	}
	
	@Test
	public void testRemoveRoot() {

		bst.insert("g");
		bst.insert("a");
		bst.insert("s");
		bst.insert("d");
		bst.insert("f");
		bst.insert("t");
		bst.insert("p");
		
		boolean rem_g = bst.remove("g");
		assertEquals(true, rem_g);
		assertEquals(6, bst.size());
		assertEquals(false, bst.contains("g"));
		
	}
	
	@Test
	public void testRemoveLeaf() {
		bst.insert("g");
		bst.insert("a");
		bst.insert("s");
		bst.insert("d");
		bst.insert("f");
		bst.insert("t");
		bst.insert("p");
		
		boolean rem_a = bst.remove("a");
		assertEquals(true, rem_a);
		assertEquals(6, bst.size());
		assertEquals(false, bst.contains("a"));
	}
	
	@Test
	public void testRemoveBasic() {
		
		bst = new BST();
		bst.insert("g");
		bst.insert("a");
		boolean rem_d = bst.remove("d");
		assertEquals(false, rem_d);
		assertEquals(2, bst.size());
		
		boolean rem_g = bst.remove("g");
		assertEquals(true, rem_g);
		assertEquals(1, bst.size());
		assertEquals(false, bst.contains("g"));
		
		boolean rem_a = bst.remove("a");
		assertEquals(true, rem_a);
		assertEquals(0, bst.size());
		assertEquals(false, bst.contains("a"));
	}
	
	@Test
	public void testRightChildRemove() {
		bst = new BST();
		bst.insert("g");
		bst.insert("j");
		boolean rem_g = bst.remove("g");
		assertEquals(true, rem_g);
		assertEquals(1, bst.size());
		assertEquals(false, bst.contains("g"));
		
		bst = new BST();
		bst.insert("g");
		bst.insert("j");
		boolean rem_j = bst.remove("j");
		assertEquals(true, rem_j);
		assertEquals(1, bst.size());
		assertEquals(false, bst.contains("j"));
		
		bst = new BST();
		bst.insert("g");
		bst.insert("j");
		bst.insert("l");
		rem_j = bst.remove("j");
		assertEquals(true, rem_j);
		assertEquals(2, bst.size());
		assertEquals(false, bst.contains("j"));
		
		bst = new BST();
		bst.insert("g");
		bst.insert("j");
		bst.insert("h");
		rem_j = bst.remove("j");
		assertEquals(true, rem_j);
		assertEquals(2, bst.size());
		assertEquals(false, bst.contains("j"));
		
		// remove right node with two children
		bst = new BST();
		bst.insert("g");
		bst.insert("j");
		bst.insert("l");
		bst.insert("h");
		bst.insert("u");
		bst.insert("i");
		bst.insert("o");
		bst.insert("p");
		bst.insert("k");
		rem_j = bst.remove("j");
		assertEquals(true, rem_j);
		assertEquals(8, bst.size());
		assertEquals(false, bst.contains("j"));
	}
	
	@Test
	public void testLeftChildRemove() {
		bst = new BST();
		bst.insert("g");
		bst.insert("a");
		boolean rem_g = bst.remove("g");
		assertEquals(true, rem_g);
		assertEquals(1, bst.size());
		assertEquals(false, bst.contains("g"));
		
		bst = new BST();
		bst.insert("g");
		bst.insert("a");
		boolean rem_a = bst.remove("a");
		assertEquals(true, rem_a);
		assertEquals(1, bst.size());
		assertEquals(false, bst.contains("a"));
		
		bst = new BST();
		bst.insert("g");
		bst.insert("b");
		bst.insert("c");
		boolean rem_b = bst.remove("b");
		assertEquals(true, rem_b);
		assertEquals(2, bst.size());
		assertEquals(false, bst.contains("b"));
		
		bst = new BST();
		bst.insert("g");
		bst.insert("b");
		bst.insert("a");
		rem_b = bst.remove("b");
		assertEquals(true, rem_b);
		assertEquals(2, bst.size());
		assertEquals(false, bst.contains("b"));
		
		bst = new BST();
		bst.insert("g");
		bst.insert("d");
		bst.insert("e");
		bst.insert("f");
		bst.insert("b");
		bst.insert("c");
		bst.insert("a");
		bst.insert("h");
		bst.insert("k");
		boolean rem_d = bst.remove("d");
		assertEquals(true, rem_d);
		assertEquals(8, bst.size());
		assertEquals(false, bst.contains("d"));	
	}	
		
	@Test
	public void testRandomRemove() {
		bst = new BST();
		int actual_size = 0;
		
		for (int i = 0; i < 50; i++) {
			// Reduces the size of the sample space to 
			// increase repetitions in the strings
			arr[i] = nextString(0, 1);
			
			// Increase the size of the sample space to 
			// reduce repetitions in the strings
//			arr[i] = nextString();
			boolean insert_success = bst.insert(arr[i]);
			actual_size = (insert_success)?(actual_size + 1):(actual_size);
		}
		
		for (int i = 0; i < 20; i++) {
			int random_num = rn.nextInt(arr.length);
			String str_rmd = arr[random_num];
			boolean contain = bst.contains(str_rmd);
			boolean rem_res = bst.remove(str_rmd);
			assertEquals(rem_res, contain);
			assertEquals(false, bst.contains(str_rmd));
		}
		
		System.out.println(String.format("arr length: %d; actual size: %d", arr.length, actual_size));
	}
	
	@Test
	public void testMinMax() {
		bst = new BST();
		int actual_size = 0;
		
		for (int i = 0; i < 50; i++) {
			arr[i] = nextString();
			boolean contains = bst.contains(arr[i]);
			boolean insert_success = bst.insert(arr[i]);
			actual_size = (insert_success)?(actual_size + 1):(actual_size);
		}
		
		arr = bubble_sort(arr);
		String min = bst.findMin();
		String max = bst.findMax();
		assertEquals(arr[0], min);
		assertEquals(arr[arr.length - 1], max);
		
		bst = new BST();
		assertEquals(null, bst.findMin());
		assertEquals(null, bst.findMax());
	}
	
	public static String[] bubble_sort(String[] arr_in) {
		
		String[] out_arr = arr_in.clone();
		
		for (int i = 0; i < out_arr.length - 1; i++) {
			for (int j = 0; j < out_arr.length - i - 1; j++) {
				if (out_arr[j].compareTo(out_arr[j + 1]) > 0) {
					String temp = out_arr[j];
					out_arr[j] = out_arr[j + 1];
					out_arr[j + 1] = temp;
				}
			}
		}
		
		return out_arr;
	}
	
	public static int rand(int lo, int hi) {
		int n = hi - lo + 1;
		int i = rn.nextInt() % n;
		if (i < 0) i = -i;
		return lo + i;
	}

	@SuppressWarnings("deprecation")
	public static String nextString(int lo, int hi) {
		int n = rand(lo, hi);
		byte b[] = new byte[n];
		for (int i = 0; i < n; i++)
			b[i] = (byte)rand('a', 'z');
		return new String(b, 0);
	}

	public static String nextString() {
		return nextString(5, 25);
	}
	
}
