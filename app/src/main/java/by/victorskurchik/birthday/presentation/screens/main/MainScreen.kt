package by.victorskurchik.birthday.presentation.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import by.victorskurchik.birthday.domain.entities.Birthday
import by.victorskurchik.birthday.presentation.screens.Screen

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel
) {

    val birthdays = viewModel.birthdays.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            Button(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Add, "add")
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            birthdays.value.forEach { birthday ->
                item {
                    Item(birthday, navController)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Item(birthday: Birthday, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp, bottom = 4.dp, start = 16.dp, end = 16.dp),
        onClick = {
            navController.navigate(Screen.BirthdayDetailsScreen.route)
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = birthday.fullName)
            Text(text = birthday.date)
        }
    }
}