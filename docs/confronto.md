# Confronto sperimentale e interpretazione

Confrontiamo la rappresentazione originale e quella RLE su tre dataset, tenendo fisso il formato `conteggio+lettera` e l'alfabeto A-Z. Non interpretiamo la misura come dimensione di file in byte.

| Dataset | Originale | RLE | Caratteri prima/dopo | Risparmio |
|---|---|---|---|---|
| Ripetizione lunga | `AAAAAAAAAAAA` | `12A` | 12/3 | 75,00% |
| Ripetizione mista | `AAAABBBCCDAA` | `4A3B2C1D2A` | 12/10 | 16,67% |
| Nessuna ripetizione | `ABC` | `1A1B1C` | 3/6 | -100,00% |

## Conclusione
RLE e' utile quando compaiono molti caratteri consecutivi uguali; con alternanze frequenti puo' espandere il testo. Per dimostrare la correttezza non basta valutare la percentuale: e' fondamentale verificare la ricostruzione perfetta dell'input.

## Possibili domande di interrogazione
1. Perche' l'ultimo gruppo viene emesso dopo il ciclo?
2. Come interpreti `12A` senza ambiguita'?
3. Perche' `ABC` peggiora la dimensione?
4. Quali test controllano la perdita di informazioni?
5. Che cosa cambia se sono permesse anche cifre nell'input?
6. Qual e' la differenza fra misurare caratteri e misurare byte?
