import java.util.Arrays;
import java.util.Scanner;

/**
 * @file LunchBox.java
 * @date 2015. 4. 10.
 * @author yyh
 */

public class LunchBox {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int T = Integer.parseInt(input.nextLine());
		while(T-->0)	{
			int N = Integer.parseInt(input.nextLine());
			Box[] boxs = new Box[N];
			String[] micros = input.nextLine().split(" ");
			String[] eats = input.nextLine().split(" ");
			
			for(int j = 0; j < N; ++j)	{
				boxs[j] = new Box(Integer.parseInt(micros[j]), Integer.parseInt(eats[j]));
			}
			
			Arrays.sort(boxs);
			
			int maxTime = 0;
			int startTime = 0;
			for(int j = 0; j < N; ++j)	{
				startTime += boxs[j].getM();
				int temp = startTime + boxs[j].getE();
				if(maxTime < temp)	{
					maxTime= temp;
				}
			}
			
			System.out.println(maxTime);
		}
	}
	
	// 각 도시락에 대한 정보 클래스
	public static class Box implements Comparable<Box>{
		int m;
		int e;
		
		public Box()	{
			
		}
		
		public Box(int m, int e)	{
			this.m = m;
			this.e = e;
		}

		public int getM() {
			return m;
		}

		public void setM(int m) {
			this.m = m;
		}

		public int getE() {
			return e;
		}

		public void setE(int e) {
			this.e = e;
		}

		@Override
		public int compareTo(Box o) {
			int result = o.e - this.e;
			if(result == 0)	{
				result = this.m - o.m;
			}
			// TODO Auto-generated method stub
			return result;
		}
	}
}
