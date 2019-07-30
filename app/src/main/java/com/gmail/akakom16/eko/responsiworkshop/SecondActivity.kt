package com.gmail.akakom16.eko.responsiworkshop
//TODO 1 java : yaitu program di atas  adalah package dari nama projec
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
//TODO 2 java : yaitu program di atas adalah package dari class java sendiri yang bisas di akases untuk mensupport program

class SecondActivity : AppCompatActivity() {
    //TODO 3 java: Yaitu program di atas adalah class seconactivity  dari class java yang di guanakan dengan extend ke class turunan dengan nama appCompatActivity

    internal lateinit var btnAbout: Button
    internal lateinit var btnSqlite:Button
    // TODO 4 java : Yaitu program di atas adalah mendeklarasikan Variabel yang sifatnya pubic yang bisa di akases di bebagai class di dalam java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        btnAbout = findViewById<View>(R.id.btnAbout) as Button
        btnAbout.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext, "Anda Menekan Tombol ABOUT", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@SecondActivity, About::class.java)
            startActivity(intent)
            //TODO 5 java: Yaitu program diatas ketika class ini di jalankan maka ketika kita mengklikk button about maka akan berpindah activity ke class seconactivity dan kemudian menampilkan pesan "anda menekan tombol about"
        })
        btnSqlite = findViewById<View>(R.id.btnSqlite) as Button
        btnSqlite.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext, "Anda Menekan Tombol DATA SQLite", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@SecondActivity, DataSQLite::class.java)
            startActivity(intent)
            //TODO 6 java: Yaitu program diatas ketika class ini di jalankan maka ketika kita mengklikk button SQLite maka akan berpindah activity ke class dataSqlite dan kemudian menampilkan pesan "anda menekan tombol SQLite"

        })

    }
}
