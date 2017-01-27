package oyvindr.rammeverk.beregning;

/**
 * Created by x0xoyr on 27.01.17.
 */
public class BankFormue {

    public Gruppe opprettBankFormue () {

        // G2
        Gruppe g2FormueOgKapital = new Gruppe("FormuOgKapital", "na");

        // G3
        Gruppe g3_Bank1 = new Gruppe("Bank", "DnB");
        g3_Bank1.legggTilFelt(new InfoFelt("BankOrgNr", "999999999"));
        g2FormueOgKapital.legggTilUnderGruppe(g3_Bank1);

        Gruppe g3_Bank2 = new Gruppe("Bank", "SpB1");
        g3_Bank2.legggTilFelt(new InfoFelt("BankOrgNr", "777777777"));
        g2FormueOgKapital.legggTilUnderGruppe(g3_Bank2);

        // G4
        Gruppe g4_Konto1 = new Gruppe("KontoNr", "123");
        g4_Konto1.legggTilFelt(new InfoFelt("Renter", "1000"));
        g4_Konto1.legggTilFelt(new InfoFelt("Innskudd", "20000"));
        g3_Bank1.legggTilUnderGruppe(g4_Konto1);

        Gruppe g4_Konto2 = new Gruppe("KontoNr", "987");
        g4_Konto2.legggTilFelt(new InfoFelt("Renter", "22"));
        g4_Konto2.legggTilFelt(new InfoFelt("Innskudd", "220"));
        g3_Bank1.legggTilUnderGruppe(g4_Konto2);


        Gruppe g4_Konto3 = new Gruppe("KontoNr", "666");
        g4_Konto3.legggTilFelt(new InfoFelt("Renter", "66"));
        g4_Konto3.legggTilFelt(new InfoFelt("Innskudd", "666"));
        g3_Bank2.legggTilUnderGruppe(g4_Konto3);

        return g2FormueOgKapital;

    }
}
