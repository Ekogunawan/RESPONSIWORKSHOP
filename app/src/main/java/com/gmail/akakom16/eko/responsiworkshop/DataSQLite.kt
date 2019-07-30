package com.gmail.akakom16.eko.responsiworkshop
//TODO 1 java : yaitu program di atas  adalah package dari nama projec
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_data_sqlite.*
//TODO 2 java : yaitu program di atas adalah package dari class java sendiri yang bisas di akases untuk mensupport program

class DataSQLite : AppCompatActivity() {
//TODO 3 java : yaitu program di atas adalah  pembuatan class dataSqlite activity kt

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_sqlite)
    }
    //TODO 4 java : yaitu program di atas adalah method ketika class ini di jalankan maka akan menampilkan layout dari activity tersebut

    fun saveRecord(view: View){
        val id = u_id.text.toString()
        val name = u_name.text.toString()
        val email = u_email.text.toString()
        val databaseHandler: DatabaseHandler= DatabaseHandler(this)
        if(id.trim()!="" && name.trim()!="" && email.trim()!=""){
            val status = databaseHandler.addEmployee(
                EmpModelClass(Integer.parseInt(id),name, email))
            if(status > -1){
                Toast.makeText(applicationContext,"record save", Toast.LENGTH_LONG)
                    .show()
                u_id.text.clear()
                u_name.text.clear()
                u_email.text.clear()
            }
        }else{
            Toast.makeText(applicationContext,"id or name or email cannot be blank",
                Toast.LENGTH_LONG).show()
        }

    }
    //TODO 5 java : yaitu program di atas adalah pembutan method saveRecord yang isinya akan menyimpan data yang sudah diisikan yang akan di simpan di databse yang di buat di class databaseHandler yang sudah di buat

    fun viewRecord(view: View){
        val databaseHandler: DatabaseHandler= DatabaseHandler(this)
        val emp: List<EmpModelClass> = databaseHandler.viewEmployee()
        val empArrayId = Array<String>(emp.size){"0"}
        val empArrayName = Array<String>(emp.size){"null"}
        val empArrayEmail = Array<String>(emp.size){"null"}
        var index = 0
        for(e in emp){
            empArrayId[index] = e.userId.toString()
            empArrayName[index] = e.userName
            empArrayEmail[index] = e.userEmail
            index++
        }
        val myListAdapter = MyListAdapter(this,empArrayId,empArrayName,
            empArrayEmail)
        listView.adapter = myListAdapter
    }
    //TODO 6 java : yaitu program di atas adalah pembutan method viewRecord yang isinya akan menampilkan  data yang sudah diisikan yang akan di simpan di databse yang di buat di class databaseHandler yang sudah di buat

    fun updateRecord(view: View){
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.update_dialog, null)
        dialogBuilder.setView(dialogView)

        val edtId = dialogView.findViewById(R.id.updateId) as EditText
        val edtName = dialogView.findViewById(R.id.updateName) as EditText
        val edtEmail = dialogView.findViewById(R.id.updateEmail) as EditText

        dialogBuilder.setTitle("Update Record")
        dialogBuilder.setMessage("Enter data below")
        dialogBuilder.setPositiveButton("Update", DialogInterface.OnClickListener {
                _, _ ->

            val updateId = edtId.text.toString()
            val updateName = edtName.text.toString()
            val updateEmail = edtEmail.text.toString()
            val databaseHandler: DatabaseHandler= DatabaseHandler(this)
            if(updateId.trim()!="" && updateName.trim()!="" && updateEmail.trim()!=""){
                val status = databaseHandler.updateEmployee(EmpModelClass(Integer.parseInt(updateId),updateName, updateEmail))
                if(status > -1){
                    Toast.makeText(applicationContext,"record update", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(applicationContext,"id or name or email cannot be blank", Toast.LENGTH_LONG).show()
            }

        })
        dialogBuilder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->
        })
        val b = dialogBuilder.create()
        b.show()
    }
    //TODO 7 java : yaitu program di atas adalah pembutan method updateRecord yang isinya akan mengupdate data yang sudah diisikan yang akan di simpan di databse yang di buat di class databaseHandler yang sudah di buat

    fun deleteRecord(view: View){
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.delete_dialog, null)
        dialogBuilder.setView(dialogView)

        val dltId = dialogView.findViewById(R.id.deleteId) as EditText
        dialogBuilder.setTitle("Delete Record")
        dialogBuilder.setMessage("Enter id below")
        dialogBuilder.setPositiveButton("Delete", DialogInterface.OnClickListener {
                _, _ ->

            val deleteId = dltId.text.toString()
            val databaseHandler: DatabaseHandler= DatabaseHandler(this)
            if(deleteId.trim()!=""){
                val status = databaseHandler.deleteEmployee(EmpModelClass(
                    Integer.parseInt(deleteId),"",""))
                if(status > -1){
                    Toast.makeText(applicationContext,"record deleted",
                        Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(applicationContext,
                    "id or name or email cannot be blank", Toast.LENGTH_LONG).show()
            }

        })
        dialogBuilder.setNegativeButton("Cancel", DialogInterface.OnClickListener {
                _, _ ->
        })
        val b = dialogBuilder.create()
        b.show()
    }
    //TODO 5 java : yaitu program di atas adalah pembutan method deleteRecord yang isinya akan menghapus data yang sudah diisikan yang akan di simpan di databse yang di buat di class databaseHandler yang sudah di buat


}
