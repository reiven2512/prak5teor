import com.antlr.ExprLexer;
import com.antlr.ExprParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class TestClass {
    public static void main(String[] args) {
        ExprLexer lexer = new ExprLexer(CharStreams.fromString("hel45 = h + g - 7 + 12"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        ParseTree tree = parser.r();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new ExprWalker(), tree);
    }
}