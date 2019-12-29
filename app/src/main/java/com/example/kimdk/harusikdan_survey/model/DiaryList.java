package com.example.kimdk.harusikdan_survey.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DiaryList {

    @SerializedName("diary")
    @Expose
    private List<Diary> diary = null;
    @SerializedName("value")
    @Expose
    private Value value;

    public List<Diary> getDiary() {
        return diary;
    }

    public void setDiary(List<Diary> diary) {
        this.diary = diary;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

}