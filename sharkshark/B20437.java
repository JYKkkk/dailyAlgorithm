package baekjoon;
import java.util.*;
import java.io.*;

public class B20437 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	// 문자열 게임의 수
		
		for(int i=0; i<T; i++) {
			char[] arr = br.readLine().toCharArray();
			int K = Integer.parseInt(br.readLine()); 	// 정수 K
			
			if(K==1) {
				System.out.println("1 1");
				continue;
			}
			
			int[] alpha = new int[26];	// 알파벳별 갯수를 저장한다.
			for(int j=0; j<arr.length; j++) {
				alpha[arr[j]-'a']++;
			}
			
			int min=10001, max=-1;
			for(int j=0; j<arr.length; j++) {
				
				// K개 이하의 알파벳은 세지 않는다.
				if(alpha[arr[j]-'a'] < K) {
					continue;
				}
				
				int cnt = 1;
				for(int l=j+1; l<arr.length; l++) {
					if(arr[j] == arr[l]) {
						cnt++;
					}
					if(cnt==K) {
						min = Math.min(min, l-j+1);
						max = Math.max(max, l-j+1);
						break;
					}
				}
			}
			
			// 출력
			if(min==10001 || max==-1) {
				System.out.println("-1");
			} else {
				System.out.println(min + " " + max);
			}
		}
	}

}
