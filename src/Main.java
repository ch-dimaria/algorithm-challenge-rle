import java.util.Scanner;

/** Programma da terminale: mostra la compressione e verifica la decodifica. */
public class Main {
    public static void main(String[] args) {
        CompressioneRLE algoritmo = new CompressioneRLE();
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Algorithm Challenge - esempio RLE");
        System.out.println("Inserisci lettere maiuscole A-Z (Invio = esempio predefinito):");
        String input = tastiera.nextLine();
        if (input.length() == 0) input = "AAAABBBCCDAA";
        try {
            String codice = algoritmo.comprimi(input);
            String ricostruito = algoritmo.decomprimi(codice);
            RisultatoCompressione prova = new RisultatoCompressione(input, codice, ricostruito);
            System.out.println(prova);
            if (!prova.isRicostruzioneCorretta()) {
                throw new IllegalStateException("Errore: il testo ricostruito e' diverso dall'originale.");
            }
        } catch (IllegalArgumentException errore) {
            System.err.println("Input non valido: " + errore.getMessage());
        }
    }
}
