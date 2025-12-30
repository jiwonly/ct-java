//  바이러스

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

    static int N,E;           // N은 노드의 수, E는 엣지(간선)의 수
    static int[][] Graph;     // 그래프를 표현할 2D 배열
    static boolean[] Visited; // 각 노드의 방문 여부를 저장할 배열
    static int count;

    static void dfs(int node){
        Visited[node]=true;
        count++;

        for(int next = 1; next<=N; ++next){
            if(!Visited[next] && Graph[node][next] == 1) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N과 E는 다른 줄에 있음
        N = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        Graph = new int[N+1][N+1];
        Visited = new boolean[N+1];

        count=0;

        for(int i = 0; i<E; ++i){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            Graph[u][v] = Graph[v][u] = 1;
        }

        dfs(1);

        System.out.println(count-1);
    }
}