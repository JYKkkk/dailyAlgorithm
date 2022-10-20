import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> backpq = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Integer> frontpq = new PriorityQueue<>((a, b) -> b - a);
        StringBuilder sb = new StringBuilder();
        frontpq.add(Integer.parseInt(br.readLine()));
        sb.append(frontpq.peek() + "\n");

        for (int i = 1; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if (frontpq.peek() >= n)
                frontpq.add(n);
            else
                backpq.add(n);

            if (frontpq.size() < backpq.size()) {
                frontpq.add(backpq.poll());
            }
            if (frontpq.size() > backpq.size() + 1) {
                backpq.add(frontpq.poll());
            }

            sb.append(frontpq.peek() + "\n");
        }
        System.out.println(sb);

    }
}