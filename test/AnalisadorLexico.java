
import execucao.Compilador;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Francisco Lucas Sens
 * @author Karin Cristiane Corrêa
 * @author William Lopes da Silva
 */
public class AnalisadorLexico {

    private final Compilador compilador = new Compilador();

    @Test
    public void testeComSucesso01() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("/* isso é um comentário */")
                .append("\nprint i_area =")
                .append("\n\"valor\" 01,0");
        String texto = compilador.compilar(stringBuilder.toString());
        // TODO implementar para fazer o assert
    }

    @Test
    public void testeComErroLexico01() {
        String texto = compilador.compilar("/* isso é um comentário */\n"
                + "print i_area =\n"
                + "\"valor 01,0");
        // TODO implementar para fazer o assert
    }

}
