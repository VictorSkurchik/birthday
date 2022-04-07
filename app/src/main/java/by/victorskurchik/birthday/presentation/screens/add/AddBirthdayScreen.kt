package by.victorskurchik.birthday.presentation.screens.add

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import by.victorskurchik.birthday.domain.entities.Birthday
import by.victorskurchik.birthday.format
import by.victorskurchik.birthday.presentation.screens.Screen
import by.victorskurchik.birthday.toDate
import java.util.*

@Composable
fun AddBirthday(
    navController: NavController,
    viewModel: AddBirthdayViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        var fullName by remember { mutableStateOf("") }
        var date by remember { mutableStateOf<Date>(Calendar.getInstance().time) }

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = fullName,
            onValueChange = { value -> fullName = value },
            label = { Text("Full Name") },
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = date.format(),
            onValueChange = { value -> date = value.toDate() },
            label = { Text("Date") },
            readOnly = true
        )

        Button(
            onClick = {
                val birthday = Birthday(fullName, date.format())
                viewModel.addBirthday(birthday)
                navController.navigate(Screen.MainScreen.route)
            },
            enabled = fullName.isNotBlank(),
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                disabledBackgroundColor = Color.Gray
            )
        ) {
            Text(text = "Save")
        }
    }
}