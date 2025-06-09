package b15683;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int map[][] = new int[8][8], result = Integer.MAX_VALUE, N, M;
    static int dir[][][][] = {
            {},
            {
                { {0,1} }, { {1,0} }, { {-1,0} } , { {0,-1} }
            },
            {
                    {
                            {0,1},{0,-1}
                    },
                    {
                            {1,0},{-1,0}
                    }
            },
            {
                {
                        {0,1}, {-1,0} // 오 위 ㄴ
                },
                {
                        {0,-1}, {-1,0} // 왼 위
                },
                {
                        {0,-1}, {1,0} // 왼 아
                },
                {
                        {0,1}, {1,0} // 우 아
                }
            }, {
            {
                    {0,1}, {-1,0}, {0, -1} // 오 위 왼 ㅗ
            },
            {
                    {0,-1}, {-1,0}, {1, 0} // 왼 위 아 ㅓ
            },
            {
                    {0,-1}, {1,0}, {0,1} // 왼 아 우 ㅜ
            },
            {
                    {0,1}, {1,0}, {-1, 0} // ㅏ
            }
    },{{
            {0,1},{0,-1},{1,0},{-1,0}
    }}
    };
    static List<int[]> cctvPos = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        init();
        solve();
        System.out.println(result);
    }

    private static void solve(){
        fn(0);
    }
    private static void fn(int index){
        if(index == cctvPos.size()){
            result = Math.min(result, find(map));
            return ;
        }

        int currPos[] = cctvPos.get(index);
        int x = currPos[0];
        int y = currPos[1];

        int dirIndex = map[x][y] / 1000;

        int[][][] currDir = dir[dirIndex];

        // 각 시행 횟수
        for(int test_cnt = 0 ; test_cnt < currDir.length; test_cnt++){
            // 설치해보기
            for(int a = 0 ; a < currDir[test_cnt].length; a++){
                install(map, currPos, currDir[test_cnt][a], 1);
            }
            fn(index + 1);
            for(int a = 0 ; a < currDir[test_cnt].length; a++){
                install(map, currPos, currDir[test_cnt][a], -1);
            }
        }

    }

    private static void install(int map[][],int pos[], int dir[], int value){
        int currX = pos[0] ;
        int currY = pos[1] ;
        // 다음 곳이 범위 안에 있고, 블록이 아니면 +=1
        while (inRange(currX + dir[0], currY + dir[1]) && map[currX + dir[0]][currY + dir[1]]/1000 != 6 ){
            currX += dir[0];
            currY += dir[1];
            map[currX][currY]+= value;
        }
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=  0; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < M; k++){
                map[i][k] = Integer.parseInt(st.nextToken()) * 1000;
                if(map[i][k] != 0 && map[i][k] != 6000){
                    cctvPos.add(new int[]{i,k});
                }
            }
        }
    }

    private static boolean inRange(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    private static int find(int arr[][]){
        int cnt = 0;
        for(int i=  0; i < N ; i++){
            for(int k = 0; k < M; k++){
                if(map[i][k] == 0) cnt ++;
            }
        }

        return cnt;
    }
}
