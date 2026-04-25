package br.pucsp.compilers;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import org.junit.Test;

public class PortugueseBookScannerTest {
    @Test
    public void tokenizesPortugueseSentence() {
        assertEquals(Arrays.asList(
                "Do",
                "titulo",
                ".",
                "Uma",
                "noite",
                "destas",
                ",",
                "vindo",
                "da",
                "cidade",
                "para",
                "o",
                "Engenho",
                "Novo",
                "."), PortugueseBookScanner.tokenize("Do titulo. Uma noite destas, vindo da cidade para o Engenho Novo."));
    }

    @Test
    public void keepsHyphenatedWords() {
        assertEquals(Arrays.asList("Comprimentou-me", ",", "sentou-se", "."),
                PortugueseBookScanner.tokenize("Comprimentou-me, sentou-se."));
    }
}
