import java.util.*;
import java.io.*;

public class ct_정수명령어 {

	public static void main(String[] args) throws Exception {
		TreeSet<Integer> t;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int tc=0; tc<T; tc++) {
			t = new TreeSet<Integer>();
			int k = Integer.parseInt(br.readLine());
			
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				String s = st.nextToken();
				int val = Integer.parseInt(st.nextToken());
				
				if(s.equals("I")) {
					t.add(val);
				} else if(!t.isEmpty() && s.equals("D") && val==1) {
					t.remove(t.last());
				} else if(!t.isEmpty() && s.equals("D") && val==-1) {
					t.remove(t.first());
				}
			}
			
			// 결과 출력
			if(t.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				System.out.println(t.last() + " " + t.first());
			}
		}
	}

}
