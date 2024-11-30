package ru.vsu.cs.sem3.oop.practice;

import java.util.Objects;
import java.util.Scanner;

public class Genre {
    private String genreName;
    private String country;
    private int popularity = 0;
    private double rating = 0;

    public Genre(String genreName, String country) {
        this.genreName = genreName;
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return Objects.equals(genreName, genre.genreName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genreName, country);
    }

    public Genre(String genreName) {
        this(genreName, null);
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void rateGenre(int a) {
        if (a < 0 || a > 100) {
            System.out.println("Недопустимая оценка!");
        } else {
            popularity++;
            rating = (rating + a) / popularity + 1;
        }
    }

    public void rateGenre() {
        System.out.println("Оцените выбранный жанр по 100-балльной шкале: ");
        Scanner scanner = new Scanner(System.in);
        try {
            int a = scanner.nextInt();
            if (a < 0 || a > 100) {
                System.out.println("Недопустимая оценка!");
            } else {
                popularity++;
                rating = (rating * popularity + a) / popularity + 1;
            }
        } catch (Exception e) {
            System.out.println("Злючка");
        }
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreName=" + genreName +
                ", country=" + country +
                ", popularity=" + popularity +
                ", rating=" + rating +
                '}';
    }
}
