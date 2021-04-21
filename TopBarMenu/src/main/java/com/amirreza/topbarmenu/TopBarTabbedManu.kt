package com.amirreza.leathershop

import android.content.Context
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.LinearLayout

class TopBarTabbedManu : HorizontalScrollView ,TopBarTabbedItem.IMenuSelectedListener{

    /**
     * Properties
     */

    var items : HashMap<Int,String>

    lateinit var preSelectedItem : TopBarTabbedItem
    var callBack : IMenuItemSelectedChangedListener
    constructor(context: Context,items : HashMap<Int,String>,callBack : IMenuItemSelectedChangedListener) : super(context) {
        this.items = items
        this.callBack = callBack
        init()
    }

    private fun init() {

        this.isHorizontalScrollBarEnabled = false

        var HSparams = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)

        this.layoutParams = HSparams

        //Initilize items holder horizontaly
        var linearHolder = LinearLayout(context)

        var params = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)

        linearHolder.layoutParams = params

        linearHolder.orientation = LinearLayout.HORIZONTAL

        //Add holder to H scroll
        this.addView(linearHolder)
        var selected = false
        for ((key,value) in items){

            val itemView = TopBarTabbedItem(context,value,key,this)

            linearHolder.addView(itemView)
            if (!selected){
                selected = true
                itemView.setSelected()
                callBack.onItemSelectedChanged(key,value)
                this.preSelectedItem = itemView
            }
        }


    }

    override fun onItemSelected(itemView: TopBarTabbedItem) {
        preSelectedItem.removeSelected()
        itemView.setSelected()
        preSelectedItem = itemView
        callBack.onItemSelectedChanged(itemView.itemId,itemView.name)
    }

    public interface IMenuItemSelectedChangedListener{
        fun onItemSelectedChanged(id : Int,name : String)
    }

}