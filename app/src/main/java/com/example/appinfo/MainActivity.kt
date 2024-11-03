package com.example.appinfo

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appinfo.ui.theme.AppInfoTheme
import com.example.ui_components.MainTopBar
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import com.example.ui_components.DrawerMenu
import com.example.ui_components.MainListItem
import com.example.utils.DrawerEvents
import com.example.utils.IdArrayList
import com.example.utils.ListItem


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val scaffoldState = rememberScaffoldState()
            val coroutineScope = rememberCaroutineScope()
            val mainList = remember {
                mutableStateOf(getListItemsByIndex(0, this))
            }
            val topBarTitle = remember {
                mutableStateOf("Грибы")
            }
            AppInfoTheme {
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        MainTopBar(title = topBarTitle.value,
                            scaffoldState
                        )
                    },
                    drawerContent = {
                        Drawer_menu(){event ->
                            when(event){
                                is DrawerEvents.OnItemClick -> {
                                    topBarTitle.value = event.title
                                    mainList.value = getListItemsByIndex(
                                        event.index, this@MainActivity)
                                }
                            }
                            coroutineScope.launch{
                                scaffoldState.drawerState.close()
                            }

                        }
                    }
                ) {
                    LazyColumn (modifier = Modifier.fillMaxSize()){
                        items(mainList.value){item ->
                            MainListItem(item = item)
                        }
                    }
                }
            }
        }
    }
}

private fun getListItemsByIndex(index: Int, context: Context): List<ListItem>{
    val list = ArrayList<ListItem>()
    val arrayList = context.resources.getStringArray(IdArrayList.listId[index])
    arrayList.forEach {item ->
        val itemArray = item.split("|")
            list.add(
                ListItem(
                    itemArray[0],
                    itemArray[1]
                )
            )
    }
    return list
}