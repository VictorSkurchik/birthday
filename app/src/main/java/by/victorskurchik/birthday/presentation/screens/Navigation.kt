package by.victorskurchik.birthday.presentation.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import by.victorskurchik.birthday.presentation.screens.add.AddBirthday
import by.victorskurchik.birthday.presentation.screens.details.BirthdayDetailsScreen
import by.victorskurchik.birthday.presentation.screens.main.MainScreen
import by.victorskurchik.birthday.presentation.screens.main.MainViewModel
import by.victorskurchik.birthday.presentation.screens.splash.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            val viewModel = hiltViewModel<MainViewModel>()
            MainScreen(navController = navController, viewModel = viewModel)
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