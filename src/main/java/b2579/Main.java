package b2579;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[301];
        int score[] = new int[301];

        for(int i = 1; i <= N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        score[1] = arr[1];
        score[2] = arr[1] + arr[2];
        score[3] = Math.max(arr[1] + arr[3] , arr[2] + arr[3]);

        for(int i = 4; i <= N; i++){
            int max1 = score[i-2] + arr[i];
            int max2 = score[i-3] + arr[i-1] + arr[i];
            score[i] = Math.max(max1, max2);
        }
        System.out.println(score[N]);
    }
}
