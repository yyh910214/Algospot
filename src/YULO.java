import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @file YULO.java
 * @date 2015. 4. 6.
 * @author yyh
 */

public class YULO {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		
		while(T-->0)	{
			int N = input.nextInt();
			ArrayList<Double> students = new ArrayList<Double>(N);
			
			for(int i = 0; i < N; ++i)	{
				students.add(input.nextDouble());
			}
			
			Collections.sort(students);
			
			double avg;
			if(N % 2 == 1)	{
				avg = students.get(N/2);
				students.remove(N/2);
			} else	{
				avg = students.get(0);
			}
			
			int S = students.size();
			for(int i = 0; i < S/2; ++i)	{
				double temp = (students.get(i) + students.get(S - 1 - i)) / 2;
				if(temp > avg)	{
					avg = temp;
				}
			}
			
			System.out.println(avg);
		}
	}
}
