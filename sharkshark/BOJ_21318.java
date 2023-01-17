import java.io.*;
import java.util.*;

public class BOJ_21318 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // input
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N+1];
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int Q = Integer.parseInt(br.readLine());

        // calculate
        int[] sum = new int[N+1];
        for(int i=1; i<=N; i++) {
            if(arr[i-1] > arr[i]) {
                sum[i] = sum[i-1] + 1;
            } else {
                sum[i] = sum[i-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(sum[y]-sum[x] +  "\n");
        }

        // output
        System.out.println(sb);
    }
}
