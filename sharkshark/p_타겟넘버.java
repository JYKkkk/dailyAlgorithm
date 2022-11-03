package programmers;

import java.util.*;
import java.io.*;

class Solution {
    
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(numbers, 0, target, 0);
        
        return answer;
    }
    
    public static void dfs(int[] numbers, int depth, int target, int sum) {
        
        if(depth==numbers.length) {
            if(target==sum) {
                answer++;
            }
        } else {
            dfs(numbers, depth+1, target, sum+numbers[depth]);
            dfs(numbers, depth+1, target, sum-numbers[depth]);
        }
    }
}
