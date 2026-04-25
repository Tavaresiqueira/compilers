package br.pucsp.compilers;

import java.util.Objects;

public final class LexicalToken {
    private final String type;
    private final String lexeme;

    public LexicalToken(String type, String lexeme) {
        this.type = type;
        this.lexeme = lexeme;
    }

    public String getType() {
        return type;
    }

    public String getLexeme() {
        return lexeme;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LexicalToken)) {
            return false;
        }
        LexicalToken that = (LexicalToken) other;
        return Objects.equals(type, that.type) && Objects.equals(lexeme, that.lexeme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, lexeme);
    }

    @Override
    public String toString() {
        return "(" + type + ", " + lexeme + ")";
    }
}
