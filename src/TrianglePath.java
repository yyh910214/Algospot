import java.util.Scanner;

/**
 * @file TrianglePath.java
 * @date 2015. 3. 7.
 * @author yyh
 */

public class TrianglePath {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T, N;
		int[][] triangle;
		int[] cache;
		T = input.nextInt();
		
		while(T-->0)	{
			N = input.nextInt();
			triangle = new int[N][N];
			cache = new int[N];
			
			for(int i = 0; i < N; ++i)	{
				for(int j = 0; j <= i; ++j)	{
					triangle[j][i] = input.nextInt();
				}
			}
			cache[0] = triangle[0][0];
			for(int i = 1; i < N; ++i)	{
				for(int j = i; j > 0; --j)	{
					cache[j] = Math.max(cache[j-1], cache[j]) + triangle[j][i];
				}
				cache[0] = cache[0] + triangle[0][i];
			}
			
			int max = 0;
			for(int i = 0; i < N; ++i)
				if(max < cache[i])
					max = cache[i];
			
			System.out.println(max);
		}
	}
}
