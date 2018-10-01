public class Main {

    public static void main(String[] args)
    {
        System.out.println("Question 1: int [][]a and int a[][]");
        System.out.println("Question 3: False");
        System.out.println("Question 5: a[2][4]");
        System.out.println("Question 7: a[2].length");
        System.out.println("Question 9: ???");//Check
        System.out.println("Question 11: Capacity expands automatically as needed.");
        System.out.println("Question 13: java.util");
        System.out.println("Question 15: Aljaccio");
        System.out.println("Question 17: cities[0][3]");
        System.out.println("Question 19: Prints all the cities in row 1.");//Check this one
        System.out.println("Question 21: Prints the cities in each row separated by a tab.");//Check
        System.out.println("Question 23: count is 2");
        System.out.println("Question 25: Returns the number of columns in each row.");
        System.out.println("Question 27: Returns the number of rows.");
        System.out.println("Question 29: Length of the arraylist");//Check
        System.out.println("Question 31:\nindex 0 = 7\nindex 1 = 45\nindex 2 = 4\nindex 3 = 21");
        System.out.println("Question 33: sout(geo[1][2])");//Check

        System.out.println("Question 68: ");
        double val[][] = new double[10][6];
        System.out.println("Number of Rows in array: " + numRows(val));
        System.out.println("Question 69: ");
        float elements[][] = new float[5][6];
        System.out.println("Number of element = " + numElements(elements));
        System.out.println("Question 70: ");//Ask someone about 70
        boolean bool[][] = new boolean[2][2];
        bool[0][0] = true;
        bool[0][1] = true;
        bool[1][0] = false;
        bool[1][1] = true;
        printBool(bool);
        System.out.println("Number of 2-element columns: " + twoElements(bool));
        System.out.println("Question 80: ");
        String str[][] = new String[2][2];
        str[0][0] = "Hello";
        str[0][1] = "World";
        str[1][0] = "String";
        str[1][1] = "Output";
        System.out.println(concatenation(str));
        System.out.println("Question 81: ");

    }//main

    public static int numRows(double value[][])
    {
        return value.length;
    }//numRows
    public static String concatenation(String str[][])
    {
        String s = "";
        for (int i=0; i<str.length; i++)
        {
            for (int j=0; j<str[i].length; j++)
            {
                s += str[i][j] + " ";
            }
        }
        return s;
    }
    public static int numElements(float elements[][])
    {
        int count = 0;
        for (int i=0; i<elements.length; i++)
        {
            for (int j=0; j<elements[i].length; j++)
            {
                count++;
            }//inner for loop
        }//out for loop
        return count;
    }//numRows
    public static int twoElements(boolean b[][])
    {
        int count = 0;
        for (int i=0; i<b.length; i++)
        {
            for (int j=0; j<b[i].length; j++)
            {
                //System.out.print(b[i][j] + " ");
                if(b[j].length == 2){
                    count++;
                }
            }
            //System.out.println("");
        }
        return count;
    }//numElements
    public static void printBool(boolean b[][]){
        for (int i=0; i<b.length; i++)
        {
            for (int j=0; j<b[i].length; j++)
            {
                System.out.print(b[i][j] + " ");
            }
            System.out.println("");
        }
    }
}//Main
