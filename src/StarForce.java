import java.util.Scanner;

public class StarForce {
	private static boolean[] possible;
	private static int[] cards;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		
		for(int i = 0; i < T; i++)	{
			possible = new boolean[65536];
			int N = scanner.nextInt();
			int M = scanner.nextInt();
			
			cards = new int[N];
			for(int j = 0; j < N; j++)	{
				cards[j] = scanner.nextInt();
			}
			
			int max = 0;
			for(int j = 65535; j > 0; j--)	{
				if(isPossible(j,M))	{
					int tempCount = getCount(j);
					if(max < tempCount)
						max = tempCount;
				}
			}
			
			
			System.out.println(max);

		}
	}
	
	public static boolean isPossible(int n, int count)	{
		int beforeEquipment = 0;
		for(int i = 0; i < cards.length; i++)	{
			beforeEquipment |= cards[i];
			if((beforeEquipment&n) == n)	{
				beforeEquipment = 0;
				count--;
			}
		}
		
		if(count <= 0)	{
			return true;
		} else	{
			return false;
		}
	}
	
	public static int getCount(int n)	{
		int count = 0;
		for(int i = 0; i < 16; i++)	{
			if((1 & n) == 1)	{
				count++;
			}
			n = n >> 1;
		}
		
		return count;
	}
}
