
https://user-images.githubusercontent.com/35161999/115717512-7d229000-a38f-11eb-831e-9b998edd359b.mov

# TopBarTabbedManu


Hi there 

This is a tool to create easy top bar tabbed manu for online shop app or other uses

Only thing you need to do is to create an instance of TopBarTabbedManu and add it as view to a ViewGroup any where you want




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


allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}


dependencies {
	        implementation 'com.github.amirreza1375:TopBarTabbedManu:1.0.00'
	}
