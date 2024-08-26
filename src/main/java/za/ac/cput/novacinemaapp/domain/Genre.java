package za.ac.cput.novacinemaapp.domain;

/*
Entity for Genre
Author : [Gammaad Mohamed]
Date : [25/08/24]
*/

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Genre {

    @Id
    private String genreID;
    private String name;
    private String description;

    public Genre() {
    }

    public Genre(Builder builder) {
        this.genreID = builder.genreID;
        this.name = builder.name;
        this.description = builder.description;
    }

    public String getGenreID() {
        return genreID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Genre genre)) return false;
        return Objects.equals(genreID, genre.genreID) && Objects.equals(name, genre.name) && Objects.equals(description, genre.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genreID, name, description);
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreID='" + genreID + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static class Builder {
        private String genreID;
        private String name;
        private String description;

        public Builder setGenreID(String genreID) {
            this.genreID = genreID;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder copy(Genre genre) {
            this.genreID = genre.genreID;
            this.name = genre.name;
            this.description = genre.description;
            return this;
        }

        public Genre build() {
            return new Genre(this);
        }
    }
}
