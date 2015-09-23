import java.util.ArrayList;
import java.util.List;

/**
 * @file FanMeeting.java
 * @date 2015. 3. 2.
 * @author yyh
 */

/*
 * 
 */

public class FanMeeting {
	public static void main(String[] args) {
		String input = "FINISH|W|B|2";
		String[] arrays = input.split("\\|");
		
		for(String t :arrays){
			System.out.println(t);
		}
	}
	
	public static List<Integer> karatsuba(List a, List b)	{
		return karatsuba(a,b,0,b.size()-1);
	}
	
	public static List<Integer> karatsuba(List a, List b, int start, int end)	{
		
		int half = getHalfIndex(start, end);
		List<Integer> z0 = karatsuba(a,b, start, half-1);
		List<Integer> z2 = karatsuba(a,b, half, end);
		List<Integer> z1 = karatsuba(calList(a, start, half-1, a, half, end, '+'),calList(b, start, half-1, b, half, end, '+')) ;
		
		
	
		return null; 
	}
	
	public static int getHalfIndex(int start, int end)	{
		return start + (end-start+1)/2;
	}
	
	/*
	 * 길이가 같은 배열을 곱하는 함수.
	 */
	public static List<Integer> calList(List<? extends Integer> a, int startA, int endA, List<? extends Integer> b, int startB, int endB, char op)	{
		
		int i = startA;
		int j = startB;
		
		
		List<Integer> result = new ArrayList<Integer>(endB-startB+1);
		while((i < endA) || (j < endB))	{
			int intA = (Integer)a.get(i);
			int intB = (Integer)b.get(j);
			
			if(i > endA)
				intA = 0;
			if(j > endB)
				intB = 0;
			
			if(op == '+')
				result.add(intA+intB);
			else if(op == '-')
				result.add(intA-intB);
			
			++i;
			++j;
			
		}
		
		return result;
	}
}
