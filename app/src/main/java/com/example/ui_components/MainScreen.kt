package com.example.ui_components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.appinfo.MainViewModel
import com.example.utils.DrawerEvents
import com.example.utils.ListItem
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    mainViewModel: MainViewModel = hiltViewModel(),
    onClick: (ListItem) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    val mainList = mainViewModel.mainList
    val topBarTitle = remember {
        mutableStateOf("Грибы")
    }
    LaunchedEffect(Unit) {
        mainViewModel.getAllItemsByCategory(topBarTitle.value)
    }
    Scaffold(
        topBar = {
            MainTopBar(
                title = topBarTitle.value,
                scaffoldState = scaffoldState
            ) {
                topBarTitle.value = "Избранное"
                mainViewModel.getFavorites()
            }
        },
        drawerContent = {
            DrawerMenu() { event ->
                when (event) {
                    is DrawerEvents.OnItemClick -> {
                        topBarTitle.value = event.title
                        mainViewModel.getAllItemsByCategory(event.title)

                    }
                }
                coroutineScope.launch {
                    scaffoldState.drawerState.close()
                }

            }
        }
    ) { paddingValues ->
        paddingValues
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(mainList.value) { item ->
                MainListItem(item = item) { listItem ->
                    onClick(listItem)
                }
            }
        }
    }
}
