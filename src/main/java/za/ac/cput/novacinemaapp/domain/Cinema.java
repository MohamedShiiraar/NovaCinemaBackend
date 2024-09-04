package za.ac.cput.novacinemaapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.*;
@Getter
@Entity

public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationID;
    private String name;
    private String address;

    public Cinema() {
    }

    public Cinema(Builder builder) {
        this.locationID = builder.locationID;
        this.name = builder.name;
        this.address = builder.address;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Cinema)) return false;
        Cinema cinema = (Cinema) o;
        return Objects.equals(locationID, cinema.locationID) &&
                Objects.equals(name, cinema.name) &&
                Objects.equals(address, cinema.address);
    }

    @Override
    public int hashCode(){
        return Objects.hash(locationID, name, address);
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "locationID='" + locationID + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address+ '\'' +
                '}';
    }

    public static class Builder {
        private Long locationID;
        private String name;
        private String address;

        public Builder setLocationID(Long locationID) {
            this.locationID = locationID;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAddress(String address){
            this.address = address;
            return this;
        }

        public Builder copy(Cinema cinema) {
            this.locationID = cinema.locationID;
            this.name = cinema.name;
            this.address = cinema.address;
            return this;
        }

        public Cinema build() {
            return new Cinema(this);
        }
    }
}