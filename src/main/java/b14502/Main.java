package b14502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M, arr[][] = new int[10][10];
    static BufferedReader br;
    static int result = 0;
    static boolean visited[][] = new boolean[10][10];
    static int dir[][] = {
            {0,1}, {0,-1}, {1,0}, {-1,0}
    };
    public static void main(String[] args) throws Exception{
        init();
        fn(0,0,0);
        System.out.println(result);
    }
    private static void print(){
        System.out.println("======");
        for(int i = 0; i < N; i++){
            for(int k = 0; k < M; k++){
                System.out.print(arr[i][k] + " ");
            }
            System.out.println();
        }
    }

    private static void fn(int x, int y, int cnt){
        if(cnt == 3){
            int find = find();
            if(find > result) result = find;
            return ;
        }
        if(!inRange(x,y)) return ;

        for(int i = x; i < N; i++){
            int startY = (i == x) ? y : 0;

            for(int k = startY; k < M ; k++){
                if(arr[i][k] != 0) continue;
                arr[i][k] = 1;
                int[] next = next(i,k);
                fn(next[0],next[1],cnt+1);
                arr[i][k] = 0;
            }
        }
    }
    private static int[] next(int x, int y){
        if(y < M-1) {
            return new int[]{x, y + 1};
        }
        return new int[]{x + 1, 0};
    }

    private static int find(){
        int cnt = 0;
        initialize(visited);
        for(int i = 0; i<  N; i++){
            for(int k = 0; k < M ; k++){
                if(visited[i][k]) continue;
                if(arr[i][k] != 2) continue;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i,k});
                visited[i][k]  = true;
                while(!queue.isEmpty()){
                    int curr[] = queue.poll();

                    for(int d = 0; d< 4; d++){
                        int dx = curr[0] + dir[d][0];
                        int dy = curr[1] + dir[d][1];
                        if(!inRange(dx,dy)) continue;
                        if(visited[dx][dy]) continue;
                        if(arr[dx][dy] != 0) continue;
                        visited[dx][dy]  =true;
                        queue.add(new int[]{dx,dy});
                    }
                }
            }
        }
        for(int i = 0; i < N; i++){
            for(int k = 0; k < M; k++){
                if(arr[i][k] == 0 && !visited[i][k]) cnt++;
            }
        }

        return cnt;
    }
    private static void initialize(boolean[][] visited){
        for(int i = 0; i < N; i++) Arrays.fill(visited[i], false);
    }

    private static boolean inRange(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    private static void init() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < M; k++){
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
