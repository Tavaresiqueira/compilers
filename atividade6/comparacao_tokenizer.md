# Atividade 6 - OpenAI Tokenizer x Tokens de Compilador

Texto usado:

```txt
position = initial + rate * 60
```

## Tokens léxicos do compilador

```txt
<id,1> <assign> <id,2> <plus> <id,3> <mult> <num,60>
```

Tabela:

| Lexema | Tipo |
|---|---|
| `position` | identificador |
| `=` | atribuição |
| `initial` | identificador |
| `+` | operador soma |
| `rate` | identificador |
| `*` | operador multiplicação |
| `60` | número inteiro |

## Tokens de LLM

O tokenizer de um LLM não segue a gramática de C, Java ou outra linguagem de programação. Ele quebra texto em unidades estatísticas, frequentemente subpalavras. Dependendo do vocabulário do modelo, `position` pode aparecer como uma palavra inteira ou ser quebrada em pedaços como `pos` + `ition`.

## Respostas

1. Por que o tokenizer da OpenAI pode quebrar `position` em `pos` + `ition`?

Porque o objetivo é representar texto com um vocabulário estatístico reutilizável. Se subpartes como `pos` e `ition` aparecem com frequência no treinamento, elas podem ser tokens eficientes para o modelo.

2. Qual é a diferença conceitual entre token léxico e token de LLM?

Token léxico é uma unidade da gramática formal de uma linguagem. Token de LLM é uma unidade de codificação textual usada para alimentar uma rede neural.

3. Por que o scanner de compilador precisa ser preciso?

Porque o parser depende dele. Se o scanner confunde identificador, número ou operador, a árvore sintática e a semântica do programa podem ficar incorretas.
