package cn.yuans.test.sort;

/**
 * 查找代码
 *
 * @author yuans
 * @create 2020-10-26-17:17
 */
public class Search {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Search search = new Search();
        int re = search.bsearch(a, a.length, 8);
        System.out.println(re);
    }

    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // 二分查找的递归实现
    public int bsearchRecursion(int[] a, int n, int val) {
        return bsearchInternally(a, 0, n - 1, val);
    }

    private int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) return -1;

        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bsearchInternally(a, mid + 1, high, value);
        } else {
            return bsearchInternally(a, low, mid - 1, value);
        }
    }


    //查找第一个值等于给定值的元素
    public int bsearch1(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (a[mid - 1] != value)) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

    //查找最后一个值等于给定值的元素
    public int bsearch2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] != value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    //查找第一个大于等于给定值的元素
    public int bsearch3(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if ((mid == 0) || (a[mid - 1] < value)) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    //查找最后一个小于等于给定值的元素
    public int bsearch4(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] > value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }


    public static void quickSort(int[] arr, int start, int end) {
        // 递归终止条件
        if (start >= end) {
            return;
        }
        // 第一步，找出分区后枢轴的下标，比如[2,1,3],枢轴为2，分区后枢轴的下标为1
        int pivotIndex = partition(arr, start, end);
        // 第二步，对左子数组排序
        quickSort(arr, start, pivotIndex - 1);
        // 第三步，对右子数组排序
        quickSort(arr, pivotIndex + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int left = start;
        int right = end;
        while (left < right) {
            //从右向左
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            if (left < right) {
                arr[left++] = arr[right];
            }
            //从左向右
            while (left < right && arr[left] < pivot) {
                left++;
            }
            if (left < right) {
                arr[right--] = arr[left];
            }
        }
        // 扫描完成后,将枢轴元素填入新坑中
        arr[left] = pivot;
        return left;
    }
}
