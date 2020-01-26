package com.hackmt.wuphf.util

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager


fun View.showWhen(thisIsTrue: Boolean): View {
    this.visibility = if(thisIsTrue) View.VISIBLE else View.INVISIBLE
    return this
}

fun View.hideKeyBoardOnPressAway(){
    this.onFocusChangeListener = keyboardHider
}

private val keyboardHider = View.OnFocusChangeListener { view, b ->
    if (!b) { hideKeyboardFrom(view) }
}

private fun hideKeyboardFrom(view: View) {
    val imm = view.context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}