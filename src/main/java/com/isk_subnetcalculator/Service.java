package com.isk_subnetcalculator;

public class Service {

    static String woj = null;
    static String pow = null;
    static String ulic = null;
    static String param = null;
    static int result = 0;

    static HandlerChooser choser = new HandlerChooser();

    public static void main(String[] args) {

        ulic = "Bieszczada";
        woj = "18";
        pow= "61";
//        ulic = "Brzozowa";
//        woj = "02";
//        pow= "01";
        result = choser.chooser(param, woj, pow, ulic);
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