package oyvindr.rammeverk.beregning;

public class Main {

    public static void main(String[] args) {

        OpprettSkattepliktRootGruppe();
    }

    public static void OpprettSkattepliktRootGruppe() {

        Gruppe Fastsettingsgrunnlag = new Gruppe("Fastsettingsgrunnlag", "na");
        Fastsettingsgrunnlag.legggTilFelt(new InfoFelt("Fastsettingsgrunnlag", "02048012345"));


        BankFormue bankFormue = new BankFormue();
        Fastsettingsgrunnlag.legggTilUnderGruppe(bankFormue.opprettBankFormue());


        // Print
        Fastsettingsgrunnlag.skrivUtGruppeTre(1);


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
