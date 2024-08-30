package za.ac.cput.novacinemaapp.factory;
    /*TheatreFactory.java
Entity for Theatre factory
Author: Daanyaal Isaacs (220094934)
Date: 17 May
 */
import za.ac.cput.novacinemaapp.domain.Cinema;
import za.ac.cput.novacinemaapp.domain.Theatre;
import za.ac.cput.novacinemaapp.util.Helper;

public class TheatreFactory {
    public static Theatre buildTheatre(String theatreType, Cinema cinema){
        if(Helper.isNullOrEmpty(theatreType) || Helper.isNullOrEmpty(cinema))
            return null;
        return new Theatre.Builder().setTheatreType(theatreType).setCinema(cinema).build();
    }
}