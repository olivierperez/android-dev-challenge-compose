package com.example.androiddevchallenge

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.domain.GetPuppies
import com.example.androiddevchallenge.domain.GetPuppyById
import com.example.androiddevchallenge.ui.screen.PuppyDetail
import com.example.androiddevchallenge.ui.screen.PuppyList
import com.example.androiddevchallenge.ui.theme.PuppyTheme

@Composable
fun PuppyApp() {
    val navController = rememberNavController()

    Surface(color = MaterialTheme.colors.background) {
        NavHost(
            navController = navController,
            startDestination = "puppy_list"
        ) {
            composable("puppy_list") {
                PuppyList(
                    navController,
                    GetPuppies()
                )
            }
            composable(
                "puppy_details/{id}",
                arguments = listOf(navArgument("id") { NavType.IntType })
            ) { backStackEntry ->
                PuppyDetail(
                    navController,
                    GetPuppyById(),
                    backStackEntry.arguments!!.getInt("id", -1)
                        .takeIf { it >= 0 }
                        ?: backStackEntry.arguments!!.getString("id", "-1").toInt()
                )
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    PuppyTheme {
        PuppyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    PuppyTheme(darkTheme = true) {
        PuppyApp()
    }
}
