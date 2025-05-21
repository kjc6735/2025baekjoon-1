package b2839;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());



        int cnt5 = N/5;
        N %= 5;

        int cnt3 = 0;
        while (N != 0){
            cnt3 += (N/3);
            N %= 3;
            if(N == 0 || cnt5 == 0) break;
            cnt5 -=1;
            N += 5;
        }


        System.out.println( N == 0 ? (cnt3 + cnt5) : -1);


    }
}
