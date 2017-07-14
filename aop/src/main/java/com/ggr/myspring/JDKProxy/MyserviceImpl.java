package com.ggr.myspring.JDKProxy;

/**
 * Created by GuiRunning on 2017/7/14.
 */
public class MyserviceImpl implements Myservice {

    public String listenSongs(String Songname) {
        return "我想听"+Songname;
    }

    //唱歌
    public void singSongs(){
        System.out.println("la..la..la..");
    }
}
