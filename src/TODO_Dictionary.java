/*import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

*//**
 * @file Dictionary.java
 * @date 2015. 4. 25.
 * @author yyh
 *//*

public class TODO_Dictionary {
	static InputReader input;

	public static void main(String[] args) {
		input = new InputReader(System.in);
		int T = input.nextInt();
		while (T-- > 0) {

		}

	}

	public static String dictionary() {
		int N = input.nextInt();
		String[] strings = new String[N];
		Graph graph = new Graph(26);

		for (int i = 0; i < N; ++i) {
			strings[i] = input.nextLine();
		}

		for (int i = 1; i < N; ++i) {
			boolean isDifferent = false;

			int j;
			for (j = 0; j < strings[i - 1].length() && j < strings[i].length(); ++j) {
				if (strings[i - 1].charAt(j) != strings[i].charAt(j)) {
					isDifferent = true;
					break;
				}
			}

			// �ٸ� ���ڸ� ã���� �׷����� ���� ����
			if (isDifferent) {
				int before = strings[i - 1].charAt(j) - 'A';
				int after = strings[i].charAt(j) - 'A';

				// �׷����� ���谡 ������ ����
				if (!graph.DFS(before, after)) {
					graph.addEdge(before, after);
				}
			}
		}
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

	
	 * DFS�� �����ϴ� �Լ� start : DFS�� ������ ���� ��ȣ toFind : DFS�� �Ͽ� ã�� ���� ��ȣ return :
	 * ã���� �ϴ� ������ �ִ��� ����
	 
	public boolean DFS(int start, int toFind) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[this.size];

		// ���� ������ ���ÿ� ����
		stack.add(start);
		visited[start] = true;

		while (!stack.empty()) {
			int nodeNo = stack.pop();
			visited[nodeNo] = true;

			// �˻��ϴ� ������ ã���� �ϴ� ������ ��ġ�ϸ� true�� ��ȯ
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
*/