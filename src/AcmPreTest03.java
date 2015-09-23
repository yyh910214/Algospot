import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @file AcmPreTest03.java
 * @date 2014. 10. 3.
 * @author yyh
 */

/**
 * @author yyh
 *
 */
public class AcmPreTest03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		
		for(int i = 0; i < T; i++)	{
			String machine = scanner.next();
			List<Character> exceptionChar = new ArrayList<Character>();
			String symbol = makeSymbol(machine, exceptionChar);
			System.out.println(symbol);
		}
	}

	
	public static String makeSymbol(String machine, List exceptionChar)	{
		Stack<Character> stack = new Stack<Character>();
		char[] machineArray = machine.toCharArray();
		int index = 0;
		boolean isFindUnderbar = false;
		boolean isEnd = false;
		while((!isEnd) && (index < machineArray.length))	{
			stack.add(machineArray[index]);
			if(machineArray[index] == '_')	{
				isFindUnderbar = true;
			}
			if((machineArray[index] == ')') && isFindUnderbar)	{
				isEnd = true;
			}
			index++;
		}
		
		StringBuilder sb = new StringBuilder();
		boolean isBracket = false;
		while(!stack.isEmpty())	{
			char popChar = stack.pop();
			if(popChar == '_')	{
				sb.append(popChar);
			} else if(!isBracket)	{
				if(popChar == '(')	{
					isBracket = true;				
				}
			} else if(isBracket)	{
				if(popChar == '|')	{
					isBracket = false;
				} else if(popChar != '(')	{
					sb.append(popChar);
				}
			}
		}
		
		sb.reverse();
		
		isBracket = true;
		
		for(int i = index; i < machineArray.length; i++)	{
			if(machineArray[i] == ')')	{
				isBracket = true;
			} else if(isBracket)	{
				if(machineArray[i] == '|')	{
					isBracket = false;
				} else	{
					sb.append(machineArray[i]);				
				}
			}
		}
		
		return sb.toString();
	}
}
