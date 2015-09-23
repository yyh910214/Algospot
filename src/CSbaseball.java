import java.util.Scanner;

/**
 * @file CSbaseball.java
 * @date 2015. 4. 4.
 * @author yyh
 */

public class CSbaseball {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		
		while(T-->0)	{
			int A = input.nextInt();
			int B = input.nextInt();
			
			if(A > B)
				System.out.println(0);
			else
				System.out.println(B-A+4);
			
			
		}
	}
}
