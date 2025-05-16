package b15656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[], N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0 ; i < N ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        fn(0, "");

        System.out.println(sb.toString());

    }

    private static void fn(int cnt, String str){
        if(cnt == M) {
            sb.append(str).append("\n");
            return ;
        }

        for(int i = 0 ; i < N ; i++){
            fn(cnt + 1, str == "" ? arr[i] + "" : str + " " + arr[i]);
        }
    }
}
