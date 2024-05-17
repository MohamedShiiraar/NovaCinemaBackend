package za.ac.cput.novacinemaapp.domain;

import java.util.Objects;

public class Movie {
    private String movieID;
    private String name;
    private String movieDescription;
    private String genre;
    private String duration;

    public Movie() {
    }

    public Movie(Builder builder) {
        this.movieID = builder.movieID;
        this.name = builder.name;
        this.movieDescription = builder.movieDescription;
        this.genre = builder.genre;
        this.duration = builder.duration;
    }

    public String getMovieID() {
        return movieID;
    }

    public String getName() {
        return name;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public String getGenre() {
        return genre;
    }

    public String getDuration() {
        return duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie movie)) return false;
        return Objects.equals(movieID, movie.movieID) && Objects.equals(name, movie.name) && Objects.equals(movieDescription, movie.movieDescription) && Objects.equals(genre, movie.genre) && Objects.equals(duration, movie.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieID, name, movieDescription, genre, duration);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieID='" + movieID + '\'' +
                ", name='" + name + '\'' +
                ", movieDescription='" + movieDescription + '\'' +
                ", genre='" + genre + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }

    public static class Builder {
        private String movieID;
        private String name;
        private String movieDescription;
        private String genre;
        private String duration;

        public void setMovieID(String movieID) {
            this.movieID = movieID;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setMovieDescription(String movieDescription) {
            this.movieDescription = movieDescription;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public Builder copy(Movie movie){
            this.movieID = movie.movieID;
            this.name = movie.name;
            this.movieDescription = movie.movieDescription;
            this.genre = movie.genre;
            this.duration = movie.duration;
            return this;
        }
        public Movie build() {
            return new Movie(this);
        }

    }
}
