package com.example.lessons.database;


import com.google.gson.annotations.SerializedName;

public class Lesson {
    @SerializedName("title")
    String title;
    @SerializedName("text")
    String text;
    @SerializedName("id")
    Integer id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
