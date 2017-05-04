package com.example.beeapplicationframework.objects;

/**
 * Created by Jackson on 1/27/2017.
 */

import java.io.Serializable;

public class QuestionBranch implements Serializable {

    public String title;
    public QuestionBranch noBranch;
    public QuestionBranch yesBranch;
    public String flag;
    public Boolean isEnd;
    public String species;
    public String helper;

    public QuestionBranch(String title, QuestionBranch noBranch, QuestionBranch yesBranch, String flag, String helper) {
        this.title = title;
        this.noBranch = noBranch;
        this.yesBranch = yesBranch;
        this.flag = flag;
        this.isEnd = false;
        this.helper = helper;
    }

    public QuestionBranch(String title, QuestionBranch noBranch, QuestionBranch yesBranch, String flag, Boolean isEnd, String species, String helper) {
        this.title = title;
        this.noBranch = noBranch;
        this.yesBranch = yesBranch;
        this.flag = flag;
        this.isEnd = isEnd;
        this.species = species;
        this.helper = helper;
    }

    public QuestionBranch(String title, QuestionBranch noBranch, QuestionBranch yesBranch, String flag, String species, String helper) {
        this.title = title;
        this.noBranch = noBranch;
        this.yesBranch = yesBranch;
        this.flag = flag;
        this.isEnd = true;
        this.species = species;
        this.helper = helper;
    }

}
