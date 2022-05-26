package com.example.lessons.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun CardLesson(title: Int, navController: NavHostController) {
    Card(elevation = 11.dp,
        modifier = Modifier
            .padding(10.dp, 10.dp)
            .height(100.dp)
            .fillMaxWidth()) {
        Column(modifier = Modifier.clickable { navController.navigate("LessonDetail/${title}") },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Урок #${title}")
        }
    }
}