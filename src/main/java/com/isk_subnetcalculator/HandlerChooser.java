package com.isk_subnetcalculator;


import java.io.File;
import java.nio.file.NoSuchFileException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author filip
 */
public class HandlerChooser {

    Map<String, String> wojew = new HashMap<>();
    Map<String, String> miasta = new HashMap<>();

    public Map<String, String> getWojew() {
        return wojew;
    }

    public Map<String, String> getMiasta() {
        return miasta;
    }

    private void createWojewMap(){
        wojew.put("Dolnośląskie", "02");
        wojew.put("Kujawsko-Pomorskie", "04");
        wojew.put("Lubelskie", "06");
        wojew.put("Lubuskie", "08");
        wojew.put("Łódzkie", "10");
        wojew.put("Małopolskie", "12");
        wojew.put("Mazowieckie", "14");
        wojew.put("Opolskie", "16");
        wojew.put("Podkarpackie", "18");
        wojew.put("Podlaskie", "20");
        wojew.put("Pomorskie", "22");
        wojew.put("Śląskie", "24");
        wojew.put("Świętokrzyskie", "26");
        wojew.put("Warmińsko-Mazurskie", "28");
        wojew.put("Wielkopolskie", "30");
        wojew.put("Zachodniopomorskie", "32");

    }

    public HandlerChooser() {

// wypisanie hashMap
//            for(Map.Entry<String, String> entry : wojew.entrySet()) {
//                String key = entry.getKey();
//                String value = entry.getValue();
//                System.out.println(key + " + " + value);
//            }
        try {
            File stream = new File("src/main/resources/data/TERC.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            TERChandler userhandler = new TERChandler();
            saxParser.parse(stream, userhandler);

            wojew = userhandler.getWojew();

        } catch (NoSuchFileException fe) {
            System.err.println("Nie znaleziono pliku TERC.xml");
        } catch (Exception e) {
            System.err.println("Błąd parsera TERC");
        }

        try {
            File stream = new File("src/main/resources/data/SIMC.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SIMChandler userhandler = new SIMChandler();
            saxParser.parse(stream, userhandler);

            miasta = userhandler.getMiasta();

        } catch (NoSuchFileException fe) {
            System.err.println("Nie znaleziono pliku SIMC.xml");
        } catch (Exception e) {
            System.err.println("Błąd parsera SIMC");
        }
    }
    /**
     *
     * @param param
     * @param woj
     * @param pow
     * @param ulic
     * @return
     */
//    public int chooser(String param, String woj, String pow, String ulic){
//
//        try {
//
//            File stream = new File("src/main/resources/data/ULIC.xml");
//            SAXParserFactory factory = SAXParserFactory.newInstance();
//            SAXParser saxParser = factory.newSAXParser();
//
//            return chooser2(param,woj,pow,ulic,saxParser,stream);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }

    public Vector<Description> chooser(String param, String woj, String pow, String ulic) {

        try {
            File stream = new File("src/main/resources/data/ULIC.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();


        System.out.println(param + " + " + woj + " + " + pow + " + " + ulic);

        // <WOJ>
        if (param == null && woj != null && pow == null && ulic != null){
            XmlHandler1 userhandler = new XmlHandler1(woj, ulic);
            saxParser.parse(stream, userhandler);
            //return userhandler.getCounter();
        }
        // <WOJ/POW>
        if (param == null && woj != null && pow != null && ulic != null){
            XmlHandler2 userhandler = new XmlHandler2(woj, pow, ulic);
            saxParser.parse(stream, userhandler);

            int counter = userhandler.getCounter();
            Vector<Description> descriptionVector = userhandler.getStreetDescription();
//            for(int i = 0; i < counter; i++){
//                System.out.println(descriptionVector.get(i));
//            }

            return userhandler.getStreetDescription();
        }
        // <ulica>
        if (param == null && woj == null && pow == null && ulic != null){
            XmlHandler3 userhandler = new XmlHandler3(ulic);
            saxParser.parse(stream, userhandler);
            //return userhandler.getCounter();
        }
        } catch (Exception e){

        }
        return null;
    }

}
