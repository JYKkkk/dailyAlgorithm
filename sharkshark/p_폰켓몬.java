package programmers;

import java.util.*;
import java.io.*;

class p_폰켓몬 {
    
    public int solution(int[] nums) throws Exception {
        int answer = 0;
        
        int max = nums.length / 2;
        HashSet<Integer> h = new HashSet<>();
        
        for(int i=0; i<nums.length; i++) {
           h.add(nums[i]); 
        }
        
        if(max < h.size()) {
            answer = max;
        } else {
            answer = h.size();
        }

        return answer;
    }
    
}
