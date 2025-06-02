package b1966;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                queue.add(new int[]{i, tmp});
            }
            List<Integer> results = new ArrayList<>();
            while (true) {
                Iterator<int[]> iterator = queue.iterator();
                int peek[] = iterator.next();
                boolean ok = true;

                while (iterator.hasNext()) {
                    if (peek[1] < iterator.next()[1]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    results.add(peek[1]);
                    if(peek[0] == M){
                        sb.append(results.size()).append("\n");
                        break;
                    }
                    queue.poll();
                } else {
                    queue.add(queue.poll());
                }
            }
        }
        System.out.println(sb.toString());
    }
}

