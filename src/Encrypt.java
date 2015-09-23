import java.util.Scanner;

/**
 * @file Encrypt.java
 * @date 2015. 3. 11.
 * @author yyh
 */

public class Encrypt {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		while(T-->0)	{
			String string = input.next();
			char[] stringArray = string.toCharArray();
			for(int i = 0; i < string.length(); i+=2)	{
				System.out.print(stringArray[i]);
			}
			for(int i = 1; i < string.length(); i+=2)	{
				System.out.print(stringArray[i]);
			}
			System.out.println();
		}
	}
}
