package b15686;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M, arr[][] = new int[51][51];
    static ArrayList<int[]> homePositions = new ArrayList<>();
    static ArrayList<int[]> chickenPositions = new ArrayList<>();
    static ArrayList<int[]> distances[];
    static BufferedReader br;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        init();
        solve();
        System.out.println(result);
    }

    private static void solve() {
        boolean[] selected = new boolean[chickenPositions.size()];
        select(0,0,selected);
    }

    private static void select(int index, int count, boolean[] selected) {
        if (count == M) {
            calculateMinCityDistance(selected);
            return;
        }
        if (index >= chickenPositions.size()) {
            return;
        }

        selected[index] = true;
        select(index + 1, count + 1, selected);

        selected[index] = false;
        select(index + 1, count, selected);
    }

    private static void calculateMinCityDistance(boolean[] selected) {
        int cityDistance = 0;

        for (int[] home : homePositions) {
            int minDistance = Integer.MAX_VALUE;

            for (int chickenIndex = 0; chickenIndex < chickenPositions.size(); chickenIndex++) {
                if (selected[chickenIndex]) {
                    int[] chicken = chickenPositions.get(chickenIndex);
                    int distance = calcDistance(home[0], home[1], chicken[0], chicken[1]);
                    minDistance = Math.min(minDistance, distance);
                }
            }

            cityDistance += minDistance;
        }

        result = Math.min(result, cityDistance);
    }

    private static int calcDistance(int x, int y, int x1, int y1){
        return Math.abs(x - x1) + Math.abs(y - y1);
    }

    private static void init() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= N ;i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 1; k <= N; k++){
                arr[i][k] = Integer.parseInt(st.nextToken());
                if(arr[i][k] == 1) homePositions.add(new int[]{i,k});
                else if(arr[i][k] == 2) chickenPositions.add(new int[]{i,k});
            }
        }

        distances = new ArrayList[chickenPositions.size()]; // 치킨집부터 집까지 거리를 저장할 배열 인덱스는 = 치킨 인덱스
        for(int i = 0; i < distances.length; i++) distances[i] = new ArrayList<>();
    }
}
