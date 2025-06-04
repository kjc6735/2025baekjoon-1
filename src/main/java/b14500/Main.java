package b14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int arr[][] = new int[500][500], N,M, max = 0;
    static BufferedReader br;
    static int diagram[][][] = {
            {
                {1,1,1,1},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
            },
            {
                {1,0,0,0},
                {1,0,0,0},
                {1,0,0,0},
                {1,0,0,0},
            },
            {
                    {1,0,0,0},
                    {1,0,0,0},
                    {1,1,0,0},
                    {0,0,0,0},
            },
            {
                    {0,1,0,0},
                    {0,1,0,0},
                    {1,1,0,0},
                    {0,0,0,0},
            },
            {
                    {1,1,0,0},
                    {0,1,0,0},
                    {0,1,0,0},
                    {0,0,0,0},
            },
            {
                    {1,1,0,0},
                    {1,0,0,0},
                    {1,0,0,0},
                    {0,0,0,0},
            },
            {
                    {1,0,0,0},
                    {1,1,1,0},
                    {0,0,0,0},
                    {0,0,0,0},
            },
            {
                    {0,0,1,0},
                    {1,1,1,0},
                    {0,0,0,0},
                    {0,0,0,0},
            },
            {
                    {1,1,1,0},
                    {0,0,1,0},
                    {0,0,0,0},
                    {0,0,0,0},
            },
            {
                    {1,1,1,0},
                    {1,0,0,0},
                    {0,0,0,0},
                    {0,0,0,0},
            },
            {
                    {1,0,0,0},
                    {1,1,0,0},
                    {0,1,0,0},
                    {0,0,0,0},
            },
            {
                    {0,1,0,0},
                    {1,1,0,0},
                    {1,0,0,0},
                    {0,0,0,0},
            },
            {
                    {1,1,0,0},
                    {0,1,1,0},
                    {0,0,0,0},
                    {0,0,0,0},
            },
            {
                    {0,1,1,0},
                    {1,1,0,0},
                    {0,0,0,0},
                    {0,0,0,0},
            },
            {
                    {1,1,1,0},
                    {0,1,0,0},
                    {0,0,0,0},
                    {0,0,0,0},
            },
            {
                    {0,1,0,0},
                    {1,1,1,0},
                    {0,0,0,0},
                    {0,0,0,0},
            },
            {
                    {1,0,0,0},
                    {1,1,0,0},
                    {1,0,0,0},
                    {0,0,0,0},
            },
            {
                    {0,1,0,0},
                    {1,1,0,0},
                    {0,1,0,0},
                    {0,0,0,0},
            },
            {
                    {1,1,0,0},
                    {1,1,0,0},
                    {0,0,0,0},
                    {0,0,0,0},
            },

    };
    public static void main(String[] args)throws Exception {
        init();
        solve();
        System.out.println(max);
    }

    private static void solve() {
        for(int i = 0; i < N ; i++){
            for(int k = 0 ; k < M ; k++){
                for(int j = 0; j < diagram.length; j++){
                    int sum = 0;

                    for(int a = 0; a < 4 ; a++){
                        for(int b = 0; b < 4; b++){
                            int currX = i + a;
                            int currY = k + b;
                            if(!inRange(currX, currY))continue;
                            if(diagram[j][a][b] == 0) continue;
                            sum += arr[currX][currY];
                        }
                    }
                    if(sum > max) max = sum;
                }
            }
        }
    }
    static private boolean inRange(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < M;
    }
    static private void init()throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < M ; k++){
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
