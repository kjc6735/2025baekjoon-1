package b2573;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int arr[][] = new int[300][300], N,M, result;
    static boolean[][] visited = new boolean[300][300];
    static int dir[][] = {
            {0,1}, {0,-1}, {1,0}, {-1,0}
    };
    static int start[];
    public static void main(String[] args) throws Exception {
        init();
        solve();
        System.out.println(result);
    }

    private static void solve() {
        while(true){

            // 몇개로 나눠졌는지 나타내는 변수
            int cnt = 0;
            initialize(visited);
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(arr[i][j] == 0) continue;
                    if(visited[i][j]) continue;
                    cnt ++;
                    ArrayList<int[]> updateList = new ArrayList<>();
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i,j});

                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int curr[] = queue.poll();
                        int bCnt = 0; // 바다 갯수
                        for(int d = 0; d < 4; d ++){
                            int x = curr[0] + dir[d][0];
                            int y = curr[1] + dir[d][1];

                            if(!inRange(x, y)) continue;

                            if(arr[x][y] == 0){
                                // 0이면 바다니까 갯수만
                                bCnt ++;
                            }else if(!visited[x][y]){
                                queue.add(new int[]{x, y});
                                visited[x][y] = true;
                            }
                        }
                        updateList.add(new int[]{curr[0], curr[1], bCnt});
                    }
                    // 반영하기
                    for(int [] update:  updateList){
                        arr[update[0]][update[1]] = max(0,  arr[update[0]][update[1]] - update[2]);
                    }
                }
            }
//
//            print();
//            System.out.println("cnt " + cnt);
            if(cnt >= 2) {
                return ;
            }else if(cnt == 0) { // 빙산이 다 녹을 때까지 분리되지 않으면
                result = 0;
                return;
            }
            result++;
        }
    }

    private static int max(int a, int b){
        return a > b ? a : b;
    }
    private static void initialize(boolean[][] tmp){
        for(int i = 0; i < N; i++) Arrays.fill(tmp[i], false);
    }
    private static boolean inRange(int x, int y){
        return x>= 0 && y>=0 && x < N && y < M;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < M ; k++){
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void print(){
        System.out.println("==========");
        for(int i = 0; i < N ; i++){
            for(int k = 0; k < M ; k++){
                System.out.print(arr[i][k] + " ");
            }
            System.out.println();
        }

    }
}
