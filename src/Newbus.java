import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class Newbus {
	private static final int DISABLE = 10000000;
	
	public static int[][] road;
	public static int[][] dist;
	
	public static int N;
	public static boolean[] visit;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		
		road = new int [101][101];
		dist = new int [101][101];
		
		for(int i = 0; i < T; i++)	{
			N = scanner.nextInt();
			int M = scanner.nextInt();
			int Q = scanner.nextInt();
			
			for(int j = 0; j < 101; ++j)	{
				for(int k = 0; k < 101; ++k)	{
					road[j][k] =  DISABLE;
					dist[j][k] =  DISABLE;
					
					if(j == k)	{
						road[j][k] = 0;
						road[k][j] = 0;
						
						dist[j][k] = 0;
						dist[k][j] = 0;

					}
				}
			}
			
			for(int j = 0; j < M; j++)	{
				int road1 = scanner.nextInt();
				int road2 = scanner.nextInt();
				int distance = scanner.nextInt();
				
				road[road1][road2] = distance;
				road[road2][road1] = distance;
				
				dist[road1][road2] = distance;
				dist[road2][road1] = distance;
			}
			
			geMinDist();
			
			
			for(int j = 0; j < Q; j++)	{
				int start = scanner.nextInt();
				int end = scanner.nextInt();
				if(dist[start][end] == DISABLE)
					System.out.println("no");
				else if(!getAnswer(start, end))
					System.out.println("only");
				else
					System.out.println("many");
			}
			
		}
	}
	
	
	public static void geMinDist()	{
		for(int mid = 0; mid <= N; ++mid)	{
			for(int start = 0; start <= N; ++start)	{
				for(int end = 0; end <= N; ++end)	{
					int newDist = dist[start][mid] + dist[mid][end];
					if(dist[start][end] > newDist)	{
						dist[start][end] = newDist;
					}
				}
			}
		}
	}
	
	public static boolean getAnswer(int start, int end)	{
		boolean isMany = false;
		if(start != end)	{
			int nextStart = -1;
			for(int i = 1; i <= N; ++i)	{
				if(isPossible(start, i) && 
						(dist[start][end] == road[start][i] + dist[i][end]))	{
					if(nextStart == -1)
						nextStart = i;
					else	{
						isMany = true;
						break;
					}
				}
			}
			if(!isMany)	{
				isMany = getAnswer(nextStart, end);
			}
		}
		return isMany;
	}
	
	public static boolean isPossible(int start,int end)	{
		return (road[start][end] != 0) && (road[start][end] != DISABLE); 
	}
	
	public class Road implements Comparable	{
		private int targetRoad;
		private int dist;
		
		public int getTargetRoad() {
			return targetRoad;
		}
		public void setTargetRoad(int targetRoad) {
			this.targetRoad = targetRoad;
		}
		public int getDist() {
			return dist;
		}
		public void setDist(int dist) {
			this.dist = dist;
		}
		@Override
		public int compareTo(Object arg0) {
			// TODO Auto-generated method stub
			return this.dist - ((Road)arg0).dist;
			
		}
		
		
	}
	public class MinHeap<T extends Comparable>	{
		private T[] heap = null;
		private int size = 0;
		
		public MinHeap()	{
			heap = (T[]) new Comparable[1024];
		}
		
		public boolean isEmpty()	{
			return size == 0;
		}
		
		public void insert(T element)	{
			if(size >= heap.length)	{
				T[] temp = Arrays.copyOf(heap, heap.length * 2);
				heap = temp;
			}
			heap[size] = element;
			int i = size;
			int p = getParent(i);
			
			while( p >= 0 && heap[p].compareTo(heap[i]) > 0)	{
				T temp = heap[i];
				heap[i] = heap[p];
				heap[p] = temp;
				i = p;
				p = getParent(p);
			}
			size++;
		}
		
		public T getMinimum()	{
			return heap[0];
		}
		
		public T ExtractMin()	{
			T min = heap[0];
			size--;
			heap[0] = heap[size];
			heapify(0);
			return min;
		}
		
		private void heapify(int i) {
			if (!hasChild(i))
				return;
			int k = getMinimumChild(i);
			if (heap[i].compareTo(heap[k]) > 0) {
				T temp = heap[i];
				heap[i] = heap[k];
				heap[k] = temp;
				heapify(k);
			}
		}
		
		private boolean hasChild(int i)	{
			return (i * 2 + 1) < size;
		}
		
		private int getParent(int i)	{
			return (i - 1) / 2;
		}
		
		private int getMinimumChild(int i)	{
			if((i*2+2) < size)	{
				return heap[i * 2 + 1].compareTo(heap[i * 2 + 2]) < 0 ? i * 2 + 1 : i * 2 + 2;
			} else if( i * 2 + 1 < size)	{
				return i * 2 + 1;
			} else	{
				return -1;
			}
		}
	}
}