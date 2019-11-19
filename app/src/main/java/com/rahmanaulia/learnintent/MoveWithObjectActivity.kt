package com.rahmanaulia.learnintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_move_with_object.*

class MoveWithObjectActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        getData()
    }

    private fun getData() {
        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON)
        if (person != null){
            val text = "Name : ${person.name}\n" +
                    "Email : ${person.email}\n" +
                    "Age : ${person.age}\n" +
                    "Location: ${person.city}"

            tvObjectReceived.text = text
        }
    }
}
