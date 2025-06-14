package b16234;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int result = 0,N,L,R, map[][] = new int[50][50];
    static int dir[][] = {
            {0,1}, {0,-1}, {1,0}, {-1,0}
    };
    static boolean visited[][] = new boolean[50][50];
    public static void main(String[] args) throws Exception {
        init();
        solve();
    }
    private static boolean inRange(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }
    private static void solve(){
        List<int[]> connList = new ArrayList<>();
        int isOK = 0;
        for(int cnt = 0 ; true ; cnt++){
            isOK = 0;
            initialize(visited);
            for(int i = 0; i < N ; i++){
                for(int k = 0; k < N; k++){
                    if(visited[i][k]) continue;
                    isOK++;
                    int sum = map[i][k];
                    Queue<int[]> queue = new LinkedList<>();
                    visited[i][k] = true;
                    queue.offer(new int[]{i,k});
                    connList.add(new int[]{i,k});
                    while(!queue.isEmpty()){
                        int curr[] = queue.poll();
                        for(int d = 0 ;d < 4; d ++){
                            int dx = curr[0] + dir[d][0];
                            int dy = curr[1] + dir[d][1];
                            if(!inRange(dx,dy)) continue;
                            if(visited[dx][dy]) continue;
                            int gap = Math.abs(map[curr[0]][curr[1]] - map[dx][dy]);
                            if(gap < L || R < gap) continue;
                            queue.add(new int[]{dx,dy});
                            connList.add(new int[]{dx,dy});
                            sum += map[dx][dy];
                            visited[dx][dy] = true;
                        }
                    }
                    int result = sum / connList.size();

                    for(int[] curr : connList) {
                        map[curr[0]][curr[1]] = result;
                    }
                    connList.clear();
                }
            }

            if(isOK == N*N) {
                System.out.println(cnt);
                return ;
            }

        }

    }

    private static void print(){

        for(int i = 0; i < N ; i++){
            for(int k = 0 ;k < N ; k++){
                System.out.print(map[i][k] + " ");
            }
            System.out.println();
        }
    }

    private static void initialize(boolean[][] arr){
        for(int i = 0; i < arr.length; i++) Arrays.fill(arr[i], false);
    }

    private static void init()throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L  = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0 ;k < N ; k++){
                map[i][k] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
