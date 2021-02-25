/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.views.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.models.dummy
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun DetailScreen(
    dogId: Int,
    navController: NavController
) {
    val scrollState = rememberScrollState()
    // todo どうにかする
    val dog = dummy.get(dogId)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("詳細") }
            )
        },
        content = {
            ConstraintLayout(
                modifier = Modifier
                    .verticalScroll(scrollState)
            ) {
                val (image, name, age) = createRefs()

                Image(
                    painter = painterResource(dog.image),
                    contentDescription = "${dog.name}",
                    modifier = Modifier
                        .constrainAs(image) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )

                Text(
                    dog.name,
                    modifier = Modifier
                        .constrainAs(name) {
                            top.linkTo(image.bottom)
                            start.linkTo(parent.start, 4.dp)
                        },
                    style = MaterialTheme.typography.h3,
                )

                Text(
                    "age : ${dog.age}",
                    modifier = Modifier
                        .constrainAs(age) {
                            top.linkTo(name.bottom)
                            start.linkTo(parent.start, 4.dp)
                        }
                )
            }
        }
    )
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    val navController = rememberNavController()
    MyTheme {
        DetailScreen(1, navController)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    val navController = rememberNavController()
    MyTheme(darkTheme = true) {
        DetailScreen(1, navController)
    }
}
