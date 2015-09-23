import java.util.Scanner;

public class ClockSync {
	private static final int CLOCK_NUM = 16;
	// 하나의 버튼은 0~3번까지만 눌러볼 필요가 있다.
	private static final int MAX_TRY = 4;
	private static final int STATE12 = 12;

	private static final int[][] BUTTON = { { 0, 1, 2 }, { 3, 7, 9, 11 },
			{ 4, 10, 14, 15 }, { 0, 4, 5, 6, 7 }, { 6, 7, 8, 10, 12 },
			{ 0, 2, 14, 15 }, { 3, 14, 15 }, { 4, 5, 7, 14, 15 },
			{ 1, 2, 3, 4, 5 }, { 3, 4, 5, 9, 13 } };
	
	private static int[] clocks = new int[CLOCK_NUM];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int C;

		// TestCase 입력
		C = scanner.nextInt();
		
		int[] results  = new int[C];
		//
		for( int i = 0; i < C; i++)	{
			for(int j = 0; j < CLOCK_NUM; j++)	{
				clocks[j] = scanner.nextInt();
			}
			results[i] = clickButton(0);
		}
		
		for(int result : results)	{
			System.out.println(result);
		}

	}

	public static int clickButton(int button) {
		int count = 1000000;
		for (int i = 0; i < MAX_TRY; i++) {
			if (button < 9) {
				int beforeCount = clickButton(button + 1);
				if((beforeCount != -1) && (beforeCount + i < count))	{
					count = beforeCount + i;
				}
			} else if (button == 9) {
				count = -1;
				if(checkState())	{
					count = i;
					break;
				}
			}
			moveClock(button);
		}
		if(count == 1000000)	{
			return -1;
		}
		return count;
	}
	
	public static void moveClock(int button)	{
		for(int clockNum : BUTTON[button])	{
			clocks[clockNum] += 3;
			if(clocks[clockNum] > 12)	{
				clocks[clockNum] -= 12;
			}
		}
		
	}
	
	public static boolean checkState()	{
		for(int clock : clocks)	{
			if(clock != STATE12)	{
				return false;
			}
		}
		return true;
	}
	
}
