package programmers;

import java.io.*;
import java.util.*;

class p_전화번호목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(int i=0; i<phone_book.length; i++) {
            hm.put(phone_book[i], i);
        }
        
        for(String s : phone_book) {
            for(int j=0; j<s.length(); j++) {
                if(hm.containsKey(s.substring(0, j))) {
                    answer = false;
                }
            }
        }
        
        return answer;
    }
}
