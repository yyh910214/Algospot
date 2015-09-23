import java.util.Scanner;

/**
 * @file XHAENEUNG.java
 * @date 2015. 4. 7.
 * @author yyh
 */

public class XHAENEUNG {
	
	static String alphabetNum[] = {
			"zero","one","two","three","four","five","six","seven","eight","nine","ten"
	};
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		int[] alphabet;
		while(T-->0)	{
			alphabet = new int[26];
			int number1 = getAlphabetNum(input.next());
			String op = input.next();
			int number2 = getAlphabetNum(input.next());
			String eq = input.next();
			String studentResult = input.next();
			
			int result = -1;
			if(op.equals("+"))	{
				result = number1 + number2;
			} else if(op.equals("-"))	{
				result = number1 - number2;
			} else if(op.equals("*"))	{
				result = number1 * number2;
			}
			
			boolean isCorrect = false;
			
			if(result >= 0 && result <= 10)	{
				isCorrect = true;
				for(int i = 0; i < alphabetNum[result].length(); ++i)	{
					alphabet[alphabetNum[result].charAt(i) - 'a']++;
				}
				
				for(int i = 0; i < studentResult.length(); ++i)	{
					alphabet[studentResult.charAt(i) - 'a']--;
				}
				
				for(int i = 0; i < 26; ++i)	{
					if(alphabet[i] != 0)	{
						isCorrect = false;
					}
				}
			}
			
			if(isCorrect)	{
				System.out.println("Yes");
			} else	{
				System.out.println("No");
			}
		}
	}
	
	public static int getAlphabetNum(String string)	{
		for(int i = 0; i < alphabetNum.length; ++i)	{
			if(string.equals(alphabetNum[i]))	{
				return i;
			}
		}
		return -1;
	}
}
