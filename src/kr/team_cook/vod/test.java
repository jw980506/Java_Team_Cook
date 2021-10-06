package kr.team_cook.vod;

import kr.team_cook.vod.Controller.VodControllers;

public class test {
    public static void main(String[] args) {

        VodControllers vod = new VodControllers();

        vod.insert();
        vod.show();
    }
}
