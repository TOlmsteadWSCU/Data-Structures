import java.util.*;
import java.io.*;
public class Main {
    public static int largestIndex(int[] list, int size)
    {
        int temp = 0;
        for (int i=0; i<size; i++)
        {
            if(list[i] > list[temp])
            {
                temp = i;
            }
        }
        System.out.println("Max Index: " + temp);
        return temp;

    }//largestIndex
    public static void generateRandomList()
    {
        Random random = new Random();
        int[] list = new int[10];
        for (int i=0; i<list.length; i++)
        {
            list[i] = random.nextInt(10) + 1;
            System.out.println("Element in list: " + list[i]);
            largestIndex(list, list.length-i);
        }//for loop

    }//generateRandomList
    public static void insertSort(int[] list)
    {

    }
    public static void main(String[] args)
    {
        generateRandomList();
        //System.out.println("Hello World!");
    }
}//Main class
