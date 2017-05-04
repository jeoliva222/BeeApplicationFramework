package com.example.beeapplicationframework.objects;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jackson on 2/3/2017.
 */

public class QuestionBranchList implements Serializable {

    ArrayList<QuestionBranch> array;
    int index;

    public QuestionBranchList() {
        this.array = new ArrayList<QuestionBranch>(10);
        int index = -1;
    }

    public void addBranch(QuestionBranch q) {
        this.array.add(q);
        this.index = this.index + 1;
    }

    public QuestionBranch popBranch() {
        if(this.index >= 1) {
            QuestionBranch q = (QuestionBranch) this.array.get(index - 1);
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
