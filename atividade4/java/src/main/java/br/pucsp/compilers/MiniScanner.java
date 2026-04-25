package br.pucsp.compilers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MiniScanner {
    private static final Pattern TOKEN_PATTERN = Pattern.compile(
            "([a-zA-Z_][a-zA-Z0-9_]*)|(\\d+)|([=+\\-*])|(\\s+)|(.)");

    private MiniScanner() {
    }

    public static List<LexicalToken> tokenize(String source) {
        List<LexicalToken> tokens = new ArrayList<LexicalToken>();
        Matcher matcher = TOKEN_PATTERN.matcher(source);

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                tokens.add(new LexicalToken("ID", matcher.group(1)));
            } else if (matcher.group(2) != null) {
                tokens.add(new LexicalToken("NUM", matcher.group(2)));
            } else if (matcher.group(3) != null) {
                tokens.add(new LexicalToken("OP", matcher.group(3)));
            } else if (matcher.group(4) != null) {
                continue;
            } else {
                throw new IllegalArgumentException("Caractere inesperado: " + matcher.group(5));
            }
        }

        return tokens;
    }

    public static List<String> dragonBookTokens(String source) {
        Map<String, Integer> symbolTable = new LinkedHashMap<String, Integer>();
        List<String> output = new ArrayList<String>();

        for (LexicalToken token : tokenize(source)) {
            String lexeme = token.getLexeme();

            if ("ID".equals(token.getType())) {
                if (!symbolTable.containsKey(lexeme)) {
                    symbolTable.put(lexeme, symbolTable.size() + 1);
                }
                output.add("<id," + symbolTable.get(lexeme) + ">");
            } else if ("NUM".equals(token.getType())) {
                output.add("<num," + lexeme + ">");
            } else if ("=".equals(lexeme)) {
                output.add("<assign>");
            } else if ("+".equals(lexeme)) {
                output.add("<plus>");
            } else if ("*".equals(lexeme)) {
                output.add("<mult>");
            } else if ("-".equals(lexeme)) {
                output.add("<minus>");
            }
        }

        return output;
    }

    public static void main(String[] args) {
        String source = "position = initial + rate * 60";
        System.out.println("Entrada: " + source);
        System.out.println("Tokens: " + tokenize(source));
        System.out.println("Figura 1.7: " + dragonBookTokens(source));
    }
}
