/**
 * @file WordLength.java
 * @date 2015. 5. 7.
 * @author yyh
 */

public class TODO_WordLength {
	public static void main(String[] args) {
		InputReader input = new InputReader(System.in);
		
		int T = input.nextInt();
		
		while(T-->0)	{
			int line = input.nextInt();
			int wordCount = 0;
			int lengthSum = 0;
			int tempLen = 0;
			boolean isDash = false;
			
			while(line-->0)	{
				String in = input.nextLine();
				int i;
				for(i = 0; i < in.length(); ++i)	{
					if(Character.isAlphabetic(in.charAt(i)))	{
						if(i == 0 && isDash)	{
							--wordCount;
						}
						++tempLen;
					} else if(tempLen != 0)	{
						lengthSum += tempLen;
						++wordCount;
						tempLen = 0;
						if(i == in.length() - 1 && in.charAt(i) == '-')	{
							isDash = true;
						}
					}
					
					if(i == 0)	{
						isDash = false;
					}
				}
				//한줄 다 끝나고 나왔을때 마지막이 -이면
				if(in.charAt(i-1) != '-' && tempLen != 0)	{
					lengthSum += tempLen;
					++wordCount;
					tempLen = 0;
				}
			}
			System.out.printf("%.4f\n",(double)lengthSum/wordCount);
		}
	}
}
