import java.util.Scanner;

/**
 * @file Boggle.java
 * @date 2015. 3. 13.
 * @author yyh
 */

public class TODO_Boggle {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		char[][] boggle;
		while(T-->0)	{
			boggle = new char[5][5];
			for(int i = 0; i < 5; ++i)	{
				String tempInput = input.next();
				boggle[i] = tempInput.toCharArray();
			}
		}
	}
	
	//public static boolean isPossible(int x, int y, char[] word)
}
