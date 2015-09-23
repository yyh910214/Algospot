import java.util.Scanner;

/**
 * @file Maxsum.java
 * @date 2015. 4. 10.
 * @author yyh
 */

public class Maxsum {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int T = Integer.parseInt(input.nextLine());
		int[] array = new int[100000];
		while(T-->0)	{
			int N = Integer.parseInt(input.nextLine());
			String[] strings = (input.nextLine()).split(" ");
			for(int i = 0; i < N; ++i)	{
				array[i] = Integer.parseInt(strings[i]);
			}
			
			int maxSum = array[0];
			int temp = (maxSum < 0) ? 0 : maxSum;
			for(int i = 1; i < N; ++i)	{
				temp += array[i];
				
				if(temp < 0)	{
					temp = 0;
				}
				
				if(temp > maxSum)	{
					maxSum = temp;
				}
				
			}
			
			System.out.println(maxSum);
		}
	}
}
