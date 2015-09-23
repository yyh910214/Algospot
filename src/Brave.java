import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Brave {
	private static List<Integer>[] lists;
	private static boolean[] visits;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		int N, M, T, point1, point2;
		Scanner scanner = new Scanner(System.in);

		T = scanner.nextInt();

		for (int i = 0; i < T; i++) {
			N = scanner.nextInt();
			M = scanner.nextInt();

			visits = new boolean[N];
			lists = new List[N];

			for (int j = 0; j < N; j++) {
				lists[j] = new ArrayList<Integer>();
			}

			for (int j = 0; j < M; j++) {
				point1 = scanner.nextInt();
				point2 = scanner.nextInt();

				lists[point1 - 1].add(point2 - 1);
				lists[point2 - 1].add(point1 - 1);
			}

			int maxCount = 0;
			for (int j = 0; j < N; j++) {
				if (!isVisit(j)) {
					int currentCount = getCountByBFS(j);
					if (currentCount > maxCount) {
						maxCount = currentCount;
					}
				}
			}
			visits = null;
			lists = null;
			Runtime.getRuntime().gc();
			System.out.println(maxCount);
		}
	}

	public static int getCountByBFS(int startIndex) {
		int resultCount = 0;
		Stack<Integer> stack = new Stack<Integer>();
		visits[startIndex] = true;
		stack.push(startIndex);
		while (!stack.isEmpty()) {
			int index = stack.pop();
			resultCount++;
			for (int linkIndex : lists[index]) {
				if (!isVisit(linkIndex)) {
					visits[linkIndex] = true;
					stack.push(linkIndex);
				}
			}
		}
		return resultCount;
	}

	public static boolean isVisit(int index) {
		return visits[index];
	}
}
