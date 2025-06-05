package b1916;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int start, dest;
    static List<int[]>[] list = new ArrayList[1_001];
    static int distance[] = new int[1_001];
    static int result;
    static {
        for(int i = 0; i < 1_001; i++){
            list[i] = new ArrayList<>();
        }
    }
    public static void main(String[] args) throws Exception{
        init();
        solve();
        System.out.println(result);
    }

    private static void solve(){
        result = dijkstra(start, dest);
    }
    private static int dijkstra(int s, int d) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        boolean[] visited = new boolean[N+1];
        for(int i = 1; i <= N; i++) distance[i] = Integer.MAX_VALUE;
        distance[s] = 0;
        pq.add(new int[]{0, s});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[1];
            if(u == d) return curr[0];
            if(visited[u]) continue;

            visited[u] = true;
            for(int[] next : list[u]){
                if(distance[next[0]] > distance[u] + next[1]){
                    distance[next[0]] = distance[u] + next[1];
                    pq.add(new int[]{distance[next[0]], next[0]});
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        for(int i = 0; i < E; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[start].add(new int[]{dest, cost});
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());
    }
}
