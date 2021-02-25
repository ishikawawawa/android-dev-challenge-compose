package com.example.androiddevchallenge.models

import com.example.androiddevchallenge.R

// サムネイルの画像サイズは512x512
// 詳細画面の画像サイズは640x480
data class Dog(
    val id: Int,
    val name: String,
    val age: Int,
    val isFavorite: Boolean,
    val thumbnail: Int, // resource id
    val image: Int // resource id
)

val dummy = listOf<Dog>(
    Dog(0, "coco", 1, false, R.drawable.dog_thumb_1, R.drawable.dog_detail_1),
    Dog(1, "mugi", 2, true, R.drawable.dog_thumb_2, R.drawable.dog_detail_2),
    Dog(2, "sora", 0, false, R.drawable.dog_thumb_3, R.drawable.dog_detail_3),
    Dog(3, "marron", 0, false, R.drawable.dog_thumb_4, R.drawable.dog_detail_4),
    Dog(4, "momo", 2, false, R.drawable.dog_thumb_1, R.drawable.dog_detail_1),
    Dog(5, "moca", 1, true, R.drawable.dog_thumb_2, R.drawable.dog_detail_2),
    Dog(6, "moco", 0, false, R.drawable.dog_thumb_3, R.drawable.dog_detail_3),
    Dog(7, "choco", 2, false, R.drawable.dog_thumb_4, R.drawable.dog_detail_4),
    Dog(8, "hana", 0, false, R.drawable.dog_thumb_1, R.drawable.dog_detail_1),
    Dog(9, "maru", 1, true, R.drawable.dog_thumb_2, R.drawable.dog_detail_2),
    Dog(10, "pochi", 0, false, R.drawable.dog_thumb_3, R.drawable.dog_detail_3),
    Dog(11, "sora", 0, false, R.drawable.dog_thumb_4, R.drawable.dog_detail_4)
)
