package com.mubassyir.progresiveloginpage.custom_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity.CENTER
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.mubassyir.progresiveloginpage.R

class CustomButton : AppCompatButton {

    private var disabledBackground : Drawable? = null
    private var enabledBackground : Drawable? = null

    private var txtColor: Int = 0


    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        background = when {
            isEnabled -> enabledBackground
            else -> disabledBackground
        }

        setTextColor (txtColor)
        textSize = 12f
        gravity = CENTER

        text = when {
            isEnabled -> "Login"
            else -> "Isi data"
        }
    }

    private fun init(){
        txtColor = ContextCompat.getColor(context, android.R.color.background_light)
        disabledBackground = ResourcesCompat.getDrawable(resources,
            R.drawable.bg_button_disable,null)
        enabledBackground = ResourcesCompat.getDrawable(resources,
            R.drawable.bg_button,null)
    }

}