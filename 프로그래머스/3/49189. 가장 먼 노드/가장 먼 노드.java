import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] Visited = new boolean[n+1];
        int[] Count = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        
        ArrayList<ArrayList<Integer>> Graph = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            Graph.add(new ArrayList<>());
        }
        
        for(int[] e : edge){
            int a = e[0];
            int b = e[1];
            Graph.get(a).add(b);
            Graph.get(b).add(a);
        }
        
        q.offer(1);
        Visited[1]=true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int next : Graph.get(now)){
                if(!Visited[next]){
                    Visited[next]=true;
                    Count[next]=Count[now]+1;
                    q.offer(next);
                }
            }
        }
        
        Arrays.sort(Count);
        int max = Count[n];
        for(int i : Count){
            if(max == i){
                answer++;
            }
        }
        
        return answer;
    }
}