package execucao;

import gerado.LexicalError;
import gerado.Lexico;
import gerado.SemanticError;
import gerado.Semantico;
import gerado.Sintatico;
import gerado.SyntaticError;
import gerado.Token;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Francisco Lucas Sens
 * @author Karin Cristiane Corrêa
 * @author William Lopes da Silva
 */
public class Compilador {

    public String compilar(String texto) {
        Lexico lexico = new Lexico(texto);
        Sintatico sintatico = new Sintatico();
        Semantico semantico = new Semantico();
        try {
            sintatico.parse(lexico, semantico);
            return "programa compilado com sucesso";
        } catch (LexicalError | SyntaticError | SemanticError e) {
            return e.getMessage();
        }
    }

}
