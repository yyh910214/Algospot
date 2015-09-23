import java.util.Scanner;

/**
 * @file Decual.java
 * @date 2014. 10. 21.
 * @author yyh
 */

/**
 * @author yyh
 *
 */
public class Decual {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		
		while(T-- > 0)	{
			String compress1 = scanner.next();
			String compress2 = scanner.next();
			
			isSameString(compress1, compress2);
			
			
		}
	}
	
	public static boolean isSameString(String str1, String str2)	{
		boolean same = false;
		boolean end = false;
		
		char[] strArray1 = str1.toCharArray();
		char[] strArray2 = str2.toCharArray();
		
		while(!end)	{
			
		}
		
		return same;
	}
}
