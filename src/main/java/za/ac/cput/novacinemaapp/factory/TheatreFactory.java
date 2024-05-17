package za.ac.cput.novacinemaapp.factory;

import za.ac.cput.novacinemaapp.domain.Cinema;
import za.ac.cput.novacinemaapp.domain.Theatre;
import za.ac.cput.novacinemaapp.util.Helper;

public class TheatreFactory {
    public static Theatre buildTheatre(String theatreType, Cinema cinema){
        if(Helper.isNullOrEmpty(theatreType) || Helper.isNullOrEmpty(cinema))
            return null;
        String theatreID = Helper.generateId();
        return new Theatre.Builder().setTheatreID(theatreID).setTheatreType(theatreType).setCinema(cinema).build();
    }
}