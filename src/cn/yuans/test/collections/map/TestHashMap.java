package cn.yuans.test.collections.map;


import java.util.HashMap;
import java.util.Map;

/**
 * @author yuans
 * @create 2020-04-11-1:18
 */
public class TestHashMap {
    public static void main(String[] args) {
        Map<String, Double> hashMap = new HashMap<>();
        //Aa和BB的hash值相等
        hashMap.put("Aa", 0.1);
        hashMap.put("BB", 0.2);
        hashMap.get("BB");
        hashMap.put("cc",0.3);
        System.out.println(hashMap.toString());
    }
}
