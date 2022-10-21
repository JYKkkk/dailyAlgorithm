import java.util.*;
import java.io.*;

public class ct_숫자빠르게찾기2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		TreeSet<Integer> t = new TreeSet<Integer>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			t.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i=0; i<m; i++) {
			int val = Integer.parseInt(br.readLine());
			if(t.ceiling(val)!=null) {
				System.out.println(t.ceiling(val));
			} else {
				System.out.println(-1);
			}
		}
	}

}
