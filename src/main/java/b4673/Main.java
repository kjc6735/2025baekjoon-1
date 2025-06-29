package b4673;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static boolean arr[] = new boolean[10000];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        for(int i = 1; i < 10000; i++){
            fn(i);
            if(!arr[i]) sb.append(i).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void fn(int n){

        int value = n;
        while(n > 0) {
            int curr = n%10;

            value += (curr);
            n /= 10;
        }
        if(value >= 10000) return ;

        arr[value] = true;
    }
}
