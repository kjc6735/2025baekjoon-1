package b2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int a = 1;
        int b = 1;
        int sum = 0;
        int cnt = 0;
        while (b <= N){
            if(a == b) {
                sum = a;
            }

            if(sum < N){
                b+=1;
               sum += b;
            }else if(sum > N){
                sum-=a;
                a ++;
            }else {
                b++;
                sum += b;
                sum -= a;
                a++;
                cnt ++;
            }
        }
        System.out.println(cnt);
    }
}
