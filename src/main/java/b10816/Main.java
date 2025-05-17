package b10816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for(int i = 0; i < N ; i++ ) {
            int tmp =  Integer.parseInt(st.nextToken());
            if(map.get(tmp) == null){
                map.put(tmp, 1);
            }else map.put(tmp, map.get(tmp) + 1);
        }

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M ; i++){
            int  curr = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(curr, 0)).append(" ");
        }
        System.out.println(sb.toString());

    }
}
