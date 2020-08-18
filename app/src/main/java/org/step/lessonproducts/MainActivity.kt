package org.step.lessonproducts

import android.graphics.Color

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    val  range  = 1..15
    lateinit var btnCheck: Button
    lateinit var products:LinearLayout


    var checkBoxList: ArrayList<CheckBox> = ArrayList()

    var productList: ArrayList<String> = arrayListOf(
        "Milk", "Water", "Coffee", "RedBull", "Tea",
        "Juice", "Oreo", "Twix", "Snikers", "Kit-Kat",
        "Nutella", "Kinder", "Bread", "Meat", "Fish",
        "Brokolli", "Oil", "Carrot", "Potatoes", "Onion",
        "Cheese", "French fries", "Burger", "Tuna",
        "Spaghetti","Salmon", "Pepper", "Chicken", "Rice"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCheck = findViewById(R.id.btn_check)
        products = findViewById(R.id.products)


        for(i in range){

            var product = productList.shuffled().first()
            var check : CheckBox = CheckBox(applicationContext)
            check.setText(product)
            productList.remove(product)
            products.addView(check)
            checkBoxList.add(check)
        }

        btnCheck.setOnClickListener {
            for (checkbox in checkBoxList) {
                if (checkbox.isChecked) {
                    checkbox.setTextColor(Color.GRAY)
                }
                else{
                    checkbox.setTextColor(Color.RED)
                }
            }
        }
    }
}



