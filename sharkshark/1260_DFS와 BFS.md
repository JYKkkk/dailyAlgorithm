<img src="https://j7b205.p.ssafy.io/assets/header/markdown_header.png" />

# <img src="https://static.solved.ac/tier_small/9.svg" alt="tier" height="32px" /> DFS와 BFS - 1260 

## 문제

> https://www.acmicpc.net/problem/1260

### 분류

graphs,graph_traversal,bfs,dfs

### 문제 설명

그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.



#### 입력

첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.



#### 출력

첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.



#### 예제

<table><tr><th><img width=120/>입력 1<img width=120/></th><th><img width=120/>출력 1<img width=120/></th></tr><tr><td>

```
4 5 1
1 2
1 3
1 4
2 4
3 4
```
</td><td>

```
1 2 4 3
1 2 3 4
```
</td></tr></table>
<table><tr><th><img width=120/>입력 2<img width=120/></th><th><img width=120/>출력 2<img width=120/></th></tr><tr><td>

```
5 5 3
5 4
5 2
1 2
3 4
3 1
```
</td><td>

```
3 1 2 5 4
3 1 4 2 5
```
</td></tr></table>
<table><tr><th><img width=120/>입력 3<img width=120/></th><th><img width=120/>출력 3<img width=120/></th></tr><tr><td>

```
1000 1 1000
999 1000
```
</td><td>

```
1000 999
1000 999
```
</td></tr></table>


####

## 풀이 코드

```c
import java.io.*;
import java.util.*;

public class Main {
	
	/* 
	 * 오름차순 정점 방문
	 * */
	static int N, M, V;
	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	static StringBuilder sbDFS = new StringBuilder();
	static StringBuilder sbBFS = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		for(int i=1; i<N+1; i++) {
			Collections.sort(graph[i]);
		}
		
		visited = new boolean[N+1];
		dfs(V);
		bfs(V);
		
		// 결과 출력
		System.out.println(sbDFS);
		System.out.println(sbBFS);
	}

	private static void bfs(int v) {
		visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		
		sbBFS.append(v).append(" ");
		q.offer(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i=0; i<graph[cur].size(); i++) {
				int val = graph[cur].get(i);
				if(!visited[val]) {
					visited[val] = true;
					sbBFS.append(val).append(" ");
					q.offer(val);
				}
			}
		}
	}

	private static void dfs(int v) {
		sbDFS.append(v).append(" ");
		visited[v] = true;
		
		for(int i=0; i<graph[v].size(); i++) {
			int val = graph[v].get(i);
			if(!visited[val]) {
				visited[val] = true;
				dfs(val);
 			}
		}
	}

}

```
