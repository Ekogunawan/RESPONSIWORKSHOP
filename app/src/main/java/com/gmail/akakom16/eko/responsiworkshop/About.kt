package com.gmail.akakom16.eko.responsiworkshop
//TODO 1 java : yaitu program di atas  adalah package dari nama projec
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

//TODO 2 java : yaitu program di atas adalah package dari class java sendiri yang bisas di akases untuk mensupport program

class About : AppCompatActivity() {
//TODO 3 java: Yaitu program di atas adalah class about dari class java yang di guanakan dengan extend ke class turunan dengan nama appCompatActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        //TODO 4 java: Yaitu program di atas yaitu untuk fungsi ketika android akan di jalankan dan akan terhubung ke activity xml dari layout tersebut dan akan menampilkan biodata yang di buat di xml tersebut
        linearLayout {
            orientation = LinearLayout.VERTICAL

            editText {
                hint = "Name"

            }.lparams(width = matchParent, height = wrapContent)

            button("Say Hello") {
            }.lparams(width = matchParent, height = wrapContent)
        }
        //TODO 5 java : yaitu program di atas adalah untuk pendeklarasian kode anko di activity.kt yaitu dengan mendeklaraikan edit text dan tombol button

        linearLayout {
            orientation = LinearLayout.VERTICAL

            val myEdt = editText {
                hint = "Name"
            }.lparams(width = matchParent, height = wrapContent)

            button("Say Hello") {
                onClick {
                    val message = if (myEdt.text.toString().isBlank()) {
                        "Hello world"
                    } else {
                        "Hello ${myEdt.text}"
                    }

                    UI {
                        toast(message)
                    }
                }
            }.lparams(width = matchParent, height = wrapContent)
        }
        //TODO 6 java : yaitu program di atas adalah pendeklataian kode anko dengan pengisisan di editText tersebut kemudain jika kita melakukan klikk pada button maka akan menampilkan pesan tulisan yang kita isikan di textView tersebut

    }
}
