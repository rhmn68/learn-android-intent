package com.rahmanaulia.learnintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_move_for_result.*

class MoveForResultActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)

        onClick()
    }

    private fun onClick() {
        btnChoose.setOnClickListener {
            if (rgNumber.checkedRadioButtonId != 0){
                var value = 0
                when(rgNumber.checkedRadioButtonId){
                    R.id.rb50 -> value = 50
                    R.id.rb100 -> value = 100
                    R.id.rb150 -> value = 150
                    R.id.rb200 -> value = 200
                }

                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }
    }
}
