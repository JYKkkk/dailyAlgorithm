package baekjoon;
import java.util.*;
import java.io.*;

public class B14650 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[10];
		dp[2] = 2;
		for(int i=3; i<dp.length; i++) {
			dp[i] = dp[i-1]*3;
		}
		
		System.out.println(dp[N]);
	}

}
