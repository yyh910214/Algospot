import java.util.LinkedList;
import java.util.Scanner;

/**
 * @file Josephus.java
 * @date 2015. 4. 6.
 * @author yyh
 */

public class Josephus {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		
		LinkedList<Integer> list;
		while(T-->0)	{
			list = new LinkedList<Integer>();
			int N = input.nextInt();
			for(int i = 0; i < N; ++i)	{
				list.add(i);			
			}
			
			int K = input.nextInt();
			int index = 0;
			while(list.size() > 2)	{
				list.remove(index);
				index = (index + K - 1) % list.size();
			}
			
			System.out.println((list.get(0)+1) + " " + (list.get(1)+1));
		}
	}
}
