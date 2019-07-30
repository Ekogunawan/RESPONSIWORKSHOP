package com.gmail.akakom16.eko.responsiworkshop
//TODO 1 java : yaitu program di atas  adalah package dari nama projec
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
//TODO 2 java : yaitu program di atas adalah package dari class java sendiri yang bisas di akases untuk mensupport program

class MyListAdapter(private val context: Activity, private val id: Array<String>,
                    private val name: Array<String>, private val email: Array<String>)
    : ArrayAdapter<String>(context, R.layout.custom_list, name) {
    //TODO 3 java : yaitu program di atas membuat class adapter list yaitu mendeklarasikan nilai variabel tersebut yaitu dengan arrray
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.custom_list, null, true)
        val idText = rowView.findViewById(R.id.textViewId) as TextView
        val nameText = rowView.findViewById(R.id.textViewName) as TextView
        val emailText = rowView.findViewById(R.id.textViewEmail) as TextView
//TODO 4 java : yaitu program di atas adalah pembuatan method untuk getView yaitu di dalam method tersebut mendeklaraskan variabel yang di buat di activity xml dan kemudian di method ini di panggil nilai variabel tersebut
        idText.text = "Id: ${id[position]}"
        nameText.text = "Name: ${name[position]}"
        emailText.text = "Email: ${email[position]}"
        return rowView
        //TODO 5 java : yaitu program di atas adalah untuk menmapilkan nilai dari variabel tersebut dan akan di simpan di array dan kemudian data akan di return
    }
}
