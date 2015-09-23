/**
 * @file Palindromize.java
 * @date 2015. 5. 5.
 * @author yyh
 */

public class TODO_Palindromize {
	public static void main(String[] args) {
		InputReader input = new InputReader(System.in);
		
		int T = input.nextInt();
		while(T-->0)	{
			String in = input.nextString();
			int palindromeIndex = -1, startIndex = 0, endIndex = in.length() -1;
			int tempIndex = -1;
			while(startIndex < endIndex)	{
				
				if(tempIndex == -1)	{
					if(in.charAt(startIndex) == in.charAt(in.length() - 1))	{
						tempIndex = startIndex;
					}
				}
				
				if(in.charAt(startIndex) != in.charAt(endIndex))	{
					if(tempIndex == -1)	{
						palindromeIndex = startIndex - 1;
						endIndex = in.length();
					} else	{
						palindromeIndex = tempIndex - 1;
						startIndex = tempIndex;
						tempIndex = -1;
						endIndex = in.length() -1;
					}
				} 
				
				++startIndex;
				--endIndex;
				
				
				
			}
			
			System.out.println(palindromeIndex + 2 + in.length());
		}
	}
}
