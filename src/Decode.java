import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @file Decode.java
 * @date 2015. 4. 16.
 * @author yyh
 */

public class Decode {
	public static void main(String[] args) {
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		FileWriter fw = null;
		try {
			int T = Integer.parseInt(input.readLine());
			int[][] matrix = new int[100][100];
			StringBuilder sb;
			int count = 0;
			while (T-- > 0) {
				sb = new StringBuilder();
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

				int index = 0;
				for (int j = 0; j < M; ++j) {
					for (int i = 0; i < N; ++i) {
						matrix[i][j] = string.charAt(index++) - '0';
					}
				}
				
				int i, stringLen = string.length()/5;
				for (i = 0; i < stringLen; ++i) {
					int temp = 0;
					for (int k = 0; k < 5; ++k) {
						temp += ((1 << (4-k)) * matrix[spiral.getX()][spiral.getY()]);
						spiral.next();
					}
					
					if(temp == 0)	{
						sb.append(' ');
					} else	{
						sb.append((char)(temp + 'A' - 1));
					}
				}
				System.out.print(count + " ");

				
				System.out.println(sb.toString());

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
