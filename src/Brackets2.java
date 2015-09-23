import java.util.Scanner;
import java.util.Stack;

/**
 * @file Brackets2.java
 * @date 2015. 4. 7.
 * @author yyh
 */

public class Brackets2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		boolean isWell;
		Stack<Character> stack;
		
		while(T-->0)	{
			isWell = true;
			stack = new Stack<Character>();
			String string = input.next();
			for(int i = 0; (isWell && i < string.length()); ++i)	{
				char c = string.charAt(i);
				if(isOpen(c))	{
					stack.push(c);
				} else	{
					if(stack.size() == 0 || !wellMatched(stack.pop(),c))	{
						isWell = false;
					}
				}
			}
			
			if(stack.size() == 0 && isWell)	{
				System.out.println("YES");
			} else	{
				System.out.println("NO");
			}
		}
		
		
	}
	
	public static boolean isOpen(char c)	{
		if(c == '(' || c == '[' || c == '{')	{
			return true;
		}
		return false;
	}
	
	public static boolean wellMatched(char open, char close)	{
		boolean isWell = false;
		if((open == '(' && close == ')')
				|| (open == '[' && close == ']')
				|| (open == '{' && close == '}'))	
				{
			isWell = true;
		}
		
		return isWell;
	}
}
