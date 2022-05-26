package com.example.lessons.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lessons.presentation.LessonDetail
import com.example.lessons.presentation.LessonsList

@Composable
fun Operator() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "LessonsList") {
        composable("LessonsList") { LessonsList(navController) }
        composable("LessonDetail/{lessonId}") { backStackEntry ->
            LessonDetail(navController, backStackEntry.arguments?.getString("lessonId"))
        }
    }
}
