/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class DataGenerator
{
    public static void swap(int[] a, int i, int j)
    {
        int x = a[i];
        int y = a[j];
        a[i] = y;
        a[j] = x;
    }
    public static RandomDataGenerator randomIntegers = new RandomDataGenerator() {
        @Override
        public RandomData generate(int n) {
            
        }
    };
    public static RandomDataGenerator almostSortedIntegers = new RandomDataGenerator()
    {
        @Override
        public RandomData generate(int n) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    };
    public static RandomDataGenerator almostSortedReversedIntegers = new RandomDataGenerator()
    {
        @Override
        public RandomData generate(int n) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    };
}//DataGenerator