import java.util.ArrayList;

/**
 * @file MVP.java
 * @date 2015. 4. 28.
 * @author yyh
 */

public class MVP {
	static int[][] prefer;
	static int[] index;	// 기자들의 좋아하는 우선순위 인덱스
	static boolean[] eliminated; // 제거된 사람을 표시
	static int[] count; // 각 라운드의 득표수
	
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
		
		// 각 배열 초기화
		
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
		
		//입력
		
		boolean isEnd = false;
		
		ArrayList<Integer> maxList = new ArrayList<Integer>();
		ArrayList<Integer> minList = new ArrayList<Integer>();
		
		while(!isEnd)	{
			
			for(int i = 0; i <= M; ++i)	{
				count[i] = 0;
			}
			
			//모든 기자가 투표를 함
			
			for(int i = 0; i < N; ++i)	{
				++count[prefer[i][index[i]]];
			}
			
			
			// 최대 최소값 찾기.
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
			 * 꼴등 목록과 1등 목록을 만든다.
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
				//중복 1위가 많으면 꼴등을 제거하고 기자들의 인덱스를 변경.
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
