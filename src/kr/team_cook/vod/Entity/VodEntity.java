package kr.team_cook.vod.Entity;

import java.util.UUID;

//super class(부모)
public class VodEntity {
    private String vodName; //명칭
    private String production;  //제작사
    private String genre;   //장르
    private UUID isbn;  //ISBN
    private int price;  //가격
    private int launchYear; //개봉년도
    private float rating;   //평점
    //감독명과 메인PD는 각각 영화, TV에 들어 갈 것이다, 추가로 시리즈와 극장상영기간

    //기본 생성자
    public VodEntity() {
    }

    //사용자 정의 생성자
    public VodEntity(String vodName, String production, String genre, UUID isbn, int price, int lanuchYear, float rating) {
        this.vodName = vodName;
        this.production = production;
        this.genre = genre;
        this.isbn = isbn;
        this.price = price;
        this.launchYear = lanuchYear;
        this.rating = rating;
    }

    public String print() {
        System.out.println("VOD명 : " + getVodName());
        System.out.println("제작사 : " + getProduction());
        System.out.println("장르 : " + getGenre());
        System.out.println("가격 : " + getPrice());
        System.out.println("개봉년도 : " + getLaunchYear());
        System.out.println("평점 : " + getRating());
        return print();
    }

    //getter and setter
    public String getVodName() { return vodName; }

    public void setVodName(String vodName) {
        this.vodName = vodName;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getGenre() { return genre; }

    public void setGenre(String genre) { this.genre = genre; }

    public UUID getIsbn() {
        return isbn;
    }

    public void setIsbn(UUID isbn) {
        this.isbn = isbn;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(int launchYear) {
        this.launchYear = launchYear;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}