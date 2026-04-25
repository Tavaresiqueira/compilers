# Atividade 3 - Buscar/Substituir com Regex

## C: remover comentários

Arquivo de entrada: `exemplo_com_comentarios.c`

Regex para remover comentário de linha:

```regex
//.*
```

Regex para remover bloco `/* ... */` em modo dotall/multiline:

```regex
/\*[\s\S]*?\*/
```

## C: substituir `=` por `:=`

Para substituir atribuições simples sem alterar `==`, `>=`, `<=` ou `!=`:

```regex
(?<![!<>=])=(?!=)
```

Substituição:

```txt
:=
```

## CSV: limpar dados

Entrada: `csv/oferta_exemplo.csv`

Remover espaços extras ao redor de separadores:

```regex
\s*,\s*
```

Substituir por:

```txt
,
```

Converter CSV para TSV:

```regex
,
```

Substituir por tabulação:

```txt
\t
```

## Conexão com scanner

Essas operações são parecidas com uma etapa léxico-textual: percorremos um fluxo de caracteres, reconhecemos padrões por regex e transformamos ou removemos lexemas conforme uma regra.
