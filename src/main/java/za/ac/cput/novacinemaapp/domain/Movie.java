package za.ac.cput.novacinemaapp.domain;

/*
Entity for User
Author : Mohamed Shiiraar (220354804)
Date : 17 May
 */

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.sql.Blob;
import java.util.Objects;
@Getter
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long movieID;
    private String name;
    private String movieDescription;
    @ManyToOne
    private Genre genre;
    private String duration;
    private String ageRestriction;
    private String imageURL;

    public Movie() {
    }

    public Movie(Builder builder) {
        this.movieID = builder.movieID;
        this.name = builder.name;
        this.movieDescription = builder.movieDescription;
        this.genre = builder.genre;
        this.duration = builder.duration;
        this.ageRestriction = builder.ageRestriction;
        this.imageURL = builder.imageURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return movieID == movie.movieID && Objects.equals(name, movie.name) && Objects.equals(movieDescription, movie.movieDescription) && Objects.equals(genre, movie.genre) && Objects.equals(duration, movie.duration) && Objects.equals(ageRestriction, movie.ageRestriction) && Objects.equals(imageURL, movie.imageURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieID, name, movieDescription, genre, duration, ageRestriction, imageURL);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieID=" + movieID +
                ", name='" + name + '\'' +
                ", movieDescription='" + movieDescription + '\'' +
                ", genre=" + genre +
                ", duration='" + duration + '\'' +
                ", ageRestriction='" + ageRestriction + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }

    public static class Builder {
        private long movieID;
        private String name;
        private String movieDescription;
        private Genre genre;
        private String duration;
        private String ageRestriction;
        private String imageURL;


        public Builder setMovieID(long movieID) {
            this.movieID = movieID;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setMovieDescription(String movieDescription) {
            this.movieDescription = movieDescription;
            return this;
        }

        public Builder setGenre(Genre genre) {
            this.genre = genre;
            return this;
        }

        public Builder setDuration(String duration) {
            this.duration = duration;
            return this;
        }

        public Builder setAgeRestriction(String ageRestriction) {
            this.ageRestriction = ageRestriction;
            return this;
        }

        public Builder setImageURL(String imageURL) {
            this.imageURL = imageURL;
            return this;
        }

        public Builder copy(Movie movie){
            this.movieID = movie.movieID;
            this.name = movie.name;
            this.movieDescription = movie.movieDescription;
            this.genre = movie.genre;
            this.duration = movie.duration;
            this.ageRestriction = movie.ageRestriction;
            this.imageURL = movie.imageURL;
            return this;
        }
        public Movie build() {
            return new Movie(this);
        }

    }
}
