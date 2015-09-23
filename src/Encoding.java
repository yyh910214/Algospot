import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @file Encoding.java
 * @date 2015. 4. 7.
 * @author yyh
 */

public class Encoding {
	public static void main(String[] args) {
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		FileWriter fw = null;
		try {
			fw = new FileWriter("output.txt");
			int T = Integer.parseInt(input.readLine());
			int[][] matrix = new int[100][100];
			int count = 0;
			while (T-- > 0) {

				for (int i = 0; i < 100; ++i) {
					for (int j = 0; j < 100; ++j) {
						matrix[i][j] = 0;
					}
				}
				count++;
				String[] strings = (input.readLine()).split(" ", 3);
				int M = Integer.parseInt(strings[0]);
				int N = Integer.parseInt(strings[1]);

				String string = strings[2];

				SpiralSearch spiral = new SpiralSearch(N - 1, M - 1);

				for (int i = 0; i < string.length(); ++i) {
					int temp = 0;
					if (string.charAt(i) == ' ') {
						temp = 0;
					} else {
						temp = (string.charAt(i) - 'A' + 1);
					}
					String binary = Integer.toBinaryString(temp);
					for (int j = binary.length(); j < 5; ++j) {
						binary = "0" + binary;
					}

					for (int k = 0; k < 5; ++k) {
						matrix[spiral.getX()][spiral.getY()] = (byte) (binary
								.charAt(k) - '0');
						spiral.next();
					}
				}
				System.out.print(count + " ");

				fw.write(Integer.toString(count) + " ");

				for (int j = 0; j < M; ++j) {
					for (int i = 0; i < N; ++i) {
						System.out.print(matrix[i][j]);
						fw.write(Integer.toString(matrix[i][j]));
					}
				}
				System.out.println();
				fw.write('\r');
				fw.write('\n');

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				input.close();
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static class SpiralSearch {
		int x;
		int y;
		int height;
		int width;
		int count;
		int state; // 0 : 오른쪽, 1: 아래, 2: 왼쪽, 3: 위
		boolean firstline;

		public SpiralSearch(int width, int height) {
			this.width = width;
			this.height = height;
			this.firstline = true;
			this.state = 0;
			this.x = 0;
			this.y = 0;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public void next() {
			if (height == 0 && width == 0) {
				x = -1;
				y = -1;
			} else {

				if (height == 0) {
					if (state == 1 || state == 3) {
						state = (state + 1) % 4;
					}
				} else if (width == 0) {
					if (state == 0 || state == 2) {
						state = (state + 1) % 4;
					}
				}
				if (state == 0) {
					x++;
					count++;
					if (count == width) {
						width--;
						count = 0;
						state = 1;
						if (firstline) {
							width++;
							firstline = false;
						}
					}
				} else if (state == 1) {
					y++;
					count++;
					if (count == height) {
						height--;
						count = 0;
						state = 2;
					}
				} else if (state == 2) {
					x--;
					count++;
					if (count == width) {
						width--;
						count = 0;
						state = 3;
					}
				} else if (state == 3) {
					y--;
					count++;
					if (count == height) {
						height--;
						count = 0;
						state = 0;
					}
				}
			}
		}
	}
}
