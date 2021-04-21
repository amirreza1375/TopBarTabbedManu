package com.amirreza.leathershop

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.TypedValue
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.LinearLayout
import android.widget.TextView


class TopBarTabbedItem : LinearLayout,View.OnClickListener {

    /**
     * Properties
     */
    var name : String
    var itemId : Int

    lateinit var selectLine : LinearLayout
    lateinit var nameTxt : TextView
    var callBack : IMenuSelectedListener

    constructor(context: Context , name : String, id : Int,callBack : IMenuSelectedListener) : super(context){
        this.name = name
        this.itemId = id
        this.callBack  = callBack
        init()
    }

    private fun init() {

        var params = LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT)
        params.setMargins(dpToPx(12f,context),dpToPx(0f,context),dpToPx(12f,context),dpToPx(0f,context))


        this.layoutParams = params

        this.orientation = VERTICAL


        nameTxt = TextView(context)

        nameTxt.text = name
        nameTxt.setTextColor(Color.GRAY)
        nameTxt.setTextSize(dpToPx(5f,context).toFloat())

        this.addView(nameTxt)

         selectLine = LinearLayout(context)

        var lineParams = LayoutParams(LayoutParams.MATCH_PARENT,dpToPx(2f,context))
        lineParams.setMargins(dpToPx(8f,context),dpToPx(4f,context),dpToPx(8f,context),dpToPx(0f,context))
        selectLine.layoutParams = lineParams
        selectLine.setBackgroundColor(Color.BLACK)


        this.setOnClickListener(this)


    }

    public fun setSelected(){

        val sa = ScaleAnimation(1f,1.3f,1f,1.3f,0f,0f)
        sa.duration = 100
        this.nameTxt.startAnimation(sa)
        sa.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationEnd(animation: Animation?) {
                addView(selectLine)
                nameTxt.typeface = Typeface.DEFAULT_BOLD
                nameTxt.setTextColor(Color.BLACK)
                nameTxt.setTextSize(dpToPx(7f,context).toFloat())
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationStart(animation: Animation?) {

            }
        })


    }

    public fun removeSelected(){

        val sa = ScaleAnimation(1f,0.7f,1f,0.7f)
        sa.duration = 100
        this.nameTxt.startAnimation(sa)
        sa.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationEnd(animation: Animation?) {
                nameTxt.typeface = Typeface.DEFAULT
                nameTxt.setTextColor(Color.GRAY)
                nameTxt.setTextSize(dpToPx(5f,context).toFloat())
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationStart(animation: Animation?) {

            }
        })

        this.removeViewAt(1)


    }



    //endregion
    fun dpToPx(dp: Float, context: Context): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp,
            context.resources.displayMetrics
        ).toInt()
    }

    public interface IMenuSelectedListener{
        fun onItemSelected(itemView : TopBarTabbedItem)
    }

    override fun onClick(v: View?) {
        if (v == this){
            callBack.onItemSelected(this)
        }
    }

}