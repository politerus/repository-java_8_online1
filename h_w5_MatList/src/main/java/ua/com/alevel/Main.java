package ua.com.alevel;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MatList<Integer> list1 = new MatList<>(new Integer[]{1, 2, 3});
        MatList<Integer> list2 = new MatList<>(new Integer[]{4, 5, 6});
        MatList<Integer> list3 = new MatList<>(new Integer[]{7, 8, 9});

        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
        System.out.println("list3 = " + list3);
         System.out.println("Adding elements..");

        list1.add(6, 8);
        list2.add(7, 8);
        list3.add(9, 8);

        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
        System.out.println("list3 = " + list3);

        list1.join(list2, list3);
        System.out.println("Joined List1 with List2 and List3: " + list1);

        list1.intersection(list2, list3);
        System.out.println("Intersection of List1, List2, and List3: " + list1);

        list1.sortDesc();
        System.out.println("Sorted in descending order: " + list1);

        list1.sortDesc(1, 3);
        System.out.println("Sorted in descending order (range 1-3): " + list1);

        list1.sortDesc(3);
        System.out.println("Sorted in descending order (starting from 3): " + list1);

        Number max = list1.getMax();
        Number min = list1.getMin();
        Number avg = list1.getAverage();
        Number median = list1.getMedian();

        System.out.println("Max value: " + max);
        System.out.println("Min value: " + min);
        System.out.println("Average value: " + avg);
        System.out.println("Median value: " + median);

        Number[] array = list1.toArray();
        System.out.println("Array representation: " + Arrays.toString(array));

        MatList<Integer> cutResult = list1.cut(1, 3);
        System.out.println("Cut result from List1: " + cutResult);
        System.out.println("Modified List1 after cut: " + list1);

        list1.clear();
        System.out.println("List1 after clear: " + list1);
    }
}