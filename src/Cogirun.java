import java.util.Scanner;

/**
 * @file Cogirun.java
 * @date 2014. 10. 10.
 * @author yyh
 */

/**
 * @author yyh
 * 
 */
public class Cogirun {
	private static char[][] map;
	private static short[][] upState;
	private static short[][] downState;

	private static final short STATE0 = 0;
	private static final short STATE1 = 1;
	private static final short STATE2 = 2;

	/*
	 * state 0 : 방문이 불가능한 상태 state 1 : 점프가 가능한 상태 state 2 : 점프가 불가능한 상태
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();

		for (int i = 0; i < T; i++) {
			int W = scanner.nextInt();
			int H = scanner.nextInt();

			map = new char[W][H];
			downState = new short[W][H + 1];
			upState = new short[W][H + 1];

			for (int k = H - 1; k >= 0; k--) {
				String input = scanner.next();
				char[] inputArray = input.toCharArray();
				for (int j = 0; j < W; j++) {
					map[j][k] = inputArray[j];
				}
			}

			upState[0][0] = STATE1;
			for (int j = 1; j < W; j++) {
				for (int k = H - 1; k >= 0; k--) {
					if (map[j][k] == '.') {
						checkPossible(j, k, W, H);
					}
				}
			}

//			for (int k = H - 1; k >= 0; k--) {
//				for (int j = 0; j < W; j++) {
//					if ((upState[j][k] != STATE0) || (downState[j][k] != STATE0))
//						System.out.print(1);
//					else
//						System.out.print(0);
//				}
//				System.out.println();
//			}

			boolean isFinish = false;
			for (int j = W - 1; j >= 0; j--) {
				for (int k = H - 1; k >= 0; k--) {
					if ((upState[j][k] != STATE0) || (downState[j][k] != STATE0)) {
						System.out.println(j + 1);
						isFinish = true;
						break;
					}

				}
				if (isFinish) {
					break;
				}
			}

			upState = null;
			downState = null;
			map = null;
		}
	}

	public static void checkPossible(int x, int y, int W, int H) {
		if (y == 0) {
			if ((upState[x - 1][y] != STATE0) || (downState[x - 1][y + 1] != STATE0)) {
				upState[x][y] = STATE1;
			}
		} else {

			if (upState[x - 1][y - 1] != STATE0) {
				upState[x][y] = upState[x - 1][y - 1];
				if (y == H - 1) {
					downState[x][y] = upState[x - 1][y - 1];
				}
			} else if (downState[x - 1][y - 1] == STATE1) {
				upState[x][y] = STATE2;
				if (y == H - 1) {
					downState[x][y] = STATE2;
				}
			}

			if (downState[x - 1][y + 1] != STATE0) {
				downState[x][y] = downState[x - 1][y + 1];
			}
		}
	}
}
