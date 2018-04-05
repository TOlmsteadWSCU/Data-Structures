
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class Main {
    public static int moby = 19792;
    public static double load = .5;
    public static int size = (int)(moby / load);
    public static HashTable table = new Buckets(HashedString.bern, size);
    public static HashTable linearTable = new Linear(HashedString.bern, size);
    public static int n = 0;
    public static int n1 = 0;
    public static void main(String[] args)
    {
        lex("mobydick.txt");
        System.out.println("Load: " + load + " Compares: " + table.getCompares());
        
        //lex("mobydick.txt");
        //System.out.println("Words: " + linearTable.size());
    }
    public static void processWord(String substring){
        int count = table.get(substring);
        table.set(substring, count + 1);
        n++;
        if(n % 10000 == 0){
            System.out.println("Word: " + substring + " Count: " + count + " Size: " + table.size() + " N: " + n);
        }
        
       int count1 = linearTable.get(substring);
        linearTable.set(substring, count1 + 1);
        n1++;
        if(n1 % 10000 == 0){
            //System.out.println("Word: " + substring + " Count: " + count + " Size: " + linearTable.size() + " N: " + n);
        }
    }
    public static void lex(String filename) {
        String line;
        try {
            FileReader f = new FileReader(filename);
            BufferedReader input = new BufferedReader(f);
            while ((line = input.readLine()) != null){
                int col = 0;
                while (col < line.length()) {
                    char ch = line.charAt(col);
                    if (Character.isWhitespace(ch)) {
                        col++;
                    } else if (Character.isLetter(ch)) {
                        int firstCol = col;
                        col++;
                        char tmp;
                        while (col < line.length() &&
                               (Character.isLetter(tmp = line.charAt(col))
                                || tmp == '\'' && col+1 < line.length() && Character.isLetter(line.charAt(col+1))
                                || tmp == '-' && col+1 < line.length() && Character.isLetter(line.charAt(col+1)))) {
                                  col++;
                        }
                        processWord(line.substring(firstCol, col));  // You have to write this method
                    } else {
                        col++;
                    }
                }
            }      
        } catch (IOException ex) {
            System.out.print("IO Error: " + ex.getMessage());
            return;
        }

    }
}
