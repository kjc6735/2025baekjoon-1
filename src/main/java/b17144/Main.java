package b17144;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R,C,T, arr[][] = new int[51][51];
    static int airCleaner[] = new int[2];
    static int tmpArr[][] = new int[51][51];
    static Queue<int[]> dustPos = new LinkedList<>();
    static int dir[][] = {
            {0,1}, {1,0},{-1,0},{0,-1}
    };
    static int airCleanerDir[][][] = { // 위쪽기준
            {
                {-1,0}, {0,1}, {1,0}, {0, -1}
            },{
                {1,0}, {0,1}, {-1,0}, {0, -1}
            }
    };

    public static void main(String[] args) throws Exception{
        init();
        solve();
        System.out.println(getDustCnt());
    }
    private static void print(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < R; i++){
            for(int k = 0; k < C; k++){
                sb.append(arr[i][k]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    private static void solve(){
        for(int t = 0; t < T; t++){
            // 먼지 확산
            for(int i = 0; i <R; i++) Arrays.fill(tmpArr[i],0);
            for(int i = 0; i < R; i ++){
                for(int k = 0; k < C; k++){
                    if(arr[i][k] <= 0) continue;
                    int cnt = 0; // 확산 횟수 변수
                    for(int d = 0; d < 4 ; d ++){ // 1-1
                        int x = i + dir[d][0];
                        int y = k + dir[d][1];
                        if(!inRange(x,y)) continue; // 1-2 방향으로 확산 일어나지 않음
                        if(arr[x][y] == -1) continue; // 1-2 공기청정기 확산X
                        cnt ++; // 확산횟수 +1
                        // tmpArr 나중에 한꺼번에 반영해주기 위해 임시 변수 사용
                        tmpArr[x][y] += arr[i][k] / 5; // 1-3 확산되는 양
                    }
                    //현재 남은 양은 계산
                    arr[i][k] = arr[i][k] - (arr[i][k]/5)*cnt;


                }
            }
            //반영하기
            for(int i = 0; i < R; i++){
                for(int k = 0; k < C; k++){
                    arr[i][k] +=  tmpArr[i][k];
                }
            }

            // 바람 위쪽
            move(0);
            move(1);
        }
    }
    private static int getDustCnt(){
        int cnt = 0;
        for(int i = 0; i < R; i++){
            for(int k = 0; k < C; k++){
                cnt += arr[i][k];
            }
        }
        return cnt + 2; /// 공기청정기 제외
    }
    private static void move(int airCleanerPosIndex){
        int currPos[] = new int[]{airCleaner[airCleanerPosIndex],0};
        int currDir = 0;
        while(true){

            int x = currPos[0] + airCleanerDir[airCleanerPosIndex][currDir][0];
            int y = currPos[1] + airCleanerDir[airCleanerPosIndex][currDir][1];
            if(!inRange(x,y) || (airCleanerPosIndex == 0 && airCleaner[airCleanerPosIndex] < x) || (airCleanerPosIndex == 1 && airCleaner[airCleanerPosIndex] > x)){
                currDir++;
                if(currDir == 4) break;
                continue;
            }
            if(arr[x][y] == -1) break;
            // 내 위치가 -1 인 경우에 다음위치는 0으로 해줌
            if(arr[currPos[0]][currPos[1]] != -1){
                arr[currPos[0]][currPos[1]] = arr[x][y];
            }

            arr[x][y] = 0;
            currPos[0] = x;
            currPos[1] = y;
        }
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < C; k++){
                arr[i][k] = Integer.parseInt(st.nextToken());
                if(arr[i][k] == -1){
                    if(airCleaner[0] == 0){
                        airCleaner[0] = i;
                    }else {
                        airCleaner[1] = i;
                    }
                }
            }
        }
    }

    private static boolean inRange(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
