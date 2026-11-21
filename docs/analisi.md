# Analisi algoritmica: RLE

## Obiettivo
Ridurre la ripetizione consecutiva di lettere maiuscole con coppie `conteggio+lettera`, conservando la possibilita' di ricostruire il testo originale.

## Traccia manuale
Input: `AAAABBBCCDAA`.

| Gruppo appena letto | Decisione | Output progressivo |
|---|---|---|
| `AAAA` | La lettera cambia da A a B: emetti `4A` | `4A` |
| `BBB` | La lettera cambia da B a C: emetti `3B` | `4A3B` |
| `CC` | La lettera cambia da C a D: emetti `2C` | `4A3B2C` |
| `D` | La lettera cambia da D ad A: emetti `1D` | `4A3B2C1D` |
| `AA` | Fine stringa: emetti l'ultimo gruppo `2A` | `4A3B2C1D2A` |

## Proprietà da verificare
Ogni prefisso gia' elaborato e' rappresentato dalle coppie gia' emesse e dal gruppo corrente ancora da emettere. Alla fine, l'ultimo gruppo e' emesso esplicitamente.

Il decoder interpreta ciascuna coppia come un numero positivo seguito da una lettera maiuscola. Per ogni input valido, `decomprimi(comprimi(testo))` deve essere identico a `testo`.

## Casi critici
- Stringa vuota: non esiste alcun gruppo.
- Gruppo di lunghezza >= 10: il conteggio contiene piu' cifre.
- Caratteri tutti diversi: il risultato puo' essere piu' lungo dell'originale.
- Stessa lettera, ma gruppi non adiacenti: i gruppi non si uniscono (es. `AABBAA`).
- Dati invalidi: caratteri non compresi fra A e Z devono essere rifiutati.

## Complessita' e limiti
La compressione analizza una volta il testo di lunghezza n. Il lavoro e' proporzionale a n, a parita' di formato e modello di costo. `StringBuilder` evita la ricostruzione ripetuta di stringhe immutabili. La decompressione richiede lavoro proporzionale al numero di caratteri ricostruiti; usare solo la lunghezza del codice compresso sarebbe fuorviante.
