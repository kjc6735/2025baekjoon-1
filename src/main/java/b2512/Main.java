package b2512;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int maxV = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i< N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > maxV) maxV = arr[i];
        }
        long M = Long.parseLong(br.readLine());

        int result = 0 ;

        int bottom = 0;
        int top = maxV;
        while(bottom <= top){
            int mid = bottom + (top - bottom)/2;
            long sum = 0;
            for(int i = 0; i < N ; i++){
                if(arr[i] <= mid) {
                    sum += arr[i];
                }else {
                    sum += mid;
                }
            }

            if(sum <= M){
                result = mid;
                bottom = mid + 1;
            }else {
                top = mid - 1;
            }
        }

        System.out.println(result);
    }
}
