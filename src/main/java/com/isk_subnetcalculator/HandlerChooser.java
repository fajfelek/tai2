package com.isk_subnetcalculator;


import java.io.File;
import java.io.IOException;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author filip
 */
public class HandlerChooser {

    /**
     *
     * @param text
     * @return
     */
    public String charReplacement(String text){

        String normNazwa = Normalizer.normalize(text.substring(0, 5),
                Normalizer.Form.NFD);

        normNazwa = normNazwa.replaceAll("[\\p{InCombining"
                + "DiacriticalMarks}]", "").replace("\u0141", "L");


        return normNazwa;
    }

    Map<String, String> wojew = new HashMap<>();
    Map<String, String> wojew2 = new HashMap<>();

    public HandlerChooser(){
        try {

            File stream = new File("src/main/resources/data/ULIC.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            TERChandler userhandler = new TERChandler();
            saxParser.parse(stream, userhandler);

            wojew2 = userhandler.getWojew();

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, String> entry : wojew2.entrySet()) {
            String klucz = charReplacement(entry.getKey());
            klucz = klucz.substring(0,5).toLowerCase();
            wojew.put(klucz, entry.getValue());
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
    public int chooser(String param, String woj, String pow, String ulic){

        try {

            File stream = new File("src/main/resources/data/ULIC.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            return chooser2(param,woj,pow,ulic,saxParser,stream);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    private int chooser2(String param, String woj, String pow,
                         String ulic, SAXParser saxParser, File stream)
            throws SAXException, IOException
    {
        System.out.println("CHOOSER2");
        System.out.println(param + " + " + woj + " + " + pow + " + " + ulic);

        // <WOJ>
        if (param == null && woj != null && pow == null && ulic != null){
            XmlHandler1 userhandler = new XmlHandler1(woj, ulic);
            saxParser.parse(stream, userhandler);
            return userhandler.getCounter();
        }
        // <WOJ/POW>
        if (param == null && woj != null && pow != null && ulic != null){
            XmlHandler2 userhandler = new XmlHandler2(woj, pow, ulic);
            saxParser.parse(stream, userhandler);

            int counter = userhandler.getCounter();
            Vector<Description> descriptionVector = userhandler.getStreetDescription();
            for(int i = 0; i < counter; i++){
                System.out.println(descriptionVector.get(i));
            }

            return userhandler.getCounter();
        }
        // <ulica>
        if (param == null && woj == null && pow == null && ulic != null){
            XmlHandler3 userhandler = new XmlHandler3(ulic);
            saxParser.parse(stream, userhandler);
            return userhandler.getCounter();
        }
        return 0;
    }

}
