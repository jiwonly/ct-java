import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int completedCount=0;
        int currTime=0;
        int sum=0;
        int index=0;
        
        int[][] newJobs = new int[jobs.length][3];
        for(int i = 0; i<jobs.length; i++){
            newJobs[i][0]=i;
            newJobs[i][1]=jobs[i][0];
            newJobs[i][2]=jobs[i][1];
        }
        
        Arrays.sort(newJobs, (a,b)->a[1]-b[1]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[2] != o2[2]) {
                return o1[2] - o2[2];
            }

            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            }
            
            return o1[0]-o2[0];
            
        });
        
        while(completedCount<newJobs.length){
            while(index<newJobs.length && currTime>=newJobs[index][1]){
                pq.add(newJobs[index]);
                index++;
            }
            
            if(pq.isEmpty()){
                currTime=newJobs[index][1];
            } else{
                int[] job = pq.poll();
                currTime+=job[2];
                sum+=(currTime-job[1]);
                completedCount++;
                
            }
        }
        
        int answer=sum/newJobs.length;
            
        return answer;
    }
}