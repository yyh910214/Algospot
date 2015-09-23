import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @file Strjoin.java
 * @date 2015. 4. 3.
 * @author yyh
 */

public class Strjoin {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		int[] stringLengths;
		while (T-- > 0) {
			int N = input.nextInt();
			stringLengths = new int[N];
			Heap<Integer> heap = new Heap<Integer>();
			
			for (int i = 0; i < N; ++i) {
				stringLengths[i] = input.nextInt();
				heap.insert(stringLengths[i]);
			}

			int result = 0;
			for (int i = 1; i < N; ++i) {
				int temp1 = heap.get();
				heap.delete();
				int temp2 = heap.get();
				heap.delete();
				int sum = temp1 + temp2;
				heap.insert(sum);
				result += sum;
			}

			System.out.println(result);

		}
	}

	public static class Heap<T extends Comparable<T>> {
		private Object[] heap;
		private int capacity;
		private int heapSize;

		public Heap() {
			init();
		}

		private void init() {
			capacity = 100;
			heap = new Object[capacity];
			heapSize = 0;
		}
		
		public T get()	{
			if(heapSize == 0)
				return null;
			else
				return (T)heap[0];
		}

		public void insert(T data) {

			heap[heapSize] = data;
			heapSize++;

			int current = heapSize - 1;
			int parent = getParent(current);
			boolean inserted = false;
			Object temp;

			while (!inserted) {
				if (current == 0) {
					inserted = true;
				} else if (((T) heap[current]).compareTo((T) heap[parent]) < 0) {
					temp = heap[current];
					heap[current] = heap[parent];
					heap[parent] = temp;

					current = parent;
					parent = getParent(current);
				} else {
					inserted = true;
				}
			}
		}

		public void delete() {
			int parent = 0;
			heap[parent] = heap[heapSize - 1];
			heap[heapSize - 1] = null;
			heapSize--;

			boolean deleted = false;

			while (!deleted) {
				int leftIndex = getLeftChild(parent);
				int rightIndex = getRightChild(parent);

				int betterIndex;
				if (leftIndex > heapSize - 1) {
					deleted = true;
				} else {
					if (rightIndex > heapSize - 1) {
						betterIndex = leftIndex;
						deleted = true;
					} else {
						if (((T) heap[leftIndex])
								.compareTo((T) heap[rightIndex]) < 0) {
							betterIndex = leftIndex;
						} else {
							betterIndex = rightIndex;
						}
					}
					
					if(((T)heap[parent]).compareTo((T)heap[betterIndex]) < 0)	{
						deleted = true;
					} else	{
						Object temp = heap[betterIndex];
						heap[betterIndex] = heap[parent];
						heap[parent] = temp;
						
						parent = betterIndex;
						
					}
				}

			}
		}

		private int getLeftChild(int parent) {
			return parent * 2 + 1;
		}

		private int getRightChild(int parent) {
			return parent * 2 + 2;
		}

		private int getParent(int child) {
			if (child % 2 == 1) {
				return (int) ((child - 1) / 2);
			} else {
				return (int) ((child - 2) / 2);
			}
		}

	}
}
