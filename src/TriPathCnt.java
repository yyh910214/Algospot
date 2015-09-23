import java.util.Scanner;

/**
 * @file TriPathCnt.java
 * @date 2015. 3. 12.
 * @author yyh
 */

public class TriPathCnt {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T, N;
		int[][] triangle;
		int[] cache;
		int[] cnt;
		T = input.nextInt();
		
		while(T-->0)	{
			N = input.nextInt();
			triangle = new int[N][N];
			cache = new int[N];
			cnt = new int[N];
			
			for(int i = 0; i < N; ++i)	{
				for(int j = 0; j <= i; ++j)	{
					triangle[j][i] = input.nextInt();
				}
			}
			cache[0] = triangle[0][0];
			cnt[0] = 1;
			for(int i = 1; i < N; ++i)	{
				for(int j = i; j > 0; --j)	{
					if(cache[j-1] == cache[j])	{
						cnt[j] = cnt[j-1] + cnt[j];
					} else if(cache[j-1] > cache[j])	{
						cnt[j] = cnt[j-1];
					}
					cache[j] = Math.max(cache[j-1], cache[j]) + triangle[j][i];
				}
				cache[0] = cache[0] + triangle[0][i];
				cnt[0] = 1;
			}
			
			int max = 0;
			int result = 0;
			for(int i = 0; i < N; ++i)	{
				if(max < cache[i])	{
					max = cache[i];
					result = cnt[i];
				} else if(max == cache[i])	{
					result += cnt[i];
				}
					
			}
			
			System.out.println(result);
		}
	}
}
