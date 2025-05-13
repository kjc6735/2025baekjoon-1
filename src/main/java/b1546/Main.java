package b1546;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        int max = 0;
        for(int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            result += tmp;
            if(max < tmp) {
                max = tmp;
            }
        }
        System.out.println((float)result*100/max/N);
    }
}
