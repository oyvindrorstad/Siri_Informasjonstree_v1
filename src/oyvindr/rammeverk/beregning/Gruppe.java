package oyvindr.rammeverk.beregning;

import java.util.*;


public class Gruppe {

   // String typeID;
  // String forekomstID;

    GruppeKey gruppeKey;

    Map<String, InfoFelt> felter = new HashMap<String, InfoFelt>();
    Map<GruppeKey, Gruppe> underGrupper = new HashMap<GruppeKey, Gruppe>();


    public Gruppe (String typeID, String forekomstID) {
        gruppeKey = new GruppeKey(typeID, forekomstID);
        this.gruppeKey.typeID = typeID;
        this.gruppeKey.forekomstID = forekomstID;
    }

    public void legggTilUnderGruppe ( Gruppe gruppe) {

        underGrupper.put (gruppe.gruppeKey, gruppe);
    }

    public void legggTilFelt(InfoFelt felt) {
        felter.put(felt.getFeltType(), felt);
    }


    public void skrivUtGruppeTre(Integer level) {
        String prefix = new String(level.toString());
        //prefix.format("%" + level*5 + "s", "prefix");
        System.out.println(String.format("%" + level*5 + "s", level.toString()) + ":"  + " Gruppe:" + gruppeKey.typeID + " forekomstID: " + gruppeKey.forekomstID);


        felter.forEach((k,v)->v.skrivUt(level));
        underGrupper.forEach((k,v)->v.skrivUtGruppeTre(level+1));
    }

    public long SummerOverGruppe(Gruppe gruppe, String typeID) {
        /*
        String result = gruppe.underGrupper.entrySet().stream()
                .filter(map -> typeID.equals(map.getKey()))
                .map(map -> map.getValue())
                .average()
                .getAsDouble();*/
        return 0;
    }

}






