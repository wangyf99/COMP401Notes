package test;


public class Main {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		printListStack(arr, 4.2);
		

	}
	
	public static void printListStack(int[] arr, double count) {
		Stack s = new Stack();
		count = (int) (Math.ceil(arr.length * count));
		while (count > 0) {
			if (s.size() == 0) { 
				for (int index = 0; index < arr.length && count > 0; index ++) { 
					System.out.print(arr[index]);
					System.out.print(" -> ");
					s.push(arr[index]); 
					count --;
				} 
			} else {
				while (s.size() != 0 && count > 0) {
					System.out.print(s.pop());
					System.out.print(" -> ");
					count --;
				}
			}
			System.out.println("");
		}
	}
	
	public static void printListStack(int[] arr, int num) {
		Stack s = new Stack();
		while (num > 0) {
			if (s.size() == 0) { 
				for (int index = 0; index < arr.length; index ++) { 
					System.out.print(arr[index]);
					System.out.print(" -> "); // 打印箭头
					s.push(arr[index]); 
				}
				num -= 1; 
			} else {
				while (s.size() != 0) {
					System.out.print(s.pop());
					System.out.print(" -> "); // 打印箭头
				}
				num -= 1;
			}
			System.out.println(""); // 换行
		}
	}
	
	public static void printListIteratively(int[] arr, int num) {
		int count = 0;
		boolean reverse = false;
		int index = 0;
		while (count < num) {
			System.out.print(arr[index]);
			System.out.print(" -> "); // 在每个元素末尾加上箭头
			if (reverse) {
				index --;
			} else {
				index ++;
			}
			if (index == arr.length) {
				index --;
				reverse = true;
				count += 1;
				System.out.println(""); // 打印完一个list之后换行
			} else if (index == -1) {
				index ++;
				reverse = false;
				count += 1;
				System.out.println(""); // 换行
			}
		}
	}
}


class Stack {
	static int MAX = 10000;
	int head = 0;
	int tail = -1;
	int[] stack = new int[MAX];
	Stack() {}
	
	int size() { return tail + 1; } // Actual size of this Stack
	void push(int val) { stack[++tail] = val; } // Pushes the value into the next available slot
	
	int pop() {
		if (size() == 0) { throw new RuntimeException("size is zero!"); } // Check edge case
		return stack[tail--]; // Pops the last element out from the stack
	}
}
