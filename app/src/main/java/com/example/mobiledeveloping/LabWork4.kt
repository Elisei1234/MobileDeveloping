package com.example.mobiledeveloping

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My First App") },
                navigationIcon = {
                    IconButton(onClick = {}){
                        Icon(Icons.Filled.FavoriteBorder, contentDescription = "Menu" )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar{
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {

                    IconButton(onClick = {})
                    {
                        Icon(Icons.Filled.DateRange, contentDescription = "Date",
                            modifier = Modifier.size(40.dp))
                    }
                    IconButton(onClick = {})
                    {
                        Icon(Icons.Filled.Home, contentDescription = "Home",
                            modifier = Modifier.size(40.dp))

                    }
                    IconButton(onClick = {})
                    {
                        Icon(Icons.Filled.AccountCircle, contentDescription = "Account",
                            modifier = Modifier.size(40.dp))

                    }
                }

            }
        },

    ) {padding ->
        padding
        Column(

            modifier = Modifier.fillMaxHeight()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text("Hello. Thats your last chats", modifier = Modifier.padding(15.dp))
            LazyColumn(){
                items(100){index->
                    Row (

                    ){
                        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "desc", modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .background(color = Color.Gray)
                        )
                        Column (){
                            Text("Chat number $index")
                            Text("That a simple example for chat number $index. I " +
                                    "just want to see this text on two lines so that you can try to make a restriction")
                        }
                    }

                }
            }

        }




    }
}

@Preview
@Composable
private fun preview() {
    SecondScreen()
}
