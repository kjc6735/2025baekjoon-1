package b1920;
import java.io.*;
import java.util.*;
public class Main2 {
    static int arr[] = new int[100_000];
    static int N, M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr,0, N);
        for(int i = 0; i < M ;i++){
            int curr = Integer.parseInt(st.nextToken());

            int result = lowbound(curr);
            if(result != N && arr[result] == curr) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        System.out.println(sb.toString());

    }

    private static int lowbound(int target){
        int right = N;
        int left = 0;

        while(left < right){
            int mid = (left + right)/2;

            if(arr[mid] < target){
                left = mid + 1;
            }else {
                right = mid ;
            }

        }

        return left;
    }
}
