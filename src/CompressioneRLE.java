/**
 * Esempio didattico: compressione RLE per stringhe contenenti solo A-Z.
 * Formato codificato: una o piu' cifre decimali, seguite da una lettera.
 * Esempio: AAAABB -> 4A2B.
 */
public class CompressioneRLE {
    private static final int MAX_CARATTERI = 100000;

    public String comprimi(String testo) {
        controllaTesto(testo);
        if (testo.length() == 0) {
            return "";
        }
        StringBuilder risultato = new StringBuilder();
        char corrente = testo.charAt(0);
        int ripetizioni = 1;

        for (int i = 1; i < testo.length(); i++) {
            char successivo = testo.charAt(i);
            if (successivo == corrente) {
                ripetizioni++;
            } else {
                risultato.append(ripetizioni).append(corrente);
                corrente = successivo;
                ripetizioni = 1;
            }
        }
        risultato.append(ripetizioni).append(corrente);
        return risultato.toString();
    }

    public String decomprimi(String codice) {
        if (codice == null) {
            throw new IllegalArgumentException("Il codice non puo' essere null.");
        }
        StringBuilder risultato = new StringBuilder();
        int i = 0;
        while (i < codice.length()) {
            if (!(codice.charAt(i) >= '0' && codice.charAt(i) <= '9')) {
                throw new IllegalArgumentException("E' atteso un conteggio in posizione " + i);
            }
            int ripetizioni = 0;
            while (i < codice.length() && (codice.charAt(i) >= '0' && codice.charAt(i) <= '9')) {
                int cifra = codice.charAt(i) - '0';
                if (ripetizioni > (MAX_CARATTERI - cifra) / 10) {
                    throw new IllegalArgumentException("Conteggio troppo grande.");
                }
                ripetizioni = ripetizioni * 10 + cifra;
                i++;
            }
            if (ripetizioni <= 0 || i >= codice.length()) {
                throw new IllegalArgumentException("Conteggio nullo o lettera mancante.");
            }
            char lettera = codice.charAt(i++);
            if (lettera < 'A' || lettera > 'Z') {
                throw new IllegalArgumentException("Sono permesse solo lettere A-Z.");
            }
            if (ripetizioni > MAX_CARATTERI - risultato.length()) {
                throw new IllegalArgumentException("Risultato decompresso troppo grande.");
            }
            for (int k = 0; k < ripetizioni; k++) {
                risultato.append(lettera);
            }
        }
        return risultato.toString();
    }

    private void controllaTesto(String testo) {
        if (testo == null || testo.length() > MAX_CARATTERI) {
            throw new IllegalArgumentException("Testo assente o troppo lungo.");
        }
        for (int i = 0; i < testo.length(); i++) {
            char c = testo.charAt(i);
            if (c < 'A' || c > 'Z') {
                throw new IllegalArgumentException("Sono permesse solo lettere maiuscole A-Z.");
            }
        }
    }
}
