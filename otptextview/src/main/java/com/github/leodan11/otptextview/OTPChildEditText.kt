package com.github.leodan11.otptextview

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat

internal class OTPChildEditText : AppCompatEditText {

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context)
    }

    private fun init(context: Context) {
        isCursorVisible = false
        setTextColor(ContextCompat.getColor(context, android.R.color.transparent))
        setBackgroundDrawable(null)
        inputType = InputType.TYPE_CLASS_TEXT
        setSelectAllOnFocus(false)
        setTextIsSelectable(false)
    }

    public override fun onSelectionChanged(start: Int, end: Int) {

        val text = text
        text?.let { editable ->
            if (start != editable.length || end != editable.length) {
                setSelection(editable.length, editable.length)
                return
            }
        }

        super.onSelectionChanged(start, end)
    }

}