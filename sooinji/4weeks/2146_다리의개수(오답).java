import java.util.*;

class Point {
	int x, y, d;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	Point(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}
public class Main {
	
	static int n, cnt = 0;
	static int[][] map;
	static boolean[][] vis;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		vis = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!vis[i][j] && map[i][j] == 1) {
					cnt++;
					bfs(i, j);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] > 1) {
					for (int d = 0; d < dx.length; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (nx < 0 || nx >= n || ny < 0 || ny >=n) continue;
						if (map[nx][ny] == 0) { // 바다와 인접
							bfs2(i, j);
							break;
						}
					}
				}
			}
		}
		System.out.println(ans - 1);
	}
	private static void bfs2(int x, int y) {
		vis = new boolean[n][n];
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(x, y, 0));
		vis[x][y] = true;
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				int nd = cur.d + 1;
				// 범위 밖
				if (nx < 0 || nx >= n || ny < 0 || ny >=n) continue;
				// 방문 o 점
				if (vis[nx][ny]) continue;
				q.offer(new Point(nx, ny, nd));
				vis[nx][ny] = true;
				if (map[x][y] != 0 && map[nx][ny] != 0 && map[x][y] != map[nx][ny]) {
					if (nd < ans) ans = nd;
				}
			}
		}
	}
	private static void bfs(int x, int y) {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(x, y));
		while(!q.isEmpty()) {
			Point cur = q.poll();
			vis[cur.x][cur.y] = true;
			map[cur.x][cur.y] = cnt;
			for (int i = 0; i < dx.length; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				// 범위 밖
				if (nx < 0 || nx >= n || ny < 0 || ny >=n) continue;
				// 방문 o 점, 바다
				if (vis[nx][ny] || map[nx][ny] == 0) continue;
				q.offer(new Point(nx, ny));
			}
		}
	}

}
