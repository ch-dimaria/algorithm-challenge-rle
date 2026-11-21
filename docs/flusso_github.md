# Workflow GitHub: esempio di organizzazione

La seguente e' una proposta di processo, **non** la cronologia realmente eseguita per questo archivio.

1. Il gruppo crea il repository remoto e assegna a tutti l'accesso.
2. Apre issue per: specifica del formato, compressione, decompressione, test, documentazione.
3. Clona il repository su ogni computer tramite IntelliJ IDEA.
4. Lavora su branch descrittivi (`feature/compressione`, `feature/decoder`, `test/casi-limite`).
5. Ogni modifica significativa viene salvata con commit e sincronizzata (`push`).
6. Per integrare il lavoro in `main`, si apre una pull request e la si fa revisionare.
7. Prima di fondere le modifiche, si eseguono i test.
8. I membri aggiornano la propria copia locale (`pull`), rifanno i test e verificano la versione finale.
9. La consegna su Moodle consiste nel link al repository e nel riferimento al commit finale richiesto.

Ogni studente deve comprendere l'intero progetto, non soltanto i file su cui ha lavorato.
