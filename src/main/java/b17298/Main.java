package b17298;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node o){
            if(o.value == this.value) {
                return this.index - o.index;
            }
            return this.value - o.value;
        }

    }
    static int N;
    static int arr[] = new int[1_000_000];
    static int result[] = new int[1_000_000];

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> stack  = new Stack<>();
        stack.add(0);
        int index = 1;

        while (index != N){
            if(!stack.isEmpty() && arr[stack.peek()] < arr[index]){
                result[stack.pop()] = arr[index];
            }else if(!stack.isEmpty() && arr[stack.peek()] >= arr[index]){
                stack.add(index++);
            }else {
                stack.add(index++);
            }
        }
        while(!stack.isEmpty()){
            result[stack.pop()] = -1;
        }
        for(int i = 0; i < N; i++) sb.append(result[i]).append(" ");
        System.out.println(sb.toString());
    }


}
