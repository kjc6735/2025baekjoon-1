package b2798;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());
        int max = 0;
        for(int i = 0; i < N-2; i++){
            for(int k = i+1; k < N-1; k++){
                for(int j = k+1; j < N; j++){
                    int sum = arr[i] + arr[k] + arr[j];
                    if(sum > M) continue;
                    if(max < sum) max = sum;
                }
            }
        }
        System.out.println(max);


    }
}
