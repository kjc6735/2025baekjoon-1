package b1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static boolean[] visited = new boolean[1_001];
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] arr = new ArrayList[1_001];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());M= Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        for(int i = 0; i <= N ; i++) arr[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        for(int i = 1; i <= N; i++) {
            Collections.sort(arr[i]);
        }
        dfs(start);
        Arrays.fill(visited, false);
        sb.append("\n");
        bfs(start);
        System.out.println(sb.toString());

    }

    static private void dfs(int idx){
        sb.append(idx).append(" ");
        visited[idx] = true;
        for(int i : arr[idx]){
            if(visited[i]) continue;
            dfs(i);
        }
    }
    static private void bfs(int idx){
        visited[idx] = true;
        sb.append(idx).append(" ");
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int i : arr[curr]){
                if(visited[i]) continue;
                visited[i] = true;
                sb.append(i).append(" ");
                queue.add(i);
            }
        }

    }
}
