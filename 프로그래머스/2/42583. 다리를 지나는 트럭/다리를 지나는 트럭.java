import java.util.*;
import java.io.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int sumWeight = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<bridge_length;i++) q.addLast(0);
        
        int idx=0;
        
        while(idx<truck_weights.length){
            time++;
            
            sumWeight-=q.pollFirst();
            
            int next = truck_weights[idx];
            
            if(sumWeight+next <= weight){
                q.addLast(next);
                sumWeight+=next;
                idx++;
             } else {
                q.addLast(0);
            }
            
            
        }
        
        return time+bridge_length;
    }
}