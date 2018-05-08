package com.isk_subnetcalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Service {

    static String woj = null;
    static String pow = null;
    static String ulic = null;
    static String param = null;
    static int result = 0;

    static HandlerChooser choser = new HandlerChooser();
    static Map<String, String> miasta = new HashMap<>();

    public static void main(String[] args) {

//        ulic = "Bieszczada";
//        woj = "18";
//        pow= "61";
        ulic = "Brzozowa";
        woj = "02";
        pow= "01";
        Vector<Description> streetDescription = choser.chooser(param, woj, pow, ulic);

        miasta = choser.getMiasta();
        for (Map.Entry<String, String> entry : miasta.entrySet()) {
//                for (int i = 0; i < streetDescription.size(); i++){

            for (Description description : streetDescription){
                if(entry.getValue().equals(description.getID_NAME())){
                    //streetDescription.get(i).setID_CITY(entry.getKey());
                }
            }

        }

        for (int i = 0; i < streetDescription.size(); i++){
            System.out.println(streetDescription.get(i));
        }


//        for (Map.Entry<String, String> entry : miasta.entrySet()) {
//            String klucz = charReplacement(entry.getKey());
//            klucz = klucz.substring(0,5).toLowerCase();
//            wojew.put(klucz, entry.getValue());
//        }
//



//        if(woj==null && pow == null) {
//            result = choser.chooser(param, woj, pow, ulic);
//        } else if (woj != null && pow == null){
//            result = choser.chooser(param, woj, pow, ulic);
//        } else if (woj == null && pow != null){
//            result = choser.chooser(param, woj, pow, ulic);
//        } else if (woj != null && pow != null){
//            result = choser.chooser(param, woj, pow, ulic);
//        }
        System.out.println(result);
    }


}