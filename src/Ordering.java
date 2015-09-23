import java.util.Scanner;

/**
 * @file Ordering.java
 * @date 2015. 4. 6.
 * @author yyh
 */

public class Ordering {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		
		while(T-->0)	{
			int N = input.nextInt();
			boolean[][] relation = new boolean[N][N];
			int[] count = new int[N];
			boolean end = false;
			
			/*
			 *  관계 만들기
			 */
			
			int relationCount = input.nextInt();
			for(int i = 0; i < relationCount; ++i)	{
				String string = input.next();
				relation[string.charAt(0)-'A'][string.charAt(1)-'A'] = true;
				count[string.charAt(1)-'A']++;
			}
			
			/*
			 * 확인하기
			 */
			while(!end)	{
				end = true;
				
				for(int i = 0; i < N; ++i)	{
					if(count[i] >= 0)	{
						end = false;
					}
					if(count[i] == 0)	{
						System.out.print((char)('A'+i));
						count[i]--;
						checkRelation(i, relation, count);
						i = N;	// for문을 끝내기 위한 조건
					}
				}
			}
			
			System.out.println();
		}
	}
	
	public static void checkRelation(int jobIndex, boolean[][] relation, int[] count)	{
		for(int i = 0; i < relation[jobIndex].length; ++i)	{
			if(relation[jobIndex][i])	{
				--count[i];
			}
		}
	}
}
