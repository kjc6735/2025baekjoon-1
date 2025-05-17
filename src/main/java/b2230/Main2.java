package b2230;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
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

        int start = 0;
        int end = 0;
        while(start < N && end < N){
            int diff = arr[end] - arr[start];

            if(diff >= M){
                min = diff < min ? diff : min;
                start ++;
            }else end ++;
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

