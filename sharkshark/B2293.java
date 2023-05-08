package baekjoon;
import java.util.*;
import java.io.*;

public class B2293 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());	// n가지 종류의 동전
		int k = Integer.parseInt(st.nextToken()); 	// 가치의 합
		
		int[] dp = new int[11];
		dp[0] = 1;	// 0을 만들 수 있는 경우 없음 == 1가지
		
		for(int i=0; i<n; i++) {
			int coin = Integer.parseInt(br.readLine());
			for(int j=coin; j<=k; j++) {
				dp[j] = dp[j] + dp[j-coin];
			}
		}
		
		// 출력
		System.out.print(dp[k]);
	}

}
