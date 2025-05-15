package b15649;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        fn(0, 0, "");

        System.out.println(sb.toString());

    }
    private static void fn(int n, int visited, String str) {
        if(n == M) {
            sb.append(str).append("\n");
            return ;
        }
        for(int i = 1; i <= N; i++){
            if((visited & (1 << i)) != 0) continue;
            fn(n+1, visited | (1 << i), str == "" ? (i + "") : str + " " + i);

        }
    }
}
