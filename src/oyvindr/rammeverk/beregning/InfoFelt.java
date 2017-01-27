package oyvindr.rammeverk.beregning;

/**
 * Created by x0xoyr on 27.01.17.
 */
public class InfoFelt {
    String feltType;
    String verdi;


    public InfoFelt(String etypeID, String eVerdi) {
        this.feltType = etypeID;
        this.verdi = eVerdi;
    }


    public String getFeltType() {
        return feltType;
    }

    public void skrivUt (Integer level) {
        System.out.println(String.format("%" + level*5 + "s", "") + ":"  + " feltType:" + feltType + " verdi:" + verdi);
    }
}

