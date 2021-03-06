package kr.team_cook.vod.Entity;

import java.util.UUID;

//sub class(자식)
public class VodTvEntity extends VodEntity {
    private String pd;  //메인PD
    private int series; //시리즈(몇부작)

    //생성자
    public VodTvEntity(String vodName, String production, String genre, UUID isbn, int price, int launchYear, float rating, String pd, int series) {
        super(vodName, production, genre, isbn, price, launchYear, rating);
        this.pd = pd;
        this.series = series;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "메인PD : " + this.getPd() + "시리즈(몇부작) : " + this.series;
    }

    //getter and setter
    public String getPd() {
        return pd;
    }

    public void setPd(String pd) {
        this.pd = pd;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}
