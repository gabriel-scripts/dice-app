package com.dicap.diceapp

import android.media.Image
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicap.diceapp.ui.theme.DiceappTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                DiceappTheme { app(); }
    }
}
@Preview (showBackground = true)
@Composable
fun app() {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(50.dp)

        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                NameInput();
                DiceTitle("Hora de atacar");
                NormalText("Ataque normal");
                SorterButton();
            }
        }
    }
}

@Composable
fun NameInput() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Digite seu nome:") },
        placeholder = { Text("Nome") },
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFF5F5F5),
            unfocusedContainerColor = Color(0xFFF5F5F5),
            focusedIndicatorColor = MaterialTheme.colorScheme.secondary,
            unfocusedIndicatorColor = Color.Gray,
            cursorColor = Color.Red,
            focusedLabelColor = MaterialTheme.colorScheme.secondary
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}

@Composable
fun DiceTitle(text: String){
    Text(
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.primary,
        text = text,
    )
}

@Composable
fun NormalText(text: String){
    Text(
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.primary,
        text= text,
    )
}

@Composable
fun SorterButton(){
    var resultado by remember { mutableIntStateOf(1) }
    diceImage(resultado);

    Button(
        modifier = Modifier.background(MaterialTheme.colorScheme.secondary, shape = CircleShape),
        onClick = {
            resultado = Random.nextInt(1, 7)
        }
    ){
        Text("Sortear");
    }
}

@Composable
fun diceImage(diceValue : Int) {
    var image = R.drawable.dice1;
    if (diceValue == 1){ image = R.drawable.dice1 }
    if (diceValue == 2){ image = R.drawable.dice2 }
    if (diceValue == 3){ image = R.drawable.dice3 }
    if (diceValue == 4){ image = R.drawable.dice4 }
    if (diceValue == 5){ image = R.drawable.dice4 }
    if (diceValue == 6){ image = R.drawable.dice6 }
    Image(
        painter = painterResource(id = image),
        contentDescription = "Dice images",
        modifier = Modifier.size(150.dp)
    )
}