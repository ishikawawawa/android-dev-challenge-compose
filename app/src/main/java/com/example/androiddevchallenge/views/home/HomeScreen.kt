package com.example.androiddevchallenge.views.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.models.dummy
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun HomeScreen(
    navController: NavController
) {
    val scrollState = rememberScrollState()

    Scaffold(content = {
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxHeight(),
        ) {
            // todo そのうちどうにかする
            repeat(10) {
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(horizontal = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    thumbnail(dummy.get(1), Modifier.weight(0.8f)) { dogId ->
                        navController.navigate("detail/${dogId}")
                    }
                    Spacer(Modifier.width(4.dp))
                    thumbnail(dummy.get(2), Modifier.weight(0.8f)) { dogId ->
                        navController.navigate("detail/${dogId}")
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(horizontal = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    thumbnail(dummy.get(3), Modifier.weight(0.8f)) { dogId ->
                        navController.navigate("detail/${dogId}")
                    }
                    Spacer(Modifier.width(4.dp))
                    thumbnail(dummy.get(4), Modifier.weight(0.8f)) { dogId ->
                        navController.navigate("detail/${dogId}")
                    }
                }
            }
        }
    })

}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        HomeScreen(navController = rememberNavController())
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        HomeScreen(navController = rememberNavController())
    }
}
