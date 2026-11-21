# Algorithm Challenge — esempio metodologico RLE

**IIS Europa Unita · 4C INFO · Prof. Christian Di Maria**

Questo è un esempio completo e indipendente per imparare **come progettare, implementare, verificare e documentare** un algoritmo. Il Run-Length Encoding (RLE) **non appartiene** alle tre famiglie assegnate ai sei gruppi (Scheduling, Cache Replacement, Pattern Matching).

## Cosa studiare

1. [Analisi del problema](docs/analisi.md)
2. [Progettazione Java e OOP](docs/progettazione.md)
3. [Codice sorgente Java](src/)
4. [Casi di test e risultati attesi](tests/casi-di-test.md)
5. [Confronto sperimentale e limiti](docs/confronto.md)
6. [Flusso GitHub in un gruppo](docs/flusso_github.md)
7. [Sorgente LaTeX della dispensa](latex/Esempio_Metodologico_RLE.tex)

La dispensa PDF è disponibile anche tra gli allegati del Compito Moodle. Il repository contiene il materiale sorgente per ristamparla.

## Algoritmo RLE

L'algoritmo codifica una sequenza di lettere uguali indicando **quante sono** e **quale lettera** compongono il gruppo:

| Originale | Codificato |
|---|---|
| `AAAABBBCCDAA` | `4A3B2C1D2A` |
| `AAAAAAAAAAAA` | `12A` |
| `ABC` | `1A1B1C` |

La dimostrazione accetta solo lettere maiuscole `A`–`Z`, fino a 100.000 caratteri. Il testo vuoto è ammesso. Il codice decodificato deve ricostruire **esattamente** il testo originale; non si tratta di una compressione generica dei file.

La compressione **non garantisce** una stringa più corta: con `ABC`, ad esempio, si passa da 3 a 6 caratteri. Le misure confrontano caratteri, non byte.

## Struttura

- `src/CompressioneRLE.java`: compressione, decompressione e validazione;
- `src/RisultatoCompressione.java`: oggetto risultato e statistiche;
- `src/Main.java`: interfaccia console con `Scanner`;
- `src/TestRLE.java`: 18 test automatici senza dipendenze esterne;
- `tests/casi-di-test.md`: dati e oracoli di test;
- `docs/`: analisi, progettazione, confronto e collaborazione.

Non sono presenti librerie che implementino RLE al posto nostro.

## Compilare ed eseguire

È sufficiente un JDK con `javac` e `java`. Dalla cartella del repository:

```bash
javac -encoding UTF-8 -d out src/*.java
java -cp out Main
java -cp out TestRLE
```

Output atteso: **`Test superati: 18/18`**.

Per IntelliJ IDEA: aprire la cartella del repository come progetto, impostare il JDK ed eseguire `Main.main()` o `TestRLE.main()`.

## Cosa verificare

- Tracciare a mano un input e confrontarlo con il programma.
- Dimostrare su esempi che `decomprimi(comprimi(testo)).equals(testo)`.
- Verificare input vuoti, conteggi a due cifre, dati non ammessi e rappresentazioni più lunghe.
- Spiegare quando RLE è vantaggioso e quando è svantaggioso.
- Distinguere il funzionamento dell'algoritmo dall'organizzazione del progetto Java.

## Rapporto con il vostro compito

Ogni gruppo realizza **due algoritmi assegnati**, in un unico repository, e consegna su Moodle **solo il link GitHub**. Tutti e tre i componenti devono saper spiegare entrambi gli algoritmi, i test e tutto il codice. Il voto finale è composto da **40% progetto comune e 60% interrogazione individuale**.

Questa demo è un **modello metodologico, non una soluzione da copiare né un terzo algoritmo da consegnare**.

## Licenza

Codice e documentazione in [MIT](LICENSE). La possibilità di riuso non sostituisce il lavoro originale richiesto dalla Algorithm Challenge.
