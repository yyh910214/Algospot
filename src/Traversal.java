/**
 * @file Traversal.java
 * @date 2015. 5. 4.
 * @author yyh
 */

public class Traversal {
	public static void main(String[] args) {
		InputReader input = new InputReader(System.in);

		int T = input.nextInt();
		int[] prefix, postfix, infix;
		infix = new int[100];
		prefix = new int[100];
		while (T-- > 0) {

			int N = input.nextInt();
			for (int i = 0; i < N; ++i) {
				prefix[i] = input.nextInt();
			}

			for (int i = 0; i < N; ++i) {
				infix[i] = input.nextInt();
			}

			postfix = new int[100];
			makePostFix(0, N - 1, 0, N - 1, prefix, infix, postfix);

			for (int i = 0; i < N; ++i) {
				System.out.print(postfix[i] + " ");
			}
		}
	}

	public static void makePostFix(int start, int end, int prefixIndex, int postfixIndex,
			int[] prefix, int[] infix, int[] postfix) {
		int rootIndex = -1;
		for (int i = start; i <= end; ++i) {
			if (prefix[prefixIndex] == infix[i]) {
				rootIndex = i;
			}
		}
		// 루트를 맨 마지막으로 보냄
		postfix[postfixIndex] = prefix[prefixIndex];

		if (rootIndex != -1) {
			if (rootIndex != start) {
				makePostFix(start, rootIndex - 1, prefixIndex + 1, postfixIndex - (end - rootIndex + 1), prefix,
						infix, postfix);
			}
			
			if (rootIndex != end) {
				makePostFix(rootIndex + 1, end,
						prefixIndex + rootIndex - start + 1, postfixIndex - 1, prefix, infix, postfix);
			}
		}
	}
}
