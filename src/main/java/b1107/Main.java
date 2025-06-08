package b1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, result;
    static List<Integer> numbers = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        init();
        solve();
        System.out.println(result);
    }
    private static void solve() {
        // 그냥 +또는 -만 눌러서 만드는 경우가 최대 값
        result = Math.abs(N - 100);

        for(int i = 0; i < 5_000_000 * 2; i++){
            
        }


    }

    private static int min (int a, int b){
        return a < b ? a : b;
    }

    private static void init() throws IOException{
        Set<Integer> deleted = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M  =Integer.parseInt(br.readLine());
        if(M != 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0;i < M; i++) deleted.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0 ; i < 10; i++) {
            if(deleted.contains(i)) continue;
            numbers.add(i);
        }
    }
}
