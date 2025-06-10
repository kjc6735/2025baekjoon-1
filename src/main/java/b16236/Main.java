package b16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int map[][] = new int[20][20], N, sharkPos[], result = 0;
    static int dir [][]= {
            {-1, 0}, {1,0}, {0,-1}, {0,1}
    };

    static Queue<int[]> fishPos = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        init();
        solve();
        System.out.println(result);
    }
    private static void solve(){
        int currSharkSize = 2;
        int sharkEatFishCnt = 0;
        while(true){
            // 물고기 찾기
            int[] findFish = findNearestFish(sharkPos, currSharkSize);

            if(findFish == null) break;

            //현재 위치와 거리 계산
            result += findFish[2];

            // 가장 가까운 위치로 가기
            sharkPos[0] =  findFish[0];
            sharkPos[1] =  findFish[1];
            //먹은 횟수 추가
            sharkEatFishCnt ++;
            // 먹은 갯수가 상어의 크기와 같아지면 업데이트
            if(currSharkSize == sharkEatFishCnt){
                currSharkSize ++;
                sharkEatFishCnt = 0;
            }
            // 먹은걸로 처리
            map[sharkPos[0]][sharkPos[1]] = 0;
        }
    }

    private static int[] findNearestFish(int[] sharkPos, int sharkSize) {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{sharkPos[0], sharkPos[1], 0});
        visited[sharkPos[0]][sharkPos[1]] = true;

        List<int[]> candidates = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1], dist = curr[2];
            if (dist > minDist) break;

            if (map[x][y] > 0 && map[x][y] < sharkSize) {
                if (dist < minDist) {
                    minDist = dist;
                    candidates.clear();
                }
                candidates.add(new int[]{x, y, dist});
            }

            for (int d = 0; d < 4; d++) {
                int dx = x + dir[d][0], dy = y + dir[d][1];

                if (dx >= 0 && dx < N && dy >= 0 && dy < N && !visited[dx][dy]) {
                    // 상어 크기보다 큰 물고기는 지나갈 수 없음
                    if (map[dx][dy] <= sharkSize) {
                        visited[dx][dy] = true;
                        queue.add(new int[]{dx, dy, dist + 1});
                    }
                }
            }
        }

        if (candidates.isEmpty()) return null;

        candidates.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        return candidates.get(0);
    }

    private static int[] getNearestFish(int[] currPos, List<int[]> positions){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            int distA = Math.abs(currPos[0] - a[0]) + Math.abs(currPos[1] - a[1]);
            int distB = Math.abs(currPos[0] - b[0]) + Math.abs(currPos[1] - b[1]);

            if (distA != distB) return distA - distB;
            if (a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });

        for(int[] pos: positions) pq.add(pos);
        return pq.poll();
    }


    private static void init()throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int k = 0 ; k < N ; k++){
                map[i][k] = Integer.parseInt(st.nextToken());
                if(map[i][k] == 9) {
                    sharkPos = new int[]{i,k};
                    map[i][k] = 0;
                }
                else if(map[i][k] > 0 && map[i][k] < 9){
                    fishPos.add(new int[]{i,k});
                }
            }
        }
    }
}
