package b15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        fn(0, "", 0);

        System.out.println(sb.toString());
    }

    private static void fn(int curr, String s, int prev) {
        if(curr == M){
            sb.append(s).append("\n");
            return ;
        }

        for (int i = prev + 1; i <= N; i++) {
            fn(curr+1, s == "" ? i + "" : s + " " + i, i);
        }
    }
}
