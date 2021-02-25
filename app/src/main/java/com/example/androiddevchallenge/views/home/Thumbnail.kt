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
package com.example.androiddevchallenge.views.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.Dog

@Composable
fun thumbnail(dog: Dog, modifier: Modifier, onPress: (dogId: Int) -> Unit) {
    ConstraintLayout(modifier) {
        val (favoriteButton) = createRefs()

        Box(
            Modifier.clickable(
                onClick = { onPress(dog.id) }
            )
        ) {
            Image(
                painter = painterResource(dog.thumbnail),
                contentDescription = "${dog.name}",
            )
        }

        // todo お気に入りに登録されている場合とそうでない場合のアイコンを切り分ける
        Image(
            painter = painterResource(R.drawable.ic_favorite),
            contentDescription = "favorite",
            modifier = Modifier
                .constrainAs(favoriteButton) {
                    end.linkTo(parent.end, margin = 2.dp)
                    bottom.linkTo(parent.bottom, margin = 2.dp)
                }
                .clickable(onClick = {})
        )
    }
}
