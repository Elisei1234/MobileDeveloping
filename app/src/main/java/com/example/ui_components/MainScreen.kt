package com.example.ui_components

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.utils.DrawerEvents
import com.example.utils.IdArrayList
import com.example.utils.ListItem


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen (context: Context, onClick: (ListItem) ->Unit) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCaroutineScope()
    val mainList = remember {
        mutableStateOf(getListItemsByIndex(0, this))
    }
    val topBarTitle = remember {
        mutableStateOf("Грибы")
    }
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MainTopBar(
                title = topBarTitle.value,
                scaffoldState
            )
        },
        drawerContent = {
            Drawer_menu() { event ->
                when (event) {
                    is DrawerEvents.OnItemClick -> {
                        topBarTitle.value = event.title
                        mainList.value = getListItemsByIndex(
                            event.index, context)
                    }
                }
                coroutineScope.launch {
                    scaffoldState.drawerState.close()
                }

            }
        }
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(mainList.value) { item ->
                MainListItem(item = item){listItem ->
                    onClick(listItem)
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
                itemArray[1],
                itemArray[2]
            )
        )
    }
    return list
}