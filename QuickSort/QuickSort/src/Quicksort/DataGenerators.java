/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quicksort;

import java.util.Random;

/**
 *
 * @author stu461516
 */
public class DataGenerators  {
    
     public static void swap(int[] a, int i, int j) {

        int x = a[i];
        int y = a[j];
        a[i] = y;
        a[j] = x;
    }

    public static Random r = new Random();
    public static RandomDataGenerator randomIntegers = new RandomDataGenerator() {
        
        

        @Override
        public RandomData generate(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = i + 1;
            }
            for (int i = 0; i < n; i++) {
                swap(a, i, r.nextInt(n));
            }

            return new RandomData(a, "Completely Random");

        }

    };

   

    public static RandomDataGenerator almostSortedIntegers = new RandomDataGenerator() {
        @Override
        public RandomData generate(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = i + 1;
            }
            for (int i = 0; i < 3; i++) {
                int swapIt = r.nextInt(n);
                swap(a, a[swapIt], r.nextInt(n));
            }

            return new RandomData(a, "Almost Sorted");

        }

    };

    public static RandomDataGenerator almostSortedReversedIntegers = new RandomDataGenerator() {
        @Override
        public RandomData generate(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = n - i;
            }
            for (int i = 0; i < 3; i++) {
                int swapIt = r.nextInt(n);
                swap(a, a[swapIt], r.nextInt(n));
            }

            return new RandomData(a, "Almost Sorted & Reversed");

        }

    };

}
