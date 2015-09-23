import java.util.Scanner;

/**
 * @file Mispell.java
 * @date 2015. 4. 4.
 * @author yyh
 */

public class Mispell {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		int count = 1;
		while(T-->0)	{
			int N = input.nextInt();
			String string = input.next();
			
			StringBuilder result = new StringBuilder(); 

			System.out.print(count + " ");
			for(int i = 0; i < string.length(); ++i)	{
				if(N-1 != i)	{
					//result.append(string.charAt(i));
					System.out.print(string.charAt(i));
				}
			}
			System.out.println();
			
			//System.out.println(count + " " + );
			count++;
		}
	}
}
