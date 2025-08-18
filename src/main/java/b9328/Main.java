package b9328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int tc, w,h;
    static String map[] = new String[100];
    static boolean visited[][] = new boolean[100][100];
    static Queue<int[]> entrance = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static int dir[][] = {
            {0,1}, {0,-1}, {1,0}, {-1,0}
    };
    static BufferedReader br;
    public static void main(String[] args) throws Exception{
        init();
        for(int testCase = 1; testCase <= tc; testCase++){
            solve();
        }

        System.out.print(sb.toString() );

    }

    private static void solve() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        entrance.clear();
        for(int i = 0; i < h; i ++){
            Arrays.fill(visited[i], false);
            map[i] = br.readLine();
            for(int k = 0; k < w; k ++){
                if(map[i].charAt(k) == '0') continue;
            }
        }
        Set<Character> key = br.readLine().toUpperCase()
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        for(int i = 0; i < h; i++) {
            if(map[i].charAt(0) != '*') {
                entrance.add(new int[]{i,0});
            }
            if(map[i].charAt(w-1) != '*' ){
                entrance.add(new int[]{i,w-1});
            }
        }
        for(int i = 0; i < w; i++){
            if(map[0].charAt(i) != '*'){
                entrance.add(new int[]{0,i});
            }
            if(map[h-1].charAt(i) != '*'){
                entrance.add(new int[]{h-1,i});
            }
        }

        int cnt = 0;
        boolean added;
        while(true){
            added = false;
            int size = entrance.size();
            for(int i = 0; i < size; i++){
                int[] entranceItem = entrance.poll();
                int sx = entranceItem[0];
                int sy = entranceItem[1];

                if(visited[sx][sy]) continue;

                if(isCapital(map[sx].charAt(sy)) && !key.contains(map[sx].charAt(sy))){
                    entrance.add(new int[]{sx,sy});
                    continue;
                };

                char tmpK = toCapital(sx,sy);
                if(isSmall(map[sx].charAt(sy)) && !key.contains(tmpK) ){
                    added = true;
                    key.add(tmpK);
                }


                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{sx,sy});
                visited[sx][sy] = true;
                if(map[sx].charAt(sy) == '$'){
                    cnt ++;
                }


                while(!queue.isEmpty()){
                    int curr[] = queue.poll();

                    for(int d = 0; d < 4; d++){
                        int x = curr[0] + dir[d][0];
                        int y = curr[1] + dir[d][1];

                        if(!inRange(x,y)) continue;
                        if(visited[x][y]) continue;
                        if(map[x].charAt(y) == '*') continue;

                        // 대문자 && 키가 없으면 못 지나감
                        if(isCapital(map[x].charAt(y)) && !key.contains(map[x].charAt(y))){
                            entrance.add(new int[]{x,y});
                            continue;
                        }
                        // 소문자면 넣어줌
                        if(isSmall(map[x].charAt(y)) &&  !key.contains(toCapital(x,y))){
                            key.add(toCapital(x,y));
                            added = true;
                        }

                        if(map[x].charAt(y) == '$'){
                            cnt++;
                        }

                        queue.add(new int[]{x,y});
                        visited[x][y] = true;
                    }
                }
            }

            if(!added) break;
        }

        sb.append(cnt).append("\n");
    }

    private static boolean isCapital(char c) {
        return c >= 'A' && c <= 'Z';
    }
    private static boolean isSmall(char c){
        return c >= 'a' && c <= 'z';
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < h  && y < w;
    }
    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
    }

    private static char toCapital(int x,int y){
        return String.valueOf(map[x].charAt(y)).toUpperCase().charAt(0);
    }
}
