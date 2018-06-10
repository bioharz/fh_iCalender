import controller.MainFhController;
import models.fhKufstein.LvData;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        MainFhController fhController = new MainFhController();

        String pkz = "1510653032";
        List<LvData> lvDataList = new ArrayList<>();
        boolean pkzIsValid = false;

        try {
            pkzIsValid = fhController.validatePkz(pkz);
            lvDataList = fhController.getLvDataThisWeek(pkz);
        } catch (Exception e) {
            e.fillInStackTrace();
        }

        System.out.println("PKZ("+pkz+") is valid: " + pkzIsValid);

        for (LvData lvData : lvDataList
                ) {
            String response = lvData.getDate() + ", " + lvData.getStartTime() + " - " + lvData.getEndTime() +
                    ", " + lvData.getCourseName() + ", " + lvData.getLecturer();
            System.out.println(response);
        }
    }
}
