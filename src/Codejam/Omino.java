/**
 * @file Omino.java
 * @date 2015. 4. 11.
 * @author yyh
 */
package Codejam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Omino {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(
				"D-small-attempt0.in"));
		FileWriter fw = new FileWriter("output.txt");

		int T = Integer.parseInt(br.readLine());
		int[] person = new int[1002];
		int testcase = 1;
		while (T-- > 0) {
			String[] inputs = br.readLine().split(" ");
			int X = Integer.parseInt(inputs[0]);

			boolean richard = true;

			int R = Integer.parseInt(inputs[1]);
			int C = Integer.parseInt(inputs[2]);

			if (R < C) {
				int t = C;
				C = R;
				R = t;
			}

			if (X == 1) {
				richard = false;
			} else if (X >= 7) {
				// RICHARD ½Â¸®
			} else if ((C < X / 2 + 1) && (R < X / 2 + 1)) {
				// ¸®Â÷µå ½Â¸®
			} else if ((R * C) % X != 0) {
				// ¸®Â÷µå ½Â¸®
			} else {
				// RÀÌ ´õ ±è
				richard = false;
				for (int i = 1; i < R - 1; ++i) {
					boolean find = false;
					int temp = C * i;
					for (int j = 0; j <= X - C; ++j) {
						if ((temp - j) >= 0) {
							if ((temp - j) % X == 0) {
								find = true;
							}
						}
					}

					if (!find) {
						richard = true;
					}
				}

				// ¸®Â÷µå

			}

			fw.write("Case #" + testcase + ": ");
			if (richard) {
				fw.write("RICHARD");
			} else {
				fw.write("GABRIEL");
			}
			fw.write('\r');
			fw.write('\n');
			fw.flush();

			testcase++;

		}

		fw.close();
		br.close();
	}
}
