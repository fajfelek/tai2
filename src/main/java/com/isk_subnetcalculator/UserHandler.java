package com.isk_subnetcalculator;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.Statement;
import java.util.ArrayList;

public class UserHandler extends DefaultHandler {

    boolean wojFlag = false;
    boolean powFlag = false;
    boolean gmiFlag = false;
    boolean cechFlag = false;
    boolean nameFlag = false;

    Statement statement;
    public ArrayList<Integer> arrayWoj = new ArrayList();
    public ArrayList<Integer> arrayPow = new ArrayList();
    public ArrayList<Integer> arrayGmi = new ArrayList();
    public ArrayList<String> arrayCech = new ArrayList();
    public ArrayList<String> arrayName = new ArrayList();

    int a = 0;

    String woj;
    String name;
    String pow;
    String gmi;
    String cech;


    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("WOJ")) {
            wojFlag = true;
        }
        if (qName.equalsIgnoreCase("POW")) {
            powFlag = true;
        }
        if (qName.equalsIgnoreCase("GMI")) {
            gmiFlag = true;
        }
        if (qName.equalsIgnoreCase("CECHA")) {
            cechFlag = true;
        }
        if (qName.equalsIgnoreCase("NAZWA_1")) {
            nameFlag = true;
        }
    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {

//        if (qName.equalsIgnoreCase("WOJ")) {
//            wojFlag = false;
//        }
//        if (qName.equalsIgnoreCase("POW")) {
//            powFlag = false;
//        }
//        if (qName.equalsIgnoreCase("GMI")) {
//            gmiFlag = false;
//        }
//        if (qName.equalsIgnoreCase("CECHA")) {
//            cechFlag = false;
//        }
//        if (qName.equalsIgnoreCase("NAZWA_1")) {
//            nameFlag = false;
//        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (wojFlag) {
            woj = new String(ch, start, length);
            wojFlag = false;
        }
        if (powFlag) {
            pow = new String(ch, start, length);
            powFlag = false;
        }
        if (gmiFlag) {
            gmi = new String(ch, start, length);
            gmiFlag = false;
        }
        if (cechFlag) {
            cech = new String(ch, start, length);
            cechFlag = false;
        }
        if (nameFlag) {
            name = new String(ch, start, length);

            arrayWoj.add(Integer.parseInt(woj));
            arrayPow.add(Integer.parseInt(pow));
            arrayGmi.add(Integer.parseInt(gmi));
            arrayCech.add(cech);
            arrayName.add(name);

            //System.out.println(++a + "      " + woj + " " + pow + " " + gmi + " " + cech + " " + name);

            nameFlag = false;
        }

    }
}
