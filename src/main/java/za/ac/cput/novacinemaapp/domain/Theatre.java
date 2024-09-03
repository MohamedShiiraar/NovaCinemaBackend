package za.ac.cput.novacinemaapp.domain;
    /*Theatre.java
Entity for Theatres
Author: Daanyaal Isaacs (220094934)
Date: 17 May
 */
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Objects;

@Getter
@Entity
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theatreID;
    private String theatreType;
    @ManyToOne
    @JoinColumn(name = "theatre_Cinema")
    private Cinema cinema;

    public Theatre() {
    }

    public Theatre(Builder builder){
        this.theatreID = builder.theatreID;
        this.theatreType = builder.theatreType;
        this.cinema = builder.cinema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Theatre theatre = (Theatre) o;
        return Objects.equals(theatreID, theatre.theatreID) && Objects.equals(theatreType, theatre.theatreType) && Objects.equals(cinema, theatre.cinema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(theatreID, theatreType, cinema);
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
        private Long theatreID;
        private String theatreType;
        private Cinema cinema;

        public Builder setTheatreID(Long id){
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
