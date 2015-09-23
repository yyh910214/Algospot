import java.util.Arrays;
import java.util.Scanner;

/**
 * @file DrawRect.java
 * @date 2015. 4. 4.
 * @author yyh
 */

public class DrawRect {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		int[] x = new int[3];
		int[] y = new int[3];
		int resultX, resultY;
		
		while(T-->0)	{
			
			for(int i = 0; i < 3; ++i)	{
				x[i] = input.nextInt();
				y[i] = input.nextInt();
			}
			
			resultX = x[0];
			resultY = y[0];
			
			if(x[1] != x[2])	{
				if(x[1] == x[0])
					resultX = x[2];
				else
					resultX = x[1];
			}
			
			if(y[1] != y[2])	{
				if(y[1] == y[0])
					resultY = y[2];
				else
					resultY = y[1];
			}
			
			System.out.println(resultX + " " + resultY);
		}
	}
}
