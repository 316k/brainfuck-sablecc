package bf;

import bf.parser.*;
import bf.lexer.*;
import bf.node.*;
import bf.analysis.*;
import java.util.*;

public class JSEvaluator extends DepthFirstAdapter
{
    /* (static) eval function */
    public static void eval(Node ast) {
        JSEvaluator e = new JSEvaluator();
        ast.apply(e);
    }

    public void inStart(Start node) {
        System.out.println("var val = [];" +
                           "var buffer = '';" +
                           "var pointer = 0;" +
                           "for(var i=0; i<30000; i++) {" +
                           "  val.push(0);" +
                           "}");
    }
    
    public void outAIncInstr(AIncInstr node) {
        System.out.println("val[pointer]++;" +
                           "if(val[pointer] == 128)" +
                           "  val[pointer] = -128;"
            );
    }
    
    public void outADecInstr(ADecInstr node) {
        System.out.println("val[pointer]--;" +
                           "if(val[pointer] == -129)" +
                           "  val[pointer] = 128;"
            );
    }

    public void outALeftInstr(ALeftInstr node) {
        System.out.println("pointer++;" +
                           "pointer %= 30000;");
    }

    public void outARightInstr(ARightInstr node) {
        System.out.println("pointer--;" +
                           "pointer = (pointer + 30000) % 30000;");
    }

    public void outALoopLoop(ALoopLoop node) {
        System.out.println("while(val[pointer] != 0) {");
        node.getProg().apply(this);
        System.out.println("}");
    }

    public void outAPrintInstr(APrintInstr node) {
        System.out.println("write(String.fromCharCode(val[pointer]));");
    }
    
    public void outAReadInstr(AReadInstr node) {
        System.out.println("if(!buffer) {" +
                           "  buffer = readline();" +
                           "  buffer = buffer === undefined ? String.fromCharCode(0) : buffer + '\\n';" +
                           "}" +
                           " write('debug'); " +
                           "val[pointer] = buffer.charCodeAt(0);" +
                           "buffer = buffer.substr(1);");
    }
}
