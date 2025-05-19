package b1759;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static char arr[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new char[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++){
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        fn(0, 0,"");
        System.out.print(sb.toString());
    }

    private static void fn(int cnt,int prev, String str){
        if(cnt == M){
            if(!isOK(str)) return;
            sb.append(str).append('\n');
            return;
        }

        for (int i = prev; i < N; i++) {
            fn(cnt + 1, i+1 ,str + String.valueOf(arr[i]));
        }
    }

    private static boolean isOK(String str){
        int a = 0;
        int b = 0;

        for(char c : str.toCharArray()) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                a++;
            } else {
                b++;
            }
        }

        return a >= 1 && b >= 2;
    }
}
