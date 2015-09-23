import java.util.Scanner;

/**
 * @file JLIS.java
 * @date 2014. 10. 3.
 * @author yyh
 */

/**
 * @author yyh
 *
 */
public class JLIS {
	static final long INF_NEG = Long.MIN_VALUE;
	static int T, N, M;
	static long[] sequence1, sequence2;
	static int[][] cache;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		T = input.nextInt();

		while (T-- > 0) {
			N = input.nextInt();
			M = input.nextInt();

			sequence1 = new long[N+1];
			sequence2 = new long[M+1];
			cache = new int[N+1][M+1];

			for (int i = 1; i <= N; ++i) {
				sequence1[i] = input.nextInt();
			}
			for (int i = 1; i <= M; ++i) {
				sequence2[i] = input.nextInt();
			}
			
			sequence1[0] = INF_NEG;
			sequence2[0] = INF_NEG+1;
			
			//��� ��츦 ���� ���� ���� ���Ѵ븦 ���۰����� ��.
			
			int result = jlis(0,0);
	
			System.out.println(result-2);
		}
	}

	// start1�� start2�� �����ϴ� JLIS
	// sequence1[start1] ��  sequence2[start2]�� ���� ���� �� �Լ��� ȣ��� �� ����.
	public static int jlis(int start1, int start2)	{
		int maxJlis = 2;
		
		// ĳ�ÿ� �������
		if(cache[start1][start2] != 0)	{
			return cache[start1][start2];
		}
		
		
		long maxElement = Math.max(sequence1[start1], sequence2[start2]);
		
		for(int i = start1 + 1; i <= N; ++i)	{
			if(maxElement < sequence1[i])	{
				maxJlis = Math.max(maxJlis, jlis(i, start2)+1);
			}
		}
		
		for(int i = start2 + 1; i <= M; ++i)	{
			if(maxElement < sequence2[i])	{
				maxJlis = Math.max(maxJlis, jlis(start1,i)+1);
			}
		}

		cache[start1][start2] = maxJlis;
		
		return maxJlis;
	}
}
