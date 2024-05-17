package za.ac.cput.novacinemaapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.*;
@Entity

public class Cinema {
    @Id
    private String locationID;
    private String name;

    public Cinema() {
    }

    public Cinema(Builder builder) {
        this.locationID = builder.locationID;
        this.name = builder.name;
    }

    public String getLocationID() {
        return locationID;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Cinema)) return false;
        Cinema cinema = (Cinema) o;
        return Objects.equals(locationID, cinema.locationID) &&
        Objects.equals(name, cinema.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(locationID, name);
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "locationID='" + locationID + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static class Builder {
        private String locationID;
        private String name;

        public Builder setLocationID(String locationID) {
            this.locationID = locationID;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder copy(Cinema cinema) {
            this.locationID = cinema.locationID;
            this.name = cinema.name;
            return this;
        }

        public Cinema build() {
            return new Cinema(this);
        }
    }
}