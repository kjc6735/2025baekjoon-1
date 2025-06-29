package b14890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int arr[][] = new int[100][100];
    static int N, L;
    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    private static void solve(){
        int cnt = 0 ;
        for(int i = 0; i < N ; i++){
            boolean check = true;
            for(int k = 0; k < N - L; k++){


            }
            // k 나머지 처리하기

            if(check) {
                cnt +=1;
            }
        }

        System.out.println(cnt);
    }

    private static boolean inRange(int x){
        return x >= 0 && x < N ;
    }
    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k  < N ; k++){
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
