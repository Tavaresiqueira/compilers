package br.pucsp.compilers;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PortugueseBookScanner {
    private static final Pattern TOKEN_PATTERN = Pattern.compile(
            "[A-Za-zÀ-ÖØ-öø-ÿ]+(?:[-'][A-Za-zÀ-ÖØ-öø-ÿ]+)*"
                    + "|\\d+(?:[.,]\\d+)?"
                    + "|[.,;:!?()\\[\\]\"'“”‘’«»—-]");

    private PortugueseBookScanner() {
    }

    public static List<String> tokenize(String text) {
        List<String> tokens = new ArrayList<String>();
        Matcher matcher = TOKEN_PATTERN.matcher(text);

        while (matcher.find()) {
            tokens.add(matcher.group());
        }

        return tokens;
    }

    public static void writeJson(List<String> tokens, String outputPath) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputPath), StandardCharsets.UTF_8);
        try {
            writer.write("[\n");
            for (int i = 0; i < tokens.size(); i++) {
                writer.write("  \"");
                writer.write(escapeJson(tokens.get(i)));
                writer.write("\"");
                if (i < tokens.size() - 1) {
                    writer.write(",");
                }
                writer.write("\n");
            }
            writer.write("]\n");
        } finally {
            writer.close();
        }
    }

    private static String escapeJson(String value) {
        return value.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Uso: java PortugueseBookScanner <entrada.txt> <saida.json>");
            return;
        }

        String text = new String(Files.readAllBytes(Paths.get(args[0])), StandardCharsets.UTF_8);
        List<String> tokens = tokenize(text);
        writeJson(tokens, args[1]);

        System.out.println("Tokens gerados: " + tokens.size());
        System.out.println("Saida: " + args[1]);
        System.out.println("Amostra: " + tokens.subList(0, Math.min(50, tokens.size())));
    }
}
