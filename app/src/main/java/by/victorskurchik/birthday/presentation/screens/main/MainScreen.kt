package by.victorskurchik.birthday.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import by.victorskurchik.birthday.domain.entities.Birthday
import by.victorskurchik.birthday.presentation.screens.Screen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel
) {

    val birthdays = viewModel.birthdays

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text("Birthdays") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Screen.AddBirthdayScreen.route)
            }) { Icon(Icons.Rounded.Add, "add") }
        },
    ) {

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(birthdays.value, { it.fullName }) { birthday ->
                val dismissState = rememberDismissState(
                    confirmStateChange = {
                        if (it == DismissValue.DismissedToEnd || it == DismissValue.DismissedToStart) {
                            viewModel.deleteBirthday(birthday)
                        }
                        true
                    }
                )

                SwipeToDismiss(
                    state = dismissState,
                    directions = setOf(DismissDirection.StartToEnd),
                    background = {
                        val color = when (dismissState.targetValue) {
                            DismissValue.Default -> Color.LightGray
                            DismissValue.DismissedToEnd -> Color.Green
                            DismissValue.DismissedToStart -> Color.Red
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color)
                        )
                    },
                    dismissContent = { Item(birthday, navController) }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Item(birthday: Birthday, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
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