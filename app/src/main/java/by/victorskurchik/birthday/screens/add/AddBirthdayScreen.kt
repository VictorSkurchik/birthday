package by.victorskurchik.birthday.screens.add

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import by.victorskurchik.birthday.format
import by.victorskurchik.birthday.toDate
import java.util.*

@Composable
fun AddBirthday() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        var name by remember { mutableStateOf("") }
        var date by remember { mutableStateOf<Date>(Calendar.getInstance().time) }

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = name,
            onValueChange = { value -> name = value },
            label = { Text("Name") },
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = date.format(),
            onValueChange = { value -> date = value.toDate() },
            label = { Text("Date") },
            readOnly = true
        )

        Button(
            onClick = { /*TODO*/ },
            enabled = name.isNotBlank(),
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                disabledBackgroundColor = Color.Gray
            )
        ) {
            Text(text = "Save")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddBirthdayPreview() {
    AddBirthday()
}