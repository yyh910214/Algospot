import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @file Lan.java
 * @date 2015. 4. 27.
 * @author yyh
 */

public class TODO_Lan {
	static InputReader input = new InputReader(System.in);
	static Point[] points = new Point[500];
	static boolean[] visit = new boolean[500];
	
	public static void main(String[] args) {
		
		int T = input.nextInt();
		
		for(int i = 0; i < 500; ++i)	{
			points[i] = new Point();
		}
		
		while(T-->0)	{
			double result = lan();
		}
	}
	
	public static double lan()	{
		double result = 0.0;
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		
		int N = input.nextInt();
		int M = input.nextInt();
		
		LanGraph graph = new LanGraph(N);
		
		
		for(int j = 0; j < N; ++j)	{
			points[j].setX(input.nextDouble());
		}
		
		for(int j = 0; j < N; ++j)	{
			points[j].setY(input.nextDouble());
		}
		
		
		//연결된 그래프 생성
		for(int j = 0; j < M; ++j)	{
			int p1 = input.nextInt();
			int p2 = input.nextInt();
			
			graph.addEdge(p1, p2);
			graph.addEdge(p2, p1);
		}
		
		queue.add(new Node(0, 0));
		
		while(!queue.isEmpty())	{
			Node node = queue.poll();
			
			//방문 안한거면 그래프에 추가
			if(!visit[node.getIndex()])	{
				result += node.getDistance();
				
				ArrayList<Integer> list = graph.checkLan(node.getIndex(), visit);
				
				for(int index : list)	{
					for(int i = 0; i < N; ++i)	{
						//방문 안했으면 거리 계산해서 큐에 추가함.
						if(!visit[i])	{
							queue.add(new Node(i, points[index].calculateDistance(points[i])));
						}
					}
				}

			}
		}
		
		return result;
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
		
		public void setX(double x)	{
			this.x = x;
		}
		
		public void setY(double y)	{
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

class Node	{
	private int index;
	private double distance;
	
	public Node(int index, double distance)	{
		this.distance = distance;
		this.index = index;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
}

class LanGraph extends Graph	{
	public LanGraph(int N)	{
		super(N);
	}
	
	public ArrayList<Integer> checkLan(int start, boolean[] visit)	{
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		boolean[] visited = new boolean[this.size];

		// 시작 지점을 스택에 넣음
		stack.add(start);
		visited[start] = true;
		visit[start] = true;
		list.add(start);

		while (!stack.empty()) {
			int nodeNo = stack.pop();
			visited[nodeNo] = true;
			
			//외부의 방문 표시 배열에 연결되었음을 표시함.
			visit[nodeNo] = true;
			list.add(nodeNo);

			for (int i : graph[nodeNo]) {
				if (!visited[i]) {
					stack.add(i);
				}
			}
		}
		
		return list;
	}
}


class Graph {
	static int DEFAULT_SIZE = 10;
	int size;
	List<Integer>[] graph;

	public Graph() {
		this(DEFAULT_SIZE);
	}

	public Graph(int size) {
		this.size = size;
	}

	private void init() {
		graph = new ArrayList[this.size];
		for (int i = 0; i < this.size; ++i) {
			graph[i] = new ArrayList<Integer>();
		}
	}

	public void addEdge(int start, int end) {
		graph[start].add(end);
	}

	public boolean DFS(int start, int toFind) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[this.size];

		// 시작 지점을 스택에 넣음
		stack.add(start);
		visited[start] = true;

		while (!stack.empty()) {
			int nodeNo = stack.pop();
			visited[nodeNo] = true;

			// 검사하는 정점이 찾고자 하는 정점과 일치하면 true를 반환
			if (nodeNo == toFind) {
				return true;
			}

			for (int i : graph[nodeNo]) {
				if (!visited[i]) {
					stack.add(i);
				}
			}
		}

		return false;
	}

}
