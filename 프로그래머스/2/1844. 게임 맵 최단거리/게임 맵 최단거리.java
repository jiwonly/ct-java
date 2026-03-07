import java.util.*;
import java.io.*;

class Solution {
    Queue<int[]> q;
    boolean[][] visited;
    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,1,-1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        q = new LinkedList<>();
        
        q.offer(new int[]{0,0});
        
        while(!q.isEmpty()){
            bfs(maps);
        }
        
        if(maps[n-1][m-1]== 1){
            return -1;
        } else{
            return maps[n-1][m-1];
        }
        
    }
    
    private void bfs(int[][] maps){
        int[] start = q.poll();
        int sy = start[0];
        int sx = start[1];
        int n = maps.length;
        int m = maps[0].length;
        
        for(int i=0;i<4;i++){
            int ny = sy + dy[i];
            int nx = sx + dx[i];
            
            if(ny<0 || nx<0 || ny>=n || nx>=m){
                continue;
            }
            
            if(maps[ny][nx] != 1){
                continue;
            }
            
            maps[ny][nx] = maps[sy][sx] + 1;
            q.offer(new int[]{ny,nx});    
        }
    }
}