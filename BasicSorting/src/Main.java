/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class Main 
{
    public static void main(String args[])
    {
        Sorter insertSort = new InsertSorter ();
       Sorter bubbleSort = new BubbleSorter();
       Sorter selectionSort = new SelectionSorter();
       Comparable<Integer> gtrInt = new GtrInt ();
       int [] a = {4, 2, 6, 5, 8, 22, -2};
       Indexable<Integer> arr1 = new IntegerArray(a);         
       CC<Integer> sortable1 = new CC<Integer>(gtrInt, arr1);
       Indexable<Integer> arr2 = new IntegerArray(a);         
       CC<Integer> sortable2 = new CC<Integer>(gtrInt, arr2);
       Indexable<Integer> arr3 = new IntegerArray(a);         
       CC<Integer> sortable3 = new CC<Integer>(gtrInt, arr3);
       insertSort.sort(sortable1);
       System.out.println("Sorted array using " + insertSort.description() + " " + sortable1 +
                          " Compares: " + sortable1.getCompares() + " Swaps: " + sortable1.getSwaps() );
       bubbleSort.sort(sortable2);
       System.out.println("Sorted array using " + bubbleSort.description() + " " + sortable2 +
                          " Compares: " + sortable2.getCompares() + " Swaps: " + sortable2.getSwaps() );
       selectionSort.sort(sortable3);
       System.out.println("Sorted array using " + selectionSort.description() + " " + sortable3 +
                          " Compares: " + sortable3.getCompares() + " Swaps: " + sortable3.getSwaps() );

    }//main
}//Main
