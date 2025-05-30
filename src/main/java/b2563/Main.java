package b2563;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int arr[][] = new int[100][100];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for(int j = 0; j < 10; j++){
                for(int k = 0; k < 10; k++){
                    if(arr[a + j][b + k] == 0) {
                        arr[a + j][b + k] = 1;
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
