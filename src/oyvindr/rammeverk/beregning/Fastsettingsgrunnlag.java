package oyvindr.rammeverk.beregning;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Fastsettingsgrunnlag {

    public static void main(String[] args) {

        InfoTre.test();
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
