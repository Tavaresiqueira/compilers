# Atividade 2 - Expressões Regulares

Texto-base:

```txt
position = initial + rate * 60
```

## Tokens do exemplo

| Token | Regex | Exemplos reconhecidos |
|---|---|---|
| Identificador | `[a-zA-Z_][a-zA-Z0-9_]*` | `position`, `initial`, `rate` |
| Número inteiro | `\d+` | `60` |
| Operador | `[=+\-*]` | `=`, `+`, `*` |
| Espaço ignorado | `\s+` | espaços e quebras de linha |

Regex única para capturar os tokens do exemplo:

```regex
[a-zA-Z_][a-zA-Z0-9_]*|\d+|[=+\-*]
```

Resultado esperado com flag global:

```txt
position
=
initial
+
rate
*
60
```

## Padrões adicionais

| Dado | Regex |
|---|---|
| E-mail | `[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}` |
| CEP | `\d{5}-?\d{3}` |
| CPF | `\d{3}\.?\d{3}\.?\d{3}-?\d{2}` |
| RG | `\d{1,2}\.?\d{3}\.?\d{3}-?[0-9Xx]` |
| Telefone BR | `(?:\+55\s?)?(?:\(?\d{2}\)?\s?)?\d{4,5}-?\d{4}` |

## Explicação curta

As expressões regulares definem conjuntos de lexemas aceitos por cada tipo de token. Um scanner usa essas regras para percorrer o fluxo de caracteres e decidir quando uma unidade significativa termina. No exemplo do livro, identificadores, operadores e números já são suficientes para gerar a sequência de tokens da expressão.
