import java.util.*;
import java.io.*;

public class BOJ_14426 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // input
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] arr = new String[N];
        for(int i=0; i<N; i++) {
            arr[i] = br.readLine();
        }

        // compare
        int answer = 0;
        for(int i=0; i<M; i++) {
            String pre = br.readLine();

            for(String s : arr) {
                if(s.startsWith(pre)) {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
