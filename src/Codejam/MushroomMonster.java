/**
 * @file MushroomMonster.java
 * @date 2015. 4. 20.
 * @author yyh
 */
package Codejam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class MushroomMonster {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("A-large-practice.in"));
		FileWriter fw = new FileWriter("output.txt");
		
		int T = Integer.parseInt(br.readLine());
		int testcase = 1;
		int[] mushrooms = new int[1000];
		while(T-->0)	{
			int N = Integer.parseInt(br.readLine());
			int max = 0;
			int method1, method2;
			method1 = 0;
			method2 = 0;
			String[] inputs = br.readLine().split(" ");
			mushrooms[0] = Integer.parseInt(inputs[0]);
			for(int i = 1; i < N; ++i)	{
				mushrooms[i] = Integer.parseInt(inputs[i]);
				int diff = mushrooms[i-1]-mushrooms[i];
				if(mushrooms[i-1] > mushrooms[i])	{
					method1 += diff;
				}
				if(max < diff)	{
					max = diff;
				}
			}
			
			for(int i = 0; i < N-1; ++i)	{
				if(max > mushrooms[i])	{
					method2 += mushrooms[i];
				} else	{
					method2 += max;
				}
			}
			
			
			
			fw.write("Case #" + testcase + ": ");
			fw.write(Integer.toString(method1) + " " + Integer.toString(method2));
			fw.write('\r');
			fw.write('\n');
			fw.flush();
			
			testcase++;
			
		}
		
		fw.close();
		br.close();
	}
}
