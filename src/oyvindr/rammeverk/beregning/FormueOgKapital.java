package oyvindr.rammeverk.beregning;

/**
 * Created by x0xoyr on 27.01.17.
 */
public class FormueOgKapital {

    public Gruppe opprettBankFormue (Gruppe mother) {

        // G2
        Gruppe gFormueOgKapital = new Gruppe("FormuOgKapital", "1");
        mother.legggTilUnderGruppe(gFormueOgKapital);

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
}
