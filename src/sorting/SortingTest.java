package sorting;

import java.util.Scanner;

public class SortingTest {

    public static void main(String[] args) {

        System.out.println("Enter the number of elements");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("Sorting method \n1. Insertion sort\n2. Quick sort\n3. Merge sort\n4. Radix sort");
        Sorting s = new Sorting(n);

        int input = sc.nextInt();
        System.out.println("Testing method  \n1. Run Time \n 2. Constant time");
        int test = sc.nextInt();
        switch (input) {
            case 1 -> s.insertion_sort();
            case 2 -> s.quick_sort();
            case 3 -> s.merge_sort();
            case 4 -> s.radix_sort();
            default -> System.out.println("wrong choice");
        }
        switch (test) {
            case 1, 3 -> System.out.println("Time taken : " + s.getTime()+ "ms");
            case 2, 4 -> System.out.println(" Constant time" + s.getConstant() + "ms");
        }

        s.printArray();

    }
}
