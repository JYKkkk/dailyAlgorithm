package baekjoon;

import java.util.*;
import java.io.*;

public class B1012 {
   
   static int T, M, N, K, X, Y, cnt;
   static int[] dx = {-1, 1, 0, 0};
   static int[] dy = {0, 0, -1, 1};
   static int[][] map;
   static boolean[][] visited;

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      
      T = Integer.parseInt(br.readLine());
      
      for(int tc=0; tc<T; tc++) {
         st = new StringTokenizer(br.readLine(), " ");
         M = Integer.parseInt(st.nextToken());
         N = Integer.parseInt(st.nextToken());
         K = Integer.parseInt(st.nextToken());
         
         map = new int[N][M];
         for(int k=0; k<K; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            map[Y][X] = 1;
         }
         
         visited = new boolean[N][M];
         cnt = 0;
         // 탐색 시작
         for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
               if(!visited[i][j] && map[i][j]==1) {   // 방문하지 않았고, 배추가 있는 위치인 경우
                  dfs(i, j);
                  cnt++;
               }
            }
         }
         
         // 결과 출력
         System.out.println(cnt);
      }
   }

   private static void dfs(int i, int j) {
      visited[i][j] = true;
      
      for(int a=0; a<4; a++) {
         int ux = i + dx[a];   
         int uy = j + dy[a];
         
         if(ux>=0 && ux<N && uy>=0 && uy<M && !visited[ux][uy] && map[ux][uy]==1) {
            dfs(ux, uy);
         }
      }
   }

}
