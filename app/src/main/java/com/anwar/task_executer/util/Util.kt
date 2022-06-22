package com.anwar.task_executer.util

import android.graphics.Typeface
import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import kotlin.coroutines.CoroutineContext

object Util {

    val DefaultThread: CoroutineContext
        get() = Default + SupervisorJob()
}

fun <T : Any?, L : StateFlow<T>> LifecycleOwner.observe(sharedFlow: L, body: (T) -> Unit) {
    lifecycleScope.launch {
        sharedFlow.collect {
            body.invoke(it)
        }
    }
}

fun getDateAndTime(): String {
    val sdf = SimpleDateFormat("dd-M-yyyy hh:mm:ss")
    return sdf.format(Date())
}

fun String.makeLastTextBold(): SpannableString {
    return SpannableString(this).apply {
        if (this.isNotEmpty()) {
            val start = this.indexOf("T")
            setSpan(StyleSpan(Typeface.BOLD), start, this.length, 0)
            setSpan(RelativeSizeSpan(1.2f), start, this.length, 0)
        }
    }
}
