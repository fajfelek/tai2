package com.isk_subnetcalculator;

public class Description {

        private String WOJ = null;
        private String POW = null;
        private String GMI = null;
        private String RODZ = null;
        private String ID_CITY = null;
        private String ID_NAME = null;
        private String CECH = null;
        private String NAME = null;

        public Description(String woj, String pow, String gmi, String rodz, String id_city, String id_name,
                           String cech, String name){
            this.WOJ = woj;
            this.POW = pow;
            this.GMI = gmi;
            this.RODZ = rodz;
            this.ID_CITY = id_city;
            this.ID_NAME = id_name;
            this.CECH = cech;
            this.NAME = name;
        }

        @Override
        public String toString() {
            return "Description{" +
                    "WOJ='" + WOJ + '\'' +
                    ", POW='" + POW + '\'' +
                    ", GMI='" + GMI + '\'' +
                    ", RODZ='" + RODZ + '\'' +
                    ", ID_CITY='" + ID_CITY + '\'' +
                    ", ID_NAME='" + ID_NAME + '\'' +
                    ", CECH='" + CECH + '\'' +
                    ", NAME='" + NAME + '\'' +
                    '}';
        }

}
