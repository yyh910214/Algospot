import java.util.ArrayList;

/**
 * @file MVP.java
 * @date 2015. 4. 28.
 * @author yyh
 */

public class MVP {
	static int[][] prefer;
	static int[] index;	// ���ڵ��� �����ϴ� �켱���� �ε���
	static boolean[] eliminated; // ���ŵ� ����� ǥ��
	static int[] count; // �� ������ ��ǥ��
	
	static InputReader input;
	
	public static void main(String[] args) {
		input = new InputReader(System.in);
		int T = input.nextInt();
		prefer = new int[100][100];
		index = new int[100];
		eliminated = new boolean[101];
		count = new int[101];
		
		while(T-->0)	{
			printMVP();
		}
	}
	
	public static void printMVP()	{
		
		// �� �迭 �ʱ�ȭ
		
		int N = input.nextInt();
		int M = input.nextInt();
		
		for(int i = 0; i < N; ++i)	{
			for(int j = 0; j < M; ++j)	{
				prefer[i][j] = input.nextInt();
			}
		}
		
		for(int i = 0; i < N; ++i)	{
			index[i] = 0;
		}
		
		for(int i = 0; i <= M; ++i)	{
			eliminated[i] = false;
		}
		
		//�Է�
		
		boolean isEnd = false;
		
		ArrayList<Integer> maxList = new ArrayList<Integer>();
		ArrayList<Integer> minList = new ArrayList<Integer>();
		
		while(!isEnd)	{
			
			for(int i = 0; i <= M; ++i)	{
				count[i] = 0;
			}
			
			//��� ���ڰ� ��ǥ�� ��
			
			for(int i = 0; i < N; ++i)	{
				++count[prefer[i][index[i]]];
			}
			
			
			// �ִ� �ּҰ� ã��.
			int max = 0;
			int min = 101;
			int maxCount = 0;
			
			for(int i = 1; i <= M; ++i)	{
				if(count[i] == max)	{
					maxCount++;
				}
				if(count[i] > max)	{
					max = count[i];
					maxCount = 1;
				}
				if(!eliminated[i] && count[i] < min)	{
					min = count[i];
				}
			}
			
			/*
			 * �õ� ��ϰ� 1�� ����� �����.
			 */
			maxList.clear();
			minList.clear();
			
			for(int i = 1; i <= M; ++i)	{
				if(max == count[i])	{
					maxList.add(i);
				}
				if(min == count[i])	{
					minList.add(i);
				}
			}
			
			
			if(maxCount == 1)	{
				isEnd = true;
			} else	{
				//�ߺ� 1���� ������ �õ��� �����ϰ� ���ڵ��� �ε����� ����.
				for(int minProgrammer : minList)	{
					eliminated[minProgrammer] = true;
				}
				
				for(int i = 0; i < N; ++i)	{
					while(eliminated[prefer[i][index[i]]])	{
						index[i]++;
						if(index[i] == M)	{
							isEnd = true;
							break;
						}
					}
				}
				
			}
			
			
		}
		
		System.out.print(maxList.get(0));
		for(int i = 1; i < maxList.size(); ++i)	{
			System.out.print(" " + maxList.get(i));
		}
		System.out.println();
	}
}
