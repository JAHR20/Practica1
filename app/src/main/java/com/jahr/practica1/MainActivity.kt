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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jahr.practica1.components.MenuLateral
import com.jahr.practica1.components.NavegacionInferiorJahr
import com.jahr.practica1.components.Topbar
import com.jahr.practica1.models.Items_options_config_JAHR.*
import com.jahr.practica1.navigation.PortafolioNavigationJahr
import com.jahr.practica1.ui.theme.Practica1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica1Theme {
                val navController = rememberNavController()
                val drawerState = rememberDrawerState(
                    initialValue = DrawerValue.Closed
                )
                MenuLateral(
                    navController = navController,
                    drawerState = drawerState
                ) {
                    contenido(
                        navController = navController,
                        drawerState = drawerState
                    )
                }

            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun contenido(
    navController: NavHostController,
    drawerState: DrawerState
){
     var mainViewModelJAHR: MainViewModelJAHR = viewModel()
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            Topbar(drawerState)
                 },
        bottomBar ={
            NavegacionInferiorJahr(navController = navController)
        }) { innerPadding ->

        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)){
            PortafolioNavigationJahr(navController = navController)
        }
        if(mainViewModelJAHR.showBottomSheet) {
            ModalBottomSheet(onDismissRequest = {mainViewModelJAHR.showBottomSheet = false}) {
                ContentBottomSheet(navController)
            }
        }
        if(mainViewModelJAHR.showDialogFavoritos){
            DialogoFavoritos(mainViewModelJAHR)
        }
    }
}

@Composable
fun DialogoFavoritos(mainViewModelJAHR: MainViewModelJAHR) {
    AlertDialog(
        icon={
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Icono favoritos",
                modifier = Modifier.size(50.dp))
        },
        title = {Text(text = "Favoritos")},
        text = { Text(text = "Aqui se muestran tus favoritos guardados",
            style = MaterialTheme.typography.bodySmall) },
        onDismissRequest = {mainViewModelJAHR.showDialogFavoritos = false},
        confirmButton = {
            TextButton(onClick = {
                mainViewModelJAHR.showDialogFavoritos = false
            }
            ){
                Text(text = "Cerrar")
            }
        }
    )
}

@Composable
fun ContentBottomSheet(navController: NavHostController){
    val items_config = listOf(
        item_config1,
        item_config2,
        item_config3,
    )
    var mainViewModelJAHR: MainViewModelJAHR = viewModel()
    Column(
        modifier = Modifier.fillMaxSize().height(300.dp).padding(horizontal = 30.dp)
    ){
        Text(text = "Configuración")
        items_config.forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth()
                    .clickable { navController.navigate(item.ruta)
                    mainViewModelJAHR.showBottomSheet = false}
            ) {
                Icon(imageVector = item.icon,
                    contentDescription = item.title)
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = item.title)
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