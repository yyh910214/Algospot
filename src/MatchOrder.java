import java.util.Arrays;
import java.util.Scanner;

/**
 * @file MatchOrder.java
 * @date 2015. 2. 27.
 * @author yyh
 */

public class MatchOrder {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N, count;
		int[] russians, koreans;
		
		
		int T = input.nextInt();
		
		while(T-- > 0)	{
			N = input.nextInt();
			
			russians = new int[N];
			koreans = new int[N];
			for(int i = 0; i < N; ++i)	{
				russians[i] = input.nextInt();
			}
			for(int i = 0; i < N; ++i)	{
				koreans[i] = input.nextInt();
			}
			
			
			Arrays.sort(russians);
			Arrays.sort(koreans);
			
			count = 0;
			for(int i = 0; i < N; ++i)	{
				if(koreans[i] >= russians[count])	{
					++count;
				}
			}
			
			System.out.println(count);
			
		}
	}
}
