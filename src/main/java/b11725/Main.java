package b11725;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] list = new ArrayList[100_001];
    static StringBuilder sb = new StringBuilder();
    static int result[] = new int[100_001];
    static {
        for(int i = 0; i < list.length; i++) list[i] = new ArrayList<>();
    }
    public static void main(String[] args) throws Exception {
        init();
        solve();
        System.out.println(sb.toString());
    }

    private static void solve(){
        result[1] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while(!queue.isEmpty()){
            int curr = queue.poll();

            for(int next : list[curr]){
                if(result[next] != 0) continue;
                result[next] = curr;
                queue.add(next);
            }
        }
        for(int i = 2; i <= N; i++){
            sb.append(result[i]).append("\n");
        }
    }

    private static void init()throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N-1 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
    }
}
