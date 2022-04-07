package by.victorskurchik.birthday.screens

sealed class Screen(val route: String) {

    object MainScreen : Screen("main_screen")
    object AddBirthdayScreen : Screen("add_birthday_screen")
    object BirthdayDetailsScreen : Screen("birthday_details_screen")
    object SplashScreen : Screen("splash_screen")
}