package com.example.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    //Global variable
    private var premium: Int = 0
    private var malePremium: Int = 0
    private var smokerPremium: Int = 0
    private var total: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO 1: Link UI to code
        val spinnerAge: Spinner = findViewById(R.id.spinnerAge)
        val radioButtonGender: RadioGroup = findViewById(R.id.radioGroupGender)
        val radioButtonMale: RadioButton = findViewById(R.id.radioButtonMale)
        val checkBoxSmoker: CheckBox = findViewById(R.id.checkBoxSmoker)
        //TODO 2: Set event listener
        spinnerAge.onItemSelectedListener = this

        // 2 way to calculate male premium, declare here or create function
        radioButtonMale.setOnClickListener{
            val male = it.isSelected // it = refers to the current view
            if(male){
                //TODO: calculate male premium
                when(spinnerAge.getSelectedItemPosition()) {
                    0 -> malePremium = 0
                    1 -> malePremium = 50
                    2 -> malePremium = 100
                    3 -> malePremium = 150
                    4 -> malePremium = 200
                    5 -> malePremium = 200
                }
            }
        }

        checkBoxSmoker.setOnCheckedChangeListener { compoundButton, b ->
            if(compoundButton.isChecked){
                //TODO: calculate smoker premium
                when(spinnerAge.getSelectedItemPosition()) {
                    0 -> smokerPremium = 0
                    1 -> smokerPremium = 100
                    2 -> smokerPremium = 150
                    3 -> smokerPremium = 200
                    4 -> smokerPremium = 250
                    5 -> smokerPremium = 300
                }
            }
        }

    }

    /*
    fun calculatePremium(view: View){
        val radioGroupGender: RadioGroup = findViewById(R.id.radioGroupGender)
        val gender = radioGroupGender.checkedRadioButtonId
        if(gender == R.id.radioButtonMale){
            //TODO: calculate male premium
        }
    }
    */

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, index: Int, id: Long) {
        //show the index number at bottom
        //Toast.makeText(this, "Item selected : $index", Toast.LENGTH_SHORT).show()
        when(index){
            0-> premium = 60
            1-> premium = 70
            2-> premium = 90
            3-> premium = 120
            4-> premium = 150
            5-> premium = 150
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        //TODO("Not yet implemented")
    }
}