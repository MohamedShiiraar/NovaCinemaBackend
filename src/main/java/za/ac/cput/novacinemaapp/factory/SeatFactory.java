package za.ac.cput.novacinemaapp.factory;
    /*SeatFactory.java
Entity for Seat factory
Author: Daanyaal Isaacs (220094934)
Date: 17 May
 */
import za.ac.cput.novacinemaapp.domain.Seat;
import za.ac.cput.novacinemaapp.domain.Theatre;
import za.ac.cput.novacinemaapp.util.Helper;

public class SeatFactory {
    public static Seat buildSeat(String seatNumber, String seatType, Theatre theatre){
        if(Helper.isNullOrEmpty(seatNumber)||
        Helper.isNullOrEmpty(seatType) || Helper.isNullOrEmpty(theatre)){
            return null;
        }
        return new Seat.Builder().setSeatNumber(seatNumber).setSeatType(seatType).setTheatre(theatre).build();
    }
}
