package b1956;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V, E;
    static List<int[]>[] edges = new ArrayList[401];
    static int minArr[] = new int[401];
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        for(int i =0 ; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(edges[a] == null) edges[a] = new ArrayList<>();
            edges[a].add(new int[]{b,Integer.parseInt(st.nextToken())});
        }

        for(int start = 1; start <= V; start++){
            if(edges[start] == null) continue;
            Arrays.fill(minArr, Integer.MAX_VALUE);
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            pq.add(new int[]{start, 0});
            
            while(!pq.isEmpty()){
                int poll[] = pq.poll();
                int node = poll[0];
                int dist = poll[1];
                
                // 이미 더 좋은 거리로 처리된 경우 스킵
                if(dist > minArr[node]) continue;
                
                if(edges[node] != null) {
                    for(int k = 0; k < edges[node].size(); k++){
                        int end = edges[node].get(k)[0];
                        int nextValue = edges[node].get(k)[1] + dist;

                        if(minArr[end] > nextValue){
                            minArr[end] = nextValue;
                            pq.add(new int[]{end, nextValue});
                        }
                    }
                }
            }

            if(minArr[start] < result ){
                result = minArr[start];
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

}


