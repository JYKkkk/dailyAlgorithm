import java.util.*;
import java.io.*;

public class ct_최대숫자구하기 {

	// 삽입, 삭제, 최대값
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		TreeSet<Integer> t = new TreeSet<Integer>();
		for(int i=1; i<m+1; i++) {
			t.add(i);
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			t.remove(Integer.parseInt(st.nextToken()));
			System.out.println(t.last());
		}
	}

}
