package com.miu.walmatrstroreapp_extention

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculaterApp: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
    }

    fun click(view: View) {
        val num1 = et1.text.toString()
        val num2 = et2.text.toString()
        when (view.id) {
            R.id.add -> {
                val addition = num1.toInt() + num2.toInt()
                tv4.text = addition.toString()
            }
            R.id.sub -> {
                val minus = num1.toInt() - num2.toInt()
                tv4.text = minus.toString()
            }
            R.id.mul -> {
                val mult = num1.toInt() * num2.toInt()
                tv4. text = mult.toString()
            }
            R.id.div -> try {
                val dvd = num1.toInt() / num2.toInt()
                tv4.text = dvd.toString()
            }
            catch (e:Exception) {
                tv4.text = "Division be Zero"
            }
        }
    }
}