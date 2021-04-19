package cn.yuans.test.offer.pointer;

/**
 * 翻转单词顺序列
 * Input:
 * "I am a student."
 * <p>
 * Output:
 * "student. a am I"
 *
 * @author yuans
 * @create 2021-04-12-17:12
 */
public class Offer_58_1 {

    public static void main(String[] args) {
        Offer_58_1 offer_58_1 = new Offer_58_1();
        String str = offer_58_1.ReverseSentence("I am a student.");
        System.out.println(str);
    }

    public String ReverseSentence(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        int i = 0, j = 0;
        while (j <= n) {
            if (j == n || chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(chars, 0, n - 1);
        return new String(chars);
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j)
            swap(c, i++, j--);
    }

    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }
}
