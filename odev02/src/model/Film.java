package model;

import java.util.ArrayList;

public class Film {

    private String filmName;
    private  int year;
    private String star;
    private double imdbPoint;
    private ArrayList<Category> catList = new ArrayList<>();
    private ArrayList<Platform> platList = new ArrayList<>();

    public Film(String filmName, int year, String star, double imdbPoint) {
        this.filmName = filmName;
        this.year = year;
        this.star = star;
        this.imdbPoint = imdbPoint;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public double getImdbPoint() {
        return imdbPoint;
    }

    public void setImdbPoint(double imdbPoint) {
        this.imdbPoint = imdbPoint;
    }

    public ArrayList<Category> getCatList() {
        return catList;
    }

    public void setCatList(ArrayList<Category> catList) {
        this.catList = catList;
    }

    public ArrayList<Platform> getPlatList() {
        return platList;
    }

    public void setPlatList(ArrayList<Platform> platList) {
        this.platList = platList;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmName='" + filmName + '\'' +
                ", year=" + year +
                ", star='" + star + '\'' +
                ", imdbPoint=" + imdbPoint +
                ", catList=" + catList +
                ", platList=" + platList +
                '}';
    }
}
