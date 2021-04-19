package cn.yuans.test.offer.pointer;

/**
 * 将字符串 S 从第 K 位置分隔成两个子字符串，并交换这两个子字符串的位置。
 * Input:
 * S="abcXYZdef"
 * K=3
 * Output:
 * "XYZdefabc"
 *
 * @author yuans
 * @create 2021-04-13-10:15
 */
public class Offer_58_2 {

    public static void main(String[] args) {
        Offer_58_2 offer_58_2 = new Offer_58_2();
        String str = offer_58_2.LeftRotateString("abcXYZdef",3);
        System.out.println(str);
    }

    /**
     * 先将 "abc" 和 "XYZdef" 分别翻转，得到 "cbafedZYX"，然后再把整个字符串翻转得到 "XYZdefabc"。
     */
    public String LeftRotateString(String str, int n) {
        if (n >= str.length())
            return str;
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j)
            swap(chars, i++, j--);
    }

    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }
}
