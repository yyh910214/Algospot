import java.util.Scanner;

/**
 * @file Endians.java
 * @date 2015. 3. 12.
 * @author yyh
 */

public class Endians {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		while(T-->0)	{
			long N = input.nextLong();
			long result = 0;
			for(int i = 0; i < 4; ++i)	{
				result = result | (N & 0xFF);
				if(i < 3)
					result = result << 8;
				N = N >> 8;
			}
			System.out.println(result);
			
		}
	}
}
