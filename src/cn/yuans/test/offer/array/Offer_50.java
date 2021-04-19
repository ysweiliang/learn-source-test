package cn.yuans.test.offer.array;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。
 * 字符串只包含 ASCII 码字符
 *
 * @author yuans
 * @create 2021-04-12-14:00
 */
public class Offer_50 {

    public static void main(String[] args) {
        String str = "abacc";
        Offer_50 offer_50 = new Offer_50();
        int cnts = offer_50.FirstNotRepeatingChar(str);
        System.out.println(cnts);
        int cnts2 = offer_50.FirstNotRepeatingCharByMap(str);
        System.out.println(cnts2);
    }

    public int FirstNotRepeatingChar(String str) {
        int[] cnts = new int[128];
        for (int i = 0; i < str.length(); i++) {
            cnts[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (cnts[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int FirstNotRepeatingCharByMap(String str) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            String key = String.valueOf(str.charAt(i));
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.putIfAbsent(key, 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(String.valueOf(str.charAt(i))) == 1) {
                return i;
            }
        }
        return -1;
    }
}
