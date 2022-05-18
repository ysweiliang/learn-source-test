package cn.yuans.test.collections.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yuans
 * @create 2022-05-19-0:00
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.score - o1.score;
            }
        });
        priorityQueue.add(new Student(2, 10, 89));
        priorityQueue.add(new Student(3, 9, 78));
        priorityQueue.add(new Student(1, 11, 99));
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}

class Student implements Comparable<Student> {

    public int id;
    public int age;
    public int score;

    public Student(int id, int age, int score) {
        this.id = id;
        this.age = age;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return this.id - o.id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
