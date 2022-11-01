package programmers;

import java.util.*;
import java.io.*;

class p_최소직사각형 {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int x = Integer.MIN_VALUE;  // 가로
        int y = Integer.MIN_VALUE;  // 세로
        
        for(int i=0; i<sizes.length; i++) {
            int tempx = Math.max(sizes[i][0], sizes[i][1]);
            int tempy = Math.min(sizes[i][0], sizes[i][1]);
            x = Math.max(x, tempx);
            y = Math.max(y, tempy);
        }
              
        answer = x * y;
        
        return answer;
    }
}
