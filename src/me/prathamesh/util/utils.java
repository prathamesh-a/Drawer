package me.prathamesh.util;

public class utils{

    public static int getRandom(int low, int high){
        return ((int) (Math.random() * (high - low)) + low);
    }

}
