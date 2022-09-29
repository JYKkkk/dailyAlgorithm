import java.util.*;
import java.io.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] line = br.readLine().split(" ");
      int N = Integer.parseInt(line[0]);
      int M = Integer.parseInt(line[1]);
      
      int[] rel = new int[N+1];
      List<Integer>[] ref = new List[N+1];
      
      for (int n = 1; n <= N; n++) {
         ref[n] = new ArrayList<>();
      }

      for (int m = 0; m < M; m++) {
         line = br.readLine().split(" ");
         int A = Integer.parseInt(line[0]);
         int B = Integer.parseInt(line[1]);

         ref[A].add(B);
         rel[B]++;
      }

      Queue<Integer> queue = new LinkedList<>();

      for (int n = 1; n <= N; n++) {
         if (rel[n] == 0) queue.add(n);
      }

      StringBuilder sb = new StringBuilder();

      while(!queue.isEmpty()){
         int e = queue.poll();
         sb.append(e+" ");

         for(int i: ref[e]){
            rel[i]--;
            if (rel[i] == 0) queue.add(i);
         }
      }

      sb.setLength(sb.length()-1);
      System.out.println(sb);
   }
      
}