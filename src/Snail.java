import java.util.Scanner;

/**
 * @file Snail.java
 * @date 2015. 3. 12.
 * @author yyh
 */

public class Snail {
	static double[][] cache;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		
		while(T-->0)	{
			int n = input.nextInt();
			int m = input.nextInt();
			
			cache = new double[n+1][m+1];
			for(int i = 0; i < n+1; ++i)	{
				for(int j = 0; j < m+1; ++j)	{
					cache[i][j] = -1.0;
				}
			}
			System.out.printf("%.10f\n",snail(n,m));
		}
	}
	
	public static double snail(int n, int m)	{
		if(cache[n][m] != -1.0)
			return cache[n][m];
		
		if(n > 2*m)
			cache[n][m] = 0.0;
		else if(n < 2)	{
			cache[n][m] = 1.0;
		}
		
		else
			cache[n][m] = snail(n-2,m-1)*0.75 + snail(n-1,m-1)*0.25;
		
		return cache[n][m];
	}
}
