# Atividade 5 - Autômatos Finitos

Arquivos criados para abrir no JFLAP:

- `dfa_inteiro.jff`: reconhece números inteiros com um ou mais dígitos.
- `dfa_identificador.jff`: reconhece identificadores no formato `[a-zA-Z_][a-zA-Z0-9_]*`.
- `nfa_operador_igual.jff`: reconhece `=` e `==`, mostrando a ambiguidade resolvida pelo maior casamento no scanner.

## Transições principais

### Número inteiro

| Estado | Entrada | Próximo |
|---|---|---|
| q0 | dígito | q1 |
| q1 | dígito | q1 |

Estado final: q1.

### Identificador

| Estado | Entrada | Próximo |
|---|---|---|
| q0 | letra ou `_` | q1 |
| q1 | letra, dígito ou `_` | q1 |

Estado final: q1.

### Operador `=` e `==`

| Estado | Entrada | Próximo |
|---|---|---|
| q0 | `=` | q1 |
| q1 | `=` | q2 |

Estados finais: q1 e q2.

## Evidências

Adicionar prints em `evidencias/`:

- `atividade5_jflap_dfa_inteiro.png`
- `atividade5_jflap_dfa_identificador.png`
- `atividade5_jflap_nfa_operador.png`
- `atividade5_fat.png`
