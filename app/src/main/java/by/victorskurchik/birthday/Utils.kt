package by.victorskurchik.birthday

import java.text.SimpleDateFormat
import java.util.*

private const val DATE_PATTERN = "yyyy-MM-dd"

fun Date.format(): String {
    val dateFormat = SimpleDateFormat(DATE_PATTERN, Locale.getDefault())
    return dateFormat.format(this)
}

fun String.toDate(): Date {
    val dateFormat = SimpleDateFormat(DATE_PATTERN, Locale.getDefault())
    return dateFormat.parse(this) as Date
}