package b12100;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[][] = new int[20][20];
    static int dir[][] = {
            {0,1}, {0,-1}, {1,0}, {-1,0}
    };
    static int max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i =0; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < N; k++){
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        fn(arr, 0);
        System.out.println(max);

    }

    static private void fn(int arr[][], int cnt){
        if(cnt == 5){
            max = max(max, getMax(arr));

            return ;
        }
        int copy[][] = copy(arr);

        for(int d = 0 ; d < 4; d++){
            move(dir[d][0], dir[d][1]);
            fn(arr, cnt + 1);
            copy(copy,arr);
        }
    }
    static void copy(int[][] origin, int[][] target){
        for(int i = 0; i < origin.length; i++){
            for(int k = 0; k < origin[i].length; k++){
                target[i][k ] = origin[i][k];
            }
        }
    }

    static void print(int arr[][]){
        System.out.println("=================");
        for(int i = 0; i < N ;i++){
            for(int k = 0; k < N; k++){
                System.out.print(arr[i][k] + " ");
            }
            System.out.println("");
        }
    }
    static private int[][] copy(int arr[][]){
        int copy[][] = new int[arr.length][arr[0].length];
        for(int i = 0; i <arr.length; i++){
            for(int k =0 ; k < arr[i].length; k++){
                copy[i][k] = arr[i][k];
            }
        }
        return copy;
    }

    static private int getMax(int arr[][]){
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            for(int k = 0; k < arr[i].length; k++){
                max = max(arr[i][k], max);
            }
        }

        return max;
    }

    static private int max(int a, int b){
        return a > b ? a : b;
    }

    static private void move(int dirX, int dirY){
        Set<String> set = new HashSet<>();
        if(dirX == 1) { // 아래 쪽으로 합치기

            for(int k = 0; k < N; k++){
                for(int i = N -1; i >= 0; i --){
                    if(arr[i][k] == 0) continue;
                    int currPos = i;
                    int nextPos = i;
                    while (nextPos +1 < N && arr[nextPos + 1][k] == 0) nextPos++;
                    arr[nextPos][k] = arr[currPos][k];
                    if(nextPos != currPos){
                        arr[currPos][k] = 0;
                    }
                    if(nextPos +1 < N && arr[nextPos][k] == arr[nextPos+1][k] && !set.contains(nextPos+1 + " " + k)){
                        arr[nextPos+1][k] *=2;
                        arr[nextPos][k] = 0;
                        set.add(nextPos+1 + " " + k);
                    }
                }
            }

        }else if(dirX == -1){ // 위 쪽으로 합치기
            for(int k = 0; k < N; k++){
                for(int i = 0; i < N; i++){
                    if(arr[i][k] == 0) continue;
                    int currPos = i;
                    int nextPos = i;
                    while (nextPos -1  >= 0 && arr[nextPos- 1][k] == 0) nextPos--;

                    arr[nextPos][k] = arr[currPos][k];
                    if(nextPos != currPos){
                        arr[currPos][k] = 0;
                    }

                    if(nextPos-1 >= 0 && arr[nextPos][k] == arr[nextPos-1][k] && !set.contains(nextPos-1 + " " + k)){
                        arr[nextPos-1][k] *=2;
                        arr[nextPos][k] = 0;
                        set.add(nextPos-1 + " " + k);
                    }
                }
            }
        }else if(dirY == 1){  // 오른 쪽
            for(int i = 0; i < N; i++){
                for(int k = N-2; k >= 0; k--){
                    if(arr[i][k] == 0) continue;
                    int currPos = k;
                    int nextPos = k;
                    while (nextPos+1 < N  && arr[i][nextPos + 1] == 0) nextPos++;
                    arr[i][nextPos] = arr[i][currPos];
                    if(nextPos != currPos) {
                        arr[i][currPos] = 0;
                    }
                    if(nextPos +1 < N && arr[i][nextPos] == arr[i][nextPos+1] && !set.contains(i + " " + (nextPos+1))){
                        arr[i][nextPos+1] *=2;
                        arr[i][nextPos] = 0;
                        set.add(i + " " + (nextPos + 1));
                    }
                }
            }
        }else if(dirY == -1){ // 왼쪽
            for(int i = 0; i < N; i++){
                for(int k = 1; k < N; k++){
                    if(arr[i][k] == 0) continue;
                    int currPos = k;
                    int nextPos = k;
                    while (nextPos -1  >= 0 && arr[i][nextPos- 1] == 0) nextPos--;
                    arr[i][nextPos] = arr[i][currPos];

                    if(nextPos != currPos) {
                        arr[i][currPos] = 0;
                    }
                    if(nextPos-1 >= 0 && arr[i][nextPos] == arr[i][nextPos-1] && !set.contains(i + " " + (nextPos-1))){
                        arr[i][nextPos-1] *=2;
                        arr[i][nextPos] = 0;
                        set.add(i + " " + (nextPos-1));
                    }
                }
            }
        }
    }
}
