package cn.yuans.test.string;

import java.util.Scanner;

/**
 * @author yuans
 * @create 2020-05-17-11:02
 */
public class StringTest {

    public static void main(String[] args) {
//        String s1 = "aaabbb";
//
//        String s2 = "aaa" + "bbb";
//
//        System.out.println(s1.equals(s1));
//
//        // >> TODO 说好的每次创建一个新的String对象呢？
//        System.out.println("s1和s2用==判断结果："+(s1 == s2));
//
//        System.out.println("s1和s2用 equals 判断结果："+(s1.equals(s2)));
//
//        // >> TODO 打乱Java对String的的优化，再试试看
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("请输入s1");
//        s1 = scanner.nextLine();
//
//        System.out.println("请输入s2");
//        s2 = scanner.nextLine();
//
//        System.out.println("s1和s2用==判断结果："+(s1 == s2));
//
//        System.out.println("s1和s2用 equals 判断结果："+(s1.equals(s2)));

        String a = "abc";
        String a2 = "abcdef";
        System.out.println(a.compareTo(a2));
        System.out.println(Integer.toBinaryString(1000001010 & 1600010000));
    }
}
