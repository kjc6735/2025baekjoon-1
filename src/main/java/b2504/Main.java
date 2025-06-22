package b2504;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int depth[] = new int[100];

        StringBuilder sb = new StringBuilder();

        int currDepth = 0; // 올라갈수록 낮은 곳에 있음
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            if( c == '(' || c == '[') {
                currDepth++;
                stack.add(c);
                continue;
            }

            if(stack.isEmpty()) {
                System.out.println(0);
                return ;
            }

            if((stack.peek() == '(') && (c == ']') ||(stack.peek() == '[') && (c == ')') ){
                System.out.println(0);
                return ;
            }
            stack.pop();
            int tmp = 0;
            if( c == ')') tmp = 2;
            else if( c == ']') tmp = 3;
            depth[currDepth] += tmp * (depth[currDepth + 1] == 0 ? 1 : depth[currDepth + 1]); // 하나 깊이 있는 곳에 있는 값 곱해주기
            depth[currDepth + 1] = 0; // 초기화
            currDepth --;

        }


        if(!stack.isEmpty()) {
            System.out.println(0);
            return ;
        }
        System.out.println(depth[1]);

    }
}