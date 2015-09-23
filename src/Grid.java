/**
 * @file Grid.java
 * @date 2015. 5. 4.
 * @author yyh
 */

public class Grid {
	public static void main(String[] args) {
		InputReader input = new InputReader(System.in);
		
		int T = input.nextInt();
		
		int[] gridCountArray = getGridCountArray();
		for(int i = 1; i <= T; ++i )	{
			int N = input.nextInt();
			System.out.println(i + " " + gridCountArray[N]);
		}
	}
	
	public static int[] getGridCountArray()	{
		int[] gridCountArray = new int[1001];
		gridCountArray[0] = 1;
		gridCountArray[1] = 1;
		gridCountArray[2] = 5;
		
		/*
		 * 끝나는 모양에 따라 경우를 세가지로 나눔
		 */
		for(int i = 3; i <= 1000; ++i)	{
			gridCountArray[i] = (gridCountArray[i-1]) // 끝이 세로 한줄짜리로 끝나는 경우
					+ (gridCountArray[i-2]*4); // 끝이 2열로 끝나는 경우 * 2열의 종류의 수
			
			// 끝이 지그재그 모양으로 끝나는 경우, 2의 배수일 경우는 특이한 경우하나가 더 추가됨
			for(int j = 0; j < i - 2; ++j)	{
				if((i - j) % 2 == 0)	{
					gridCountArray[i] += gridCountArray[j] * 3;
				} else	{
					gridCountArray[i] += gridCountArray[j] * 2;
				}
				
			}
		}
		
		return gridCountArray;
	}
}
