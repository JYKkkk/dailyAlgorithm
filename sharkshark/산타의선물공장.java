package codeTree;
import java.util.*;
import java.io.*;

public class 산타의선물공장 {
	
	static int q, m, n;	// 명령의 개수, 벨트의 개수, 상자의 개수
	static BOX[] box = new BOX[100005];
	static BELT[] belt = new BELT[15];	// belt[i] : i번 벨트에서 가장 앞에 있는 박스 번호, 없다면 0
	static int[] idx = new int[100005], weights = new int[100005];
	static HashMap<Integer, BOX> boxMap = new HashMap<>();	// id : BOX 값
	
	static class BOX {
		int idx, belt, weight;
		BOX prev, next;
		
		BOX(int idx, int belt, int weight) {
			this.idx = idx;	this.belt = belt;	this.weight = weight;
			this.prev = null; this.next = null;
		}
	}
	
	static class BELT {
		BOX front, end;
		boolean broken;
		
		BELT() {
			this.front = null; this.end = null;
			this.broken = false;
		}
	}
	
	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		q = Integer.parseInt(br.readLine());
		
		// 공장 설립 명령 : 항상 첫 번째 명령으로 주어짐
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		st.nextToken();	// 100
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		for(int i=1; i<=n; i++) {
			idx[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<=n; i++) {
			weights[i] = Integer.parseInt(st.nextToken());		
		}
		int T = n / m;
		for(int i=1; i<=m; i++) {
			for(int j=(i-1)*T+1; j<=i*T; j++) {
				box[j].idx = idx[j];
				box[j].belt = i;
				box[j].weight = weights[j];
				pushBox(i, box[j]);
			}
		}
	}

	static void pushBox(int beltIdx, BOX box) {
		// beltIdx번 벨트에 box번 박스를 넣음
		boxMap.put(box.idx, box);
		box.belt = beltIdx;
		if(belt[beltIdx].front == null) {
			box.prev = box.next = null;
			belt[beltIdx].front = belt[beltIdx].end = box;
		} else {
			box.prev = belt[beltIdx].end;
			box.next = null;
			belt[beltIdx].end.next = box;
			belt[beltIdx].end = box;
		}
	}
	
	static class Pair {
		Integer key, value;
		
		Pair(Integer key, Integer value) {
			this.key = key; this.value = value;
		}
		
		Integer getKey() {
			return key;
		}
		
		Integer getValue() {
			return value;
		}
	}
	
	static List<Integer> ans = new ArrayList<>();
	static List<Pair> Qs = new ArrayList<>();
	
	static void pro() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int rep=2; rep<=q; rep++) {
			int q2, v;	// 명령어, 인자
			st = new StringTokenizer(br.readLine());
			q2 = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			Qs.add(new Pair(q2, v));
		}
		for(Pair p : Qs) {
			int query = p.getKey();
			if(query == 200) {
				int W = p.getValue();
				ans.add(query200(W));
			} else if(query == 300) {
				int id = p.getValue();
				ans.add(query300(id));
			} else if(query == 400) {
				int id = p.getValue();
				ans.add(query400(id));
			} else if(query == 500) {
				int bNum = p.getValue();
				ans.add(query500(bNum));
			}
		}
		
		// output
		for(int x : ans) {
			System.out.print(x);
		}
	}

	static Integer query200(int w) {
		// 물건 하차
		int sum = 0;
		for(int i=1; i<=m; i++) {
			if(belt[i].front == null || belt[i].broken) {
				continue;
			}
			if(belt[i].front.weight <= w) {
				sum += belt[i].front.weight;
				dropBox(i);
			} else {
				Box box = dropBox(i);
				pushBox(i, box);
			}
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		input();
		pro();
	}



}
