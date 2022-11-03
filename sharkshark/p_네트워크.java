package programmers;

import java.io.*;
import java.util.*;

class Solution {   
    
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n+1];
        for(int i=0; i<n; i++) {
            if(!visited[i+1]) {
                dfs(computers, n, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void dfs(int[][] computers, int n, int v) {
        
        visited[v+1] = true;
        
        for(int j=0; j<n; j++) {
            if(computers[v][j]==1 && !visited[j+1]) {
                visited[j+1] = true;
                dfs(computers, n, j);
            }
        }       
    }
}
