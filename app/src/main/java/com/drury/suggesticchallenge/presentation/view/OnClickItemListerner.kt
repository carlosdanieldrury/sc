package com.drury.suggesticchallenge.presentation.view

/**
 * Callback when users clicks on cell on the recyclerView
 */
interface OnClickItemListerner {
    fun showAlertDialog(title: String, message: String)
}