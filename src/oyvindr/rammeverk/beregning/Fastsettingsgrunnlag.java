package oyvindr.rammeverk.beregning;

public class Fastsettingsgrunnlag {

    public static void main(String[] args) {

        OpprettSkattepliktRootGruppe();
    }

    public static void OpprettSkattepliktRootGruppe() {

        Gruppe fastsettingsgrunnlag = new Gruppe("Fastsettingsgrunnlag", "na");
        fastsettingsgrunnlag.legggTilFelt(new InfoFelt("Fastsettingsgrunnlag", "02048012345"));

        // Legg til undergruppe g2FormueOgKapital
        FormueOgKapital bankFormue = new FormueOgKapital ();
        bankFormue.opprettBankFormue(fastsettingsgrunnlag);

        // Print
        fastsettingsgrunnlag.skrivUtGruppeTre(1);


        /* Opprett summert bankgruppe fra
        SPESIFIKASJON:
        For hver unik forekomst av source:FASTSETTINGSGRUNNLAG:FORMUEOGKAPITAL:BANK identifisert ved :BANK.OrgNr
            opprett target:SKATTEGRUNNLAG:SUMBANK identifisert ved :bankensorgnr
            Mapp:
                SUMBANK.bankensnavn = BANK.navn;
                SUMBANK.bankensorgnr = BANK.navn;

            Aggregering:
                SUMBANK.rentesum = SUM OVER (BANK.KONTO.renter);

        */
        Gruppe sumBank = new Gruppe(("OppsummeringBanker"), "na");
        //Fastsettingsgrunnlag.


    }
}
