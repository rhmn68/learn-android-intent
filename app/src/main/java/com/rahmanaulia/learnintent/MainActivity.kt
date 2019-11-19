package com.rahmanaulia.learnintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onClick()
    }

    private fun onClick() {
        btnMoveActivity.setOnClickListener {
            val moveIntent = Intent(this, MoveActivity::class.java)
            startActivity(moveIntent)
        }

        /**
         * Explicit Intent
         * */

        btnMoveWithData.setOnClickListener {
            val moveWithDataIntent = Intent(this, MoveWithDataActivity::class.java)

            moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Aulia Rahman")
            moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 23)

            startActivity(moveWithDataIntent)
        }

        btnMoveWithObject.setOnClickListener {
            val moveWithObjectIntent = Intent(this, MoveWithObjectActivity::class.java)
            val person = Person(
                "Aulia Rahman",
                23,
                "auliar74@gmail.com",
                "Cimahi"
            )
            moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
            startActivity(moveWithObjectIntent)
        }

        /**
         * Implicit Intent
         * */

        btnDialNumber.setOnClickListener {
            val phoneNumber = "1234567890"
            val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(dialPhoneIntent)
        }

        /**
         * Result Activity
         * */

        btnMoveActivityWithResult.setOnClickListener {
            val moveForResultActivity = Intent(this, MoveForResultActivity::class.java)
            startActivityForResult(moveForResultActivity, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE){
            if (resultCode == MoveForResultActivity.RESULT_CODE){
                val selectedValue = data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
                val text = "Hasil: $selectedValue"
                tvResult.text = text
            }
        }
    }
}
