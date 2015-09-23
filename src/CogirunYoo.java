import java.util.Scanner;

/**
 * Algospot - COGIRUN
 * @see https://algospot.com/judge/problem/read/COGIRUN
 * @since 2014.10.15
 * @author SungKyu Yoo (skyoo2003@naver.com)
 */
public class CogirunYoo {
	static Node[][] map = new Node[10][500000];
	static int W;
	static int H;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int M = scanner.nextInt();
		while(M-- > 0) {
			Runtime.getRuntime().gc();
			W = scanner.nextInt();
			H = scanner.nextInt();
			
			for(int h = 0; h < H; ++h) {
				String line = scanner.next();
				for(int w = 0; w < W; ++w) {
					map[h][w] = new Node(line.charAt(w));
				}
			}
			
			int largest = 1;
			map[H-1][0].s[0] = true;
			for(int w = 1; w < W; ++w) {
				for(int h = H - 1; h >= 0; --h) {
					if(map[h][w].c != '#') {
						walk(h, w);
						jump(h, w);
						jumpdown(h, w);
						doublejump(h, w);
						doublejumpdown(h, w);
						if(possible(h, w))
							largest = Math.max(largest, w+1);
					}
				}
			}
			System.out.println(largest);
		}
		
		scanner.close();
	}
	
	static class Node {
		public char c;
		// 0: WALK, 1: JUMP, 2: JUMPDOWN, 3: DOUBLEJUMP, 4: DOUBLEJUMPDOWN
		public boolean[] s = new boolean[5];
		public Node(char c) {
			this.c = c;
		}
	}
	
	static void walk(int h, int w) {
		if(h == H -1) 
			map[h][w].s[0] = map[h][w-1].s[0] || map[h-1][w-1].s[2] || map[h-1][w-1].s[4];
	}
	
	static void jump(int h, int w) {
		if(h < H - 1) 
			map[h][w].s[1] = map[h+1][w-1].s[0] | map[h+1][w-1].s[1];
	}
	
	static void jumpdown(int h, int w) {
		if(h == 1) map[h][w].s[2] = map[h-1][w-1].s[1];
		else if(h > 1) map[h][w].s[2] = map[h-1][w-1].s[2];
	}
	
	static void doublejump(int h, int w) {
		if(h < H - 1) map[h][w].s[3] = map[h+1][w-1].s[2] || map[h+1][w-1].s[3];
	}
	
	static void doublejumpdown(int h, int w) {
		if(h == 1) map[h][w].s[4] = map[h-1][w-1].s[3];
		else if(h > 1) map[h][w].s[4] = map[h-1][w-1].s[4];
	}
	
	static boolean possible(int h, int w) {
		return map[h][w].s[0] || map[h][w].s[1] || map[h][w].s[2] || map[h][w].s[3] || map[h][w].s[4];
	}
}