package algori;
import java.util.*;
import java.io.*;

public class BOJ_11657 {
	
	static class City {
		int end, weight;
		
		City(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}
	
	static int N, M;
	static ArrayList<ArrayList<City>> city;
	static long[] dist; // 자료형을 int로 할 경우 오버플로우 발새함
	static final int INF = 987654321;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		city = new ArrayList<>(); 
		dist = new long[N+1];
		
		for(int i=0; i<=N; i++) {
			city.add(new ArrayList<>());
			dist[i] = INF;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			city.get(A).add(new City(B, C));
		}
		
		StringBuilder sb = new StringBuilder();
		if(bellmanFord()) {
			sb.append("-1\n");
		} else {
			for(int i=2; i<=N; i++) {
				if(dist[i] == INF) {
					sb.append("-1\n");
				} else {
					sb.append(dist[i] + "\n");
				}
			}
		}
		System.out.println(sb.toString());
	}

	private static boolean bellmanFord() {
		dist[1] = 0; 	// 시작점은 0으로 초기화
		boolean update = false;
		
		// (정점의 개수 - 1)번 동안 최단거리 초기화 작업을 반복함.
		for(int i=1; i<N; i++) {
			update = false;
			
			// 최단거리 초기화
			for(int j=1; j<=N; j++) {
				for(City c : city.get(j)) {
					if(dist[j] == INF) {
						break;
					}
					if(dist[c.end] > dist[j] + c.weight) {
						dist[c.end] = dist[j] + c.weight;
						update = true;
					}
				}
			}
			
			// 더 이상 최단거리 초기화가 일어나지 않았을 경우 반복문을 종료
			if(!update) {
				break;
			}
		}
		
		// (정점의 개수 - 1)번까지 계속 업데이트가 발생했을 경우
		// (정점의 개수)번도 업데이트 발생하면 음수 사이클이 일어난 것을 의미함.
		if(update) {
			for(int i=1; i<=N; i++) {
				for(City c : city.get(i)) {
					if(dist[i] == INF) {
						break;
					}
					if(dist[c.end] > dist[i] + c.weight) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
