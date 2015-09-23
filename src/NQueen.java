import java.util.Arrays;
import java.util.Scanner;

/**
 * @file NQueen.java
 * @date 2015. 4. 6.
 * @author yyh
 */

public class NQueen {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		
		while(T -- > 0)	{
			int n = input.nextInt();
			int result = 0;
			boolean[] map = new boolean[n*n];
			for(int i = 0; i < n; ++i){
				result += getPossibleCount(n, 0, i, map);
			}
			System.out.println(result);
		}
	}
	
	public static int getPossibleCount(int size, int n, int index, boolean[] previousMap)	{
		if(n == size-1){
			return 1;
		}
		boolean[] map = Arrays.copyOf(previousMap, previousMap.length);
		
		int diagonal = 0;
		for(int i = n*size+index; i < size*size; i+=size )	{
			map[i] = true;
			if((i+diagonal)/size == i/size)
				map[i+diagonal] = true;
			if((i-diagonal)/size == i/size)
				map[i-diagonal] = true;
			
			diagonal++;
		}
		
		int total = 0;
		
		int line = (n+1)*size;
		for(int i = 0; i < size; ++i)	{
			if(!map[line+i])	{
				total += getPossibleCount(size, n+1, i, map);
			}
		}
		
		return total;
	}
}
