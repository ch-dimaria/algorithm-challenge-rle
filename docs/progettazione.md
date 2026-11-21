# Progettazione orientata agli oggetti

`CompressioneRLE` possiede la logica della strategia e la verifica degli input. `RisultatoCompressione` conserva i dati di una prova, espone le lunghezze e il risparmio percentuale e ridefinisce `toString()` per una rappresentazione leggibile. `Main` si occupa esclusivamente dell'interazione con l'utente. `TestRLE` gestisce i controlli indipendenti.

Questa separazione evita che input, algoritmo, report e test finiscano tutti nel metodo `main`. La classe `CompressioneRLE` non conserva stato modificabile fra due esecuzioni: questo rende piu' facili i test ripetuti.

**Nota sull'ereditarieta':** non introdurla soltanto per soddisfare un vincolo grafico. Qui viene mostrato un solo algoritmo, quindi `extends` non aggiungerebbe una generalizzazione naturale. Il progetto assegnato agli studenti comprende due strategie per gruppo e richiede invece di valutare una relazione di ereditarieta' significativa.
