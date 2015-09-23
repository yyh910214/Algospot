import java.util.LinkedList;

/**
 * @file ITES.java
 * @date 2015. 5. 8.
 * @author yyh
 */

public class ITES {
	public static void main(String[] args) {
		InputReader input = new InputReader(System.in);
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		long mod = (long)(0x01) << 32;
		
		int a[] = {
				1,4,2,1,4,3,1,6,1
		};

		
		int T = input.nextInt();
		while(T-->0)	{
			long before = 1983;
			int K = input.nextInt();
			int N = input.nextInt();
			int sum = 0;
			int count = 0;
			int i = 0;
			while(i < N)	{
				if(sum == K)	{
					++count;
					sum -= list.pop();
				} else if(sum > K)	{
					sum -= list.pop();
				} else	{
					
					int temp = makeSignal(before);
					list.add(temp);
					sum += temp;
					before = (before * (long)214013 + (long)2531011) % mod;
					
					++i;
				}
			}
			System.out.println(count);
		}
	}
	
	public static int makeSignal(long in)	{
		return (int)(in % 10000 + 1);
	}
}
