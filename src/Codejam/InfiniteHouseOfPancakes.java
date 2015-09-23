/**
 * @file InfiniteHouseOfPancakes.java
 * @date 2015. 4. 11.
 * @author yyh
 */
package Codejam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class InfiniteHouseOfPancakes {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("B-large.in"));
		FileWriter fw = new FileWriter("B-output.txt");
		
		int T = Integer.parseInt(br.readLine());
		int testcase = 1;
		int[] diner = new int[1000];
		while(T-->0)	{
			int N = Integer.parseInt(br.readLine());
			int max = 0;
			String[] inputs = br.readLine().split(" ");
			for(int i = 0; i < N; ++i)	{
				diner[i] = Integer.parseInt(inputs[i]);
				if(max < diner[i])	{
					max = diner[i];
				}
			}
			
			int minTime = max;
			
			for(int i = 1; i <= max; ++i)	{
				int divideTime = 0;
				for(int j = 0; j < N; ++j)	{
					if(diner[j] > i)	{
						divideTime += (diner[j] / i - 1);
						if(diner[j] % i != 0)	{
							++divideTime;
						}
					}
				}
				
				if(minTime > (divideTime+i) )	{
					minTime = divideTime + i;
				}
			}
			
			fw.write("Case #" + testcase + ": ");
			fw.write(Integer.toString(minTime));
			fw.write('\r');
			fw.write('\n');
			fw.flush();
			
			testcase++;
			
		}
		
		fw.close();
		br.close();
	}
}
