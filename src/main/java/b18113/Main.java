package b18113;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, L;
    static int arr[] = new int[1_000_000];
    static int max = 0;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int index = 0;

        for(int i = 0; i < N; i++){
            int tmp = Integer.parseInt(br.readLine());

            if(tmp > 2 * K) {
                arr[index] = tmp - 2 * K;
                if(arr[index] > max) max = arr[index];
                index++;
            } else if(tmp > K && tmp < 2 * K) {
                arr[index] = tmp - K;
                if(arr[index] > max) max = arr[index];
                index++;
            }
        }

       L = index;

        int result = fn();
        System.out.println(result);
    }


    static int fn(){
        if(L == 0) return -1;

        int bottom = 1;
        int top = max;
        int result = -1;

        while(bottom <= top){
            int mid = bottom + (top - bottom)/2;
            long sum = 0;
            for(int i = 0; i < L; i++){
                sum += (arr[i] / mid);
            }
            if(sum >= M){
                result = mid;
                bottom = mid + 1;
            }else {
                top = mid - 1;
            }
        }

        return result;
    }
}
