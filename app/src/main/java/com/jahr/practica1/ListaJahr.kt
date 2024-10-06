package com.jahr.practica1

import android.graphics.drawable.Icon
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDirection.Companion.Content
import androidx.compose.ui.unit.dp
import com.jahr.practica1.models.items_lista
import com.jahr.practica1.models.items_lista.*

@Composable
fun ListaJahr(modifier: Modifier){
    //Text(text = "esto es lista screem")
    val items = listOf(
        item1, item2, item3, item4, item5
    )
    Column(modifier=modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.img), contentDescription = "JAHR")
        LazyColumn(contentPadding = PaddingValues(20.dp)) {
            items(items) {
                //Text(text=it.title)
                ListItemRow(it)
                HorizontalDivider(color = MaterialTheme.colorScheme.outline)
            }
        }
        Button(colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onPrimary,
            contentColor = MaterialTheme.colorScheme.primary
        ), onClick = {}) {
            Text(text = "JAHR")
        }
    }
}

@Composable
fun ListItemRow(it: items_lista) {
    var masinfo = remember{
        mutableStateOf(false)
    }
    Column(modifier = Modifier.animateContentSize(animationSpec = tween(200))) {
        Row {
            Text(
                text = it.title,
                modifier = Modifier.weight(1f)
            )

            IconButton(onClick = {
                masinfo.value=!masinfo.value
            }) {
                Icon(
                    imageVector = if(masinfo.value)Icons.Filled.KeyboardArrowUp
                            else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "mas información"
                )
            }
        }
        if(masinfo.value){
            Row{
                Text(
                    text = it.details,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}