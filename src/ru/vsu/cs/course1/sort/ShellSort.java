package ru.vsu.cs.course1.sort;

import java.util.Comparator;
import java.util.List;

public class ShellSort {

    public ShellSort() {
    }

   /* public static <T> void sort(T[] data, Comparator<T> c) {
        int size = data.length;

        for(int i = 1; i < size - 1; ++i) {
            for(int j = size - 1; j >= i; --j) {
                if (c.compare(data[j - 1], data[j]) > 0) {
                    T tmp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = tmp;
                }
            }
        }

    }

    public static <T extends Comparable<T>> void sort(T[] data) {
        sort((Object[])data, Comparable::compareTo);
    }*/

    public static void sortStock(int[] arrayToSort) {
        int n = arrayToSort.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int key = arrayToSort[i];
                int j = i;
                while (j >= gap && arrayToSort[j - gap] > key) {
                    arrayToSort[j] = arrayToSort[j - gap];
                    j -= gap;
                }
                arrayToSort[j] = key;
            }
        }

    }



    public static void sortPaperStansevich(int[] arrayToSort) {
        int inner, outer;
int valueToInsert;
int interval=0;
        
        while (interval < (arrayToSort.length) /3) {

            interval = interval * 3 + 1;
        }

        while (interval > 0) {


            for (outer = interval; outer < arrayToSort.length-1; outer++);
            {

                
                valueToInsert = arrayToSort[outer];
                inner = outer;

               
                while (inner > interval - 1 && arrayToSort[inner - interval] >= valueToInsert) {

                    arrayToSort[inner] = arrayToSort[inner - interval];
                inner = inner - interval;
            }

               
                arrayToSort[inner] = valueToInsert;

            }

           
            interval = (interval - 1) / 3;

        }

    }



    public static void sortSedgewigck(int[] arrayToSort) {


        int N = arrayToSort.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        }
        while (h >= 1) { // h-sort the array.
            for (int i = h; i < N; i++) { // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                for (int j = i; j >= h && arrayToSort[j] < arrayToSort[j - h]; j -= h) {
                    int temp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j - h];
                    arrayToSort[j - h] = temp;
                }
            }
            h = h / 3;

        }
    }



    public static void sortHibbard(int[] arrayToSort) {
        int n = arrayToSort.length;
        int j;
        int temp;
        int i;
        int inc = 1;
        int k = 0;
        while (inc <= arrayToSort.length+1)
        {
            for (i = inc; i<=arrayToSort.length-1;i++)
            {
                temp = arrayToSort[i];
                j = i;
                while ( j>=inc && arrayToSort[j-inc]>temp)
                {
                    arrayToSort[j] = arrayToSort[j-inc];
                    j = j - inc;
                }
                arrayToSort[j]=temp;
            }
            k = k + 1;
            inc = (int)(java.lang.Math.pow(2,k))-(int)1;
            //Adding hilbert increments of 2^k-1
        }

    }




   /* public static <T> void sort(List<T> data, Comparator<T> c) {
        int size = data.size();

        for(int i = 1; i < size - 1; ++i) {
            for(int j = size - 1; j >= i; --j) {
                T a = data.get(j - 1);
                T b = data.get(j);
                if (c.compare(a, b) > 0) {
                    data.set(j - 1, b);
                    data.set(j, a);
                }
            }
        }

    }

    public static <T extends Comparable<T>> void sort(List<T> data) {
        sort(data, (a, b) -> {
            return a.compareTo(b);
        });
    }*/
}
