/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

/**
 *
 * @author jackthibodeau
 */
    
 public class Link<T>{

    public Link<T> next;
    public T data;

    public Link(T data, Link<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return print(this);
    }

    
    public static <T> String print(Link<T> x) {
        return "[" + print1(x);
    }

    public static <T> String print1(Link<T> x) {
        if (x == null) {
            return "]";
        }
        if (x.next == null) {
            return x.data + "]";
        }
        return x.data + ", " + print1(x.next);
    }
    public static <T> Link <T> splithelper(Link<T> slow, Link<T> fast){
        
        if(fast == null || fast.next == null|| fast.next.next == null){
        
            Link <T> r = slow.next;
        
            slow.next= null;
        
            return r;
    }
        else{ 
            return splithelper (slow.next , fast.next.next);
        }
    }
    public static <T> Link <T> split(Link<T>x){
    return splithelper (x,x);
}
    public static Link<Integer> merge (Link<Integer> L1, Link<Integer> L2){
        if( L1 == null){
            return L2;
         }
        if( L2 == null){
            return L1;
        }
        MergeSort.compares++;
        
        if (L1.data < L2.data){
            L1.next = merge(L1.next, L2);
            return L1;
        }
        else{
            L2.next = merge(L1,L2.next);
            return L2;
        }
    }
    public static Link<Integer> mergesort(Link<Integer>L1){
        if (L1 == null || L1.next == null){
            return L1;
        }
        Link <Integer> L2 = split(L1);
        L1 = mergesort (L1);
        L2 = mergesort (L2);
        return Link.merge (L1, L2);
    }
    
}
