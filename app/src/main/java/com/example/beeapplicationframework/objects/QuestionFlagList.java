package com.example.beeapplicationframework.objects;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jackson on 2/3/2017.
 */

public class QuestionFlagList implements Serializable {

    ArrayList<QuestionFlag> array;
    int index;

    public QuestionFlagList() {
        this.array = new ArrayList<QuestionFlag>(10);
        int index = -1;
    }

    public void addBranch(QuestionFlag q) {
        this.array.add(q);
        this.index = this.index + 1;
    }

    public void addBranch(String flag, String value) {
        QuestionFlag q = new QuestionFlag(flag, value);
        this.array.add(q);
        this.index = this.index + 1;
    }

    public void removeBranch() {
        if(this.index >= 1) {
            this.array.remove(index - 1);
            this.index = this.index - 1;
            return;
        }
    }

    public QuestionFlag popBranch() {
        if(this.index >= 1) {
            QuestionFlag q = (QuestionFlag) this.array.get(index - 1);
            this.array.remove(index - 1);
            this.index = this.index - 1;
            return q;
        } else {
            return null;
        }
    }

    public void clearList() {
        this.array.clear();
        this.index = -1;
    }

}
