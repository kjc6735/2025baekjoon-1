package b1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception{
        solve();
    }

    private static void solve() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i = 0; i < N ; i++){
            String str = br.readLine();
            char currChar = str.charAt(0);
            boolean check = true;
            HashSet<Character> set  = new HashSet<>();
            for(int k = 0; k < str.length() -1 ; k++){
                // 같으면 넘어감
                if(currChar == str.charAt(k)) continue;

                // set에 이미 존재하면 아닌거임
                if(set.contains(str.charAt(k))){
                    check = false;
                    break;
                }

                set.add(currChar);
                currChar = str.charAt(k);
            }
            // 마지막것도 포함되나 확인
            if(set.contains(str.charAt(str.length()-1))){
                check = false;
            }

            if(check){
                result++;
            }
        }
        System.out.println(result);


    }
}
