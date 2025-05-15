package b15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N,M;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        fn(1, 1,"");

        System.out.println(sb.toString());
    }

    private static void fn(int curr,int prev, String s) {
        if(curr > M) {
            sb.append(s).append("\n");
            return ;
        }

        for(int i = prev; i <= N ; i++){
            fn(curr+ 1,i, s.isEmpty() ? i + "" : s + " "+i);
        }
    }
}
