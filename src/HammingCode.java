import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @file HammingCode.java
 * @date 2015. 4. 15.
 * @author yyh
 */

public class HammingCode {
	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		
		int T = Integer.parseInt(input.readLine());
		
		while(T-->0)	{
			String string = input.readLine();
			byte[] bytes = new byte[8];
			int targetIndex = 0;
			for(int i = 1; i <= 7; ++i)	{
				bytes[i] = (byte)(string.charAt(i-1) - '0');
			}
			
			targetIndex += (bytes[1]^bytes[3]^bytes[5]^bytes[7]);
			targetIndex += 2*(bytes[2]^bytes[3]^bytes[6]^bytes[7]);
			targetIndex += 4*(bytes[4]^bytes[5]^bytes[6]^bytes[7]);
			
			bytes[targetIndex] ^= 1;
			
			System.out.print(bytes[3]);
			System.out.print(bytes[5]);
			System.out.print(bytes[6]);
			System.out.println(bytes[7]);
			
		}
	}
}
