package b17244;

import javax.sound.midi.SysexMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    static char[][] map = new char[50][50];
    static int dir[][] = {
            {0,1}, {1,0}, {-1,0}, {0,-1}
    };
    static int start[] = new int[2];
    static int end[] = new int[2];
    static List<int[]> xPosition = new ArrayList<int[]>();
    static int distance[][] = new int[5][5];
    static int N,M;
    static Map<String, Integer> hashmap = new HashMap<>();
    static int[] startDistance = new int[5];
    static int[] endDistance = new int[5];
    static int minDistance =  Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        init();
        if(xPosition.size() == 0){
            System.out.println(startToEnd());
            return ;
        }
        setDistance();
        findAnswer();
        System.out.println(minDistance);
    }

    static void findAnswer() {
        fn(0, 0, 0, 0);
    }
    static void fn(int currPosition, int prev, int used, int result){
        int size = hashmap.size();
        if(currPosition == size){
            result += endDistance[prev];
            if(result < minDistance) {
                minDistance = result;
            }
            return ;
        }

        for(int i = 0; i < size; i++){
            if( (used & (1 << i)) != 0) continue;

            int r = result;
            int bitCnt = Integer.bitCount(used);
            if(bitCnt == 0) {
                r += startDistance[i];
            }
            if(bitCnt >= 1){
                r += distance[prev][i];
            }


            fn(currPosition + 1, i, used | (1 << i), r );

        }
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int xPositionIndex = 0;
        for(int i = 0; i < N ; i++){
            map[i] = br.readLine().toCharArray();
            for(int k = 0; k < M ; k++){
                if(map[i][k] == '#' || map[i][k] == '.') continue;
                if(map[i][k] == 'S') {
                    start[0] = i; start[1] = k;
                }else if(map[i][k] == 'E') {
                    end[0] = i ; end[1] = k;
                }else if(map[i][k] == 'X'){
                    xPosition.add(new int[]{i,k});
                    hashmap.put(i+" "+k, xPositionIndex++);
                }
            }
        }
    }

    static void setDistance(){
        if(xPosition.size() == 0) return ;

        boolean[][] visited = new boolean[50][50];

        for(int[] item : xPosition){
            int itemIndex = hashmap.get(item[0]+" "+item[1]);
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{item[0], item[1], 0});
            visited[item[0]][item[1]] = true;
            while(!queue.isEmpty()){
                int curr[] = queue.poll();

                int targetIdx =  hashmap.getOrDefault(curr[0]+" "+curr[1], -1);

                if(map[curr[0]][curr[1]] == 'X') {
                    distance[itemIndex][targetIdx] = curr[2];
                }else if (map[curr[0]][curr[1]] == 'S'){
                    startDistance[itemIndex] = curr[2];
                }else if (map[curr[0]][curr[1]] == 'E'){
                    endDistance[itemIndex] = curr[2];
                }
                for(int d = 0; d < 4; d++){
                    int x = curr[0] + dir[d][0];
                    int y = curr[1] + dir[d][1];

                    if(!inRange(x,y)) continue;
                    if(map[x][y] == '#') continue;
                    if(visited[x][y]) continue;
                    visited[x][y] = true;
                    queue.add(new int []{x, y, curr[2] + 1});
                }
            }
            for(int i = 0; i < visited.length; i++) Arrays.fill(visited[i], false);
        }
    }

    static int startToEnd(){
        boolean[][] visited = new boolean[50][50];
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});

        while(!queue.isEmpty()){
            int curr[] =  queue.poll();

            if(map[curr[0]][curr[1]] == 'E') {
                return curr[2];
            }

            for(int d = 0; d < 4; d++){
                int x = curr[0] + dir[d][0];
                int y = curr[1] + dir[d][1];

                if(!inRange(x,y)) continue;
                if(map[x][y] == '#') continue;
                if(visited[x][y]) continue;
                visited[x][y] = true;
                queue.add(new int []{x, y, curr[2] + 1});
            }
        }

        return -1;
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
