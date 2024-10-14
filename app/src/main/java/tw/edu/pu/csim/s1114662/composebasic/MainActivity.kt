package tw.edu.pu.csim.s1114662.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tw.edu.pu.csim.s1114662.composebasic.ui.theme.ComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeBasicTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "MaoZiYun",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    //  var x:Int = 0
    // var x by remember { mutableStateOf(0) }
    var x = remember { mutableStateOf(0) }

    Column {
        Row {
            Button(
                onClick = {
                    x.value = 0
                }
            ) {
                Text("歸零")
                Image(
                    painter = painterResource(id = R.drawable.happy),
                    contentDescription = "happy照片",
                    modifier = modifier.size(50.dp)
                )
            }
            Button(
                onClick = {
                    x.value = x.value * 2
                }
            ) {
                Text("x2")
                Image(
                    painter = painterResource(id = R.drawable.happy),
                    contentDescription = "happy照片",
                    modifier = modifier.size(50.dp)
                )
            }
        }


            /*
            Text(text=x.toString(),
                fontSize = 50.sp,
                modifier = modifier.clickable { x++ }
            )

         */
            Text(text = x.value.toString(),
                fontSize = 50.sp,
                modifier = modifier.clickable { x.value++ }
            )
            Row {
                Text(
                    text = stringResource(R.string.author),
                    color = Color.Blue,
                    fontSize = 50.sp,
                    fontFamily = FontFamily(Font(R.font.hand)),
                    modifier = modifier
                )
                Image(
                    painter = painterResource(id = R.drawable.dog),
                    contentDescription = "薩摩耶耶",
                    alpha = 0.5f,
                    modifier = modifier.clip(CircleShape)
                )
            }
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dog),
                    contentDescription = "薩摩耶耶",
                    alpha = 0.5f,
                    modifier = modifier.clip(CircleShape)
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        ComposeBasicTheme {
            Greeting("Android")
        }
    }