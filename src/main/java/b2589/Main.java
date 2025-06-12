package b2589;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static String[] map = new String[51];
    static boolean[][] visited = new boolean[51][51];
    static int result;
    static int dir[][] = {
            {0,1}, {0,-1}, {1,0}, {-1,0}
    };

    static int N,M;
    public static void main(String[] args) throws Exception{
        init();
        solve();
        System.out.println(result);
    }

    private static void solve(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i].charAt(j) == 'W') continue;
                int r = find(i,j);
                result = max(result, r);
            }
        }
    }

    private static int find(int x, int y){
        int r = 0;
        initialize(visited);
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y,0});

        while (!queue.isEmpty()){
            int curr[] = queue.poll();
            r  = max(r, curr[2]);
            for(int d = 0; d < 4; d ++) {
                int dx = curr[0] + dir[d][0];
                int dy = curr[1] + dir[d][1];

                if(!inRange(dx, dy)) continue;
                if(visited[dx][dy]) continue;
                if(map[dx].charAt(dy) == 'W') continue;
                visited[dx][dy] = true;
                queue.add(new int[]{dx,dy,curr[2] + 1});
            }

        }

        return r;
    }


    private static void initialize(boolean[][] arr){
        for(int i = 0; i < arr.length; i++) Arrays.fill(arr[i], false);
    }
    private static int max(int a, int b){
        return a > b ? a : b;
    }


    private static boolean inRange(int x, int y){
        return x >= 0 && y >= 0 && x<  N && y < M;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N ; i++) map[i] = br.readLine();
    }
}
