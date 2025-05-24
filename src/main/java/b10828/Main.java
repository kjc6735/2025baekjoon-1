package b10828;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N ; i++){
            String [] str = br.readLine().split(" ");

            if(str[0].equals("push")){
                int r = Integer.parseInt(str[1]);
                stack.add(r);
            }else if(str[0].equals("top")){
                sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
            }else if(str[0].equals("size")){
                sb.append(stack.size()).append("\n");
            }else if(str[0].equals("empty")){
                sb.append(stack.isEmpty() ? 1 : 0).append("\n");
            }else if(str[0].equals("pop")){
                sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
