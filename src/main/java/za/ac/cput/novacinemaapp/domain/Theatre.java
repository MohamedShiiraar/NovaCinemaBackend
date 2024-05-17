package za.ac.cput.novacinemaapp.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Theatre {

    @Id
    private String theatreID;
    private String theatreType;
    @OneToOne
    @JoinColumn(name = "theatre_Cinema")
    private Cinema cinema;

    public Theatre() {
    }

    public Theatre(Builder builder){
        this.theatreID = builder.theatreID;
        this.theatreType = builder.theatreType;
        this.cinema = builder.cinema;
    }

    public String getTheatreID() {
        return theatreID;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public String getTheatreType() {
        return theatreType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Theatre theatre = (Theatre) o;
        return Objects.equals(theatreID, theatre.theatreID) && Objects.equals(cinema, theatre.cinema) && Objects.equals(theatreType, theatre.theatreType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(theatreID, cinema, theatreType);
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "theatreID='" + theatreID + '\'' +
                ", theatreType='" + theatreType + '\'' +
                ", cinema=" + cinema +
                '}';
    }

    public static class Builder{
        private String theatreID;
        private String theatreType;
        private Cinema cinema;

        public Builder setTheatreID(String id){
            this.theatreID = id;
            return this;
        }

        public Builder setTheatreType(String theatreType){
            this.theatreType = theatreType;
            return this;
        }

        public Builder setCinema(Cinema cinema){
            this.cinema = cinema;
            return this;
        }

        public Builder copy(Theatre theatre){
            this.theatreID = theatre.theatreID;
            this.theatreType = theatre.theatreType;
            this.cinema = theatre.cinema;
            return this;
        }

        public Theatre build(){
            return new Theatre(this);
        }
    }
}
