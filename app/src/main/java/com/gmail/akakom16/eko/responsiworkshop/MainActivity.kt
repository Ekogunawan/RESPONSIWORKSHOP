package com.gmail.akakom16.eko.responsiworkshop
//TODO 1 java : yaitu program di atas  adalah package dari nama projec
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.view.View
import android.widget.EditText
import android.widget.Toast
//TODO 2 java : yaitu program di atas adalah package dari class java sendiri yang bisas di akases untuk mensupport program

class MainActivity : AppCompatActivity() {
//TODO 3 java: Yaitu program di atas adalah class activity java dari class java yang di guanakan dengan extend ke class turunan dengan nama appCompatActivity

    internal lateinit var editText1:EditText
    internal lateinit var editText2:EditText
    internal lateinit var text1: String
    internal lateinit var text2:String
    // TODO 4 java : Yaitu program di atas adalah mendeklarasikan Variabel yang sifatnya pubic yang bisa di akases di bebagai class di dalam java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //TODO 5 java: Yaitu program di atas yaitu ketika program di jalankan maka akan menampilkan ke activity layout dari class tersebut
    }

fun loginMasuk(view: View) {
    editText1 = findViewById(R.id.edittext_username) as EditText
    editText2 = findViewById(R.id.edittext_password) as EditText
    text1 = editText1.getText().toString()
    text2 = editText2.getText().toString()
    //TODO 6 java: Yaitu program di atas yaitu untuk Method onClick pada Button


    if (text1.contains("Admin") && text2.contains("admin")) {
        Toast.makeText(this, "Login Sukses", Toast.LENGTH_SHORT).show()
        val intent = Intent(this@MainActivity, SecondActivity::class.java)
        startActivity(intent)
        //TODO 7 java: Yaitu program di atas yaitu untuk  Kondisi jika username : Admin dan password : admin , maka akan menampilkan pesan text toast  dan Login sukses dan masuk ke activity 2
    } else if (text1.matches("".toRegex()) || text2.matches("".toRegex()))

    //TODO 8 java: Yaitu program di atas yaitu untuk  Atau jika input text 1 dan text 2 kosong
    {

        Toast.makeText(this, "Isikan Username dan Password", Toast.LENGTH_SHORT).show()
        //TODO 9 java: Yaitu program di atas yaitu Maka akan menampilkan pesan text toast
    } else {


        Toast.makeText(this, "Login Gagal /Username Password Salah", Toast.LENGTH_SHORT).show()
        //TODO 10 java: Yaitu program di atas yaitu jika kedua kondisi diatas tidak memenuhi
    }
}
}
