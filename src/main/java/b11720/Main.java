package b11720;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int result = 0;
        for(int i = 0; i < len ;i++) result += (str.charAt(i) - '0');

        System.out.println(result);
    }
}
