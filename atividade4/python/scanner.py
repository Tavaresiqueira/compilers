import re
import sys
from dataclasses import dataclass
from typing import Iterable, List, Tuple
from urllib.request import urlopen

try:
    import requests
except ImportError:  # Mantem o exemplo executavel mesmo sem dependencia externa.
    requests = None


@dataclass(frozen=True)
class Token:
    tipo: str
    lexema: str


TOKEN_REGEX = re.compile(
    r"(?P<ID>[a-zA-Z_][a-zA-Z0-9_]*)"
    r"|(?P<NUM>\d+)"
    r"|(?P<OP>[=+\-*])"
    r"|(?P<WS>\s+)"
    r"|(?P<ERRO>.)"
)

EMAIL_REGEX = re.compile(r"[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}")


def tokenize(texto: str) -> List[Tuple[str, str]]:
    """Retorna tokens no formato (tipo, lexema), ignorando espacos."""
    tokens: List[Tuple[str, str]] = []

    for match in TOKEN_REGEX.finditer(texto):
        tipo = match.lastgroup
        lexema = match.group()

        if tipo == "WS":
            continue
        if tipo == "ERRO":
            raise ValueError(f"Caractere inesperado: {lexema!r}")

        tokens.append((tipo, lexema))

    return tokens


def dragon_book_tokens(texto: str) -> List[str]:
    """Gera uma representacao parecida com a Figura 1.7 do livro do Dragao."""
    symbol_table = {}
    output = []

    for tipo, lexema in tokenize(texto):
        if tipo == "ID":
            if lexema not in symbol_table:
                symbol_table[lexema] = len(symbol_table) + 1
            output.append(f"<id,{symbol_table[lexema]}>")
        elif tipo == "NUM":
            output.append(f"<num,{lexema}>")
        elif lexema == "=":
            output.append("<assign>")
        elif lexema == "+":
            output.append("<plus>")
        elif lexema == "*":
            output.append("<mult>")
        elif lexema == "-":
            output.append("<minus>")

    return output


def extract_emails_from_url(url: str) -> List[str]:
    """Le uma pagina web textual e extrai e-mails por regexp."""
    if requests is not None:
        conteudo = requests.get(url, timeout=10).text
    else:
        with urlopen(url, timeout=10) as response:
            conteudo = response.read().decode("utf-8", errors="ignore")

    return sorted(set(EMAIL_REGEX.findall(conteudo)))


def main(argv: Iterable[str]) -> int:
    codigo = "position = initial + rate * 60"
    print("Entrada:", codigo)
    print("Tokens:", tokenize(codigo))
    print("Figura 1.7:", dragon_book_tokens(codigo))
    return 0


if __name__ == "__main__":
    raise SystemExit(main(sys.argv[1:]))
