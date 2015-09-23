import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @file Lecture.java
 * @date 2015. 4. 4.
 * @author yyh
 */

public class Lecture {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		
		while(T-->0)	{
			String string = input.next();
			String[] strings = new String[string.length()/2];
			
			for(int i = 0; i < string.length()/2; ++i)	{
				strings[i] = string.substring(2*i, 2*i+2);
			}
			
			Arrays.sort(strings);
			
			for(int i = 0; i < string.length()/2; ++i)	{
				System.out.print(strings[i]);
			}
			
			System.out.println();
			
		}
	}
	
}
