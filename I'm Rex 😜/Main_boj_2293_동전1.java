package com.younghwani.a230508;

import java.io.*;
import java.util.stream.*;

public class Main_boj_2293_동전1 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int[] C = new int[arr[0]];
    for (int i = 0; i < arr[0]; i++) {
      C[i] = Integer.parseInt(br.readLine());
    }
    int[] dp = new int[arr[1] + 1];
    dp[0] = 1;
    for (int i = 0; i < arr[0]; i++) {
      for (int j = C[i]; j <= arr[1]; j++) {
        dp[j] += dp[j - C[i]];
      }
    }
    System.out.print(dp[arr[1]]);
    br.close();
  }
}
