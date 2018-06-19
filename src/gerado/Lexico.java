package gerado;

public class Lexico implements Constants {

    private int position;
    private String input;
    private int start;

    public Lexico() {
        this("");
    }

    public Lexico(String input) {
        setInput(input);
    }

    public void setInput(String input) {
        this.input = input;
        setPosition(0);
    }

    public String getInput() {
        return input;
    }

    public void setPosition(int pos) {
        position = pos;
    }

    public Token nextToken() throws LexicalError {
        if (!hasInput()) {
            return null;
        }

        start = position;

        int state = 0;
        int lastState = 0;
        int endState = -1;
        int end = -1;

        while (hasInput()) {
            lastState = state;
            state = nextState(nextChar(), state);

            if (state < 0) {
                break;
            } else {
                if (tokenForState(state) >= 0) {
                    endState = state;
                    end = position;
                }
            }
        }

        if (endState < 0 || (endState != state && tokenForState(lastState) == -2)) {
            /* TODO aqui foi alterado para poder resgatar o número da linha e o caractere com erro */
            if ((lastState == 19) || (lastState == 4) || (lastState == 0)) {
                throw new LexicalError(retornarTextoErroLinha(start) + input.substring(start, position) + " " + SCANNER_ERROR[lastState], start);
            }
            throw new LexicalError(retornarTextoErroLinha(start) + SCANNER_ERROR[lastState], start);
        }

        position = end;

        int token = tokenForState(endState);

        if (token == 0) {
            return nextToken();
        } else {
            String lexeme = input.substring(start, end);
            token = lookupToken(token, lexeme);
            return new Token(token, lexeme, start);
        }
    }

    private int nextState(char c, int state) {
        int start = SCANNER_TABLE_INDEXES[state];
        int end = SCANNER_TABLE_INDEXES[state + 1] - 1;

        while (start <= end) {
            int half = (start + end) / 2;

            if (SCANNER_TABLE[half][0] == c) {
                return SCANNER_TABLE[half][1];
            } else if (SCANNER_TABLE[half][0] < c) {
                start = half + 1;
            } else //(SCANNER_TABLE[half][0] > c)
            {
                end = half - 1;
            }
        }

        return -1;
    }

    private int tokenForState(int state) {
        if (state < 0 || state >= TOKEN_STATE.length) {
            return -1;
        }

        return TOKEN_STATE[state];
    }

    public int lookupToken(int base, String key) {
        int start = SPECIAL_CASES_INDEXES[base];
        int end = SPECIAL_CASES_INDEXES[base + 1] - 1;

        while (start <= end) {
            int half = (start + end) / 2;
            int comp = SPECIAL_CASES_KEYS[half].compareTo(key);

            if (comp == 0) {
                return SPECIAL_CASES_VALUES[half];
            } else if (comp < 0) {
                start = half + 1;
            } else //(comp > 0)
            {
                end = half - 1;
            }
        }

        return base;
    }

    private boolean hasInput() {
        return position < input.length();
    }

    private char nextChar() {
        if (hasInput()) {
            return input.charAt(position++);
        } else {
            return (char) -1;
        }
    }

    private String retornarTextoErroLinha(int start) {
        return "Erro na linha " + retornarLinha(start) + " - ";
    }

    public int getStart() {
        return start;
    }

    public int retornarLinha(int inicio) {
        String[] linhas = input.split("\n");
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
