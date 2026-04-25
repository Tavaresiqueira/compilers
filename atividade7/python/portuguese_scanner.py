import json
import re
import sys
from pathlib import Path
from typing import Iterable, List


TOKEN_REGEX = re.compile(
    r"[A-Za-zÀ-ÖØ-öø-ÿ]+(?:[-'][A-Za-zÀ-ÖØ-öø-ÿ]+)*"
    r"|\d+(?:[.,]\d+)?"
    r"|[.,;:!?()\[\]\"'“”‘’«»—-]",
    re.UNICODE,
)


def tokenize(texto: str) -> List[str]:
    """Quebra texto em portugues em palavras, numeros e pontuacao."""
    return TOKEN_REGEX.findall(texto)


def main(argv: Iterable[str]) -> int:
    args = list(argv)
    if len(args) != 2:
        print("Uso: python portuguese_scanner.py <entrada.txt> <saida.json>")
        return 2

    input_path = Path(args[0])
    output_path = Path(args[1])
    text = input_path.read_text(encoding="utf-8", errors="ignore")
    tokens = tokenize(text)

    output_path.parent.mkdir(parents=True, exist_ok=True)
    output_path.write_text(
        json.dumps(tokens, ensure_ascii=False, indent=2),
        encoding="utf-8",
    )

    print(f"Tokens gerados: {len(tokens)}")
    print(f"Saida: {output_path}")
    print("Amostra:", tokens[:50])
    return 0


if __name__ == "__main__":
    raise SystemExit(main(sys.argv[1:]))
