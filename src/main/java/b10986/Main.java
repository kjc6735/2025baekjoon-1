package b10986;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr = new int[1_000_000];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] sum = new long[N];
        long[] c = new long[M];

        st = new StringTokenizer(br.readLine());
        long answer = 0;
        sum[0] = Integer.parseInt(st.nextToken());
        for(int i = 1; i < N; i++){
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i = 0;i < N ; i++){
            int remainder = (int) (sum[i] % M);
            if(remainder == 0) answer ++;
            c[remainder]++;
        }

        for(int i = 0; i < M ; i++){
            if(c[i] > 1) {
                answer = answer + (c[i] * (c[i] - 1) / 2);
            }
        }
        System.out.println(answer);
    }
}
