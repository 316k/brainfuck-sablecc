package bf;

import bf.parser.*;
import bf.lexer.*;
import bf.node.*;
import java.io.*;
 
class Main {
    public static void main(String args[]) {
        try {
            Parser p = 
                new Parser (
                    new Lexer (
                        new PushbackReader(new InputStreamReader(System.in), 1024)));
      
            Start tree = p.parse();

            JSEvaluator.eval(tree);
        } catch(Exception e) {
            System.err.println("Le programme brainfuck entré est invalide");
        }
    }
}
