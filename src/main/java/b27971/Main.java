package b27971;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N,M,A,B;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        HashSet<Integer> set = new HashSet<>();
        int result[] = new int[N+1];

        for(int i= 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for(int k= start; k <= end; k++){
                set.add(k);
            }
        }

        for(int i = 0; i <= N ; i++){
            if(set.contains(i)) continue;
            //
            if(i != 0 && result[i] == 0) continue;
            // 범위 안에 있고
            if(i + A <= N && !set.contains(i + A)){
                result[i + A] = min(result[i] + 1, result[i + A] == 0 ? result[i] + 1 : result[i + A]);
            }

            if(i + B <= N && !set.contains(i + B)){
                result[i + B] = min(result[i] + 1, result[i + B] == 0 ? result[i] + 1 : result[i + B]);
            }

        }
        System.out.println(result[N] == 0 ? -1 : result[N]);
    }

    private static int min(int a, int b){
        return a < b ? a : b;
    }
}
