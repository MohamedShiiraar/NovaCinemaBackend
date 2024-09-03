package za.ac.cput.novacinemaapp.domain;

/*
Entity for Genre
Author : [Gammaad Mohamed]
Date : [25/08/24]
*/

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.Objects;

@Getter
@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genreID;
    private String name;
    private String description;

    public Genre() {
    }

    public Genre(Builder builder) {
        this.genreID = builder.genreID;
        this.name = builder.name;
        this.description = builder.description;
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
        private Long genreID;
        private String name;
        private String description;

        public Builder setGenreID(Long genreID) {
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
