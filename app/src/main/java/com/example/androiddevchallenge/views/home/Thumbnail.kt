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
            )) {
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
