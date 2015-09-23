/**
 * @file Dijkstra.java
 * @date 2015. 4. 11.
 * @author yyh
 */
package Codejam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Dijkstra {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("C-small-attempt1.in"));
		FileWriter fw = new FileWriter("output.txt");

		int T = Integer.parseInt(br.readLine());
		int testcase = 1;
		while (T-- > 0) {
			int target = 2;
			String[] inputs = br.readLine().split(" ");
			int N = Integer.parseInt(inputs[0]);
			int X = Integer.parseInt(inputs[1]);
			String string = br.readLine();
			int len = N*X;
			int i = 0;
			
	
			if (len >= 3) {
				
				int before = 1;
				for (i = 0; i < len; ++i) {
					int temp = string.charAt(i % N) - 'g';
					before = multifly(before, temp);
					
					
					if (target == before) {
						target++;
						
						before = 1;
						if(target == 5)	{
							break;
						}
					}
				}
			}

			fw.write("Case #" + testcase + ": ");
			if( (i != 0) && (target == 5)  && (i == (len - 1)))	{
				fw.write("YES");
			} else	{
				fw.write("NO");
			}
			
			fw.write('\r');
			fw.write('\n');
			fw.flush();

			testcase++;

		}

		fw.close();
		br.close();
	}

	public static int multifly(int a, int b) {
		boolean minus = false;
		if ((a < 0) && (b >= 0)) {
			minus = true;
		} else if ((b < 0) && (a >= 0)) {
			minus = true;
		}
		
		if(a < 0)	{
			a = -a;
		}
		
		if(b < 0)	{
			b = -b;
		}

		int result = 0;
		if (a == 1) {
			result = b;
		} else if (b == 1) {
			result = a;
		} else if (a == b) {
			result = -1;
		} else if (a == 2) {
			if (b == 3) {
				result = 4;
			}
			if (b == 4) {
				result = -3;
			}
		} else if (a == 3) {
			if (b == 2) {
				result = -4;
			}
			if (b == 4) {
				result = 2;
			}
		} else if (a == 4) {
			if (b == 2) {
				result = 3;
			}
			if (b == 3) {
				result = -2;
			}
		}

		if (minus) {
			result = -result;
		}
		return result;
	}
}
