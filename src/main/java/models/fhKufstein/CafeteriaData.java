package models.fhKufstein;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CafeteriaData {

    @SerializedName("tag")
    @Expose
    private String tag;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("preis")
    @Expose
    private String preis;
    @SerializedName("symbol")
    @Expose
    private String symbol;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreis() {
        return preis;
    }

    public void setPreis(String preis) {
        this.preis = preis;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
