package b12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt[] = new int[4];
        String str = br.readLine();
        st = new StringTokenizer(br.readLine());
        int check[] = new int [4];
        int result = 0;
        for(int i = 0; i < 4; i++) check[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M ; i++) {
            if(str.charAt(i) == 'A') cnt[0]++;
            if(str.charAt(i) == 'C') cnt[1]++;
            if(str.charAt(i) == 'G') cnt[2]++;
            if(str.charAt(i) == 'T') cnt[3]++;
        }
        if(isOK(check, cnt)) result ++;
        for(int i = 1; i < N - M+ 1 ; i++){
            if(str.charAt(i-1) == 'A') cnt[0]--;
            if(str.charAt(i-1) == 'C') cnt[1]--;
            if(str.charAt(i-1) == 'G') cnt[2]--;
            if(str.charAt(i-1) == 'T') cnt[3]--;

            if(str.charAt(i+M-1) == 'A') cnt[0]++;
            if(str.charAt(i+M-1) == 'C') cnt[1]++;
            if(str.charAt(i+M-1) == 'G') cnt[2]++;
            if(str.charAt(i+M-1) == 'T') cnt[3]++;
            if(isOK(check, cnt)) result ++;
        }
        System.out.println(result);
    }
    private static boolean isOK(int check[], int cnt[]){
        for(int i = 0; i < 4; i++){
            if(check[i] > cnt[i]) return false;
        }
        return true;
    }
}
