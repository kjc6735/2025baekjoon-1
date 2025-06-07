package b14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int dir[][] = {
            {-1,0}, {0,1}, {1,0}, {0,-1}
    };
    static int N,M, map[][] = new int[50][50];
    static int startX, startY, currDir, cnt = 0;
    public static void main(String[] args) throws Exception {
        init();
        solve();
        System.out.println(cnt);
    }
    private static void solve(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        while (!queue.isEmpty()){
            int curr[] = queue.poll();
            //현재 칸이 청소되지 않은 경우, 현재 칸을 청소한다.
            if(map[curr[0]][curr[1]] == 0){
                map[curr[0]][curr[1]] = 2;
                cnt ++;
            }

            boolean checkDirty = true;
            for(int d = 0 ;d < 4; d++){
                int dx = curr[0] + dir[d][0];
                int dy = curr[1] + dir[d][1];
                if(!inRange(dx,dy)) continue;
                if(map[dx][dy] == 1) continue; // 벽이면 지나감
                if(map[dx][dy] == 2) continue; // 청소된거면 지나감
                checkDirty = false;
                break;
            }
            //주변에 4칸 중 청소가 된 경우에(?)
            if(checkDirty){
                // 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                int backDir[] = new int[]{dir[currDir][0] * -1, dir[currDir][1] * -1};
                int backPosition[] = new int[]{curr[0] + backDir[0], curr[1] + backDir[1]};
                // 뒤쪽 칸이 벽이라 후진할 수 없다면 동작을 멈춤
                if(!inRange(backPosition[0], backPosition[1]) || map[backPosition[0]][backPosition[1]] == 1) return ;
                // 한칸 후진하고 1번으로 돌아감.
                queue.add(new int[]{backPosition[0], backPosition[1]});
            }else {
                // 반시계 90도 회전
                currDir-=1;
                if(currDir == -1) currDir = 3;

                // 바라보는 방향 기준으로 앞쪽 칸 청소 확인
                int frontPosition[] = new int[]{curr[0] + dir[currDir][0], curr[1] + dir[currDir][1]};
                // 범위 확인 후 청소 확인
                if(inRange(frontPosition[0], frontPosition[1]) && map[frontPosition[0]][frontPosition[1]] == 0) {
                    queue.add(new int[]{frontPosition[0], frontPosition[1]});
                }else {
                    queue.add(new int[]{curr[0], curr[1]});

                }
            }
        }
    }

    private static boolean inRange(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        currDir = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < M; k++){
                map[i][k] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
