import java.util.ArrayList;
import java.util.Scanner;

/**
 * @file MagicPower.java
 * @date 2015. 4. 7.
 * @author yyh
 */

public class MagicPower {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		ArrayList<Integer> list;
		
		while(T-->0)	{
			int N = input.nextInt();
			int M = input.nextInt();
			
			list = new ArrayList<Integer>(N);
			
			for(int i = 0; i < N; ++i)	{
				int temp = input.nextInt();
				list.add(temp);
			}
			
			int max = getMax(list);
			int maxCount = 1;
			int second = getMax(list);
			int result = 0;
			while(max == second)	{
				second = getMax(list);
				maxCount++;
			}
			
			while(M > 0 && max != 0)	{
				if(M >= maxCount)	{
					result += (maxCount* max);
					M -= maxCount;
					--max;
				} else	{
					result += (M * max);
					M = 0;
				}
				
				while(max == second)	{
					second = getMax(list);
					maxCount++;
				}
			}
			
			System.out.println(result);
		}
	}
	
	public static int getMax(ArrayList<Integer> list)	{
		if(list.size() == 0)	{
			return -1;
		}
		int max = list.get(0);
		int index = 0;
		for(int i = 0; i < list.size(); ++i)	{
			if(list.get(i) > max)	{
				max = list.get(i);
				index = i;
			}
		}
		
		list.remove(index);
		return max;
	}
	
}
