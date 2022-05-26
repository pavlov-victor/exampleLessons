package com.example.lessons.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun LessonDetail(navController: NavHostController, lessonId: String?) {
    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopAppBar(
                elevation = 2.dp,
                backgroundColor = Color.Transparent
            ) {
                Text(text = "Lesson ${lessonId}",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold)
            }
        }
    ) {}
}