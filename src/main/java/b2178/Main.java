package b2178;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static String[] str = new String[101];
    static int N,M, result;
    static boolean visited[][] = new boolean[101][101];
    static int dir[][] = {
            {0,1}, {1,0}, {-1,0},{0,-1}
    };
    public static void main(String[] args) throws Exception{
        init();
        solve();
        System.out.println(result);
    }

    private static void solve(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int curr[] = queue.poll();

            for(int d = 0; d < 4; d++){
                int x = curr[0] + dir[d][0];
                int y = curr[1] + dir[d][1];
                if(!inRange(x,y)) continue;
                if(visited[x][y]) continue;
                if(str[x].charAt(y) == '0') continue;
                if(x == N-1 && y == M-1) {
                    result = curr[2] + 1;
                    return ;
                }
                visited[x][y] = true;
                queue.add(new int[]{x,y,curr[2] + 1});
            }
        }
    }

    private static boolean inRange(int x, int y){
        return x>= 0 && y>=0 && x < N && y < M;
    }

    private static void init()throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N ; i++) str[i] =  br.readLine();
    }
}
