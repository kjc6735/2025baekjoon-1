package b11723;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[21];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("add")){
                arr[Integer.parseInt(st.nextToken())] = 1;
            }else if(command.equals("remove")){
                arr[Integer.parseInt(st.nextToken())] = 0;
            }else if(command.equals("check")){
                int tmp = Integer.parseInt(st.nextToken());
                sb.append(arr[tmp]).append("\n");
            }else if(command.equals("toggle")){
                int tmp = Integer.parseInt(st.nextToken());
                arr[tmp] = arr[tmp] == 0 ? 1 : 0;
            }else if(command.equals("all")){
                Arrays.fill(arr, 1);
            }else {
                Arrays.fill(arr, 0);
            }
        }
        System.out.println(sb.toString());
    }
}
