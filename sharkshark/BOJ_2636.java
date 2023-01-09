package algori;
import java.util.*;
import java.io.*;

public class BOJ_2636 {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int cheeseCnt;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static class Location{
		int x, y;
		
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][M];
		
		int ans;
		for(ans=0; isCheese(); ans++) {
			for(boolean[] arr : visited) {
				Arrays.fill(arr, false);
			}
			
			visited[0][0] = true;
			cheeseCnt = 0;
			
			bfs(new Location(0, 0));
		}
		
		System.out.println(ans);
		System.out.println(cheeseCnt);
	}

	private static void bfs(Location location) {
		Queue<Location> q = new LinkedList<>();
		
		q.offer(location);
		
		while(!q.isEmpty()) {
			Location cur = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				// 범위를 벗어나는 경우	
				if(nx<0 || ny<0 || nx>=N || ny>=M) {
					continue;
				}
				
				if(!visited[nx][ny]) {
					if(map[nx][ny]==1) {
						visited[nx][ny] = true;
						map[nx][ny] = 2;
						cheeseCnt++;	// 다음에 지워질 치즈의 개수
					}
					
					if(map[nx][ny]==0) {
						visited[nx][ny] = true;
						q.add(new Location(nx, ny));
					}
				}
			}
		}
	}

	// 판 위에 치즈가 존재하는지
	private static boolean isCheese() {
		// map[i][j] = 2로 표시된 부분은 공기와 맞닿은 치즈이므로
		// 먼저 공기로 바꿔줘야 함.
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==2) {
					map[i][j] = 0;
				}
			}
		}
		
		// 판 위에 치즈가 존재하는지 체크
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==1) {
					return true;
				}
			}
		}
		
		return false;
	}

}
