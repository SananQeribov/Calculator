package com.example.hesabmakinesi

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.hesabmakinesi.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

private lateinit var binding: ActivityMainBinding
private lateinit var cacview: Calculator
private var currentNumber = ""

class MainActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cacview = ViewModelProvider(this).get(Calculator::class.java)
        val numberbuttons = arrayOf(
            binding.sumbt,
            binding.minus,
            binding.bolme,
            binding.vurmabt,
            binding.num0,
            binding.num1,
            binding.num2,
            binding.num3,
            binding.num4,
            binding.num5,
            binding.num6,
            binding.num7,
            binding.num8,
            binding.num9


        )
        numberbuttons.forEach { buttons ->
            buttons.setOnClickListener {

                cacview.inputnumber(buttons.text.toString())
                //  binding.textView.text = binding.textView.text.toString() + buttons.text.toString()
                val stringBuilder = StringBuilder(binding.textView.text.toString())
                stringBuilder.append(buttons.text.toString())
                binding.textView.text = stringBuilder.toString()


            }


        }
        binding.equation.setOnClickListener {
            try {

                val expression = binding.textView.text.toString()
                val result: Double = ExpressionBuilder(expression).build().evaluate()
                binding.textView2.text = result.toString()

            } catch (sanan: Exception) {
                binding.textView2.text = "incorrect"

            }
        }
        binding.ac.setOnClickListener {

            val (clearedText, originalText) = cacview.clear(binding.textView.text.toString())
            binding.textView2.text = clearedText
            binding.textView.text = originalText


        }


    }
}

