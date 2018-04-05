/*
 * Author: Prof Peterson
 *
 * TokenStream.java
 *
 * Created on November 13, 2007, 9:39 PM
 *
 */

package tree3;
import java.util.ArrayList;
public class TokenStream {
    public ArrayList<Token> tokens;
    public int here;
    public int size;
    public TokenStream() {
        tokens = new ArrayList<Token>();
        here = 0;
        size = 0;
    }
    public void addToken(Token t) {
        tokens.add(size, t);
        size++;
    }
    public Token next() {
        if (here < size) {
            Token res = tokens.get(here);
            here++;
            return res;
        }
        return Token.EOF;
    }
        public Token peek() {
        if (here < size) {
            return tokens.get(here);}
        else return Token.EOF;
    }
    
}
