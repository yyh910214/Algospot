import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @file Routing.java
 * @date 2015. 4. 20.
 * @author yyh
 */

public class Routing {
	static final double INF = 1e9;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		LinkedList[] graphs = new LinkedList[10000];
		
		//링크드리스트를 미리 만들어 놓음. 메모리때문에....
		for(int i = 0; i < 10000; ++i)	{
			graphs[i] = new LinkedList<GraphNode>();
		}
		
		
		while(T-->0)	{
			String[] inputs = br.readLine().split(" ");
			
			int N = Integer.parseInt(inputs[0]);
			int M = Integer.parseInt(inputs[1]);
			
			// 리스트 초기화
			for(int i = 0; i < N; ++i)	{
				graphs[i].clear();
			}
			
			// 입력과 리스트 랭성
			int node1, node2;
			double dist;
			GraphNode temp;
			
			for(int i = 0; i < M; ++i)	{
				inputs = br.readLine().split(" ");
				
				node1 = Integer.parseInt(inputs[0]);
				node2 = Integer.parseInt(inputs[1]);
				dist = Math.log(Double.parseDouble(inputs[2]));
				
				temp = new GraphNode(node1, dist);
				graphs[node2].add(temp);
				
				temp = new GraphNode(node2, dist);
				graphs[node1].add(temp);
			}
			
			double distance = getDijkstra(0, N-1, graphs, N);
			
			System.out.printf("%.10f",Math.pow(Math.E, distance));
		}
	}
	
	public static class GraphNode implements Comparable<GraphNode>	{
		int destination;
		double distance;
		
		public GraphNode(int destination, double distance)	{
			this.destination = destination;
			this.distance = distance;
		}

		/* (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(GraphNode o) {
			// TODO Auto-generated method stub
			double diff = this.distance - o.distance;
			if(diff < 0)	{
				return -1;
			} else if(diff == 0)	{
				return 0;
			} else	{
				return 1;
			}
		}
		
		
	}
	
	
	/* 
	 * 그냥 큐 안쓰고 검사해보는거
	 */
	
	/*
	public static double getDijkstra(int start, int end, List<GraphNode>[] list, int N)	{
		double[] dist = new double[N];
		boolean[] visited = new boolean[N];
		
		for(int i = 0; i < N; ++i)	{
			dist[i] = INF;
		}
		
		for(GraphNode node : list[start])	{
			dist[node.destination] = node.distance;
		}
		visited[start] = true;
		
		
		while(!visited[end])	{
			double min = INF;
			int minIndex = -1;
			// 가장 짧은 거리를 가진 곳으로 이동.
			for(int i = 0; i < N; ++i)	{
				if(!visited[i] && dist[i] != INF)	{
					if(min == INF)	{
						min = dist[i];
						minIndex = i;
					} else if(min > dist[i])	{
						min = dist[i];
						minIndex = i;
					}
				}
			}
			
			// 다음 지점을 방문하고, 연걸된 목적지 거리 갱신
			visited[minIndex] = true;
			for(GraphNode node : list[minIndex])	{
				double length = min * node.distance;
				if(!visited[node.destination])	{
					if(dist[node.destination] == INF || dist[node.destination] > length)	{
						dist[node.destination] = length;
					}
				}
			}

		}
		
		
		return dist[end];

	}
	
	*/
	
	
	public static double getDijkstra(int start, int end, List<GraphNode>[] list, int N)	{
		double[] dist = new double[N];
		boolean[] visited = new boolean[N];
		
		// 어디까지 얼마나 걸리나 저장할 큐
		PriorityQueue<GraphNode> queue = new PriorityQueue<GraphNode>();
		
		for(int i = 0; i < N; ++i)	{
			dist[i] = INF;
		}

		dist[start] = 0.0;
		queue.add(new GraphNode(start, 0));
		
		
		while(!queue.isEmpty())	{

			// 가장 짧은 거리를 가진 곳으로 이동.
			GraphNode graphNode = queue.poll();
			if(visited[graphNode.destination]) {
				// 이미 방문햇으면 안봄
				continue;
			}

			
			// 다음 지점을 방문하고, 연걸된 목적지 거리 갱신
			visited[graphNode.destination] = true;
			dist[graphNode.destination] = graphNode.distance;
			
			for(GraphNode node : list[graphNode.destination])	{
				//아직 방문 안한 노드면 큐에 삽입
				if(!visited[node.destination])	{
					double length = graphNode.distance + node.distance;
					queue.add(new GraphNode(node.destination, length));
				}
			}
		}
		
		return dist[end];
	}
}
