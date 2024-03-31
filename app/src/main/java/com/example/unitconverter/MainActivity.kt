package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable

fun UnitConverter() {

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Centimeters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val conversionFactor = remember { mutableStateOf(0.01) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //UI elements stacked below one another
        Text("Unit Converter")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = inputValue, onValueChange = {
            inputValue = it

        },
            label = { Text("Enter number:") })
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            //The input box
            Box {
                //The input Button
                Button(onClick = { iExpanded = true }) {
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Drop down arrow")
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
                    DropdownMenuItem(text = { Text("cm") },
                        onClick = { iExpanded = false
                        inputUnit = "cm"
                        conversionFactor.value = 0.01})
                    DropdownMenuItem(text = { Text("m") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text("ft") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text("mm") }, onClick = { /*TODO*/ })
                }

            }
            Spacer(modifier = Modifier.width(16.dp))
            //The output box
            Box {
                //The output button
                Button(onClick = { oExpanded = true }) {
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Drop down arrow")
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                    DropdownMenuItem(text = { Text("cm") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text("m") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text("ft") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text("mm") }, onClick = { /*TODO*/ })

                }

            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Result:")
    }
}


@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverter()

}
