package b2941;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<String> list = new ArrayList<>();
        list.add("c=");
        list.add("c-");
        list.add("dz=");
        list.add("d-");
        list.add("lj");
        list.add("nj");
        list.add("s=");
        list.add("z=");
        for(int i = 0; i < list.size(); i++){
            str = str.replaceAll(list.get(i), "a");
        }
        System.out.println(str.length());
    }
}
