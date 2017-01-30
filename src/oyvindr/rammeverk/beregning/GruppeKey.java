package oyvindr.rammeverk.beregning;

/**
 * Created by oyvin on 30.01.2017.
 */
public class GruppeKey {
    String typeID;
    String forekomstID;

    public GruppeKey(String typeID, String forekomstID) {
        this.typeID = typeID;
        this.forekomstID = forekomstID;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GruppeKey)) return false;

        GruppeKey gruppeKey = (GruppeKey) o;

        if (!getTypeID().equals(gruppeKey.getTypeID())) return false;
        return forekomstID.equals(gruppeKey.forekomstID);
    }

    @Override
    public int hashCode() {
        int result = getTypeID().hashCode();
        result = 31 * result + forekomstID.hashCode();
        return result;
    }
}
