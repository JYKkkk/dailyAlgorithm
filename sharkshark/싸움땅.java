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
		
		public int subtract(Player o) {
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
				if(c==0) {	// 이동한 방향에 플레이어가 없는 경우(싸움이 일어나지 않았다면)
					drop_gun(j);
					pick_gun(j);
				} else {	// 이동한 방향에 플레이어가 있는 경우(싸움이 일어났다면)
					fight(j, c);
				}
			}
		}	
		// output : 각 플레이어들이 획득한 포인트 출력
		for(int i=1; i<=m; i++) {
			System.out.print(player[i].score + " ");
		}
	}

	static void fight(int j, int c) {
		// j번 사람이랑 c번 사람이 싸움!
		if(player[j].compareTo(player[c]) < 0) {	// c번 사람 승리
			player[c].score += player[c].subtract(player[j]);
			loser(j);
			winner(c);
		} else {
			player[j].score += player[j].subtract(player[c]);
			loser(c);
			winner(j);
		}
	}

	static void winner(int j) {
		// 승리자에 대한 처리
		drop_gun(j);
		pick_gun(j);
	}

	static void loser(int j) {
		// 패배자에 대한 처리
		// 1. 총 떨어뜨리기
		drop_gun(j);
		// 2. 네 방향을 시계 방향으로 돌면서 갈 곳을 찾음
		int d = player[j].d;
		int nx = player[j].x + dir[d][0], ny = player[j].y + dir[d][1];
		while(nx < 1 || ny < 1 || nx > n || ny > n || conflict(nx, ny, j) != 0) {
			d = (d + 1) % 4;
			nx = player[j].x + dir[d][0]; ny = player[j].y + dir[d][1];
		}
		player[j].d = d;
		player[j].x = nx; player[j].y = ny;
		// 3.
		pick_gun(j);
	}

	static void pick_gun(int j) {
		// j번 사람이 현재 위치에서 총을 주움
		int x = player[j].x, y = player[j].y;
		if(map[x][y].isEmpty()) {
			player[j].gun = 0;
		} else {
			player[j].gun = map[x][y].poll();
		}
	}

	static void drop_gun(int j) {
		// 이미 총을 가지고 있는 경우, 공격력이 더 쎈 총 획득
		int x = player[j].x, y = player[j].y;
		map[x][y].add(player[j].gun);
		player[j].gun = 0;
	}

	static int conflict(int x, int y, int j) {
		// 현재 (x, y)에 있는 사람 / 플레이어가 충돌하는지 여부
		for(int i=1; i<=m; i++) {
			if(i==j) continue;
			if(x == player[i].x && y == player[i].y) {
				return i;	// 이동한 방향에 있는 플레이어
			}
		}
		return 0;
	}

	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	static void move(int j) {
		// j번 플레이어가 규칙에 맞게 이동함
		int d = player[j].d;
		int nx = player[j].x + dir[d][0], ny = player[j].y + dir[d][1];
		if(nx < 1 || ny < 1 || nx > n || ny > n) {	// 격자를 벗어나는 경우, 정반대 방향으로 +1
			d ^= 2;
			player[j].d ^= 2;
			nx = player[j].x + dir[d][0]; ny = player[j].y + dir[d][1]; 
		}
		player[j].x = nx; player[j].y = ny;
	}

	public static void main(String[] args) throws Exception {
		input();
		pro();
	}

}
