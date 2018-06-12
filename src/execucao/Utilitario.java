package execucao;


/**
 * @author Francisco Lucas Sens
 * @author Karin Cristiane Corrêa
 * @author William Lopes da Silva
 */
public class Utilitario {

    public static String retornarTextoErroLinha(int start, String textoParaAnalise) {
        return "Erro na linha " + retornarLinha(start, textoParaAnalise) + " - ";
    }

    /**
     *
     * @param inicio
     * @param textoParaAnalise
     * @return a posição da linha no texto
     */
    private static int retornarLinha(int inicio, String textoParaAnalise) {
        String[] linhas = textoParaAnalise.split("\n");
        int auxiliar = 0;
        for (int i = 0; i < linhas.length; auxiliar++, i++) {
            String linha = linhas[i];
            auxiliar += linha.length();
            if (inicio <= auxiliar) {
                return i + 1;
            }
        }
        return -1;
    }
}
