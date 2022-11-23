package id.firdhausra.temperatureconverter.utils

fun convertToFahrenheit(celsius: String) =
    celsius.toDoubleOrNull()?.let {
        (it * 9 / 5) + 32
    }.toString()