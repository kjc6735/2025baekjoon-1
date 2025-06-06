package b18866;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int arr[][] = new int[1_000_001][2], N;
    static int tmp[][] = new int[1_000_001][2];
    static int tmp1[][] = new int[1_000_001][2];

    static int result = -1 ;
    public static void main(String[] args) throws Exception {
        init();
        solve();
        System.out.println(result);
    }
    private static void solve() {
        tmp[0][0] = arr[0][0];
        if(tmp[0][0] == 0) tmp[0][0] = Integer.MAX_VALUE;
        tmp[N-1][1] = arr[N-1][0];
        if(tmp[N-1][1] == 0) tmp[N-1][1] = 1;

        tmp1[0][0] = arr[0][1];
        if(tmp1[0][0] == 0) tmp1[0][0] = 1;
        tmp1[N-1][1] = arr[N-1][1];
        if(tmp1[N-1][1] == 0) tmp1[N-1][1] = Integer.MAX_VALUE;

        // 0은 그냥 지금까지 나온 수 중 가장 큰 수 넣어 주기
        for(int i = 1; i < N ; i++){
            // 행복 누적 앞에서 최소값
            tmp[i][0] = arr[i][0] == 0 ? tmp[i-1][0] : min(arr[i][0], tmp[i-1][0]);
            //뒤에서 누적
            tmp[N-1-i][1] = arr[N-1-i][0] == 0 ? tmp[N-i][1] : max(arr[N-1-i][0], tmp[N-i][1]);

            //피로감 아ㅠ에서 누적
            tmp1[i][0] = arr[i][1] == 0 ? tmp1[i-1][0] : max(arr[i][1], tmp1[i-1][0]);
            //뒤에서 누적
            tmp1[N-1-i][1] = arr[N-1-i][1] == 0 ? tmp1[N-i][1] : min(arr[N-1-i][1], tmp1[N-i][1]);
        }
        for(int k = 0; k < N-1; k++){
            boolean r1 = tmp[k][0] >= tmp[k+1][1];
            boolean r2 = tmp1[k][0] <= tmp1[k+1][1];
            if(r1 && r2) result = k +1;
        }
    }

    private static int max(int a, int b){
        return a > b ? a : b;
    }
    private static int min(int a, int b){
        return a < b ? a : b;
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a; // 행복
            arr[i][1] = b; // 피로
        }
    }

}
