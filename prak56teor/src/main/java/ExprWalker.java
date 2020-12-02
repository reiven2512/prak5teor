import com.antlr.ExprBaseListener;
import com.antlr.ExprParser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ExprWalker extends ExprBaseListener {
    public void enterR(ExprParser.RContext ctx ) {
        for(ParseTree tree:ctx.children){
            System.out.printf("%-20s",tree.getText());
            if (tree instanceof TerminalNode) {
                TerminalNode node = (TerminalNode)tree;
                Token symbol = node.getSymbol();
                switch (symbol.getType()){
                    case ExprParser.ID:
                        System.out.printf("%-20s","Идентификатор");
                        break;
                    case ExprParser.Dig:
                        System.out.printf("%-20s","Число");
                        break;
                    case ExprParser.Act:
                        System.out.printf("%-20s",getWord(tree.getText().charAt(0)));
                        break;
                    default:
                        System.out.printf("%-20s","Знак присваивания");
                        break;
                }
                System.out.println();
            }
        }
    }

    public static String getWord(char c){
        switch (c){
            case '+': return "Знак операции 'сложение'";
            case '-': return "Знак операции 'вычитание'";
            case '/': return "Знак операции 'деление'";
            case '*': return "Знак операции 'умножение'";
            case '(': return "Открывающая скобка";
            case ')': return "Закрывающая скобка";
        }
        return "";
    }
}