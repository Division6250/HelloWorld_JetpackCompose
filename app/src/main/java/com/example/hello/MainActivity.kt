package com.example.hello

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hello.ui.theme.HelloTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloTheme {
                val counter = remember{
                    mutableStateOf(0)
                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ShowNumber(counter = counter.value)
                        Spacer(modifier = Modifier.height(130.dp))
                        CreateCircle(counter = counter.value) {
                            newValue->counter.value = newValue
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ShowNumber (counter: Int) {
    Box(contentAlignment = Alignment.Center) {
        Text(
            text = "${counter}",
            style = TextStyle(color = Color.Black),
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun CreateCircle (counter: Int = 0, countUp: (Int) -> Unit) {
    Card(modifier = Modifier
        .padding(3.dp)
        .size(105.dp)
        .clickable {
            countUp(counter + 1)
        },
    shape = CircleShape,
    elevation = 4.dp) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = "Tap")
        }
    }
}
