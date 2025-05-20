package b1991;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<String, List<String>> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N ; i++){
            String strs[] = br.readLine().split(" ");
            if(!map.containsKey(strs[0])) {
                map.put(strs[0], new ArrayList<String>() );
            }
            map.get(strs[0]).add(strs[1]);
            map.get(strs[0]).add(strs[2]);
        }

        System.out.println(preorder("A"));
        System.out.println(inorder("A"));
        System.out.println(postorder("A"));
    }

    private static String preorder(String curr){
        if(curr.equals(".")) return "";
        String str = curr;

        str += preorder(map.get(curr).get(0));
        str += preorder(map.get(curr).get(1));

        return str;
    }
    private static String inorder(String curr){
        if(curr.equals(".")) return "";
        String str = "";

        str += inorder(map.get(curr).get(0));
        str += curr;
        str += inorder(map.get(curr).get(1));

        return str;
    }
    private static String postorder(String curr){
        if(curr.equals(".")) return "";
        String str = "";

        str += postorder(map.get(curr).get(0));
        str += postorder(map.get(curr).get(1));
        str += curr;

        return str;
    }

}
