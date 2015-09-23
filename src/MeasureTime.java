import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @file MeasureTime.java
 * @date 2015. 4. 10.
 * @author yyh
 */

public class MeasureTime {
	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[] array = new int[50000];
		int[] counts = new int[50000];
		while(T-->0)	{
			int N = Integer.parseInt(br.readLine());
			String string = br.readLine();
			
			StringBuilder sb = new StringBuilder();
			int index = 0;
			for(int i = 0; i < string.length(); ++i)	{
				if(string.charAt(i) != ' '){
					sb.append(string.charAt(i));
				} else	{
					array[index++] = Integer.parseInt(sb.toString());
					sb = new StringBuilder();
				}
			}
			array[index] = Integer.parseInt(sb.toString());
			
			System.out.println(insertionSort(array, N));
		}
	}
	
	public static long insertionSort(int[] array, int size)	{
		long count = 0;
		for(int i = 0; i < size; ++i)	{
			int j = i;

			while(j > 0 && array[j-1] > array[j])	{
				int temp = array[j-1];
				array[j-1] = array[j];
				array[j] = temp;
				--j;
				++count;
			}
		}
		
		return count;
	}
}
