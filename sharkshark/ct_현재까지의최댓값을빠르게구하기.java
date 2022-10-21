
import java.util.*;
import java.io.*;

public class ct_현재까지의최댓값을빠르게구하기 {

	public static void main(String[] args) {
		int[] arr = {3, 6, 2, 6, 7, 7, 2};
		
		TreeSet<Integer> t = new TreeSet<Integer>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<arr.length; i++) {
			t.add(arr[i]);
			sb.append(t.last()).append(" ");
		}
		
		System.out.println(sb);
	}

}
