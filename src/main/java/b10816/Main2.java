package b10816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main2 {
    static int N,M;
    static int arr[] = new int[500_000];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < N ; i++ ) {
            int tmp =  Integer.parseInt(st.nextToken());
            arr[i] = tmp;
        }
        Arrays.sort(arr, 0, N);
        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M ; i++){
            int  curr = Integer.parseInt(st.nextToken());
            int firstIndex = lowerBound(curr);
            int lastIndex = upperBound(curr);
            if(firstIndex == N || arr[firstIndex] != curr) {
                sb.append(0).append(" ");
            }else {
                sb.append(lastIndex - firstIndex).append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    private static int lowerBound(int target){
        int left = 0;
        int right = N;
        while(left < right){
            int mid = (left + right) / 2;

            if(arr[mid] < target) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return left;
    }

    private static int upperBound(int target){
        int left = 0;
        int right = N;
        while(left < right){
            int mid = (left + right) / 2;

            if(arr[mid] <= target) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return left;
    }
}
