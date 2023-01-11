package algori;
import java.io.*;
import java.util.*;

public class BOJ_11404 {
	
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][N+1];
		
		// 초기값 설정
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				arr[i][j] = INF;
				
				if(i==j) {
					arr[i][j] = 0;
				}
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			// 출발 도시와 도착 도시가 같지만 비용이 다른 입력값이 들어올 수 있음.
			// 예를 들어 "1 4 1"과 "1 4 2"가 입력으로 들어왔으면,
			// "1 4 1"을 택해야 함.
			arr[a][b] = Math.min(arr[a][b], c);
		}
		
		// 플로이드 와샬 알고리즘
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					// 최단경로 초기화
					if(arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				// 갈 수 없는 곳은 0으로 초기화
				if(arr[i][j]==INF) {
					arr[i][j] = 0;
				}
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
