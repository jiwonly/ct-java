import java.util.*;

class Solution {
    
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long left = 1;
        long right = (long) times[times.length-1] * n;
        
        while(left <= right){
            long mid = (left+right)/2;
            long sum = 0; // mid 시간 동안 처리할 수 있는 사람의 수
            
            for(int t : times){
                sum+=mid/t;
                
                // 처리 인원이 n명을 넘어가면 더 이상 계산 불필요
                if(sum>=n) break;
            }
            
            if (sum<n){
                // 시간이 부족하므로 범위를 큰 쪽으로 이동
                left=mid+1;
            }
            else{
                // n명 이상 처리가 가능하므로 일단 정답으로 기록
                // 더 짧은 시간에도 가능한지 확인하기 위해 범위를 작은 쪽으로 이동
                answer = mid;
                right=mid-1;
            }
        }
        
        return answer;
    }
}