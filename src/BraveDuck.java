import java.util.LinkedList;
import java.util.Queue;

/**
 * @file BraveDuck.java
 * @date 2015. 5. 5.
 * @author yyh
 */

public class BraveDuck {
	public static void main(String[] args) {
		InputReader input = new InputReader(System.in);
		
		int T = input.nextInt();
		Point[] rocks = new Point[102];
		
		for(int i = 0; i < 102; ++i)	{
			rocks[i] = new Point();
		}
		while(T-->0)	{
			double jumpable = input.nextDouble();
			rocks[0].setX(input.nextInt()); rocks[0].setY(input.nextInt());
			rocks[1].setX(input.nextInt()); rocks[1].setY(input.nextInt());
			
			int size = input.nextInt();
			size += 2;
			
			for(int i = 2; i < size; ++i)	{
				rocks[i].setX(input.nextInt());
				rocks[i].setY(input.nextInt());
			}
			
			if(isPossible(jumpable, rocks, size))	{
				System.out.println("YES");
			} else	{
				System.out.println("NO");
			}
		}
	}
	
	/*
	 * 0번에 시작 좌표, 1번에 목적 좌표를 저장한 후
	 * BFS를 이용하여 전체 탐색.
	 * BFS가 끝난 후 1번에 갈 수 있으면 TRUE, 아니면 FALSE
	 */
	public static boolean isPossible(double jumpable, Point[] rocks, int size)	{
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[size];
		queue.add(0);
		visited[0] = true;
		
		while(!queue.isEmpty())	{
			int index = queue.poll();
			
			for(int i = 1; i < size; ++i)	{
				if(!visited[i] && (rocks[i].distance(rocks[index]) <= jumpable))	{
					queue.add(i);
					visited[i] = true;
				}
			}
		}
		
		return visited[1];
	}
	
	static class Point	{
		int x;
		int y;
		
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		
		public double distance(Point p1)	{
			return Math.sqrt(Math.pow(p1.x - x,2.0) + Math.pow(p1.y - y, 2.0));
		}
		
	}
}
