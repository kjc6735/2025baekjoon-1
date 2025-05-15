package b15654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static StringBuilder sb=new StringBuilder();
    static int arr[] = new int[10];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr, 0, N);

        fn(0,0,"");
        System.out.println(sb.toString());
    }

    private static void fn(int curr, int visited, String s) {
        if(curr == M){
            sb.append(s).append("\n");
            return ;
        }

        for(int i = 0; i < N ; i++){
            if((visited & (1 << i)) != 0) continue;
            fn(curr + 1, visited | (1 << i), s.isEmpty() ? arr[i] + "" : s + " " + arr[i]);
        }
    }
}
