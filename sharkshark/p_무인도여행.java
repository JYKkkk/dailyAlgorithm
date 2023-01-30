package programmers;
import java.util.*;
import java.io.*;
public class p_무인도여행 {

    static int[][] realMap;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M, cnt=0;
    static List<Integer> answer = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        String[] map = {"X591X","X1X5X","X231X", "1XXX1"};

        N = map.length;
        M = map[0].length();
        realMap = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            char[] mapCharArr = map[i].toCharArray();

            for(int j=0; j<M; j++) {
                char c = mapCharArr[j];

                if(c=='X' || c=='x') {
                    realMap[i][j] = -1;
                    visited[i][j] = true;
                } else {
                    realMap[i][j] = c - '0';
                }
            }
        }

        // 탐색 시작
        for(int i=0; i< N; i++) {
            for(int j=0; j<M; j++) {
//                cnt = 0;
                dfs(i, j);
//                System.out.println(cnt);
                if(cnt!=0) {
                	answer.add(cnt);
//                	System.out.println(cnt);
                	cnt = 0;
                }
            }
        }
        
        // 무인도가 없는 경우
        if(answer.size() == 0) {
//            return new int[] {-1};
        }
        
        // 무인도가 있는 경우
        Collections.sort(answer);
        int[] answerArr = new int[answer.size()];

        for(int i=0; i<answerArr.length; i++) {
            answerArr[i] = answer.get(i);
        }

//        return answerArr;
    }

    private static void dfs(int x, int y) {
        if(x<0 || x>=N || y<0 || y>=M || visited[x][y] || realMap[x][y]==-1) {
            return;
        }
        
        visited[x][y] = true;
        cnt += realMap[x][y];

        for(int i=0; i<4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            
            if(cx<0 || cx>=N || cy<0 || cy>=M || visited[cx][cy] || realMap[cx][cy]==-1) {
                continue;
            }
            
            dfs(cx, cy);
        }
    }
}
