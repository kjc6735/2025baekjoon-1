package b2636;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int arr[][] = new int[1010][1010];
    static int cnt[] = new int[1001];
    static boolean visited[][] = new boolean[1010][1010];
    static int N,M;
    static int dir[][] = {
            {0,1}, {0,-1}, {1,0}, {-1,0}
    };
    public static void main(String[] args) throws Exception{
        init();
        solve();

    }

    private static void solve(){
        for(int c = 1 ;  true ; c ++){
            cnt[c] = cnt[c-1];
            List<int[]> meltPos = new ArrayList<int[]>();
            find();
            for(int i = 0; i < N ; i++){
                for(int k = 0; k < M ; k++){
                    if(arr[i][k] == 0) continue;

                    int meltCnt = 0;
                    for(int d = 0; d < dir.length; d++){
                        int x = i + dir[d][0];
                        int y = k + dir[d][1];

                        if(!inRange(x,y)) continue;
                        if(!visited[x][y]) continue;
                        meltCnt++;
                        meltPos.add(new int[]{i,k});
                        break;
                    }
                    if(meltCnt != 0){
                        cnt[c]--;
                    }
                }
            }
            for(int[] pos : meltPos){
                arr[pos[0]][pos[1]] = 0;
            }

            if(cnt[c] == 0) {
                System.out.println(c);
                System.out.println(cnt[c-1]);
                return ;
            }
        }

    }

    private static void find(){
        Queue<int[]> queue = new LinkedList<int[]>();
        for(int i = 0; i < N ; i++) Arrays.fill(visited[i],false);
        queue.add(new int[]{0,0});
        visited[0][0] = true;

        while (!queue.isEmpty()){
            int curr[] = queue.poll();

            for(int d = 0; d < dir.length; d++){
                int x = curr[0] + dir[d][0];
                int y = curr[1] + dir[d][1];

                if(!inRange(x,y)) continue;
                if(visited[x][y]) continue;
                if(arr[x][y] == 0) {
                    visited[x][y] = true;
                    queue.add(new int[]{x,y});
                }
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    private static void init()throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < M ; k++){
                arr[i][k] = Integer.parseInt(st.nextToken());
                if(arr[i][k] == 1) {
                    cnt[0] ++;
                }
            }
        }
    }

    private static void print(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N ; i++){
            for(int k = 0; k < M ; k++){
                sb.append(arr[i][k] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
