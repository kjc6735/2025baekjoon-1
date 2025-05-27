package b19644;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int L, Ml, Mk, C, arr[] = new int[4_000_000], v[] = new int[4_000_000];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        L = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Ml = Integer.parseInt(st.nextToken());
        Mk = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(br.readLine());

        for(int i = 1; i <= L; i++){
            int tmp = Integer.parseInt(br.readLine());
            arr[i] = tmp;
        }
        for(int currPos = 0; currPos < L; currPos++){
            if(arr[currPos] > 0) {
                System.out.println("NO");
                return ;
            }
            v[currPos+1] += v[currPos];
            int d = (v[currPos + 1] + 1) * Mk; // 내가 쏜 횟수 + 지금 내가 쏠 거
            boolean canKill = d >= arr[currPos + 1];
            if(canKill) {
                arr[currPos + 1] = 0;
                v[currPos + 1] += 1;
                if(currPos + Ml+ 1 <= L){
                    v[currPos + Ml+ 1] -= 1 ;
                }
            }else {
                if(C > 0) {
                    C--;
                    arr[currPos + 1] = 0;
                }else{
                    System.out.println("NO");
                    return ;
                }
            }

        }


        System.out.println("YES");
    }
}
