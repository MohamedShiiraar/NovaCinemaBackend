package za.ac.cput.novacinemaapp.domain;

    /*Seat.java
Entity for Theatre Seats
Author: Daanyaal Isaacs (220094934)
Date: 17 May
 */

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Seat {
    @Id
    private String seatID;
    private String seatNumber;
    private String seatType;

    protected Seat() {
    }

    public Seat(Builder builder){
        this.seatID = builder.seatID;
        this.seatNumber = builder.seatNumber;
        this.seatType = builder.seatType;
    }

    public String getSeatID() {
        return seatID;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getSeatType() {
        return seatType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return Objects.equals(seatID, seat.seatID) && Objects.equals(seatNumber, seat.seatNumber) && Objects.equals(seatType, seat.seatType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatID, seatNumber, seatType);
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatID='" + seatID + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                ", seatType='" + seatType + '\'' +
                '}';
    }

    public static class Builder{
        private String seatID;
        private String seatNumber;
        private String seatType;

        public Builder setSeatID(String id){
            this.seatID = id;
            return this;
        }

        public Builder setSeatNumber(String seatNumber){
            this.seatNumber = seatNumber;
            return this;
        }

        public Builder setSeatType(String seatType){
            this.seatType = seatType;
            return this;
        }

        public Builder copy(Seat seat){
            this.seatID = seat.seatID;
            this.seatNumber = seat.seatNumber;
            this.seatType = seat.seatType;
            return this;
        }

        public Seat build(){
            return new Seat(this);
        }
    }
}
