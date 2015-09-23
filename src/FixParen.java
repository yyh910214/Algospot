import java.util.Scanner;
import java.util.Stack;

/**
 * @file FixParen.java
 * @date 2015. 4. 9.
 * @author yyh
 */

public class FixParen {
	
	static char[] PARENS = {
		'(',')','[',']','{','}','<','>'
	};
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char[] leftPriority = new char[4];
		char[] rightPriority = new char[4];
		
		int T = input.nextInt();
		
		while(T-->0)	{
			String string = input.next();
			char[] parentheses = string.toCharArray();
			String priority = input.next();

			for(int i = 0; i < 4; ++i)	{
				leftPriority[i] = priority.charAt(i);
				if(leftPriority[i] == '(')	{
					rightPriority[i] = ')';
				} else if(leftPriority[i] == '[')	{
					rightPriority[i] = ']';
				} else if(leftPriority[i] == '{')	{
					rightPriority[i] = '}';
				} else if(leftPriority[i] == '<')	{
					rightPriority[i] = '>';
				}
			}
			Stack<Integer> integerStack = new Stack<Integer>();
			
			
			for(int i = 0; i < parentheses.length; ++i)	{
				if(isOpenParen(parentheses[i]))	{
					integerStack.push(i);
				} else	{
					int leftIndex = integerStack.pop();
					for(int j = 0; j < 4; ++j)	{
						if(parentheses[leftIndex] == leftPriority[j])	{
							parentheses[i] = rightPriority[j];
							j = 4;
						} else if(parentheses[i] == rightPriority[j])	{
							parentheses[leftIndex] = leftPriority[j];
							j = 4;
						}
					}
				}
			}
			
			for(int i = 0; i < parentheses.length; ++i)	{
				System.out.print(parentheses[i]);
			}
			System.out.println();
		}
	}
	
	public static boolean isOpenParen(char c)	{
		if(c == '<' || c == '[' || c == '{' || c == '(')	{
			return true;
		}
		return false;
	} 
}
