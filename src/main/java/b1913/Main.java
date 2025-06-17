package b1913;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int arr[][] = new int[1000][1000],N, target, targetPos[];
    static StringBuilder result = new StringBuilder();
    static int dir[][] = {
            {1, 0}, {0, 1}, {-1,0}, {0,-1}
    };
    public static void main(String[] args) throws Exception {
        init();
        solve();
        System.out.println(result);
    }

    private static void solve(){
        int currNum = N*N ;
        arr[0][0] = currNum;
        int dirIndex = 0;
        int posX = 0;
        int posY = 0;
        while(true) {
            //현재 값 체크
            if(arr[posX][posY] == target){
                targetPos = new int[]{posX, posY};
            }

            if(currNum == 1) break;

            int x = posX + dir[dirIndex][0];
            int y = posY + dir[dirIndex][1];


            // 범위가 아니거나 숫자가 채워져 있는 곳이면 방향을 바꿈
            if(!inRange(x, y) || arr[x][y] != 0) {
                dirIndex = (dirIndex + 1) % 4;
                continue;
            }

            currNum--;
            posX = x;
            posY = y;
            arr[x][y] = currNum;
        }

        for(int i = 0; i < N ; i++){
            for(int k = 0; k < N ; k++){
                result.append(arr[i][k]).append(" ");
            }
            result.append("\n");
        }

        result.append((targetPos[0]+1) + " " + (targetPos[1]+1));

    }

    private static boolean inRange(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    private static void init()throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        target = Integer.parseInt(br.readLine());

    }
}
