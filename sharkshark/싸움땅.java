package codeTree;
import java.util.*;
import java.io.*;

public class 싸움땅 {
	
	static int n, m, k;
	static PriorityQueue<Integer>[][] map;
	static Player[] player;
	
	static class Player implements Comparable<Player> {
		int x, y, d, s;	// (x, y):플레이어의 위치 / d:방향 / s:플레이어의 초기 능력치
		int gun, score;
		
		Player(int x, int y, int d, int s) {
			this.x=x; this.y=y; this.d=d; this.s=s;
		}

		@Override
		public int compareTo(Player o) {
			if(s+gun != o.s+o.gun) {
				return (s+gun) - (o.s+o.gun);
			}
			return s - o.s;
		}
		
		public int getDiff(Player o) {
			return s + gun - o.s - o.gun;
		}
	}
	
	// input
	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());	// 격자의 크기
		m = Integer.parseInt(st.nextToken());	// 플레이어의 수
		k = Integer.parseInt(st.nextToken()); 	// 라운드의 수
		
		// (map에)격자에 있는 총의 정보 입력
		map = new PriorityQueue[n+1][n+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				map[i][j] = new PriorityQueue<Integer>(Collections.reverseOrder());
				map[i][j].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		// 플레이어들의 정보 입력
		player = new Player[m+1];
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			player[i] = new Player(x, y, d, s);
		}
	}
	
	static void pro() {
		// k라운드 동안 게임 진행
		for(int i=0; i<k; i++) {
			// 1번 ~ m번 플레이어까지 한 번씩 진행
			for(int j=1; j<=m; j++) {
				move(j);
				int c = conflict(player[j].x, player[j].y, j);
				if(c==0) {	// 이동한 방향에 플레이어가 없는 경우
					pick_gun();
				} else {	// 이동한 방향에 플레이어가 있는 경우
					fight();
				}
			}
		}
		
		// output : 각 플레이어들이 획득한 포인트 출력
		for(int i=1; i<=m; i++) {
			System.out.print(player[i] + " ");
		}
	}

	// j번 플레이어를 한 칸 이동시킴
	static void move(int j) {
		
	}

	public static void main(String[] args) throws Exception {
		input();
		pro();
	}

}
