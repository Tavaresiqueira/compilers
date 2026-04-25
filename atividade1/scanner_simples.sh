#!/usr/bin/env bash

# Simula a leitura de fluxo de caracteres por um analisador lexico.
# Uso: cat exemplo.c | ./scanner_simples.sh
while IFS= read -r linha; do
    limpa=$(printf "%s" "$linha" | tr -d ' \t\r')

    if [ -n "$limpa" ]; then
        echo "[SCANNER] Linha original: '$linha'"
        echo "[SCANNER] Sem espacos/tabs: '$limpa'"
    fi
done
