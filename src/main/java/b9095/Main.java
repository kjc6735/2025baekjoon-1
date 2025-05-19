package b9095;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int dp[] = new int[12];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for(int i = 3; i < 11; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; tc++){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n-1]).append("\n");
        }

        System.out.print(sb.toString());
    }
}
