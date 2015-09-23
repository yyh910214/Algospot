import java.util.Scanner;

/**
 * @file BruteForce.java
 * @date 2015. 5. 13.
 * @author yyh
 */

public class TODO_BruteForce {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		
		while(T-->0)	{
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int n = scanner.nextInt();
			
			long result = useSomeDigit(b-a+1, n+1);
			System.out.println(result);
			result *= pow(n,a-1);
			System.out.println(result);
			result = result % 1000000007;
			System.out.println(result);
		}
	}
	
	public static long useSomeDigit(long size, long degree)	{
		if(size == 1)	{
			return degree;
		} else	{
			
			long temp = useSomeDigit(size/2, degree);
			long temp2 = pow(degree, size/2);
			long result = (temp + 1) * temp2 + temp;
			
			if(size % 2 == 1)	{
				result += (temp2*degree);
			}
			
			return result % 1000000007;
		}
	}
	
	public static long pow(long a, long b)	{
		if(b == 0)	{
			return 1;
		}
		if(b == 1)	{
			return a;
		}
		if(b % 2 == 1)	{
			return (a * pow(a,b/2)) % 1000000007;
		} else	{
			return  pow(a,b/2) % 1000000007;
		}
	}
}
