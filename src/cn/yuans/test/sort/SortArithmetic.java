package cn.yuans.test.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author yuans
 * @create 2020-10-19-22:40
 */
public class SortArithmetic {

    public static void main(String[] args) {
        String[] a = new String[]{"9", "3", "5", "7", "6", "4", "2", "1"};
//        SortArithmetic.selection(a);
//        SortArithmetic.insertion(a);
        SortArithmetic.merge(a, new String[a.length], 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    /**
     * a>b 则a.compareTo(b) > 0
     *
     * @param a 参数
     * @param b 参数
     */
    public static boolean less(String a, String b) {
        return a.compareTo(b) < 0;
    }

    /**
     * 交换程序
     *
     * @param a   数组
     * @param i   下标
     * @param min 下标
     */
    public static void exch(String[] a, int i, int min) {
        String temp = a[i];
        a[i] = a[min];
        a[min] = temp;
    }

    /**
     * 选择排序
     */
    public static void selection(String[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            //设置最小的数据索引，初始化为0
            int min = i;
            for (int j = i + 1; j < N; j++) {
                //右边数据遍历对比最小索引
                if (less(a[i], a[j])) {
                    min = j;
                }
                //每对比一次就交换一次数据，将最小值换到最小数据索引下
                exch(a, i, min);
            }
        }
    }

    /**
     * 插入排序
     */
    public static void insertion(String[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            //将a[i]数据插入到a[i-1]，a[i-2]，a[i-3]……之中
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                //less(a[j], a[j - 1]) a.compareTo(b) < 0 ==>a<b 交换
                exch(a, j, j - 1);
            }
        }
    }


    /**
     * 归并排序
     */
    public static void merge(String[] a, String[] result, int start, int end) {
        if (start >= end)
            return;
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        merge(a, result, start1, end1);
        merge(a, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2)
            result[k++] = less(a[start1], a[start2]) ? a[start1++] : a[start2++];
        while (start1 <= end1)
            result[k++] = a[start1++];
        while (start2 <= end2)
            result[k++] = a[start2++];
        for (k = start; k <= end; k++)
            a[k] = result[k];
    }

    /**
     * 快速排序
     */
    public static void quick(String[] a) {
        int len = a.length;
        int low = 0;
        int high = len - 1;
        int mid = (low + high) / 2;

    }


    /**
     * 计数排序，a是数组，n是数组大小。假设数组中存储的都是非负整数。
     *
     * @param a 数组
     * @param n 数组大小
     */
    public void countingSort(int[] a, int n) {
        if (n <= 1) return;
        // 查找数组中数据的范围
        int max = a[0];
        for (int i = 1; i < n; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        int[] c = new int[max + 1]; // 申请一个计数数组c，下标大小[0,max]
        for (int i = 0; i <= max; ++i) {
            c[i] = 0;
        }

        // 计算每个元素的个数，放入c中
        for (int i = 0; i < n; ++i) {
            c[a[i]]++;
        }

        // 依次累加
        for (int i = 1; i <= max; ++i) {
            c[i] = c[i - 1] + c[i];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[n];
        // 计算排序的关键步骤，有点难理解
        for (int i = n - 1; i >= 0; --i) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // 将结果拷贝给a数组
        for (int i = 0; i < n; ++i) {
            a[i] = r[i];
        }
    }
}
