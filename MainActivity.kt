package com.example.myapplication48_1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        clear.setOnClickListener {
            fname.setText("")
            sname.setText("")
        }

        send.setOnClickListener {
            val name = fname.text.toString()
            val surname = sname.text.toString()
            val firebase = FirebaseDatabase.getInstance()
            val ref = firebase.getReference("Employee")
            val id:String? = ref.push().key
            val Employee = Employee(id.toString(),name, surname)
            ref.child(id.toString()).setValue(Employee).addOnCompleteListener {
                Toast.makeText(applicationContext, "complete", Toast.LENGTH_LONG).show()
                fname.setText("")
                sname.setText("")
            }
        }
    }
}