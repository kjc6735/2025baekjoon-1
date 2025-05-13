package b11660;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int arr[][] = new int[1025][1025];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 1; k <= N; k++){
                int curr = Integer.parseInt(st.nextToken());
                arr[i][k] = arr[i-1][k] + arr[i][k-1] - arr[i-1][k-1] + curr;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) -1;
            int y1 = Integer.parseInt(st.nextToken()) -1;
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int result = arr[x2][y2] - arr[x1][y2] - arr[x2][y1]  + arr[x1][y1];
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }
}
