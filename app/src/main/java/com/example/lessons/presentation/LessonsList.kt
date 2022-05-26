package com.example.lessons.presentation

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.lessons.components.CardLesson
import com.example.lessons.database.Lesson
import com.example.lessons.database.LessonService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun LessonsList(navController: NavHostController) {
    val lessonsListResponse = remember {
        mutableStateOf(listOf<Lesson>())
    }

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopAppBar(
                elevation = 2.dp,
                backgroundColor = Color.Transparent
            ) {
                Text(text = "Lessons",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold)
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(ScrollState(1)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                val retrofit: Retrofit =
                    Retrofit
                        .Builder()
                        .baseUrl("https://itcube.goykt.ru/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                CoroutineScope(Dispatchers.IO).launch {
                    val lessons = retrofit.create(LessonService::class.java).listLessons().execute()
                    val result: List<Lesson> = lessons.body() as List<Lesson>
                    lessonsListResponse.value = result
                }

            }) {
                Text(text = "Обновить занятия")
            }
            for (lesson in lessonsListResponse.value) {
                CardLesson(lesson.id, navController)
            }

        }
    }

}