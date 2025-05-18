package b1926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int dir [][] = {
            {0,1}, {0,-1}, {1,0},{-1,0}
    };
    static int N,M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int arr[][] = new int [N][M];
        for(int i = 0; i <N; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < M ; k++){
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        int maxCnt = 0;
        int cnt = 0;
        for(int i = 0; i < N ; i++){
            for(int k = 0; k < M; k++){
                if(arr[i][k] == 0) continue;
                cnt +=1;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i,k});
                arr[i][k] = 0;
                int currCnt = 1;
                while (!queue.isEmpty()){
                    int[] curr = queue.poll();

                    for(int d = 0 ; d < 4; d++) {
                        int x = curr[0] + dir[d][0];
                        int y = curr[1] + dir[d][1];
                        if(!inRange(x,y)) continue;
                        if(arr[x][y] == 0) continue;
                        arr[x][y] = 0;
                        queue.add(new int[]{x,y});
                        currCnt ++;
                    }
                }

                if(currCnt > maxCnt) maxCnt = currCnt;
            }
        }
        System.out.println(cnt);
        System.out.println(maxCnt);

    }
    private static boolean inRange(int x, int y){
        return x < N && x >= 0 && y < M && y>=0;
    }
}
