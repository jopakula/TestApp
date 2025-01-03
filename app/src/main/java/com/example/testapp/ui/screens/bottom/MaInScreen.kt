package com.example.testapp.ui.screens.bottom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.testapp.R
import com.example.testapp.data.DataStoreManager
import com.example.testapp.data.storage.lessonCards
import com.example.testapp.navigation.Screens
import com.example.testapp.ui.helpfulFunctions.ChangeStatusBarColor
import com.example.testapp.uikit.cards.MyCard
import com.example.testapp.uikit.common.BlackColor
import com.example.testapp.uikit.common.GrayColor
import com.example.testapp.uikit.common.WhiteColor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    navigationController: NavHostController,
    dataStoreManager: DataStoreManager ,
) {

    val selectedLessonIds = remember { mutableStateListOf<Int>() }

    LaunchedEffect(Unit) {
        dataStoreManager.getSelectedLessonsFlow().collect { storedIds ->
            selectedLessonIds.clear()
            selectedLessonIds.addAll(storedIds)
        }
    }

    ChangeStatusBarColor(color = WhiteColor, isIconsLight = false)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = WhiteColor),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            modifier = Modifier
                .padding(start = 16.dp, top = 64.dp, end = 16.dp, bottom = 16.dp),
            text = "Main",
            fontSize = 34.sp,
            fontWeight = FontWeight.ExtraBold,
            color = BlackColor
        )
        HorizontalDivider()
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(bottom = 8.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier
                            .padding(vertical = 16.dp),
                        text = "Started lessons",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = GrayColor
                    )
                }
            }
            if (selectedLessonIds.isEmpty()) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(280.dp),
                        contentAlignment = Alignment.Center,
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.shopping_card),
                                contentDescription = null
                            )
                            Text(
                                text = "No lessons started",
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "YWe recommend taking 2 lessons per month. \n Choose any you would like to study",
                                textAlign = TextAlign.Center,
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            } else {
                items(lessonCards.filter { selectedLessonIds.contains(it.id) }) { card ->
                    MyCard(
                        card = card,
                        onClick = {
                            navigationController.navigate(Screens.Detail.createRoute(cardId = card.id))
                        }
                    )
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier
                            .padding(vertical = 16.dp),
                        text = "All lesson",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = GrayColor
                    )
                }
            }
            items(lessonCards) { card ->
                MyCard(
                    card = card,
                    onClick = {
                        navigationController.navigate(Screens.Detail.createRoute(cardId = card.id))
                        CoroutineScope(Dispatchers.IO).launch {
                            dataStoreManager.saveLessonId(id = card.id)
                        }
                    }
                )
            }

        }
    }
}

@Composable
@Preview
private fun MainScreenPreview() {
    val context = LocalContext.current
    val dataStoreManager = DataStoreManager(context)
    MainScreen(
        navigationController = rememberNavController(),
        dataStoreManager = dataStoreManager
    )
}