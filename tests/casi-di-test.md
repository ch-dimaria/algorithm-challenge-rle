# Piano di collaudo: casi attesi e risultati

Il test runner si avvia con `java -cp out TestRLE` dopo la compilazione.

| ID | Input | Output previsto | Obiettivo | Esito verificato |
|---|---|---|---|---|
| T01 | vuoto | vuoto | limite | OK |
| T02 | A | 1A | gruppo singolo | OK |
| T03 | AAAA | 4A | ripetizioni | OK |
| T04 | ABAB | 1A1B1A1B | alternanza | OK |
| T05 | AAAABBBCCDAA | 4A3B2C1D2A | input misto | OK |
| T06 | AAAAAAAAAAAA | 12A | conteggio multi-cifra | OK |
| T07 | ZZZZZZZZZZY | 10Z1Y | cambio dopo 10 caratteri | OK |
| T08 | ABC | 1A1B1C | espansione | OK |
| T09 | AABBAA | 2A2B2A | gruppi separati | OK |
| T10 | BBBBBBBA | 7B1A | fine stringa | OK |
| T11–T12 | A1, abc | eccezione | input non valido | OK |
| T13–T18 | 0A, 3, 2a, 1A2, A, 100001A | eccezione | codice non valido | OK |

Per tutti i casi validi si verifica anche `decomprimi(comprimi(input)) == input`. Test eseguiti: **18/18 superati**.
