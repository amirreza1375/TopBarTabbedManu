package com.amirreza.exampletopbarmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ArrayAdapter
import com.amirreza.leathershop.TopBarTabbedManu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,TopBarTabbedManu.IMenuItemSelectedChangedListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var items : HashMap<Int,String> = HashMap()
        items.put(0,"Hand bag")
        items.put(1,"Jewellery")
        items.put(2,"Foot wear")
        items.put(3,"Dresses")
        items.put(4,"Shoes")
        items.put(5,"Clothes")

        val tabbedMenu = TopBarTabbedManu(this,items,this)

        menuHolder.addView(tabbedMenu)

    }

    override fun onItemSelectedChanged(id: Int, name: String) {

        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getArray(name))
        list.adapter = adapter

        refresh.isRefreshing = true
        Handler().postDelayed(Runnable {
            refresh.isRefreshing = false
        },1000)
    }

    private fun  getArray(name: String) : ArrayList<String> {

        var items : ArrayList<String> = ArrayList()

        items.add(name + " number 1")
        items.add(name + " number 2")
        items.add(name + " number 3")
        items.add(name + " number 4")
        items.add(name + " number 5")
        items.add(name + " number 6")
        items.add(name + " number 7")
        items.add(name + " number 8")
        items.add(name + " number 9")
        items.add(name + " number 10")
        items.add(name + " number 11")
        items.add(name + " number 12")
        items.add(name + " number 13")
        items.add(name + " number 14")
        items.add(name + " number 15")
        items.add(name + " number 16")
        items.add(name + " number 17")
        items.add(name + " number 18")
        items.add(name + " number 19")
        items.add(name + " number 21")
        items.add(name + " number 22")
        items.add(name + " number 23")
        items.add(name + " number 24")
        items.add(name + " number 25")
        items.add(name + " number 26")
        items.add(name + " number 27")

        return items


    }
}