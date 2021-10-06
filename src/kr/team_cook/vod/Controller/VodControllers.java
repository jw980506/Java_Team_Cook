package kr.team_cook.vod.Controller;

import kr.team_cook.vod.Entity.*;
import java.util.Scanner;
import java.util.UUID;

public class VodControllers {
    static final int MAX_VOD = 50;
    Scanner sc = new Scanner(System.in);    //입력을 위한 Scanner

    //객체 배열, MAX_VOD = 50으로 선언
//    VodEntitis[] vod = new VodEntitis[50];
    VodMovie[] movie = new VodMovie[MAX_VOD];
    VodTv[] tv = new VodTv[MAX_VOD];

    int moviecnt = 0;
    int tvcnt = 0;

    //등록
    public void insert() {

        System.out.println("\nVOD 등록을 시작합니다");
        System.out.printf("VOD 명칭 : ");
        String name = sc.nextLine();
        System.out.printf("제작사 : ");
        String pro = sc.nextLine();
        System.out.printf("장르 : ");
        String gen = sc.nextLine();
        System.out.printf("가격 : ");
        int price = Integer.parseInt(sc.nextLine());
        System.out.printf("개봉년도 : ");
        int year = Integer.parseInt(sc.nextLine());
        System.out.printf("평점 : ");
        float ting = Integer.parseInt(sc.nextLine());
        System.out.println("ISBN은 자동으로 생성됩니다");
        UUID isbn = UUID.randomUUID();

        System.out.printf("영화면 1번, TV면 2번을 눌러주세요 (1.영화, 2.TV) : ");
        int selnum = Integer.parseInt(sc.nextLine());
        if (selnum == 1) {
            System.out.printf("감독이름 : ");
            String direc = sc.nextLine();
            System.out.printf("상영시간(n시00분 : ");
            int peri = Integer.parseInt(sc.nextLine());
            //객체에 저장
            movie[moviecnt] = new VodMovie(name, pro, gen, isbn, price, year, ting, direc, peri);
        } else if (selnum == 2) {
            System.out.printf("PD이름 : ");
            String pdname = sc.nextLine();
            System.out.printf("시리즈 몇부작 : ");
            int seri = Integer.parseInt(sc.nextLine());
            //객체에 저장
            tv[tvcnt] = new VodTv(name, pro, gen, isbn, price, year, ting, pdname, seri);
            tvcnt++;
        } else {
            System.out.printf("잘못입력하셨습니다");
            System.out.printf("초기화면으로 돌아갑니다");
        }
    }//End 등록

    //조회
    public void show() {
        if (moviecnt == 0 || tvcnt == 0) {
            System.out.println("\n등록되어 있는 VOD가 없습니다");
            System.out.println("초기화면으로 돌아갑니다");
        } else {
            System.out.println("\n등록되어 있는 VOD목록입니다");
            System.out.println("영화 목록을 원하시면 1번, TV 목록을 원하시면 2번을 눌러주세요 : ");
            int choienum = Integer.parseInt(sc.nextLine());

            if (choienum == 1) {
                for (int i = 0; i < movie.length; i++) {
                    if (movie[i] != null) {
                        System.out.println("영화 목록입니다.");
                        System.out.println(i + 1 + "번째 VOD명칭 : " + movie[i].getVodName());
                        System.out.println(i + 1 + "번째 제작사 : " + movie[i].getProduction());
                        System.out.println(i + 1 + "번째 장르 : " + movie[i].getGenre());
                        System.out.println(i + 1 + "번째 가격 : " + movie[i].getPrice());
                        System.out.println(i + 1 + "번째 개봉년도 :  " + movie[i].getLanuchYear());
                        System.out.println(i + 1 + "번째 평점 :  " + movie[i].getRating());
                        System.out.println(i + 1 + "번째 ISBN : " + movie[i].getIsbn());

                        System.out.println("");
                    }
                }
            } else if (choienum == 2) {
                for (int n = 0; n < tv.length; n++) {
                    if (tv[n] != null) {
                        System.out.println("TV 목록입니다.");
                        System.out.println(n + 1 + "번째 VOD명칭 : " + tv[n].getVodName());
                        System.out.println(n + 1 + "번째 제작사 : " + tv[n].getProduction());
                        System.out.println(n + 1 + "번째 장르 : " + tv[n].getGenre());
                        System.out.println(n + 1 + "번째 가격 : " + tv[n].getPrice());
                        System.out.println(n + 1 + "번째 개봉년도 :  " + tv[n].getLanuchYear());
                        System.out.println(n + 1 + "번째 평점 :  " + tv[n].getRating());
                        System.out.println(n + 1 + "번째 ISBN : " + tv[n].getIsbn());
                        System.out.println(n + 1 + "번째 메인PD : " + tv[n].getPd());
                        System.out.println(n + 1 + "번째 시리즈(몇부작) : " + tv[n].getSeries());
                        System.out.println("");
                    }
                }
            }
        }
    }//End 조회

//    public void modify() {
//        System.out.println("수정 메뉴 입니다");
//        System.out.printf("수정을 원하시는 인덱스를 입력해주세요(수정을 원하지 않으면 0번을 눌러주세요) :  ");
//
//        //수정을 위한 인덱스 대신 받을 변수
//        int num = Integer.parseInt(sc.nextLine());
//
//        if (num == 0) {
//            System.out.printf("초기 메뉴로 돌아갑니다.");
//        }
//
//        else {
//            System.out.println("수정 전 DVD 번호 : " + dvd[num - 1].getDvdNumber());
//            System.out.println("수정 전 출시년 : " + dvd[num - 1].getDvdLanunchYear());
//            System.out.println("수정 전 DVD 명 : " + dvd[num - 1].getDvdName());
//            System.out.println("수정 전 제작사 : " + dvd[num - 1].getProduction());
//            System.out.println("수정 전 장르 :  " + dvd[num - 1].getGenre());
//            System.out.println("------------------------------------\n");
//
//            System.out.printf("수정 할 DVD 번호 : ");
//            int number = Integer.parseInt(sc.nextLine());
//            System.out.printf("수정 할 출시년 : ");
//            int year = Integer.parseInt(sc.nextLine());
//            System.out.printf("수정 할 DVD 명 : ");
//            String name = sc.nextLine();
//            System.out.printf("수정 할 제작사 : ");
//            String pro = sc.nextLine();
//            System.out.printf("수정 할 장르 : ");
//            String gen = sc.nextLine();
//            UUID isbn = dvd[num - 1].getIsbn();
//
//            //수정된 내용을 배열에 다시 저장
//            dvd[num - 1] = new DvdEntity(number, isbn, year, name, pro, gen);
//        }
//    }//End 수정
//
//    public void delete() {
//        System.out.println();
//        System.out.println("삭제 메뉴 입니다");
//        System.out.printf("삭제를 원하는 인덱스를 입력해주세요 : ");
//
//        int num = Integer.parseInt(sc.nextLine());
//
//        for (int i = num-1; i < dvd.length-1; i++) {
//            dvd[i] = dvd[i+1];
//        }
//
//        System.out.println("삭제가 완료되었습니다");
//        cnt--;
//    }//End 삭제
    }
}//End