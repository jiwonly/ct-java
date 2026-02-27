import java.util.*;

class Solution {
    // location : 몇 번째로 실행되는지 알고싶은 프로세스의 위치
    public int solution(int[] priorities, int location) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[] cnt = new int[10]; // 각 우선순위 몇 개인지
        
        for(int i=0;i<priorities.length;i++){
            int curr = priorities[i];
            q.addLast(new int[]{curr, (i==location)?1:0});
            cnt[curr]++;
        }
        
        int max = 9;
        while(max>0 && cnt[max]==0) max--;
        
        int executed =0;
        
        while(true){
            int[] curr = q.pollFirst();
            int currNum = curr[0];
            
            if(currNum!=max){
                q.addLast(curr);
            } else{
                executed++;
                if(curr[1]==1){
                    return executed;
                }
                
                cnt[currNum]--;
                while(max>0 && cnt[max]==0) max--;
                
            }
        }
        
    }
}