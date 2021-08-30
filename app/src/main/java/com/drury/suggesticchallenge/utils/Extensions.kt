package com.drury.suggesticchallenge.utils

import android.view.View
import com.drury.suggesticchallenge.data.repositories.DayMessageEntity
import com.drury.suggesticchallenge.domain.DayMessageModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> Gson.fromJson(json: String) = fromJson<T>(json, object: TypeToken<T>() {}.type)

fun DayMessageEntity.toDayMessageModel() : DayMessageModel = DayMessageModel(
    title = title,
    subtitle = subtitle,
    day = day
)

fun View.show() { this.visibility = View.VISIBLE }
fun View.gone() { this.visibility = View.GONE }


// Sorry, I know this is not the one best approach but, it solves the issue to convert int to number name until 30
fun Int.toStringName() : String {
    return when (this) {
        1 -> "One"
        2 -> "Two"
        3 -> "Three"
        4 -> "Four"
        5 -> "Five"
        6 -> "Six"
        7 -> "Seven"
        8 -> "Eight"
        9 -> "Nine"
        10 -> "Ten"
        11 -> "Eleven"
        12 -> "Twelve"
        13 -> "Thirteen"
        14 -> "Fourteen"
        15 -> "Fifteen"
        16 -> "Sixteen"
        17 -> "Seventeen"
        18 -> "Eighteen"
        19 -> "Nineteen"
        20 -> "Twenty"
        21 -> "Twenty one"
        22 -> "Twenty two"
        23 -> "Twenty three"
        24 -> "Twenty four"
        25 -> "Twenty five"
        26 -> "Twenty six"
        27 -> "Twenty seven"
        28 -> "Twenty eight"
        29 -> "Twenty nine"
        30 -> "Thirty"
        31 -> "Thirty one"
        else -> "X"
    }
}