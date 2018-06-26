package gerado;

import execucao.EsquemaTraducao;
import view.MainJFrame;

public class Semantico implements Constants {

    public void executeAction(int action, Token token) throws SemanticError {
        MainJFrame.getEsquemaTraducao().gerar(action, token);
    }
}
