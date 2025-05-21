package b2606;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) + 1;
        int M = Integer.parseInt(br.readLine());
        boolean visited[] = new boolean[N];
        ArrayList<Integer>[] arr = new ArrayList[N];
        for(int i = 0; i < N ; i++) arr[i] = new ArrayList<>();
        for(int i =0; i < M ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        int cnt = 0;
        visited[1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int next: arr[curr]){

                if(visited[next]) continue;
                visited[next] = true;
                cnt ++;
                queue.add(next);
            }
        }

        System.out.println(cnt);

    }
}
