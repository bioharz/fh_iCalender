package controller;

import controller.GetFhDataApi;
import models.fhKufstein.LvData;
import utils.DateUtils;
import utils.ThisLocalizedWeek;

import java.util.List;
import java.util.Locale;

public class MainFhController {

    final ThisLocalizedWeek actualWeek = new ThisLocalizedWeek(Locale.GERMANY);

    public List<LvData> getLvDataThisWeek(String pkz) {
        return GetFhDataApi.getLvData(DateUtils.asDate(actualWeek.getFirstDay()), DateUtils.asDate(actualWeek.getLastDay()), pkz);
    }

    public boolean validatePkz(String pkz){
        return GetFhDataApi.pkzValidator(pkz);
    }


}
