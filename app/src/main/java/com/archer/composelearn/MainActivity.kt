package com.archer.composelearn

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toBitmap
import com.archer.composelearn.old.OldViewActivity
import com.archer.composelearn.ui.theme.ComposeLearnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLearnTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }

        startActivity(Intent(applicationContext, OldViewActivity::class.java))
    }
}

@Composable
fun Greeting(name: String) {
    LazyColumn {
       items(100) {
           Greeting1(name)
       }
    }
}

@Composable
fun Greeting1(name: String) {
    var isExpanded by remember {
        mutableStateOf(false)
    }

    /* var foreground= remember {
         mutableStateOf(painterResource(id = R.drawable.ic_launcher_foreground))

     }*/


    val resource = LocalContext.current.resources
    val background by remember {
        mutableStateOf(
            ResourcesCompat.getDrawable(resource, R.drawable.ic_launcher_background, null)!!
                .toBitmap().asImageBitmap()
        )
    }

    Row(
        Modifier
            .clickable { isExpanded = !isExpanded }
            .fillMaxWidth()) {
        /*Box(
            Modifier
                .size(50.dp)
                .background(Color.Blue)
                .padding(5.dp)
                .background(Color.Cyan)
                .padding(5.dp)
                .background(Color.Red)
        )*/


        Image(

            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .padding(10.dp)
                .clip(CircleShape)
                .border(2.dp, MaterialTheme.colors.secondary, CircleShape)
                .drawBehind {
                    drawImage(background)
                }
                .size(if (isExpanded) 100.dp else 50.dp)
//                .paint(painterResource(id = R.drawable.ic_launcher_background))
                .animateContentSize()
        )

        Text(text = "Hello $name!", style = MaterialTheme.typography.subtitle2)

    }}

