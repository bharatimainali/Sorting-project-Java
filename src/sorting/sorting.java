

package sorting;

import java.util.Random;
import java.util.Scanner;

import static java.sql.DriverManager.println;

class Sorting {

        private final int arr[];
        private final Random rand;
        private long timeStart, timeEnd, totaltime;
        private double Constant;
        private int n;

        public double getConstant() {
            return Constant;
        }

        public long getTime() {
            return totaltime;
        }

        Sorting(int n) {
            this.n = n;
            this.rand = new Random();
            this.arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = rand.nextInt(n) + 1;
            }
        }

        void printArray() {
            int n = arr.length;
            for (int i = 0; i < n; ++i) {
                System.out.print(arr[i] + " ");
            }

            System.out.println();
        }
        void insertion_sort() {
            timeStart = System.currentTimeMillis();
            int n = arr.length;
            for (int i = 1; i < n; ++i) {
                int key = arr[i];
                int j = i - 1;

                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = key;
            }
            timeEnd = System.currentTimeMillis();
            totaltime = timeEnd - timeStart;;
            Constant = (totaltime / ((float)n * (float)n));
            println("The total time the algorithm used was " + totaltime + " ms.");
        }




        //////////
        static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        /* This function takes last element as pivot, places
           the pivot element at its correct position in sorted
           array, and places all smaller (smaller than pivot)
           to left of pivot and all greater elements to right
           of pivot */
        private int partition(int low, int high) {

            int pivot = arr[high];
            int i = (low - 1);
            for (int j = low; j <= high - 1; j++) {

                if (arr[j] < pivot) {
                    i++;
                    swap(arr, i, j);
                }
            }
            swap(arr, i + 1, high);
            return (i + 1);
        }

        private void quickSort(int low, int high) {
            if (low < high) {

                int pi = partition(low, high);
                quickSort(low, pi - 1);
                quickSort(pi + 1, high);
            }
        }

        ///////////
        void quick_sort() {
            timeStart = System.currentTimeMillis();
            quickSort(0, arr.length - 1);
            timeEnd = System.currentTimeMillis();
            totaltime = timeEnd - timeStart;;
            long durationInMs = timeEnd - timeStart;
            Constant = n * Math.log(n);
            long timeEnd = System.currentTimeMillis();
            System.out.println("Time taken: " + durationInMs + " ms");
        }

        private void merge(int l, int m, int r) {
            int n1 = m - l + 1;
            int n2 = r - m;

            int L[] = new int[n1];
            int R[] = new int[n2];

            for (int i = 0; i < n1; ++i) {
                L[i] = arr[l + i];
            }
            for (int j = 0; j < n2; ++j) {
                R[j] = arr[m + 1 + j];
            }

            int i = 0, j = 0;
            int k = l;
            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    arr[k] = L[i];
                    i++;
                } else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }

            while (i < n1) {
                arr[k] = L[i];
                i++;
                k++;
            }

            while (j < n2) {
                arr[k] = R[j];
                j++;
                k++;
            }
        }

        private void mergesort(int l, int r) {
            if (l < r) {
                int m = l + (r - l) / 2;
                mergesort(l, m);
                mergesort(m + 1, r);

                merge(l, m, r);
            }
        }

        void merge_sort() {
            timeStart = System.currentTimeMillis();
            mergesort(0, arr.length - 1);
            timeEnd = System.currentTimeMillis();
            totaltime = timeEnd - timeStart  ;
            long durationInMs = timeEnd - timeStart;
            Constant = n * Math.log(n);
            long end = System.currentTimeMillis();
            System.out.println("Time taken: " + durationInMs + " ms");




        }

        void countingSort(int array[], int size, int place) {
            int[] output = new int[size + 1];
            int max = array[0];
            for (int i = 1; i < size; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            int[] count = new int[max + 1];

            for (int i = 0; i < max; ++i) {
                count[i] = 0;
            }

            for (int i = 0; i < size; i++) {
                count[(array[i] / place) % 10]++;
            }

            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            for (int i = size - 1; i >= 0; i--) {
                output[count[(array[i] / place) % 10] - 1] = array[i];
                count[(array[i] / place) % 10]--;
            }

            for (int i = 0; i < size; i++) {
                array[i] = output[i];
            }
        }

        int getMax(int array[], int n) {
            int max = array[0];
            for (int i = 1; i < n; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            return max;
        }

        void radix_sort() {
            timeStart = System.currentTimeMillis();
            int max = getMax(arr, arr.length);

            for (int place = 1; max / place > 0; place *= 10) {
                countingSort(arr, arr.length, place);
            }
            timeEnd = System.currentTimeMillis();
            long durationInMs = timeEnd - timeStart;
            totaltime = timeEnd - timeStart  ;
            Constant = n * Math.log(n);

            long end = System.currentTimeMillis();
            System.out.println("Time taken: " + durationInMs + " ms");

        }

    }



