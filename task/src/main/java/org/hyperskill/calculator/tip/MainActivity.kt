package org.hyperskill.calculator.tip

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    private var number = 0.0
    private var percent = 0.0
    private var output:TextView? = null
    private var slider: Slider? = null
    private var input: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        output = findViewById(R.id.text_view)

        input = findViewById(R.id.edit_text)

        slider = findViewById(R.id.slider)


        slider?.addOnChangeListener(object: Slider.OnChangeListener {
            override fun onValueChange(slider: Slider, value: Float, fromUser: Boolean) {
                current()
            }

        })


        input?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                current()
            }
        })
    }
    fun current() {
        if (input?.text.toString().isEmpty()) {
            output?.text = ""
        }
        else {
            percent = slider?.value?.toDouble() ?: 0.0
            number = input?.text.toString().toDouble()

            output?.text = "Tip amount: ${String.format("%.2f", number * (percent / 100.0))}"
        }
    }
}