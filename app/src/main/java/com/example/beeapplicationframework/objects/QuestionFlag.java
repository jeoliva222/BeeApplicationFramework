package com.example.beeapplicationframework.objects;

import java.io.Serializable;

/**
 * Created by Jackson on 2/3/2017.
 */

// Simple class to store flags for querying at the end

public class QuestionFlag implements Serializable {

    String flag;
    String value;

    public QuestionFlag(String flag, String value) {
        this.flag = flag;
        this.value = value;
    }

}
