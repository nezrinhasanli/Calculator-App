package com.nezrin.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.nezrin.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var newOperator = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun buttonSay(view: View) {
        var buttonSec=view as Button
        if (newOperator){
            binding.etNumber.setText("")
            newOperator=false
        }

        var buttonDeger: String = binding.etNumber.text.toString()



        when (buttonSec.id) {
            binding.button0.id -> {
                buttonDeger += "0"
            }
            binding.button1.id -> {
                buttonDeger += "1"
            }
            binding.button2.id -> {
                buttonDeger += "2"
            }
            binding.button3.id -> {
                buttonDeger += "3"
            }
            binding.button4.id -> {
                buttonDeger += "4"
            }
            binding.button5.id -> {
                buttonDeger += "5"
            }
            binding.button6.id -> {
                buttonDeger += "6"
            }
            binding.button7.id -> {
                buttonDeger += "7"
            }
            binding.button8.id -> {
                buttonDeger += "8"
            }
            binding.button9.id -> {
                buttonDeger += "9"
            }
            binding.buttonPlusMinus.id -> {
                buttonDeger = "-$buttonDeger"
            }
        }
        binding.etNumber.setText(buttonDeger)
    }

    var operator = "*"
    var oldnumber = ""

    fun buttonOperator(view: View) {
        val buttonSec = view as Button
        when (buttonSec.id) {
            binding.buttonDivide.id -> {
                operator = "/"
            }
            binding.buttonMultiply.id -> {
                operator = "x"
            }
            binding.buttonMinus.id -> {
                operator = "-"
            }
            binding.buttonPlus.id -> {
                operator = "+"
            }
        }
        oldnumber = binding.etNumber.text.toString()
        newOperator = true
    }

    fun buttonEqual(view: View) {
        var newNumber = binding.etNumber.text.toString()
        var result: Double? = null
        when(operator){
            "/"->{
                result=oldnumber.toDouble()/newNumber.toDouble()
            }
            "x"->{
                result=oldnumber.toDouble()*newNumber.toDouble()
            }
            "+"->{
                result=oldnumber.toDouble()+newNumber.toDouble()
            }
            "-"->{
                result=oldnumber.toDouble()-newNumber.toDouble()
            }
        }
        binding.etNumber.setText(result.toString())
        newOperator=true
    }
    fun buttonAC(view: View){
        binding.etNumber.setText("0")
        newOperator=true
    }
    fun buttonPercent(view: View){
        var say:Double=binding.etNumber.text.toString().toDouble()/100
        binding.etNumber.setText(say.toString())
        newOperator=true
    }
}