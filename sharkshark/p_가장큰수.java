package programmers;

import java.util.*;
import java.io.*;

class p_가장큰수 {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] arr = new String[numbers.length];
        
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(arr, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        
        if(arr[0].equals("0")) {
            answer.append("0");
        } else {
            for(int i=0; i<arr.length; i++) {
                answer.append(arr[i]);
            }
        }
        
        return answer.toString();
    }
}
