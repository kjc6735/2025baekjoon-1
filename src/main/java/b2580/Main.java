package b2580;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int map[][] = new int[10][10];
    static int row[] = new int[10];
    static int column[] = new int[10];
    static int map3[][] = new int[3][3];
    static boolean ok = false;
    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    private static void solve(){
        backtracking(0);
    }
    public static void backtracking(int pos){
        if(pos == 81) {

            ok = true;
            print();
            return ;
        }

        if(ok) return ;

        int x = pos / 9;
        int y = pos % 9;

        if(map[x][y] != 0) backtracking(pos + 1);
        else {

            for(int i = 1; i <= 9; i++){

                int tmpR = row[x];
                int tmpC = column[y];
                int tmp3 = map3[x/3][y/3];
                int tmpM = map[x][y];
                row[x] |= (1 << i);
                column[y] |= (1 << i);
                map3[x/3][y/3] |= (1 << i);
                map[x][y] = i;

                if(row[x] != tmpR && column[y] != tmpC && map3[x/3][y/3] != tmp3){
                    backtracking(pos + 1);
                }
                row[x] = tmpR;
                column[y] = tmpC;
                map3[x/3][y/3] = tmp3;
                map[x][y] = tmpM;
            }
            map[x][y] = 0;
        }
    }

    private static void print(){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 9; i++){
            for(int k = 0; k < 9; k++){
                sb.append(map[i][k]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int k = 0; k < 9; k++){
                map[i][k] = Integer.parseInt(st.nextToken());
                if(map[i][k] == 0) continue;
                row[i] |= (1  << map[i][k]);
                column[k] |= (1  << map[i][k]);
                map3[i/3][k/3] |= (1  << map[i][k]);
            }
        }

        // 경우의 수 줄이기
        // 만약 사용할 수 있는 숫자가 1개면 그 자리에 숫자 써주기
        while(true){
            boolean updated = false;
            for(int i = 0; i < 9; i++){
                for(int k = 0; k < 9; k++){
                    if(map[i][k] != 0) continue;
                    int tmp = map[i][k] | map3[i/3][k/3] | row[i] | column[k];
                    // bitcount가 8개면 1개 남은거임
                    if(Integer.bitCount(tmp) != 8) continue;
                    updated = true;
                    int v = 0;
                    for(v = 1; v <= 9; v++){
                        if((tmp & (1 << v)) == 0) break;
                    }
                    map[i][k] = v;
                    row[i] |= (1 << v);
                    column[k] |= (1 << v);
                    map3[i/3][k/3] |= (1 << v);
                }
            }

            if(!updated) break;
        }
    }

}
