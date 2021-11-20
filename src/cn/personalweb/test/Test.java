package cn.personalweb.test;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @program: JavaSourceLearn
 * @description:
 * @author: lizheng
 * @create: 2020-11-25 19:42
 **/
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
//        User user = new User("张三", "男", 26, 12324);
//
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(0, 1);
//
//
//        ArrayList<String> strings = new ArrayList<>();
//        String[] objects = strings.toArray(new String[5 ]);
//        System.gc();
//        Runtime.getRuntime().gc();
//        int[] ints = new int[23];
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
//
//        }
//        int a = 5;
//        Integer b = 5;
//        System.out.println(b.equals(a));
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 50; i++) {
            list.offerLast(i);
        }

        Iterator<Integer> iterator = list.iterator();
        list.remove(25);
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next == 25) {
                list.remove(next);
            }
        }

    }

    public static boolean test(int[] freq) {
        int[] q = freq;
        q[4] = 0;
        return true;
    }

    public static int getMax(int num) {
        char[] sb = String.valueOf(num).toCharArray();
        char min = sb[0];
        int minIndex = 0;
        for(int i = 1; i < sb.length; i++) {
            if(sb[i] > min){
                minIndex = i;
                min = sb[i];
            }
        }
        if (sb[0]< sb[minIndex]) {
            char temp = sb[0];
            sb[0] = sb[minIndex];
            sb[minIndex] =temp;
        }

        return Integer.parseInt(String.valueOf(sb));
    }


    public void quickSort(int[] nums, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int pivot = partition(nums, begin, end);
        quickSort(nums, begin, pivot - 1);
        quickSort(nums, pivot + 1, end);
        String s = "abc";
        char[] chars = s.toCharArray();

        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        String str = "abcd";
        char[] chs = new char[]{'a'};

    }


    public int partition(int[] nums, int begin, int end) {
        int count = begin, pivot = end;
        for (int i = begin; i < end; i++) {
            if (nums[i] < nums[pivot]) {
                int temp = nums[i];
                nums[i] = nums[count];
                nums[count++] = temp;
            }
        }
        int temp = nums[pivot];
        nums[pivot] = nums[count];
        nums[count] = temp;
        return count;
    }


}
