package models.fhKufstein;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CafeteriaDataList {

    @SerializedName("cafeteriaData")
    @Expose
    private List<CafeteriaData> cafeteriaData = null;

    public List<CafeteriaData> getCafeteriaData() {
        return cafeteriaData;
    }

    public void setCafeteriaData(List<CafeteriaData> cafeteriaData) {
        this.cafeteriaData = cafeteriaData;
    }

}
