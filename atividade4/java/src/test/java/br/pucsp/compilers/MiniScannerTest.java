package br.pucsp.compilers;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class MiniScannerTest {
    @Test
    public void tokenizesDragonBookExample() {
        List<LexicalToken> tokens = MiniScanner.tokenize("position = initial + rate * 60");

        assertEquals(Arrays.asList(
                new LexicalToken("ID", "position"),
                new LexicalToken("OP", "="),
                new LexicalToken("ID", "initial"),
                new LexicalToken("OP", "+"),
                new LexicalToken("ID", "rate"),
                new LexicalToken("OP", "*"),
                new LexicalToken("NUM", "60")), tokens);
    }

    @Test
    public void printsDragonBookRepresentation() {
        assertEquals(Arrays.asList(
                "<id,1>",
                "<assign>",
                "<id,2>",
                "<plus>",
                "<id,3>",
                "<mult>",
                "<num,60>"), MiniScanner.dragonBookTokens("position = initial + rate * 60"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejectsInvalidCharacter() {
        MiniScanner.tokenize("position @ initial");
    }
}
