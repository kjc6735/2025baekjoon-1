package b1034;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M,K;
    static long[] map = new long[50];
    static int result = 0;

    public static void main(String[] args) throws Exception {
        init();
        solve();
        System.out.println(result);
    }

    private static void solve(){
        for(int i = 0; i < N; i++) {
            int bitCnt = M - Long.bitCount(map[i]);
            if(bitCnt > K || (K-bitCnt)%2 != 0) continue;

            int cnt = 0;

            for(int k = 0; k < N ; k++) if(map[i] == map[k]) cnt ++;

            if(result < cnt) result = cnt;
        }
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int k = 0; k < M; k++){
                if(str.charAt(k) == '0') continue;
                map[i] |= (1L << k);
            }
        }
        K = Integer.parseInt(br.readLine());
    }
}
