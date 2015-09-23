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
		 * ������ ��翡 ���� ��츦 �������� ����
		 */
		for(int i = 3; i <= 1000; ++i)	{
			gridCountArray[i] = (gridCountArray[i-1]) // ���� ���� ����¥���� ������ ���
					+ (gridCountArray[i-2]*4); // ���� 2���� ������ ��� * 2���� ������ ��
			
			// ���� ������� ������� ������ ���, 2�� ����� ���� Ư���� ����ϳ��� �� �߰���
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
