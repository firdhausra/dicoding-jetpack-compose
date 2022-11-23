package id.firdhausra.temperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.firdhausra.temperatureconverter.model.enum.Scale
import id.firdhausra.temperatureconverter.ui.components.GeneralTemperatureInput
import id.firdhausra.temperatureconverter.ui.components.StatefulTemperatureInput
import id.firdhausra.temperatureconverter.ui.components.StatelessTemperatureInput
import id.firdhausra.temperatureconverter.ui.theme.TemperatureConverterTheme
import id.firdhausra.temperatureconverter.utils.convertToCelsius
import id.firdhausra.temperatureconverter.utils.convertToFahrenheit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemperatureConverterTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TemperatureConverterApp()
                }
            }
        }
    }
}

@Composable
fun TemperatureConverterApp() {
    Column {
        StatefulTemperatureInput()
        ConverterApp()
        TwoWayConverterApp()
    }
}

@Composable
private fun ConverterApp(
    modifier: Modifier = Modifier,
) {
    var input by remember { mutableStateOf("") }
    var output by remember { mutableStateOf("") }
    Column(modifier) {
        StatelessTemperatureInput(
            input = input,
            output = output,
            onValueChange = { newInput ->
                input = newInput
                output = convertToFahrenheit(newInput)
            }
        )
    }
}

@Composable
private fun TwoWayConverterApp(
    modifier: Modifier = Modifier,
) {
    var celsius by remember { mutableStateOf("") }
    var fahrenheit by remember { mutableStateOf("") }
    Column(modifier.padding(16.dp)) {
        Text(
            text = stringResource(R.string.two_way_converter),
            style = MaterialTheme.typography.h5
        )
        GeneralTemperatureInput(
            scale = Scale.CELSIUS,
            input = celsius,
            onValueChange = { newInput ->
                celsius = newInput
                fahrenheit = convertToFahrenheit(newInput)
            }
        )
        GeneralTemperatureInput(
            scale = Scale.FAHRENHEIT,
            input = fahrenheit,
            onValueChange = { newInput ->
                fahrenheit = newInput
                celsius = convertToCelsius(newInput)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TemperatureConverterApp()
}