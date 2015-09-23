import java.util.Scanner;

/**
 * @file Ratio.java
 * @date 2015. 4. 10.
 * @author yyh
 */

/*
 * Double은 최후의 최후까지 사용하지 말자.
 * 정밀도가 떨어져서....오답
 */
public class Ratio {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		while(T-->0)	{
			long N = input.nextLong();
			long M = input.nextLong();
			
			long winRate = (long)(((double)M * 100 )/N) + 1 ;

			long result = -1;
			if(winRate <= 99)	{
				double r = (double)(winRate * N - 100 * M)/(100 - winRate);
				
				result = (long)Math.ceil(r);
				
				for(int i = -500; i <= 500; i++) {
		            if(result + i > 0) {
		                int curr 
		                        = (int)((double)(M + result + i) 
		                                / (N + result + i) * 100);
		                if(curr >= winRate)	{
		                    result = result + i;
		                    break;
		                }
		            }
		        }
				
				if(result <= 0 || result > 2000000000)	{
					result = -1;
				}
				
			}
			
			System.out.println(result);
		}
	}
}
