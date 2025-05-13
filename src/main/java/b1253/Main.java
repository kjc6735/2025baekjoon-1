package b1253;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Long,Set<Integer>> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        long arr[] = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++){
            long tmp = Long.parseLong(st.nextToken());
            arr[i] = tmp;
            if(map.containsKey(tmp)){
                map.get(tmp).add(i);
            }else {
                map.put(tmp, new HashSet<>());
                map.get(tmp).add(i);
            }
        }
        int cnt = 0;
        for(int i = 0; i < N ; i++){
            for(int k  = i + 1; k < N ; k++){
                long tmp = arr[i] + arr[k];
                if(map.get(tmp) == null || map.get(tmp).size() == 0) continue;

                if(map.get(tmp).size() != 0 && arr[i] == 0 && arr[k] == 0) {
                    Set<Integer> tmpSet = new HashSet<>();

                    if(map.get(tmp).contains(i)) {
                        tmpSet.add(i);
                    }
                    if(map.get(tmp).contains(k)) {
                        tmpSet.add(k);
                    }


                    if(tmpSet.size() == 2){
                       cnt += map.get(tmp).size() - 2;
                        map.put(tmp, new HashSet<>());
                        map.get(tmp).add(i);
                        map.get(tmp).add(k);
                    }else if(tmpSet.contains(i)){
                        cnt += map.get(tmp).size() - 1;
                        map.put(tmp, new HashSet<>());
                        map.get(tmp).add(i);
                    }else if(tmpSet.contains(k)){
                        cnt += map.get(tmp).size() - 1;
                        map.put(tmp, new HashSet<>());
                        map.get(tmp).add(k);
                    }else {
                        cnt += map.get(tmp).size();
                        map.put(tmp, new HashSet<>());
                    }

                }else if ( map.get(tmp).contains(i) && tmp == arr[i]){
                    cnt += map.get(tmp).size() -1;
                    map.put(tmp, new HashSet<>());
                    map.get(tmp).add(i);
                }else if( map.get(tmp).contains(k) && tmp == arr[k]){
                    cnt += map.get(tmp).size() -1;
                    map.put(tmp, new HashSet<>());
                    map.get(tmp).add(k);
                }else {
                    cnt += map.get(tmp).size();
                    map.put(tmp, new HashSet<>());
                }
            }
        }

        System.out.println(cnt);
    }
}
// 1 2 -> 3
// 1 3 -> 4
// 1 5 -> 5
// 1 6 -> 7
// 1 8 -> 9
