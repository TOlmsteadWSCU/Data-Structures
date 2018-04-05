

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
public class Sorters {

    public Sorter[] allSorts = new Sorter[6];

    public Sorters() {

        allSorts[0] = insertSort;
        allSorts[1] = selectSort;
        allSorts[2] = bubbleSort;
        allSorts[3] = heapSort;
        allSorts[4] = quickSortran;
        allSorts[5] = quickSortfirst;

    }

    public static Sorter insertSort = new Sorter() {
        @Override
        public void sort(Sortable s) {
            //put algorithm here

            for (int i = 1; i < s.size(); i++) {
                for (int j = i; j > 0; j--) {
                    if (s.gtr(j - 1, j)) {
                        s.swap(j - 1, j);
                    } else {
                        break;
                    }
                }
            }
        }

        @Override
        public String description() {

            return "Insert ";
        }

    };

    public static Sorter selectSort = new Sorter() {
        @Override
        public void sort(Sortable s) {
            for (int i = 0; i < s.size() - 1; i++) {
                int index = i;
                for (int j = 0; j < s.size() - 1; j++) {
                    if (s.gtr(j, index)) {
                        index = j;

                    }
                    s.swap(i, index);
                }
            }

        }

        @Override
        public String description() {

            return "Select ";
        }
    };
    
    
    public static Sorter bubbleSort = new Sorter(){
        @Override
        public void sort(Sortable s) {
        boolean sorted = false;
        
        while(!sorted){
            for(int i = 0; i < s.size(); i++){
                for(int j = 0; j < s.size() - 1; j++){
                    if(s.gtr(j, i)){
                        s.swap(i, j);
                        
                    }
                    else
                        sorted = true;
                }
            }
        }
    }
        @Override
        public String description()  {
        
        return "Bubble ";
        
    }
        
        
    };
    
    
    
    public static Sorter heapSort = new Sorter() {
        @Override
        public void sort(Sortable s) {
            for(int i = s.size()/2; i>=0; i--){
                heapify(i, s, s.size());
            }
            
            for(int i = s.size() - 1; i>0; i--){
                s.swap(0, i);
                heapify(0, s, i);
            }
            
        }
        
        void heapify(int i, Sortable s, int n) {  // n is the limit of s
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (r < n) {
            if (s.gtr(l, i) || s.gtr(r, i)) {
                if (s.gtr(l, r)) {
                    s.swap(i, l);
                    heapify(l, s, n);
                } else {
                    s.swap(i, r);
                    heapify(r, s, n);
                }
            }
        } else if (l < n) {
            if (s.gtr(l, i)) {
                s.swap(i, l);
            }
        }
    }


        @Override
        public String description(){
        
        return "Heap ";
    }
        
        
    };
    
    
        public static Sorter quickSortran = new Sorter() {
        @Override
        public void sort(Sortable s) {
            //put algorithm here

           
        }
        
        public Sorter partition (Sortable s, int low, int high){
            int pivot = (low + high)/2;
            s.swap(pivot, high);
            while(low <= high){
                for(int i =0; i < s.size() -1; i++){
                    if(s[i] > pivot){
                        s[i] = low;
                    }
                    else {
                        s[i] = high;
                    }
                    
                }
                s.swap(low, high);
                low = low + 1;  //bump
                high = high - 1;
            }
            
        }  
       

        @Override
        public String description() {

            return "Insert ";
        }

    };
        
            public static Sorter quickSortfirst = new Sorter() {
        @Override
        public void sort(Sortable s) {
            //put algorithm here

            for (int i = 1; i < s.size(); i++) {
                for (int j = i; j > 0; j--) {
                    if (s.gtr(j - 1, j)) {
                        s.swap(j - 1, j);
                    } else {
                        break;
                    }
                }
            }
        }

        @Override
        public String description() {

            return "Insert ";
        }

    };

   
}
