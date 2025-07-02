//  그림 alt+X

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx= {-1,1,0,0};
    static int[] dy= {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  // 입력을 한 줄씩 읽어올 수 있게 함
        StringTokenizer st = new StringTokenizer(br.readLine()); // 한 줄을 입력받으면, 그 줄을 공백 기준으로 잘라줌

        n = Integer.parseInt(st.nextToken()); // 첫 번째 토큰을 정수로 변환하여 저장
        m = Integer.parseInt(st.nextToken()); // 두 번째 토큰을 정수로 변환하여 저장

        map = new int[n][m];
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine()); // 한 줄씩 입력 받음
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); // 숫자를 하나씩 꺼내서 정수로 변환 후
            }
        }

        visited=new boolean[n][m];
        int cnt=0;
        int max=0;

        for (int i =0;i<n;i++) {
            for(int j =0;j<m;j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    max=Math.max(bfs(j,i),max); // Math.max()
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);


    }

    static int bfs(int start_x, int start_y) {
        Queue<int[]> q = new LinkedList<>(); // 큐 선언 방식
        q.add(new int[] {start_x,start_y});
        visited[start_y][start_x] = true;
        int size = 1;

        while(!q.isEmpty()) {
            int[] p= q.poll(); // front를 삭제 & 확인
            int x = p[0];
            int y = p[1];

            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx<0 || ny<0 || nx>m-1 || ny>n-1) continue;
                if(visited[ny][nx]) continue;
                if(map[ny][nx] == 1) {
                    size++;
                    visited[ny][nx] = true;
                    q.add(new int[] {nx, ny});
                }
            }
        }
        return size;

    }
}