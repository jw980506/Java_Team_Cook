package kr.team_cook.vod.Entity;

import java.util.UUID;

//sub class(자식)
public class VodMovie extends VodEntitis {
    private String director;    //영화 감독
    private int period; //극장에서의 상영기간

    //생성자
    public VodMovie(String vodName, String production, String genre, UUID isbn, int price, int lanuchYear, float rating, String director, int period) {
        super(vodName, production, genre, isbn, price, lanuchYear, rating);
        this.director = director;
        this.period = period;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "영화 감독 : " + director + "극장에서의 상영시간 : " + period;
    }

    //getter and setter
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}
