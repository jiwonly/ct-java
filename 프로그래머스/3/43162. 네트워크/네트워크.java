class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int len = computers.length;
        
        boolean[] visited = new boolean[len];
        
        for(int i=0;i<len;i++){
            if(!visited[i]){
                dfs(i, computers, visited);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(int now, int[][] computers, boolean[] visited){
        visited[now] = true;
        
        for(int i=0;i<computers.length;i++){
            if(computers[now][i]==1 && !visited[i]){
                dfs(i, computers, visited);
            }
        }
    }
}