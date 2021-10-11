package kr.team_cook.vod.Controller;

import com.sun.nio.sctp.AbstractNotificationHandler;
import kr.team_cook.vod.Entity.*;
import java.util.Scanner;
import java.util.UUID;

public class VodController {
    Scanner sc = new Scanner(System.in);    //입력받기 위한 Scanner
//    VodEntity[] vod = new VodEntity[50];    //객체배열 [n]개 선언

    VodMovieEntity[] movie = new VodMovieEntity[10];
    VodTvEntity[] tv = new VodTvEntity[10];

    int cnt = 0;

    //등록
    public void Insert() {
        System.out.println("등록을 시작합니다.");
        System.out.printf("(1)영화, (2)Tv중에서 원하시는 것을 골라주세요 : ");
        int choic = Integer.parseInt(sc.nextLine());
        System.out.println("");

        if (choic == 1) {
            System.out.println("영화를 고르셨습니다.");
            System.out.printf("VOD명 : ");
            String name = sc.nextLine();
            System.out.printf("제작사 : ");
            String pro = sc.nextLine();
            System.out.printf("장르 : ");
            String gen = sc.nextLine();
            System.out.printf("가격(원) : ");
            int pri = Integer.parseInt(sc.nextLine());
            System.out.printf("개봉년도(yyyy) : ");
            int year = Integer.parseInt(sc.nextLine());
            System.out.printf("평점 : ");
            float rating = sc.nextFloat();
            sc.nextLine();  //버퍼제거
            System.out.printf("감독이름 : ");
            String directer = sc.nextLine();
            System.out.printf("영상길이(분) : ");
            int lenght = Integer.parseInt(sc.nextLine());
            UUID isbn = UUID.randomUUID();
            System.out.println("ISBN은 자동 생성됩니다.\n");

            movie[cnt] = new VodMovieEntity(name, pro, gen, isbn, pri, year, rating, directer, lenght);
            cnt++;
        }

        else if (choic == 2) {
            System.out.println("Tv를 고르셨습니다.");
            System.out.printf("VOD명 : ");
            String name = sc.nextLine();
            System.out.printf("제작사 : ");
            String pro = sc.nextLine();
            System.out.printf("장르 : ");
            String gen = sc.nextLine();
            System.out.printf("가격(원) : ");
            int pri = Integer.parseInt(sc.nextLine());
            System.out.printf("개봉년도(yyyy) : ");
            int year = Integer.parseInt(sc.nextLine());
            System.out.printf("평점 : ");
            float rating = sc.nextFloat();
            sc.nextLine();
            System.out.printf("메인PD : ");
            String pd = sc.nextLine();
            System.out.printf("시리즈(몇부작) : ");
            int seri = Integer.parseInt(sc.nextLine());
            UUID isbn = UUID.randomUUID();
            System.out.println("ISBN은 자동 생성됩니다.\n");

            tv[cnt] = new VodTvEntity(name, pro, gen, isbn, pri, year, rating, pd, seri);
            cnt++;
        }
        else {
            System.out.println("잘못입력하셨습니다.\n");
            Insert();
        }
    }//End 등록

    //조회
    public void Show() {

        System.out.println("조회를 시작합니다.");

        if (cnt <= 0) {
            System.out.println("등록되어있는 VOD가 없습니다.");
            System.out.println("초기화면으로 돌아갑니다.");
        }

        else if (cnt > 0) {
            System.out.printf("(1)영화, (2)Tv중에서 원하시는 것을 골라주세요 : ");
            int num = Integer.parseInt(sc.nextLine());
            System.out.println("");

            if ( num == 1) {
                for (int i = 0; i < movie.length; i++) {
                    if (movie[i] != null) {
                        System.out.println(i + 1 + "번째 VOD명 : " + movie[i].getVodName());
                        System.out.println(i + 1 + "번째 제작사 : " + movie[i].getProduction());
                        System.out.println(i + 1 + "번째 장르 : " + movie[i].getGenre());
                        System.out.println(i + 1 + "번째 가격 : " + movie[i].getPrice());
                        System.out.println(i + 1 + "번째 개봉년도 : " + movie[i].getLaunchYear());
                        System.out.println(i + 1 + "번째 평점 : " + movie[i].getRating());
                        System.out.println(i + 1 + "번째 영화감독 : " +  movie[i].getDirector());
                        System.out.println(i + 1 + "번째 영상길이 : " + movie[i].getMovieLenght());
                        System.out.println(i + 1 + "번째 ISBN : " + movie[i].getIsbn());
                        System.out.println("");
                    }
                }
            }

            else if (num == 2) {
                for (int i = 0; i < tv.length; i++) {
                    if (tv[i] != null) {
                        System.out.println(i + 1 + "번째 VOD명 : " + tv[i].getVodName());
                        System.out.println(i + 1 + "번째 제작사 : " + tv[i].getProduction());
                        System.out.println(i + 1 + "번째 장르 : " + tv[i].getGenre());
                        System.out.println(i + 1 + "번째 가격 : " + tv[i].getPrice());
                        System.out.println(i + 1 + "번째 개봉년도 : " + tv[i].getLaunchYear());
                        System.out.println(i + 1 + "번째 평점 : " + tv[i].getRating());
                        System.out.println(i + 1 + "번째 PD : " + tv[i].getPd());
                        System.out.println(i + 1 + "번째 씨리즈(몇부작) : " + tv[i].getSeries());
                        System.out.println(i + 1 + "번째 ISBN : " + tv[i].getIsbn());
                        System.out.println("");
                    }
                }
            }
        }
//        if (cnt <= 0) {
//            System.out.println("등록되어있는 VOD가 없습니다.");
//            System.out.println("초기화면으로 돌아갑니다.\n");
//        }
//
//        else if (cnt > 0) {
//            System.out.println("조회를 시작합니다.");
//            System.out.println("원하시는 종류의 조회를 입력해주세요 (1)전체, (2)영화, (3)Tv");
//
//            int choie = Integer.parseInt(sc.nextLine());
//
//            if (choie == 1) {   //전체 조회
//                System.out.println("전체 조회입니다.");
//
//                for (int i = 1; i < vod.length; i++) {
//
//            }
//
//            } else if (choie == 2) {  // 영화 조회
//                System.out.println("영화 조회를 시작합니다.");
//
//                System.out.printf(vod.toString());
//            } else if (choie == 3) {  //Tv 조회

//            }
    }//End 조회

    //수정
    public void Modify() {
        System.out.println("수정 메뉴 입니다.");
        System.out.printf("(1)영화, (2)Tv중에서 원하시는 것을 골라주세요 : ");
        int choie = Integer.parseInt(sc.nextLine());
        System.out.println("");

        if (choie == 1) {
            if (movie[0] == null) {
                System.out.println("등록된 영화정보가 없습니다.");
                System.out.println("다시 돌아갑니다.\n");
                Modify();
            }
            else {
                System.out.println("영화를 고르셨습니다.");
                System.out.printf("수정을 원하시는 n번째를 골라주세요 : ");
                int temnum = Integer.parseInt(sc.nextLine());
                System.out.println("");

                System.out.println(temnum + "번째로 고르셨습니다.");
                System.out.println("수정할 데이터를 입력해주세요.");
                System.out.printf("VOD명 : ");
                String name = sc.nextLine();
                System.out.printf("제작사 : ");
                String pro = sc.nextLine();
                System.out.printf("장르 : ");
                String gen = sc.nextLine();
                System.out.printf("가격(원) : ");
                int pri = Integer.parseInt(sc.nextLine());
                System.out.printf("개봉년도(yyyy) : ");
                int year = Integer.parseInt(sc.nextLine());
                System.out.printf("평점 : ");
                float rating = sc.nextFloat();
                sc.nextLine();
                System.out.printf("감독이름 : ");
                String directer = sc.nextLine();
                System.out.printf("영상길이(분) : ");
                int lenght = Integer.parseInt(sc.nextLine());
                UUID isbn = movie[temnum - 1].getIsbn();
                System.out.println("ISBN은 변경되지않습니다.\n");

                movie[temnum - 1] = new VodMovieEntity(name, pro, gen, isbn, pri, year, rating, directer, lenght);
            }
        }

        else if (choie == 2) {
            if (tv[0] == null) {
                System.out.println("등록된 Tv정보가 없습니다.");
                System.out.println("다시 돌아갑니다.\n");
                Modify();
            }
            else {
                System.out.println("Tv를 고르셨습니다.");
                System.out.printf("수정을 원하시는 n번째를 골라주세요 : ");
                int temnum = Integer.parseInt(sc.nextLine());
                System.out.println("");

                System.out.println(temnum + "번째로 고르셨습니다.");
                System.out.println("수정할 데이터를 입력해주세요.");
                System.out.printf("VOD명 : ");
                String name = sc.nextLine();
                System.out.printf("제작사 : ");
                String pro = sc.nextLine();
                System.out.printf("장르 : ");
                String gen = sc.nextLine();
                System.out.printf("가격(원) : ");
                int pri = Integer.parseInt(sc.nextLine());
                System.out.printf("개봉년도(yyyy) : ");
                int year = Integer.parseInt(sc.nextLine());
                System.out.printf("평점 : ");
                float rating = sc.nextFloat();
                sc.nextLine();
                System.out.printf("PD : ");
                String pd = sc.nextLine();
                System.out.printf("씨리즈(몇부작) : ");
                int sei = Integer.parseInt(sc.nextLine());
                UUID isbn = movie[temnum - 1].getIsbn();
                System.out.println("ISBN은 변경되지않습니다.");

                tv[temnum - 1] = new VodTvEntity(name, pro, gen, isbn, pri, year, rating, pd, sei);
            }
        }
    }//End 수정

    //삭제
    public void Delete() {
        System.out.println("삭제 메뉴입니다.");
        System.out.printf("(1)영화, (2)Tv중에서 원하시는 것을 골라주세요 : ");
        int page = Integer.parseInt(sc.nextLine());
        System.out.println("");

        if (page == 1) {
            System.out.println("영화를 고르셨습니다.");
            System.out.printf("삭제를 원하시는 n번째를 입력해주세요 : ");
            int dele = Integer.parseInt(sc.nextLine());
            System.out.println("");

            for (int i = dele - 1; i < movie.length - 1; i++) {
                movie[i] = movie[i + 1];
            }
            System.out.println("삭제가 완료되었습니다.\n");
            cnt--;
        }
        else if (page == 2) {
            System.out.println("Tv를  고르셨습니다.");
            System.out.printf("삭제를 원하시는 n번째를 입력해주세요 : ");
            int dele = Integer.parseInt(sc.nextLine());
            System.out.println("");

            for (int i = dele - 1; i < tv.length - 1; i++) {
                tv[i] = tv[i + 1];
            }
            System.out.println("삭제가 완료되었습니다.");
            cnt--;
        }
    }//End 삭제
}//End
