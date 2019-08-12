package org.sofyan.myktm.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PrintUtil {

    private PrintUtil() {}

    public static String prettyPrintJson(Object jsonObj) {

        try {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.toJson( jsonObj );

        }catch (Exception e) {
            e.printStackTrace();
        }

        return "Not a valid JSON";

    }

}
