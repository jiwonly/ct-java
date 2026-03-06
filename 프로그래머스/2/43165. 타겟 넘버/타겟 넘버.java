import java.util.*;
import java.io.*;

class Solution {
    int answer = 0;
    int n;
    int[] numbers;
    int target;
    
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        this.numbers = numbers;
        this.target = target;
        dfs(0,0);
        
        return answer;
    }
    
    private void dfs(int idx, int sum){
        if(idx == n){
            if(sum==target) answer++;
            return;
        }
        
        dfs(idx+1, sum-numbers[idx]);
        dfs(idx+1, sum+numbers[idx]);
    }
}