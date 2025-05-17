package b2230;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int arr[] = new int [100_000];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N ; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr, 0, N);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < N ; i++){
            int target = M + arr[i];
            int result = lowerBound(target);
            if(result == i) result += 1;
            if(result >= N) continue;
            int sub = Math.abs(arr[result] - arr[i]);
            if(sub >= M && min > sub) min = sub;
        }
        System.out.println(min);
    }

    private static int lowerBound(int target){
        int left = 0;
        int right = N;

        while(left < right){
            int mid = (left + right) / 2;

            if(arr[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }

        }
        return left;
    }
}

