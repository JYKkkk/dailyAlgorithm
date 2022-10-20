package baekjoon;

import java.io.*;
import java.util.*;

public class B7576 {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N, M, cnt = Integer.MIN_VALUE;
	static int[][] map;
	static class Tomato {
		private int x, y;
		
		Tomato(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static Queue<Tomato> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 익은 토마토 구하기
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==1) {	// 익은 토마토라면
					q.add(new Tomato(i, j));
				}
			}
		}
		
		// 익히기 시작
		bfs();
		
		// 결과 출력
		boolean all = true;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) {
					all = false;
				}
			}
		}
		
		if(!all) {			
			System.out.println(-1);
		}  else {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(cnt < map[i][j]) {
						cnt = map[i][j];
					}
				}
			}
			System.out.println(cnt-1);
		}
	}

	private static void bfs() {
		
		while(!q.isEmpty()) {
			Tomato val = q.poll();
			
			for(int i=0; i<4; i++) {
				int curX = val.x + dx[i];
				int curY = val.y + dy[i];
				
				if(curX>=0 && curX<N && curY>=0 && curY<M 
						&& map[curX][curY]==0 && map[curX][curY]!=-1) {
					map[curX][curY] = map[val.x][val.y] + 1;
					q.add(new Tomato(curX, curY));
				}
			}
		}
	}

}
