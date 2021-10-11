package kr.team_cook.vod.Entity;

import java.util.UUID;

//sub class(자식)
public class VodMovieEntity extends VodEntity {
    private String director;    //영화 감독
    private int movieLenght;    //영상길이

    //생성자
    public VodMovieEntity(String vodName, String production, String genre, UUID isbn, int price, int launchYear, float rating, String director, int movieLenght) {
        super(vodName, production, genre, isbn, price, launchYear, rating);
        this.director = director;
        this.movieLenght = movieLenght;
    }

    public VodMovieEntity() {

    }

    @Override
public String print() {
        super.print();
        System.out.println("영화감독 : " + getDirector());
        System.out.println("영상길이 : " + getMovieLenght());
        return print();
    }

    //getter and setter
    public String getDirector() { return director; }

    public void setDirector(String director) { this.director = director; }

    public int getMovieLenght() { return movieLenght; }

    public void setMovieLenght(int movieLenght) { this.movieLenght = movieLenght; }
}
