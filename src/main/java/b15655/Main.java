package b15655;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M, arr[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        fn( 0,0, "");



        System.out.println(sb.toString());
    }
    private static void fn(int prev, int cnt, String str) {
        if(cnt == M) {
            sb.append(str).append("\n");
            return ;
        }

        for(int i = prev; i < N ; i++){
            fn(  i + 1, cnt + 1,str == "" ? arr[i] + "" : str +" "+ arr[i]);
        }
    }

}
