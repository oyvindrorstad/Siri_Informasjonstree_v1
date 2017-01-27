package oyvindr.rammeverk.beregning;

import java.util.*;


public class Gruppe {

    String typeID;
    String forekomstID;

    Map<String, InfoFelt> felter = new HashMap<String, InfoFelt>();
    Map<String, Gruppe> underGrupper = new HashMap<String, Gruppe>();


    public Gruppe (String etypeID, String forekomstID) {

        this.typeID = etypeID;
        this.forekomstID = forekomstID;
    }

    public void legggTilUnderGruppe ( Gruppe gruppe) {

        underGrupper.put (gruppe.getForekomstID(), gruppe);
    }

    public void legggTilFelt(InfoFelt felt) {
        felter.put(felt.getFeltType(), felt);
    }

    public String getForekomstID() {
        return forekomstID;
    }

    public String getEtypeID() {
        return typeID;
    }

    public void skrivUtGruppeTre(Integer level) {
        String prefix = new String(level.toString());
        //prefix.format("%" + level*5 + "s", "prefix");
        System.out.println(String.format("%" + level*5 + "s", level.toString()) + ":"  + " Gruppe:" + typeID + " forekomstID: " + forekomstID);


        felter.forEach((k,v)->v.skrivUt(level));
        underGrupper.forEach((k,v)->v.skrivUtGruppeTre(level+1));
    }


}






