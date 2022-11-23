package id.firdhausra.temperatureconverter.utils

fun convertToFahrenheit(celsius: String) =
    celsius.toDoubleOrNull()?.let {
        (it * 9 / 5) + 32
    }.toString()

fun convertToCelsius(fahrenheit: String) =
    fahrenheit.toDoubleOrNull()?.let {
        (it - 32) * 5 / 9
    }.toString()