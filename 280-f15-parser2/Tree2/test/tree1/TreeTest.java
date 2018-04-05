/*
 * TreeTest.java
 * JUnit based test
 *
 * Created on November 14, 2007, 7:46 PM
 */

package tree1;

import junit.framework.*;
import java.util.ArrayList;

/**
 *
 * @author fac_peterson
 */
public class TreeTest extends TestCase {
    
    public TreeTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    /**
     * Test of treePrint method, of class tree1.Tree.
     */
    public void testTreePrint() {
        System.out.println("treePrint");
        
        Tree<Integer> t = new Tree<Integer>(1);
        t.addTree(new Tree<Integer>(2));
        t.addTree(new Tree<Integer>(3));
        
        String expResult = "1\n    2\n    3\n";
        String result = Tree.treePrint(t);
        assertEquals("Error in treePrint", expResult, result);

    }

}
