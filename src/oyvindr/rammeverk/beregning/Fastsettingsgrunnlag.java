package oyvindr.rammeverk.beregning;

public class Fastsettingsgrunnlag {

    public static void main(String[] args) {

        OpprettSkattepliktRootGruppe();
    }

    public static void OpprettSkattepliktRootGruppe() {

        Gruppe fastsettingsgrunnlag = new Gruppe("Fastsettingsgrunnlag", "na");
        fastsettingsgrunnlag.legggTilFelt(new InfoFelt("FNR", "02048012345"));

        // Legg til undergruppe g2FormueOgKapital
        Gruppe formueOgKapital = FormueOgKapital.opprettBankFormue();
        fastsettingsgrunnlag.legggTilUnderGruppe(formueOgKapital);

        // Print
        fastsettingsgrunnlag.skrivUtGruppeTre(1);

        // Oprett summert bankgrupper
        Gruppe summertBankGruppe = FormueOgKapital.opprettSummertBankGruppe(formueOgKapital);
        fastsettingsgrunnlag.legggTilUnderGruppe (summertBankGruppe);
        summertBankGruppe.skrivUtGruppeTre(1);
    }
}
