package com.example.laboratorio_2_carlos_cruz

import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.laboratorio_2_carlos_cruz.ui.navigation.Labo3App
import com.example.laboratorio_2_carlos_cruz.ui.theme.Laboratorio_2_Carlos_CruzTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio_2_Carlos_CruzTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) {
//                    innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    //aplicacion()
                Labo3App()
//                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Laboratorio_2_Carlos_CruzTheme {
        Greeting("Android")
    }
}

@Preview
@Composable
fun aplicacion (){

    val usuario: MutableState<String> = remember { mutableStateOf("")}
    val listado = remember {mutableStateListOf<String>()}

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),

    ){
        Spacer(modifier = Modifier.padding(16.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
            ) {
                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Nombre") },
                        value = usuario.value,
                        onValueChange = {
                            usuario.value = it
                        },
                    )
                Button(
                    onClick = {
                        listado.add(usuario.value)
                    }
                ){
                    Text("Guardar")
                }
            }
        Row(
            modifier= Modifier.fillMaxWidth(),
            horizontalArrangement=Arrangement.SpaceEvenly
        ){
            Text("Listado de nombres y posición \nen la lista")
            Button(
                onClick = {
                    listado.clear()
                }
            ){
                Text("Limpiar")
            }
        }
        LazyColumn(
            modifier = Modifier
                .border(width = 2.dp,
                    color= Color.Blue)
        ) {
            itemsIndexed(listado.toList()) { index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(text=item)
                    Text(text=(index+1).toString())
                }

            }
        }
    }

}

