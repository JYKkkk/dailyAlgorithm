import java.util.*;
import java.io.*;

public class BOJ_17352 {

    static int N, start;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // input
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=0; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<N-2; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            start = u;
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        // find
        dfs(start);

        // output
        int p1=0, p2=1;
        for(int i=1; i<visited.length; i++) {
            if(!visited[i]) {
                p1 = i;
            } else {
                p2 = i;
            }
        }

        System.out.println(p1 + " " + p2);
    }

    private static void dfs(int s) {
        visited[s] = true;

        for(int i=0; i<graph[s].size(); i++) {
            int val = graph[s].get(i);
            if(!visited[val]) {
                visited[val] = true;
                dfs(val);
            }
        }
    }
}
