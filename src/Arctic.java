import java.util.Scanner;

/**
 * @file Arctic.java
 * @date 2015. 4. 7.
 * @author yyh
 */

public class Arctic {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		Point[] points;
		boolean[] visited;
		double[] dist;
		while(T-->0)	{
			int N = input.nextInt();
			points = new Point[N];
			visited = new boolean[N];
			dist = new double[N];
			
			for(int i = 0; i < N; ++i)	{
				double x = input.nextDouble();
				double y = input.nextDouble();
				
				points[i] = new Point(x,y);
			}
			
			/*
			 * 시작지점을 본부로 만들기 위해 0번째 인덱스부터시작
			 */
			int minIndex=0;
			double minDist = 100000000;
			visited[0] = true;
			
			for(int j = 0; j < N; ++j)	{
				dist[j] = points[0].calculateDistance(points[j]);
				if(minDist > dist[j])	{
					minDist = dist[j];
					minIndex = j;
				}
			}
			
			double result = minDist;
			visited[minIndex] = true;
			
			/*
			 * 나머지 인덱스들에 대해서 프림 알고리즘 사용
			 */
			for(int i = 1; i < N; ++i)	{
				
				minDist = 10000000;
				for(int j = 0; j < N; ++j)	{
					if((minDist == 10000000 || dist[j] < minDist) && !visited[j])	{
						minIndex = j;
						minDist = dist[j];
					}
				}
				
				visited[minIndex] = true;
				if(result < dist[minIndex])	{
					result = dist[minIndex];
				}
				
				// 새로 넣은 점과 다른 점들의 거리를 업데이트
				for(int j = 0; j < N; ++j)	{
					if(!visited[j])	{
						double temp = points[minIndex].calculateDistance(points[j]);
						if(temp < dist[j])	{
							dist[j] = temp;
						}
					}
				}
				
			}
			
			
			System.out.printf("%.2f",result);
			System.out.println();
		}
	}
	
	public static class Point	{
		private double x;
		private double y;
		
		public Point(){
			
		}
		public Point(double x, double y)	{
			this.x = x;
			this.y = y;
		}
		public void setPoint(double x, double y)	{
			this.x = x;
			this.y = y;
		}
		
		public double getX()	{
			return x;
		}
		public double getY()	{
			return y;
		}
		
		public double calculateDistance(Point p)	{
			return Math.sqrt(Math.pow((this.x - p.x), 2) + Math.pow((this.y - p.y), 2));
		}
	}
	
}
