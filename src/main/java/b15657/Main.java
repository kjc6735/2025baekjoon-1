package b15657;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M, arr[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0;  i < N ; i++) arr[i ] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        fn(0, 0, "");

        System.out.println(sb.toString());
    }

    private static void fn(int depth, int cnt, String str){
        if(cnt == M){
            sb.append(str).append("\n");
            return ;
        }

        for(int i = depth; i < N; i++){
            fn(i, cnt + 1, str == "" ? arr[i] +"" : str + " " + arr[i]);
        }
    }

}
