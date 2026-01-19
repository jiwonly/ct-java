import java.util.*;
import java.io.*;

public class Solution{
    static int[] dx = {0, 0,-1, 1};
    static int[] dy = {-1, 1, 0,0};
    static int N;
    static int[][] map;
    static int[][] minTime;

    static class Node implements Comparable<Node> {
        int x, y, time;

        public Node(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time; // 복구 시간이 짧은 순서대로 정렬
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        for(int i=0;i<cnt;i++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            minTime = new int[N][N];

            for(int j=0;j<N;j++){
                String line = br.readLine();
                for(int k =0;k<N;k++){
                    map[j][k] = line.charAt(k) - '0';
                    minTime[j][k] = Integer.MAX_VALUE;
                }
            }

            int answer = dijkstra(0,0);

            System.out.println("#"+(i+1)+" "+answer);
        }

    }

    private static int dijkstra(int startX, int startY) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        minTime[startY][startX] = 0;
        pq.offer(new Node(startX, startY, 0));

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int cx = curr.x; int cy = curr.y; int ctime = curr.time;

            if(cx == N-1 && cy == N-1){
                return ctime;
            }

            if(minTime[cy][cx] < ctime) continue;

            for(int i=0;i<4;i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<N){
                    int nextTime = ctime+map[ny][nx];

                    if(minTime[ny][nx] > nextTime){
                        minTime[ny][nx] = nextTime;
                        pq.offer(new Node(nx, ny, nextTime));
                    }
                }
            }
        }
        return 0;
    }

}
