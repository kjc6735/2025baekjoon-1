package b1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int dp[] = new int[N+1];

        for(int n = N; n > 1; n--){
            if(n%3 == 0) {
                dp[n/3] = dp[n/3] == 0 ? dp[n] + 1 : min(dp[n/3], dp[n] + 1);
            }
            if(n%2 == 0){
                dp[n/2] = dp[n/2] == 0 ? dp[n] + 1 : min(dp[n/2], dp[n] + 1);
            }
            dp[n-1] = dp[n-1] == 0 ? dp[n] + 1 : min(dp[n-1], dp[n] + 1);

        }
        System.out.println(dp[1]);
    }

    private static int min (int a, int b){
        return a < b ? a : b;
    }
}
