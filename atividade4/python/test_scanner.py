import unittest

from scanner import dragon_book_tokens, tokenize


class ScannerTest(unittest.TestCase):
    def test_tokenize_exemplo_livro(self):
        self.assertEqual(
            tokenize("position = initial + rate * 60"),
            [
                ("ID", "position"),
                ("OP", "="),
                ("ID", "initial"),
                ("OP", "+"),
                ("ID", "rate"),
                ("OP", "*"),
                ("NUM", "60"),
            ],
        )

    def test_dragon_book_tokens(self):
        self.assertEqual(
            dragon_book_tokens("position = initial + rate * 60"),
            ["<id,1>", "<assign>", "<id,2>", "<plus>", "<id,3>", "<mult>", "<num,60>"],
        )

    def test_invalid_character(self):
        with self.assertRaises(ValueError):
            tokenize("position @ initial")


if __name__ == "__main__":
    unittest.main()
