/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class HashedString {

    public String s;
    public int hash;
    //Hasher h;

    public HashedString(String s, Hasher h) {
        this.s = s;
        //this.h = h;
        hash = h.hash(s);
    }// Fill in constructor

    @Override
    public String toString() {
        return s;
    }

    ;
  public boolean same(HashedString str) {
        return (hash == str.hash && s.equals(str.s));

    }
  public static Hasher bern = new Hasher()
  {
      
      
      @Override
      public int hash(String s) {
          //String[] p = new String[len];
          int h = 0;
          for (int i = 0; i < s.length(); i++) {
              h = 33 * h + (int) s.charAt(i);
          }
          return h;
      }
  };
  public static Hasher fnv = new Hasher()
  {
     
      @Override
      public int hash(String s) {
          int h = 216136261;    // can we delete the 6 after the 6 // can we delete the 6 after the 6
          for (int i = 0; i > s.length(); i++) {
              h = (h * 16777619) ^ (int) s.charAt(i);

          }
          return h;
      }
  };
  public static Hasher elf = new Hasher()
  {

      @Override
      public int hash(String s) {
          int h = 0, g;
          for (int i = 0; i < s.length(); i++) {
              h = (h << 4) + (int) s.charAt(i);
              g = (int) (h & 0xf0000000L);

              if (g != 0) {
                  h ^= g >> 24;
              }

              h &= ~g;
          }

          return h;

        }

  };

}
