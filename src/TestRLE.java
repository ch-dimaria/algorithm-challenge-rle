/** Semplice test runner senza librerie esterne. */
public class TestRLE {
    private static int eseguiti = 0;
    private static int superati = 0;
    private static final CompressioneRLE rle = new CompressioneRLE();

    private static void verifica(String testo, String atteso) {
        eseguiti++;
        String ottenuto = rle.comprimi(testo);
        String ricostruito = rle.decomprimi(ottenuto);
        boolean ok = ottenuto.equals(atteso) && ricostruito.equals(testo);
        if (ok) superati++;
        else System.err.println("FALLITO: " + testo + " | atteso " + atteso + " | ottenuto " + ottenuto);
    }

    private static void verificaErrore(String testo, boolean decompressione) {
        eseguiti++;
        try {
            if (decompressione) rle.decomprimi(testo);
            else rle.comprimi(testo);
            System.err.println("FALLITO: doveva lanciare IllegalArgumentException: " + testo);
        } catch (IllegalArgumentException atteso) {
            superati++;
        }
    }

    public static void main(String[] args) {
        verifica("", "");
        verifica("A", "1A");
        verifica("AAAA", "4A");
        verifica("ABAB", "1A1B1A1B");
        verifica("AAAABBBCCDAA", "4A3B2C1D2A");
        verifica("AAAAAAAAAAAA", "12A");
        verifica("ZZZZZZZZZZY", "10Z1Y");
        verifica("ABC", "1A1B1C");
        verifica("AABBAA", "2A2B2A");
        verifica("BBBBBBBA", "7B1A");
        verificaErrore("A1", false);
        verificaErrore("abc", false);
        verificaErrore("0A", true);
        verificaErrore("3", true);
        verificaErrore("2a", true);
        verificaErrore("1A2", true);
        verificaErrore("A", true);
        verificaErrore("100001A", true);
        System.out.println("Test superati: " + superati + "/" + eseguiti);
        if (superati != eseguiti) System.exit(1);
    }
}
