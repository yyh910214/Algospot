import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @file Meeting.java
 * @date 2015. 3. 12.
 * @author yyh
 */

/*
 * 정렬 알고리즘을 바꿔야 하는듯.
 */

/*
 * ㄴㄴ 입력 개수가 많아서 입력 시간 초과..... 라인으로 받아야 함
 */


public class Meeting {
	static int[] man, woman;
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(input.readLine());
		while(T-->0)	{
			int N = Integer.parseInt(input.readLine());
			
			String[] mans = (input.readLine()).split(" ");
			String[] womans = (input.readLine()).split(" ");
			
			
			man = new int[2001];
			woman = new int[2001];
			
			for(int i = 0; i < N; ++i)	{
				man[Integer.parseInt(mans[i])+1000]++;
			}
			
			for(int i = 0; i < N; ++i)	{
				woman[Integer.parseInt(womans[i])+1000]++;
			}
			
			
			int result = 0;
			
			int manIndex = 0;
			int womanIndex = 0;
			while(manIndex <= 2000 && womanIndex <= 2000)	{
				while(manIndex <= 2000 && man[manIndex] == 0)	{
					manIndex++;
				}
				while(womanIndex <= 2000 && woman[womanIndex] == 0)	{
					womanIndex++;
				}
				
				if(manIndex != 2001 && womanIndex != 2001)	{
					result += Math.abs(manIndex - womanIndex);
					--man[manIndex];
					--woman[womanIndex];
				}
			}
			
			System.out.println(result);
		}
	}
}


/*
public class Meeting {
	static int[] man, woman;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		while(T-->0)	{
			int N = input.nextInt();
			input.nextLine();
			String[] mans = (input.nextLine()).split(" ");
			String[] womans = (input.nextLine()).split(" ");
			
			man = new int[N];
			woman = new int[N];
			
			for(int i = 0; i < N; ++i)	{
				man[i] = Integer.parseInt(mans[i]);
			}
			
			for(int i = 0; i < N; ++i)	{
				woman[i] = Integer.parseInt(womans[i]);
			}
			
			
			int result = 0;
			
			Arrays.sort(man);
			Arrays.sort(woman);

			for(int i = 0; i < N; ++i)	{

				result += Math.abs(man[i] - woman[i]);
			}
			
			System.out.println(result);
		}
	}
}
*/