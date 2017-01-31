package oyvindr.rammeverk.beregning;

/**
 * Created by x0xoyr on 27.01.17.
 */
public class FormueOgKapital {

    public static Gruppe opprettBankFormue () {

        // G2
        Gruppe gFormueOgKapital = new Gruppe("FormuOgKapital", "1");

        // G3
        Gruppe gBank1 = new Gruppe("Bank", "DnB");
        gBank1.legggTilFelt(new InfoFelt("BankOrgNr", "999999999"));
        gFormueOgKapital.legggTilUnderGruppe(gBank1);

        Gruppe gBank2 = new Gruppe("Bank", "SpB1");
        gBank2.legggTilFelt(new InfoFelt("BankOrgNr", "777777777"));
        gFormueOgKapital.legggTilUnderGruppe(gBank2);

        // G4
        Gruppe gKonto1 = new Gruppe("KontoNr", "123");
        gKonto1.legggTilFelt(new InfoFelt("Renter", "1000"));
        gKonto1.legggTilFelt(new InfoFelt("Innskudd", "20000"));
        gBank1.legggTilUnderGruppe(gKonto1);

        Gruppe gKonto2 = new Gruppe("KontoNr", "987");
        gKonto2.legggTilFelt(new InfoFelt("Renter", "22"));
        gKonto2.legggTilFelt(new InfoFelt("Innskudd", "220"));
        gBank1.legggTilUnderGruppe(gKonto2);


        Gruppe gKonto3 = new Gruppe("KontoNr", "666");
        gKonto3.legggTilFelt(new InfoFelt("Renter", "66"));
        gKonto3.legggTilFelt(new InfoFelt("Innskudd", "666"));
        gBank2.legggTilUnderGruppe(gKonto3);

        return gFormueOgKapital;
    }

    public static Gruppe opprettSummertBankGruppe (Gruppe formueOgKapitalGruppe) {
        /* Opprett summert bankgruppe fra
        SPESIFIKASJON:
        For hver unik forekomst av source::FORMUEOGKAPITAL:BANK identifisert ved :BANK.Navn
            opprett target::SUMBANK identifisert ved :BANK.Navn
            Mapp:
                SUMBANK.bankensnavn = BANK.navn;
                SUMBANK.bankensorgnr = BANK.bankensorgnr;

            Aggregering:
                SUMBANK.rentesum = SUM OVER (BANK.KONTO.renter);
        */
        Gruppe sumBank = new Gruppe(("OppsummeringBanker"), "na");

        // IKKE KOMPLETT:::::::::::::::::......................
        formueOgKapitalGruppe.underGrupper.entrySet().stream()
                .filter(s -> s.getKey().getTypeID().equals("Bank"))
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach: " + s));

        return sumBank;
    }
}
