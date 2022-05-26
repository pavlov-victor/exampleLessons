package com.example.lessons.database;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LessonService {
    @GET("lessons")
    Call<List<Lesson>> listLessons();
}
