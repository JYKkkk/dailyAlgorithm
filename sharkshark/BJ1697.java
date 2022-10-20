package baekjoon;

import java.util.*;
import java.io.*;

public class BJ1697 {
	  
	static int N, K, cnt;
	static int[] visited = new int[100001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
        if (N >= K) {
            System.out.println(N - K);
        } else {
        	System.out.println(bfs(N));
        }
	}

	private static int bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(n);
		visited[n] = 1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i=0; i<3; i++) {
				int val;
				if(i==0) {
					val = cur - 1;
				} else if(i==1) {
					val = cur + 1;
				} else {
					val = cur * 2;
				}
				
				if(val==K) {
					return visited[cur];
				}
				
				if(val>=0 && val<100001 && visited[val]==0) {
					visited[val] = visited[cur] + 1;
					q.add(val);
				}
			}
		}
		return 0;
	}

}
