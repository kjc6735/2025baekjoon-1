//package b19238;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//    static int N, M, A;
//    static int map[][] = new int[21][21];
//    static int dir[][] = {
//            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
//    };
//    static int min = Integer.MAX_VALUE;
//    static boolean[][] visited = new boolean[21][21];
//    static int[][] passengers = new int[21][4];
//    static boolean[] used = new boolean[21];
//    static Set<String> set = new HashSet<>();
//    static Map<String, String> posMap = new HashMap<>();
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        A = Integer.parseInt(st.nextToken());
//
//        for (int i = 1; i <= N; i++) {
//            for (int k = 1; k <= N; k++) {
//                st = new StringTokenizer(br.readLine());
//                map[i][k] = Integer.parseInt(st.nextToken());
//            }
//        }
//        st = new StringTokenizer(br.readLine());
//
//        int startX = Integer.parseInt(st.nextToken());
//        int startY = Integer.parseInt(st.nextToken());
//
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//            int sx = Integer.parseInt(st.nextToken());
//            int sy = Integer.parseInt(st.nextToken());
//            int dx = Integer.parseInt(st.nextToken());
//            int dy = Integer.parseInt(st.nextToken());
//            posMap.put(sx + " " + sy, dx +" "+ dy);
//        }
//
//        fn(startX, startY, 0, 0);
//
//        System.out.println(min);
//    }
//
//    static void fn(int x, int y, int cnt, int amount){
//        if(cnt == M){
//            if(amount > A) return ;
//            if(amount < min) min = amount;
//            return ;
//        }
//
//        int[] findUSer =  getFindNearestPassenger(x,y);// return x, y, cnt // 현재 위치에서 가장 가까운 유저의 거리 및 cnt
//        if(findUSer == null) return; // 없으면 null
//        String destStr = posMap.get(findUSer[0] + " " + findUSer[1]); // 찾은 유저의 정보 가져오기
//        posMap.remove(findUSer[0] + " " + findUSer[1]); // 찾았으니까 찾은 유저 삭제하기
//        int destX = Integer.parseInt(destStr.split(" ")[0]); // 도착지 x
//        int destY = Integer.parseInt(destStr.split(" ")[1]); // 도착지 Y
//        fn(destX, destY, cnt + 1, amount + findUSer[2] + getDistance(
//                findUSer[0],
//                findUSer[1],
//                destX,
//                destY));// 기존 거리 + 찾은 유저한테 간 거리 + 유저의 출발지부터 목적지 거리
//    }
//
//
//    private static int[] getFindNearestPassenger(int x, int y) { // 유저 및 거리 리턴해줌
//        initializeVisitedArray(visited);
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{x, y, 0});
//        visited[x][y] = true;
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            List<int[]> candidates = new ArrayList<>();
//            for (int i = 0; i < size; i++) {
//                int[] curr = queue.poll();
//
//                for (int d = 0; d < 4; d++) {
//                    int dx = curr[0] + dir[d][0];
//                    int dy = curr[1] + dir[d][1];
//                    if (!inRange(dx, dy)) continue;
//                    if (visited[dx][dy]) continue;
//                    if (map[dx][dy] == 1) continue;
//                    visited[dx][dy] = true;
//                    queue.add(new int[]{dx, dy, curr[2] + 1});
//                    candidates.add(new int[]{dx, dy, curr[2] + 1});
//                }
//            }
//
//            if (!candidates.isEmpty()) {
//                candidates.sort((a, b) -> {
//                    if (a[0] != b[0]) return a[0] - b[0];
//                    return a[1] - b[1];
//                });
//                return candidates.get(0);
//            }
//        }
//
//        return null;
//    }
//
//
//    private static boolean inRange(int x, int y) {
//        return x >= 1 && y >= 1 && x <= N && y <= N;
//    }
//
//    private static void initializeVisitedArray(boolean[][] visited) {
//        for (int i = 0; i <= N; i++) Arrays.fill(visited[i], false);
//    }
//
//
//    private static int getDistance(int x1, int y1, int x2, int y2) {
//        if (x1 == x2 && y1 == y2) return 0;
//
//        initializeVisitedArray(visited);
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{x1, y1, 0});
//        visited[x1][y1] = true;
//
//        while (!queue.isEmpty()) {
//            int[] curr = queue.poll();
//            int x = curr[0];
//            int y = curr[1];
//            int dist = curr[2];
//
//            for (int d = 0; d < 4; d++) {
//                int nx = x + dir[d][0];
//                int ny = y + dir[d][1];
//
//                if (!inRange(nx, ny)) continue;
//                if (visited[nx][ny]) continue;
//                if (map[nx][ny] == 1) continue;
//
//                if (nx == x2 && ny == y2) {
//                    return dist + 1;
//                }
//
//                visited[nx][ny] = true;
//                queue.add(new int[]{nx, ny, dist + 1});
//            }
//        }
//
//        return -1;
//    }
//
//}
package b19238;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, A;
    static int map[][] = new int[21][21];
    static int dir[][] = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    static int maxFuel = -1;
    static boolean[][] visited = new boolean[21][21];
    static Map<String, String> posMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 1; k <= N; k++) {
                map[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());

        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int dx = Integer.parseInt(st.nextToken());
            int dy = Integer.parseInt(st.nextToken());
            posMap.put(sx + " " + sy, dx + " " + dy);
        }

        fn(startX, startY, 0, A);

        System.out.println(maxFuel);
    }

    static void fn(int x, int y, int cnt, int fuel) {
        if (cnt == M) {
            maxFuel = Math.max(maxFuel, fuel);
            return;
        }

        int[] findUser = getFindNearestPassenger(x, y);
        if (findUser == null) return;

        String destStr = posMap.get(findUser[0] + " " + findUser[1]);
        if (destStr == null) return;

        posMap.remove(findUser[0] + " " + findUser[1]);

        String[] destParts = destStr.split(" ");
        int destX = Integer.parseInt(destParts[0]);
        int destY = Integer.parseInt(destParts[1]);

        int userToDestDistance = getDistance(findUser[0], findUser[1], destX, destY);
        if (userToDestDistance == -1) {
            posMap.put(findUser[0] + " " + findUser[1], destStr);
            return;
        }

        int totalDistance = findUser[2] + userToDestDistance;
        if (fuel >= totalDistance) {
            int newFuel = fuel - totalDistance + (userToDestDistance * 2);
            fn(destX, destY, cnt + 1, newFuel);
        }

        posMap.put(findUser[0] + " " + findUser[1], destStr);
    }

    private static int[] getFindNearestPassenger(int x, int y) {
        initializeVisitedArray(visited);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<int[]> candidates = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (posMap.containsKey(curr[0] + " " + curr[1])) {
                    candidates.add(new int[]{curr[0], curr[1], curr[2]});
                }

                for (int d = 0; d < 4; d++) {
                    int dx = curr[0] + dir[d][0];
                    int dy = curr[1] + dir[d][1];
                    if (!inRange(dx, dy)) continue;
                    if (visited[dx][dy]) continue;
                    if (map[dx][dy] == 1) continue;
                    visited[dx][dy] = true;
                    queue.add(new int[]{dx, dy, curr[2] + 1});
                }
            }

            if (!candidates.isEmpty()) {
                candidates.sort((a, b) -> {
                    if (a[0] != b[0]) return a[0] - b[0];
                    return a[1] - b[1];
                });
                return candidates.get(0);
            }
        }

        return null;
    }

    private static boolean inRange(int x, int y) {
        return x >= 1 && y >= 1 && x <= N && y <= N;
    }

    private static void initializeVisitedArray(boolean[][] visited) {
        for (int i = 0; i <= N; i++) Arrays.fill(visited[i], false);
    }

    private static int getDistance(int x1, int y1, int x2, int y2) {
        if (x1 == x2 && y1 == y2) return 0;

        initializeVisitedArray(visited);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x1, y1, 0});
        visited[x1][y1] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];

            for (int d = 0; d < 4; d++) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];

                if (!inRange(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 1) continue;

                if (nx == x2 && ny == y2) {
                    return dist + 1;
                }

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, dist + 1});
            }
        }

        return -1;
    }
}