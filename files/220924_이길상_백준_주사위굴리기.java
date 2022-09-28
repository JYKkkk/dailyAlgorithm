import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int X = Integer.parseInt(line[2]);
        int Y = Integer.parseInt(line[3]);
        int K = Integer.parseInt(line[4]);

        int[][] board = new int[N][M];
        for (int n = 0; n < N; n++) {
            line = br.readLine().split(" ");
            for (int m = 0; m < M; m++) {
                board[n][m] = Integer.parseInt(line[m]);
            }
        }

        //  1
        //3 0 2
        //  4
        //  5
        // 동 서 북 남
        int[][] direction = {
            {2, 1, 5, 0, 4, 3},
            {3, 1, 0, 5, 4, 2},
            {1, 5, 2, 3, 0, 4},
            {4, 0, 2, 3, 5, 1}
        };
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        int[] dice = new int[6];
        int top = 0;

        StringBuilder sb = new StringBuilder();

        line = br.readLine().split(" ");
        for (int i = 0; i < K; i++) {
            int k = Integer.parseInt(line[i])-1;
            
            // 이동 가능한지 확인
            int nx = X + dx[k];
            int ny = Y + dy[k];

            // 이동 불가능하면 명령 무시
            if (nx<0 || ny<0 || nx>=N || ny>=M) continue;

            // 이동
            X = nx;
            Y = ny;
            
            // 주사위 굴리기
            int[] newdice = new int[6];
            for (int j = 0; j < 6; j++) {
                newdice[direction[k][j]] = dice[j];
            }
            dice = newdice;

            // 윗면  출력
            sb.append(dice[0] + "\n");

            // 칸이 0일 경우
            if (board[X][Y]==0) 
                board[X][Y] = dice[5];
            // 칸이 0이 아닌 경우
            else {
                dice[5] = board[X][Y];
                board[X][Y] = 0;
            }
        }

        System.out.println(sb);
    }
}