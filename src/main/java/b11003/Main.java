package b11003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        Deque<int[]> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            int tmp = Integer.parseInt(st.nextToken());

            while (!deque.isEmpty() && deque.peekFirst()[0] < ( i - M + 1)){
                deque.poll();
            }
            while (!deque.isEmpty() && deque.peekLast()[1] > tmp) {
                deque.pollLast();
            }
            deque.addLast(new int[]{i, tmp});
            sb.append(deque.peekFirst()[1]).append(" ");
        }
        System.out.println(sb.toString());

    }
}
