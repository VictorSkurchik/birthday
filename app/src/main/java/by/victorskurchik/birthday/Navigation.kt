package by.victorskurchik.birthday

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import by.victorskurchik.birthday.screens.Screen
import by.victorskurchik.birthday.screens.add.AddBirthday
import by.victorskurchik.birthday.screens.details.BirthdayDetailsScreen
import by.victorskurchik.birthday.screens.main.MainScreen
import by.victorskurchik.birthday.screens.splash.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen()
        }
        composable(route = Screen.AddBirthdayScreen.route) {
            AddBirthday()
        }
        composable(route = Screen.BirthdayDetailsScreen.route) {
            BirthdayDetailsScreen()
        }
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
    }
}