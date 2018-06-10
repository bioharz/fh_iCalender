package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.fhKufstein.CafeteriaDataList;
import models.fhKufstein.LvData;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class GetFhDataApi {

    protected static final String BASIC_URL = "https://webproxy.fh-kufstein.ac.at";

    protected static final String CAFETERIA_PATH = "cafeteria/getcafeteriadata;";

    private static final String LV_PATH = "infoboard/getrpdata?";

    private static final String PKZ_VALIDATOR = "pkzvalidator";

    protected static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    private static final Gson GSON = new Gson();

    public static CafeteriaDataList getCafetariaData(Date from, Date until) {
        HashMap<String, String> requestField = new HashMap<>();
        requestField.put("Accept", "application/json");
        try {
            String fromString = simpleDateFormat.format(from);
            String untilString = simpleDateFormat.format(until);
            String uriString = BASIC_URL + "/" + CAFETERIA_PATH + "from=" + fromString + ";until=" + untilString;
            CafeteriaDataList cafeteriaDataList = (CafeteriaDataList) callApi(uriString, CafeteriaDataList.class, requestField);
            return cafeteriaDataList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public static List<LvData> getLvData(Date from, Date until, String pkz) {
        HashMap<String, String> requestField = new HashMap<>();
        requestField.put("Accept", "application/json");
        try {
            String fromString = simpleDateFormat.format(from);
            String untilString = simpleDateFormat.format(until);
            String uriString = BASIC_URL + "/" + LV_PATH + "from=" + fromString + "&until=" + untilString + "&pkz=" + pkz;
            Type type = new TypeToken<Collection<LvData>>() {
            }.getType();
            List<LvData> lvDataList = (List<LvData>) callApi(uriString, type, requestField);
            return lvDataList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public static boolean pkzValidator(String pkz) {
        HashMap<String, String> requestField = new HashMap<>();
        requestField.put("Content-Type", "application/x-www-form-urlencoded");
        try {
            String uriString = BASIC_URL + "/" + PKZ_VALIDATOR;
            boolean isValid = postRequestReturnBoolean(uriString, requestField, pkz);
            return isValid;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    private static Object callApi(String uriString, Type expectType, HashMap<String, String> requestField) throws Exception {
        URLConnection urlConnection = urlConnectorGet(uriString, requestField);

        Object expectObject = GSON.fromJson(new InputStreamReader((InputStream) urlConnection.getContent()), expectType);
        return expectObject;
    }

    private static Object callApi(String uriString, Class expectClass, HashMap<String, String> requestField) throws Exception {
        URLConnection urlConnection = urlConnectorGet(uriString, requestField);

        Object expectObject = GSON.fromJson(new InputStreamReader((InputStream) urlConnection.getContent()), expectClass);
        return expectObject;
    }

    private static URLConnection urlConnectorGet(String uriString, HashMap<String, String> requestField) throws Exception {
        URL url = new URL(uriString);
        URLConnection urlConnection = url.openConnection();
        if (requestField != null) {
            requestField.forEach(urlConnection::setRequestProperty);
        }
        urlConnection.connect();
        return urlConnection;
    }


    private static boolean postRequestReturnBoolean(String uriString, HashMap<String, String> requestField, String body) throws Exception {
        URL url = new URL(uriString);
        HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
        urlConnection.setRequestMethod("POST");
        urlConnection.setDoOutput(true);
        urlConnection.setDoOutput(true);
        urlConnection.setUseCaches(false);
        urlConnection.setRequestProperty("Content-Length", String.valueOf(body.length()));

        if (requestField != null) {
            requestField.forEach(urlConnection::setRequestProperty);
        }

        OutputStreamWriter writer = new OutputStreamWriter(urlConnection.getOutputStream());
        writer.write(body);
        writer.flush();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(urlConnection.getInputStream()));

        boolean answer = false;
        for (String line; (line = reader.readLine()) != null; ) {
            if (line.equals("true")) {
                answer = true;
            }
        }

        writer.close();
        reader.close();

        return answer;
    }


}
