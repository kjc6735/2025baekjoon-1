package b2775;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        int arr[][] = new int[16][16];
        StringBuilder sb = new StringBuilder();
        makeArray(arr);
        for(int tc = 0 ;tc < TC; tc ++){
            int n = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());
            sb.append(arr[n][k]).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void makeArray(int arr[][]){
        for(int i = 0; i < 16; i++) {
            arr[0][i] = i;
        }
        for(int i = 1; i < 16 ; i++){
            for(int k = 1; k < 16; k++){
                arr[i][k] = arr[i-1][k] + arr[i][k-1];
            }
        }
    }
}
