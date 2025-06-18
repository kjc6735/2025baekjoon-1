package b5430;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    static Deque<Integer> deque = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        solve();
    }

    private static void solve()throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for(int tc = 1 ; tc <= TC; tc++){
            deque = new ArrayDeque<>();
            String commands = br.readLine();
            int arrSize = Integer.parseInt(br.readLine());
            String[] tmpArr = br.readLine().split(",");

            // 큐에 넣기
            for(int i = 0; i < arrSize; i++){
                String tmp = tmpArr[i].replaceAll("\\[", "").replaceAll("]", "");
                deque.addLast(Integer.parseInt(tmp));
            }
            int currPointer = 0; // 0 앞 1 뒤
            boolean error = false;
            for(int i = 0; i < commands.length(); i++){
                if(commands.charAt(i) == 'D'){
                    if(deque.isEmpty()){
                       error = true;
                       break;
                    }

                    if(currPointer == 0) deque.pollFirst();
                    else deque.pollLast();
                }else {
                    currPointer = currPointer == 1 ? 0 : 1;
                }
            }
            if(error){
                sb.append("error\n");
            }else {
                sb.append("[");
                while(!deque.isEmpty()){
                    int tmp = 0;
                    if(currPointer == 0){
                        tmp = deque.pollFirst();
                    }else tmp = deque.pollLast();
                    sb.append(tmp);
                    if(deque.size() != 0) sb.append(",");
                }
                sb.append("]\n");
            }
        }

        System.out.println(sb.toString());
    }
}
