import unittest

from portuguese_scanner import tokenize


class PortugueseScannerTest(unittest.TestCase):
    def test_tokenize_portuguese_sentence(self):
        self.assertEqual(
            tokenize("Do titulo. Uma noite destas, vindo da cidade para o Engenho Novo."),
            [
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
                ".",
            ],
        )

    def test_keeps_hyphenated_words(self):
        self.assertEqual(tokenize("Comprimentou-me, sentou-se."), ["Comprimentou-me", ",", "sentou-se", "."])

    def test_numbers_with_comma(self):
        self.assertEqual(tokenize("O valor foi 1499,90."), ["O", "valor", "foi", "1499,90", "."])


if __name__ == "__main__":
    unittest.main()
