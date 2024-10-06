package com.jahr.practica1
import android.os.Bundle
import android.util.Log
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.jahr.practica1.components.NavegacionInferiorJahr
import com.jahr.practica1.navigation.PortafolioNavigationJahr
import com.jahr.practica1.ui.theme.Practica1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica1Theme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize(),
                    bottomBar ={
                        NavegacionInferiorJahr(navController = navController)
                    }) { innerPadding ->
                    /*Greeting(
                        jahr = "JAHR",
                        modifier = Modifier.padding(innerPadding)
                    )
                    ListaJahr(
                        modifier = Modifier.padding(innerPadding)
                    )*/
                    Box(modifier = Modifier.fillMaxSize().padding(innerPadding)){
                        PortafolioNavigationJahr(navController = navController)
                    }

                }
            }
        }
    }
}
@Composable
fun Greeting(jahr: String, modifier: Modifier = Modifier) {
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {OvershootInterpolator(8f).getInterpolation(it)
                }
            )
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize().scale(scale.value),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello $jahr!",
            modifier = modifier,
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.displayLarge,
            textAlign = TextAlign.Center
        )
        Image(painter = painterResource(R.drawable.img), contentDescription = "Imagen de app")
        Text(
            text = "Bienvenido Jesús Alberto",
            modifier = Modifier,
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center

        )
        Text(text = "Hoy es viernes")
        Row{
            OutlinedButton(onClick = {
                Log.d("prueba de boton","OK")
            } ) {
                Text(text = "Invitado")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.onPrimary,
                contentColor = MaterialTheme.colorScheme.primary
            ), onClick = {} ) {
                Text(text ="Ingresar")
            }
        }
        Text(
            text = "Android 1.0",
            modifier = Modifier,
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Practica1Theme {
        Greeting("Android")
    }
}