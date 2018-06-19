package execucao;

import gerado.SemanticError;
import java.util.Stack;

/**
 * @author Francisco
 */
public class EsquemaTraducao {

    private Stack<String> pilhaTipos = new Stack<>();
    private StringBuilder codigo = new StringBuilder();
    private String operador = "";

    public void gerar(int acao) throws SemanticError {
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
        }
    }

    public void acao01() {
        String tipo1 = pilhaTipos.pop();
        String tipo2 = pilhaTipos.pop();
        // TODO validar string e bool
        if (tipo1.equals("float64") || tipo2.equals("float64")) {
            pilhaTipos.push("float64");
        } else {
            pilhaTipos.push("int64");
        }
        codigo.append("add\n");
    }

    public void acao02() {
        String tipo1 = pilhaTipos.pop();
        String tipo2 = pilhaTipos.pop();
        // TODO validar string e bool
        if (tipo1.equals("float64") || tipo2.equals("float64")) {
            pilhaTipos.push("float64");
        } else {
            pilhaTipos.push("int64");
        }
        codigo.append("add\n");
    }

    public void acao03() {
        String tipo1 = pilhaTipos.pop();
        String tipo2 = pilhaTipos.pop();
        // TODO validar string e bool
        if (tipo1.equals("float64") || tipo2.equals("float64")) {
            pilhaTipos.push("float64");
        } else {
            pilhaTipos.push("int64");
        }
        codigo.append("mul\n");
    }

    public void acao04() throws SemanticError {
        String tipo1 = pilhaTipos.pop();
        String tipo2 = pilhaTipos.pop();
        // TODO validar string e bool
        if (tipo1.equals(tipo2)) {
            pilhaTipos.push(tipo1);
        } else {
            throw new SemanticError("ERRO semântico, parar");
        }
        codigo.append("div\n");
    }

    public void acao05() {
        pilhaTipos.push("int64");
        //codigo.append("ldc.i8 ").append(token.getLexeme()).append("\n");
        codigo.append("conv.r8\n");
    }

    public void acao06() {
        pilhaTipos.push("float64\n");
        //  codigo.append("ldc.r8 ").append(token.getLexeme()).append("\n");
    }

    public void acao07() throws SemanticError {
        String tipo = pilhaTipos.pop();
        if (tipo.equals("float64") || tipo.equals("int64")) {
            pilhaTipos.push(tipo);
        } else {
            throw new SemanticError("ERRO semântico, parar");
        }
    }

    public void acao08() throws SemanticError {
        String tipo = pilhaTipos.pop();
        if (tipo.equals("float64") || tipo.equals("int64")) {
            pilhaTipos.push(tipo);
        } else {
            throw new SemanticError("ERRO semântico, parar");
        }
        codigo.append("ldc.i8 -1\n");
        codigo.append(tipo.equals("int64") ? "conv.r8\n" : "mul\n");
    }

    public void acao09() {
        //    operador = token.getLexeme();
    }

    public void acao10() throws SemanticError {
        String tipo1 = pilhaTipos.pop();
        String tipo2 = pilhaTipos.pop();
        if (tipo1.equals(tipo2)) {
            pilhaTipos.push("bool");
        } else {
            throw new SemanticError("ERRO semântico, parar");
        }

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

    public void acao11() {
        pilhaTipos.push("bool");
        codigo.append("ldc.i4.1\n");
    }

    public void acao12() {
        pilhaTipos.push("bool");
        codigo.append("ldc.i4.0\n");
    }

    public void acao13() throws SemanticError {
        String tipo = pilhaTipos.pop();
        if (tipo.equals("bool")) {
            pilhaTipos.push("bool");
        } else {
            throw new SemanticError("ERRO semântico, parar");
        }
        pilhaTipos.push("ldc.i4.1");
        codigo.append("xor\n");
    }

    public void acao14() {
        String tipo = pilhaTipos.pop();
        if (tipo.equals("int64")) {
            codigo.append("conv.i8\n");
        }
        codigo.append("call void [mscorlib]System.Console::Write(").append(tipo).append(")\n");
    }

    public void acao15() {
        codigo.append(".assembly extern mscorlib {}\n .assembly _codigo_objeto{}\n .module _codigo_objeto.exe\n .class public _UNICA{\n .method static public void _principal() {\n .entrypoint\n");
    }

    public void acao16() {
        codigo.append("ret\n}\n}\n");
    }

    public void acao17() {
    }

    public void acao18() {
    }

    public void acao19() {
    }

    public void acao20() {
    }

    // Código para gerar o método do Switch
    public static void main(String[] args) {
        System.out.println("switch(acao){");
        for (int i = 0; i < 20; i++) {
            System.out.println("case " + (i + 1) + ": ");
            System.out.println("acao" + (((i + 1) < 10) ? "0" : "") + (i + 1) + "();");
            System.out.println("break;");
        }
        System.out.println("}\n}");
        for (int i = 0; i < 20; i++) {
            System.out.println("public void acao" + (((i + 1) < 10) ? "0" : "") + (i + 1) + "(){");
            System.out.println("}");
        }
    }
}
