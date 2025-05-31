package b3190;

import java.io.BufferedReader;
import java.util.*;

public class Main {
    static int arr[][] = new int[101][101], N,K, L;
    static int dir[][] = {
            {0,1}, {1,0},{0,-1}, {-1,0}
    };
    // 0에서 R => +1  / L = + 3
    // 1에서 R => + 1 / L = + 3;
    static BufferedReader br;
    static Map<Integer, String> command = new HashMap<>();
    static int result = 0;
    public static void main(String[] args) throws Exception{
        init();
        play();
        System.out.println(result);
    }
    private static void play(){
        int currDir = 0;
        int currPos[] = new int[]{1,1};
        Set<String> body = new HashSet<>();
        Queue<String> moveQueue = new LinkedList<>();
        moveQueue.add(currPos[0] + " " + currPos[1]);
        for(int sec = 0; ; sec++){
            // 현재 초에서 위치가 있으면 위치 바꿔주기
            if(command.containsKey(sec)){
                String dirStr = command.get(sec);
                if(dirStr.equals("L")){
                    currDir += 3;
                }else if(dirStr.equals("D")){
                    currDir += 1;
                }
                currDir %= 4;
            }
            int nextX = currPos[0] + dir[currDir][0];
            int nextY = currPos[1] + dir[currDir][1];
            if(!inRange(nextX, nextY) || body.contains(nextX + " " + nextY)){
                result = sec + 1;
                return ;
            }

            moveQueue.offer(nextX + " " + nextY); //moveQueue에 넣기만 한다.
            body.add(nextX + " " + nextY);
            currPos[0] = nextX;
            currPos[1] = nextY;
            if(arr[nextX][nextY] == 1){ // 만약 사과면 ??
                // 사과를 먹는다.
                arr[nextX][nextY] = 0;
                // 아무일도 발생 X
            }else {
                //꼬리를 없애야함 == body 지우기, moveQueue빼기
                String next = moveQueue.poll();
                body.remove(next);
            }

        }
    }


    private static boolean inRange(int x, int y){
        return x >= 1 && y >= 1 && x <= N && y <= N;
    }

    private static void init() throws Exception{
        br = new BufferedReader(new java.io.InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
        }
        L = Integer.parseInt(br.readLine());
        for(int i = 0; i < L ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int second = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            command.put(second, dir);
        }
    }
}
