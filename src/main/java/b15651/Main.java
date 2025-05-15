package b15651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fn(0, "");
        System.out.println(sb.toString());
    }

    private static void fn(int curr, String str){
        if(curr == M) {
            sb.append(str).append("\n");
            return ;
        }
        for(int i = 1 ; i <= N ; i++){
            fn(curr + 1, str == "" ? i + "" : str + " " + i);
        }
    }
}
