package b31848;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int holes[] = new int[1_000_000];
    static int N;
    static int qCnt;
    static int qList[] = new int[1_000_000];

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    private static void solve(){
        HashMap<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < qCnt; i++){
            int r = map.getOrDefault(qList[i], -1);

            if(r == -1) {
                int calc = lowerBound(qList[i]);
                map.put(qList[i], calc);
                r = calc;
            }

            sb.append(r + 1).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static int lowerBound(int target){
        int bottom = 0;
        int top = N;

        while(bottom < top){
            int mid = (bottom + top) / 2;

            if(holes[mid] < target){
                bottom = mid + 1;
            }else {
                top = mid;
            }
        }

        return bottom;
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++){
            int tmp  = Integer.parseInt(st.nextToken()) + i;
            if(i == 0) {
                holes[i] = tmp;
                continue;
            }
            if(tmp <= holes[i-1]) holes[i] = holes[i-1];
            else holes[i] = tmp;
        }

        qCnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < qCnt ; i++){
            qList[i] = Integer.parseInt(st.nextToken());
        }
    }
}

// 1. dp??? -> 해당 위치에서 가장 크게 들어갈 값 ???
