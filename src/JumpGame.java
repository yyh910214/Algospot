import java.util.Scanner;

/**
 * @file JumpGame.java
 * @date 2015. 3. 7.
 * @author yyh
 */

public class JumpGame {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T, N;
		int[][] map;
		
		T = input.nextInt();
		while(T-->0)	{
			N = input.nextInt();
			map = new int[N][N];
			for(int i = 0; i < N; ++i)	{
				for(int j = 0; j < N; ++j)
					map[j][i] = input.nextInt();
			}
			
			if(isPossible(map, N))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	
	public static boolean isPossible(int[][] map, int n)	{
		boolean visit[][] = new boolean[n][n];
		visit[0][0] = true;
		for(int i = 0; i < n; ++i)	{
			for(int j = 0; j < n; ++j)	{
				if(visit[j][i])	{
					if(i+map[j][i] < n)
						visit[j][i+map[j][i]] = true;
					if(j+map[j][i] < n)
						visit[j+map[j][i]][i] = true;
				}
			}
		}
			
		return visit[n-1][n-1];
	}
}
