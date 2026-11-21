/** Un oggetto che raccoglie l'input, l'output e le misure di una prova. */
public class RisultatoCompressione {
    private final String originale;
    private final String compresso;
    private final boolean ricostruzioneCorretta;

    public RisultatoCompressione(String originale, String compresso, String ricostruito) {
        this.originale = originale;
        this.compresso = compresso;
        this.ricostruzioneCorretta = originale.equals(ricostruito);
    }

    public int getLunghezzaOriginale() { return originale.length(); }
    public int getLunghezzaCompressa() { return compresso.length(); }
    public boolean isRicostruzioneCorretta() { return ricostruzioneCorretta; }

    /** Il dato qui e' il numero di caratteri, NON lo spazio in byte. */
    public double getRisparmioPercentuale() {
        if (originale.length() == 0) return 0.0;
        return 100.0 * (originale.length() - compresso.length()) / originale.length();
    }

    @Override
    public String toString() {
        return "originale=" + originale + " | compresso=" + compresso
                + " | caratteri " + getLunghezzaOriginale() + " -> " + getLunghezzaCompressa()
                + " | risparmio=" + String.format(java.util.Locale.ROOT, "%.2f", getRisparmioPercentuale())
                + "% | decodifica OK=" + ricostruzioneCorretta;
    }
}
