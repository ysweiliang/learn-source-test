package cn.yuans.test.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 泛型测试
 *
 * @author yuans
 * @create 2020-05-15-15:35
 */
public class GenericTest {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        Dog dog = new Dog("旺财");
//        stringList.add(dog);
        List<Dog> dogList = new ArrayList<>();
        dogList.add(dog);

        // Comparable<? super T> 则代表 Comparable 的类型参数必须是 T 或 T 的父类型。
        // <? extends T>，问号代表继承和实现 T
        // Collections.sort(dogList);
        String a = "a";
        String b = "b";
        stringList.add(a);
        stringList.add(b);
        //其中第一部分 <T extends Comparable> 指的是 T 必须是 Comparable 的实现（这是重点）
        //第二部分方法入参 sort(List<T> list)，指的是仅能传入继承 Comparable 的参数化类型的 list。
        Collections.sort(stringList);
    }
}
