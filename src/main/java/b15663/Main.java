package b15663;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N,M,arr[];
    static StringBuilder sb = new StringBuilder();
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        fn(0,"", 0);
        System.out.println(sb.toString());
    }

    private static void fn(int cnt,String str, int visited) {
        if(cnt == M){
            if(set.contains(str)) return;
            set.add(str);
            sb.append(str).append("\n");
            return ;
        }

        for(int i = 0; i < N; i++){
            if((visited & (1 << i)) != 0) continue;
            fn(cnt + 1, str == "" ? arr[i] + "" : str + " " + arr[i], visited | (1 << i));
        }
    }
}
