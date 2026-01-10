//  플로이드

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static final int INF=10_000_000;

    public static void main(String[] args) throws IOException {
        int N, M;
        int[][] Graph;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        Graph = new int[N+1][N+1];

        for(int i =1;i<=N;i++){
            for(int j =1;j<=N;j++){
                if (i == j) Graph[i][j] = 0;
                else Graph[i][j] = INF;
            }
        }

        for(int i = 1;i<M+1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(Graph[a][b]>c) Graph[a][b]=c;
        }

        // 3. 플로이드-워셜 알고리즘 수행
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (Graph[i][k] + Graph[k][j] < Graph[i][j]) {
                        Graph[i][j] = Graph[i][k] + Graph[k][j];
                    }
                }
            }
        }

        StringBuilder sb= new StringBuilder();
        for(int i = 1;i<N+1;i++){
            for(int j = 1;j<N+1;j++){
                if(Graph[i][j]==INF){
                    sb.append("0 ");
                }
                else{
                    sb.append(Graph[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);

    }
}