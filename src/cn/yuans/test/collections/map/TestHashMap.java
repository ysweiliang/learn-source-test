package cn.yuans.test.collections.map;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yuans
 * @create 2020-04-11-1:18
 */
public class TestHashMap {
    public static void main(String[] args) {
        testHashMap();
        testConcurrentHashMap();
    }

    public static void testHashMap() {
        Map<String, Double> hashMap = new HashMap<>();
        //Aa和BB的hash值相等
        hashMap.put("Aa", 0.1);
        hashMap.put("BB", 0.2);
        hashMap.get("BB");
        hashMap.put("cc", 0.3);
        System.out.println(hashMap.toString());
    }

    public static void testConcurrentHashMap() {
        Map<String, Double> hashMap = new ConcurrentHashMap<>();
        //Aa和BB的hash值相等
        hashMap.put("Aa", 0.1);
        hashMap.put("BB", 0.2);
        hashMap.get("BB");
        hashMap.put("cc", 0.3);
        System.out.println(hashMap.toString());
    }
}
