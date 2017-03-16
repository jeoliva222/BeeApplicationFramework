package com.example.beeapplicationframework;

import java.io.Serializable;

/**
 * Created by Jackson on 2/16/2017.
 */

public class BeedexNode implements Serializable {

    String latinName;
    String commonName;
    String picName;
    String habitatInfo;
    String activeInfo;
    String descInfo;

    public BeedexNode(String latinName, String commonName, String picName, String habitatInfo, String activeInfo, String descInfo) {
        this.latinName = latinName;
        this.commonName = commonName;
        this.picName = picName;
        this.habitatInfo = habitatInfo;
        this.activeInfo = activeInfo;
        this.descInfo = descInfo;
    }

}
