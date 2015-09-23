import java.util.Scanner;

/**
 * @file DiamondPath.java
 * @date 2015. 3. 11.
 * @author yyh
 */

public class DiamondPath {
	static int[][] diamond;
	static int[][] cache;
	
	public static void main(String[] args) {
		int T, N;
		Scanner input = new Scanner(System.in);
		
		T = input.nextInt();
		
		while(T-->0)	{
			N = input.nextInt();
			
			diamond = new int[2*N][N+1];
			cache = new int[2*N][N+1];
			
			int i = 0;
			
			for(i = 0; i < N-1; ++i)	{
				for(int j = N-i-1; j < N; ++j)	{
					diamond[i][j] = input.nextInt();
				}
			}
			
			for(i = 0; i < N; ++i)	{
				for(int j = 0; j < N-i; ++j)	{
					diamond[N+i-1][j] = input.nextInt();
				}
			}
			
			System.out.println(path(2*N-2,0));
		}
		
	}
	
	public static int path(int lineNo, int index)	{
		
		if(cache[lineNo][index] != 0 || diamond[lineNo][index] == 0)	{
			return cache[lineNo][index];
		}
		int maxPath = 0;
		
		if(lineNo != 0)	{
			maxPath = Math.max(path(lineNo-1, index), path(lineNo-1, index+1));
		}
		
		maxPath += diamond[lineNo][index];
		
		cache[lineNo][index] = maxPath;
		return maxPath;
	}
}
