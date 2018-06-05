package execucao;

import analisadorLexico.LexicalError;
import analisadorLexico.Lexico;
import analisadorLexico.Token;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Francisco Lucas Sens
 * @author Karin Cristiane Corrêa
 * @author William Lopes da Silva
 */
public class Compilador {

    private static Map<Integer, String> classes;

    static {
        classes = new HashMap<>();
        classes.put(2, "identificador");
        classes.put(3, "constante inteira");
        classes.put(4, "constante real");
        classes.put(5, "constante caractere");
        for (int i = 6; i <= 26; i++) {
            classes.put(i, "palavra reservada");
        }
        for (int i = 27; i <= 44; i++) {
            classes.put(i, "símbolo especial");
        }
    }

    public String compilar(String texto) {
        Lexico lexico = new Lexico(texto);
        StringBuilder sb = new StringBuilder();
        try {
            Token token;

            sb.append("linha\t\tclasse\t\t\tlexema\n");
            while ((token = lexico.nextToken()) != null) {
                sb.append(lexico.retornarLinha(lexico.getStart())).append("\t\t")
                        .append(getClasse(token.getId())).append("\t\t\t")
                        .append(token.getLexeme()).append("\n");
            }
            sb.append("programa compilado com sucesso");
        } catch (LexicalError e) {
            return e.getMessage();
        }

        return sb.toString();
    }

    public String getClasse(int lexema) {
        return classes.get(lexema);
    }

}
