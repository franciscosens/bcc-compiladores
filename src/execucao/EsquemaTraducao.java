package execucao;

import gerado.SemanticError;
import gerado.Token;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;

/**
 * @author Francisco
 */
public class EsquemaTraducao {

    private static final Stack<String> pilhaTipos = new Stack<>();
    private static StringBuilder codigo = new StringBuilder();
    private static String operador = "";
    private static Token token;
    private static final String FLOAT64 = "float64", INT64 = "int64", BOOLEAN = "bool";
    private static String tipoVariavel = "";
    private static Hashtable<String, String> ts = new Hashtable<>();
    private static ArrayList<String> listaId = new ArrayList<>();
    private static Stack<String> pilhaRotulos = new Stack<>();
    private static int contadorRotulo = 0;

    public EsquemaTraducao() {
    }

    public String obterCodigo() {
        return codigo.toString();
    }

    public void limparTudo() {
        contadorRotulo = 0;
        pilhaTipos.clear();
        pilhaRotulos.clear();
        listaId.clear();
        ts.clear();
        codigo = new StringBuilder();
        operador = "";
    }

    public static void gerar(int acao, Token token) throws SemanticError {
        EsquemaTraducao.token = token;
        switch (acao) {
            case 1:
                acao01();
                break;
            case 2:
                acao02();
                break;
            case 3:
                acao03();
                break;
            case 4:
                acao04();
                break;
            case 5:
                acao05();
                break;
            case 6:
                acao06();
                break;
            case 7:
                acao07();
                break;
            case 8:
                acao08();
                break;
            case 9:
                acao09();
                break;
            case 10:
                acao10();
                break;
            case 11:
                acao11();
                break;
            case 12:
                acao12();
                break;
            case 13:
                acao13();
                break;
            case 14:
                acao14();
                break;
            case 15:
                acao15();
                break;
            case 16:
                acao16();
                break;
            case 17:
                acao17();
                break;
            case 18:
                acao18();
                break;
            case 19:
                acao19();
                break;
            case 20:
                acao20();
                break;
            case 21:
                acao21();
                break;
            case 22:
                acao22();
                break;
            case 23:
                acao23();
                break;
            case 24:
                acao24();
                break;
            case 25:
                acao25();
                break;
            case 26:
                acao26();
                break;
            case 27:
                acao27();
                break;
            case 28:
                acao28();
                break;
            case 29:
                acao29();
                break;
            case 30:
                acao30();
                break;
            case 31:
                acao31();
                break;
        }
    }

    private static void acao01() {
        String tipo1 = pilhaTipos.pop();
        String tipo2 = pilhaTipos.pop();
        // TODO validar string e bool
        if (tipo1.equals(FLOAT64) || tipo2.equals(FLOAT64)) {
            pilhaTipos.push(FLOAT64);
        } else {
            pilhaTipos.push(INT64);
        }
        codigo.append("\t\tadd\n");
    }

    private static void acao02() {
        String tipo1 = pilhaTipos.pop();
        String tipo2 = pilhaTipos.pop();
        // TODO validar string e bool
        if (tipo1.equals(FLOAT64) || tipo2.equals(FLOAT64)) {
            pilhaTipos.push(FLOAT64);
        } else {
            pilhaTipos.push(INT64);
        }
        codigo.append("\t\tsub\n");
    }

    private static void acao03() {
        String tipo1 = pilhaTipos.pop();
        String tipo2 = pilhaTipos.pop();
        // TODO validar string e bool
        if (tipo1.equals(FLOAT64) || tipo2.equals(FLOAT64)) {
            pilhaTipos.push(FLOAT64);
        } else {
            pilhaTipos.push(INT64);
        }
        codigo.append("\t\tmul\n");
    }

    private static void acao04() throws SemanticError {
        String tipo1 = pilhaTipos.pop();
        String tipo2 = pilhaTipos.pop();
        // TODO validar string e bool
        if (tipo1.equals(tipo2)) {
            pilhaTipos.push(tipo1);
        } else {
            throw new SemanticError("ERRO semântico, parar");
        }
        codigo.append("\t\tdiv\n");
    }

    private static void acao05() {
        pilhaTipos.push(INT64);
        codigo.append("\t\tldc.i8 ").append(token.getLexeme()).append("\n");
        codigo.append("\t\tconv.r8\n");
    }

    private static void acao06() {
        pilhaTipos.push(FLOAT64);
        codigo.append("\t\tldc.r8 ").append(token.getLexeme().replace(",", ".")).append("\n");
    }

    private static void acao07() throws SemanticError {
        String tipo = pilhaTipos.pop();
        if (tipo.equals(FLOAT64) || tipo.equals(INT64)) {
            pilhaTipos.push(tipo);
        } else {
            throw new SemanticError("tipo incompatível em operação aritmética unária");
        }
    }

    private static void acao08() throws SemanticError {
        String tipo = pilhaTipos.pop();
        if (tipo.equals(FLOAT64) || tipo.equals(INT64)) {
            pilhaTipos.push(tipo);
        } else {
            throw new SemanticError("tipo incompatível em operação aritmética unária");
        }
        codigo.append("\t\tldc.i8 -1\n");
        codigo.append("\t\t").append(tipo.equals(INT64) ? "\t\tconv.r8\n" : "").append("\t\tmul\n");
    }

    private static void acao09() {
        operador = token.getLexeme();
    }

    private static void acao10() throws SemanticError {
        String tipo1 = pilhaTipos.pop();
        String tipo2 = pilhaTipos.pop();
        if (tipo1.equals(tipo2)) {
            pilhaTipos.push(BOOLEAN);
        } else if (!((tipo1.equals(INT64) || tipo1.equals(FLOAT64)) && (tipo2.equals(INT64) || tipo2.equals(FLOAT64)))) {
            throw new SemanticError("tipos incompatíveis em operação relacional");
        }
        codigo.append("\t\t");
        switch (operador) {
            case ">":
                codigo.append("cgt\n");
                break;
            case "<":
                codigo.append("clt\n");
                break;
            case "=":
                codigo.append("ceq\n");
                break;
        }
    }

    private static void acao11() {
        pilhaTipos.push(BOOLEAN);
        codigo.append("\t\tldc.i4.1\n");
    }

    private static void acao12() {
        pilhaTipos.push(BOOLEAN);
        codigo.append("\t\tldc.i4.0\n");
    }

    private static void acao13() throws SemanticError {
        String tipo = pilhaTipos.pop();
        if (tipo.equals(BOOLEAN)) {
            pilhaTipos.push(BOOLEAN);
        } else {
            throw new SemanticError("tipo incompatível em operação lógica unária");
        }
        codigo.append("\t\tldc.i4.1\n");
        codigo.append("\t\txor\n");
    }

    private static void acao14() {
        String tipo = pilhaTipos.pop();
        if (tipo.equals(INT64)) {
            codigo.append("\t\tconv.i8\n");
        } else if (tipo.equals(FLOAT64)) {
            codigo.append("");
        } else {
            codigo.append("\t\tldstr ").append(token.getLexeme()).append("\n");
        }
        codigo.append("\t\tcall void [mscorlib]System.Console::Write(").append(tipo).append(")\n");
    }

    private static void acao15() {
        codigo.append(".assembly extern mscorlib {}\n.assembly _codigo_objeto{}\n.module _codigo_objeto.exe\n\n.class public _UNICA{\n\t.method static public void _principal() {\n\t\t.entrypoint\n");
    }

    private static void acao16() {
        codigo.append("\t\tret\n\t}\n}\n");
    }

    private static void acao17() {
        String tipo = pilhaTipos.pop();
        if (tipo.equals(INT64)) {
            codigo.append("\t\tconv.i8\n");
        } else if (tipo.equals(FLOAT64)) {
            codigo.append("");
        } else {
            codigo.append("\t\tldstr \"\\n\"\n");
        }

        codigo.append("\t\tcall void [mscorlib]System.Console::Write(").append(tipo).append(")\n");
    }

    private static void acao18() {
        codigo.append("\t\tand\n");
    }

    private static void acao19() {
        codigo.append("\t\tor\n");
    }

    private static void acao20() {
        pilhaTipos.push("string");

    }

    private static void acao21() {
        switch (token.getLexeme()) {
            case "int":
                tipoVariavel = INT64;
                break;
            case "float":
                tipoVariavel = FLOAT64;
                break;
            case "str":
                tipoVariavel = "string";
                break;
            case "bool":
                tipoVariavel = "bool";
                break;

        }
    }

    private static void acao22() {
        listaId.add(token.getLexeme());
    }

    private static void acao23() throws SemanticError {
        for (String id : listaId) {
            if (ts.containsKey(id)) {
                throw new SemanticError("identificador já declarado");
            }
            ts.put(id, tipoVariavel);
            codigo.append("\t\t.locals(").append(tipoVariavel).append(" ").append(id).append(")\n");
        }
        listaId.clear();
    }

    private static void acao24() throws SemanticError {
        for (String id : listaId) {
            if (!ts.containsKey(id)) {
                throw new SemanticError("identificador não declarado");
            }
            String tipoId = ts.get(id);
            String classe = "";
            switch (tipoId) {
                case INT64:
                    classe = "Int64";
                    break;
                case FLOAT64:
                    classe = "Double";
                    break;
            }
            codigo.append("\t\tcall string [mscorlib]System.Console::ReadLine()\n");
            codigo.append("\t\tcall ").append(tipoId).append(" [mscorlib]System.").append(classe).append("::Parse(string)\n");
            codigo.append("\t\tstloc ").append(id).append("\n");
        }
        listaId.clear();
    }

    private static void acao25() throws SemanticError {
        String id = token.getLexeme();
        if (!ts.containsKey(id)) {
            throw new SemanticError("identificador não declarado");
        }
        String tipoId = ts.get(id);
        pilhaTipos.push(tipoId);
        codigo.append("\t\tldloc ").append(id).append("\n");
        if (tipoId.equals(INT64)) {
            codigo.append("\t\tconv.r8\n");
        }
    }

    private static void acao26() throws SemanticError {
        String id = listaId.remove(0);
        if (!ts.containsKey(id)) {
            throw new SemanticError("identificador não declarado");
        }
        String tipoId = ts.get(id);
        String tipoExp = pilhaTipos.pop();
        if (!tipoId.equals(tipoExp)) {
            throw new SemanticError("tipo incompatível em comando de atribuição");
        }
        if (tipoId.equals(FLOAT64)) {
            codigo.append("\t\tconv.i8\n");
        }
        codigo.append("\t\tstloc ").append(id).append("\n");
    }

    private static void acao27() {
        pilhaRotulos.add("label" + ++contadorRotulo);
        codigo.append("\t\tlabel").append(contadorRotulo).append(":\n");

    }

    private static void acao28() {

        if (token.getLexeme().equals("ifTrue")) {
            pilhaRotulos.add("label" + ++contadorRotulo);
            codigo.append("\t\tbrfalse label").append(contadorRotulo).append("\n");
        }
        if (token.getLexeme().equals("ifFalse")) {
            pilhaRotulos.add("label" + ++contadorRotulo);
            codigo.append("\t\tbrtrue label").append(contadorRotulo).append("\n");
        } else if (token.getLexeme().equals("whileTrue")) {
            pilhaRotulos.add("label" + ++contadorRotulo);
            codigo.append("\t\tbrfalse label").append(contadorRotulo).append("\n");
        } else if (token.getLexeme().equals("whileFalse")) {
            pilhaRotulos.add("label" + ++contadorRotulo);
            codigo.append("\t\tbrtrue label").append(contadorRotulo).append("\n");
        }
    }

    private static void acao29() {
        codigo.append("\t\t").append(pilhaRotulos.pop()).append(":\n");
    }

    private static void acao30() {
        String texto = "label" + ++contadorRotulo;
        gerar(texto, pilhaRotulos.pop());
        pilhaRotulos.add(texto);
    }

    private static void gerar(String auxiliar01, String auxiliar02) {
        codigo.append("\t\tbr ").append(auxiliar01).append("\n");
        codigo.append("\t\t").append(auxiliar02).append(":\n");
    }

    private static void acao31() {
        String ultimo = pilhaRotulos.pop();
        gerar(pilhaRotulos.pop(), ultimo);
    }

}
