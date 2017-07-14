package com.ggr.myspring.CGLIBProxy;


/**
 * 定义目标对象
 */
public class Myservice {
    public String listenSongs(String Songname) {
        return "我想听"+Songname;
    }

    //唱歌
    public void singSongs(){
        System.out.println("la..la..la..");
    }
}