# LAB 1 - Scanner / Analisador Léxico

PUC-SP - Ciência da Computação  
Disciplina: Compiladores  
LAB 1: Scanner, Expressões Regulares e Autômatos Finitos

## Descrição sugerida para o GitHub

Atividades do LAB 1 de Compiladores da PUC-SP: scanner, expressões regulares, autômatos finitos, tokenização em Python e Java.

## Equipe

- João Pedro Siqueira

## Objetivo

Este repositório reúne as evidências e os arquivos das 7 atividades do LAB 1. O foco é demonstrar a primeira fase de um compilador: o analisador léxico, que lê um fluxo de caracteres, agrupa lexemas e produz tokens a partir de regras descritas por expressões regulares e autômatos finitos.

Exemplo-base do livro do Dragão:

```txt
position = initial + rate * 60
```

## Estrutura do repositório

| Atividade | Pasta | Conteúdo |
|---|---|---|
| 1 | `atividade1/` | Script Bash `scanner_simples.sh`, arquivo `exemplo.c` e saída esperada |
| 2 | `atividade2/` | Regex para tokens, e-mail, CEP, CPF, RG e telefone |
| 3 | `atividade3/` | Exercícios de buscar/substituir com regex em C e CSV |
| 4 | `atividade4/` | Mini-scanner em Python e Java com testes unitários |
| 5 | `atividade5/` | Autômatos em arquivos JFLAP `.jff` e descrição das transições |
| 6 | `atividade6/` | Comparação entre tokens de compilador e tokens de LLM |
| 7 | `atividade7/` | Scanner de texto em português em Python e Java usando Dom Casmurro |

O livro escolhido para a Atividade 7 foi **Dom Casmurro**, de Machado de Assis, baixado do Project Gutenberg em UTF-8: <https://www.gutenberg.org/ebooks/55752>. O arquivo original está em `data/dom_casmurro.txt`; a versão usada pelo scanner, sem cabeçalho/rodapé do Gutenberg, está em `data/dom_casmurro_portugues.txt`.

## Como executar

### Atividade 1

Em Linux, WSL2 ou Git Bash:

```bash
cd atividade1
chmod +x scanner_simples.sh
cat exemplo.c | ./scanner_simples.sh
```

### Atividade 4 - Python

```bash
cd atividade4/python
python scanner.py
python -m unittest test_scanner.py
```

### Atividade 4 - Java

Com JDK e Maven instalados:

```bash
cd atividade4/java
mvn test
mvn exec:java -Dexec.mainClass=br.pucsp.compilers.MiniScanner
```

### Atividade 7 - Python

```bash
cd atividade7/python
python portuguese_scanner.py ../../data/dom_casmurro_portugues.txt ../../outputs/dom_casmurro_tokens_python.json
python -m unittest test_portuguese_scanner.py
```

### Atividade 7 - Java

Com JDK e Maven instalados:

```bash
cd atividade7/java
mvn test
mvn exec:java -Dexec.mainClass=br.pucsp.compilers.PortugueseBookScanner -Dexec.args="../../data/dom_casmurro_portugues.txt ../../outputs/dom_casmurro_tokens_java.json"
```

## Evidências de execução

Arquivos já incluídos:

- `outputs/atividade1_saida.txt`
- `outputs/atividade4_python_saida.txt`
- `outputs/atividade7_python_amostra.json`
- `outputs/dom_casmurro_tokens_python.json`

Printscreens que devem ser adicionados antes da entrega final:

- `evidencias/atividade2_regexr.png`
- `evidencias/atividade2_regex101.png`
- `evidencias/atividade4_colab_python.png`
- `evidencias/atividade4_java_ide.png`
- `evidencias/atividade5_jflap_dfa_inteiro.png`
- `evidencias/atividade5_jflap_dfa_identificador.png`
- `evidencias/atividade5_jflap_nfa_operador.png`
- `evidencias/atividade5_fat.png`
- `evidencias/atividade6_openai_tokenizer.png`

## Resumo das respostas conceituais

Um token léxico de compilador é definido pela gramática da linguagem. Por exemplo, `position` é um identificador único porque corresponde à regra `[a-zA-Z_][a-zA-Z0-9_]*`. Já um token de LLM é uma unidade estatística de texto, geralmente gerada por BPE ou técnica semelhante; por isso uma palavra pode ser quebrada em subpalavras conforme o vocabulário do modelo.

O scanner de compilador precisa ser preciso porque sua saída alimenta o analisador sintático. Se o scanner classifica errado um lexema, toda a compilação pode falhar. O tokenizer de LLM não precisa seguir a gramática formal de uma linguagem de programação; ele precisa representar texto de forma eficiente para o modelo.

## Reflexão individual

João Pedro Siqueira: O que há de interessante no analisador léxico é que uma ideia aparentemente simples, ler caracteres, vira uma etapa formal baseada em expressões regulares e autômatos finitos. Isso mostra como compiladores transformam texto em estruturas manipuláveis. O scanner também conecta teoria e prática: as regras de uma linguagem podem ser descritas por regex, implementadas como autômatos finitos e usadas em programas reais para reconhecer tokens com eficiência.
