package za.ac.cput.novacinemaapp.factory;

import za.ac.cput.novacinemaapp.domain.Seat;
import za.ac.cput.novacinemaapp.util.Helper;

public class SeatFactory {
    public static Seat buildSeat(String seatNumber, String seatType){
        if(Helper.isNullOrEmpty(seatNumber)||
        Helper.isNullOrEmpty(seatType)){
            return null;
        }
        String seatID = Helper.generateId();
        return new Seat.Builder().setSeatID(seatID).setSeatNumber(seatNumber).setSeatType(seatType).build();
    }
}
