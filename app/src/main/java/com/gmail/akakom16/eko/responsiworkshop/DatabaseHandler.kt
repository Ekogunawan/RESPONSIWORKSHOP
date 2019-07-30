package com.gmail.akakom16.eko.responsiworkshop
//TODO 1 java : yaitu program di atas  adalah package dari nama projec
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
//TODO 2 java : yaitu program di atas adalah package dari class java sendiri yang bisas di akases untuk mensupport program

class DatabaseHandler(context: Context): SQLiteOpenHelper(
    //TODO 3 java : yaitu program di atas adalah  pembuatan class databse handler dengan menggunkan data SQLite

    context,DATABASE_NAME,null,DATABASE_VERSION) {
    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "EmployeeDatabase"
        private val TABLE_CONTACTS = "EmployeeTable"
        private val KEY_ID = "id"
        private val KEY_NAME = "name"
        private val KEY_EMAIL = "email"
    }
    //TODO 4 java : yaitu program di atas adalah pembuatan nama database dan mendeklaraikan variabel dari database tersebut

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_CONTACTS_TABLE = ("CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_EMAIL + " TEXT" + ")")
        db?.execSQL(CREATE_CONTACTS_TABLE)
    }
//TODO 5 java : yaitu program di atas adalah pembuatan method onCreate dengan mendeklarasikan pembuatan database tersebuit dan pembhuatan tabel id ,nama dan email dari databse tersebut

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS)
        onCreate(db)
    }
    //TODO 6 java : yaitu program di atas adalah pembuatan method upgrade yaitu fungsi ini di pakai ketika menghapus tabel dari database


    fun addEmployee(emp: EmpModelClass):Long{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_ID, emp.userId)
        contentValues.put(KEY_NAME, emp.userName)
        contentValues.put(KEY_EMAIL,emp.userEmail )

        val success = db.insert(TABLE_CONTACTS, null, contentValues)
        db.close()
        return success
    }
    //TODO 7 java : yaitu program di atas adalah pembuatan method untuk addEmployee yang isinya akan menyimpan atau menambah data id,nama dan email ke database

    fun viewEmployee():List<EmpModelClass>{
        val empList:ArrayList<EmpModelClass> = ArrayList<EmpModelClass>()
        val selectQuery = "SELECT  * FROM $TABLE_CONTACTS"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try{
            cursor = db.rawQuery(selectQuery, null)
        }catch (e: SQLiteException) {
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var userId: Int
        var userName: String
        var userEmail: String
        if (cursor.moveToFirst()) {
            do {
                userId = cursor.getInt(cursor.getColumnIndex("id"))
                userName = cursor.getString(cursor.getColumnIndex("name"))
                userEmail = cursor.getString(cursor.getColumnIndex("email"))
                val emp= EmpModelClass(userId = userId,
                    userName = userName, userEmail = userEmail)
                empList.add(emp)
            } while (cursor.moveToNext())
        }
        return empList
    }
    //TODO 8 java : yaitu program di atas adalah pembuatan method untuk viewEmployee yang isinya akan menampilkan  data id,nama dan email yang berada di database ke layout sctivity

    fun updateEmployee(emp: EmpModelClass):Int{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_ID, emp.userId)
        contentValues.put(KEY_NAME, emp.userName)
        contentValues.put(KEY_EMAIL,emp.userEmail )

        val success = db.update(TABLE_CONTACTS, contentValues,"id="+emp.userId,null)
        db.close()
        return success
    }
    //TODO 9 java : yaitu program di atas adalah pembuatan method untuk updateEmployee yang isinya akan mengupdata atau merubah data id,nama dan email yang sudah di simpan ke database tersebut


    fun deleteEmployee(emp: EmpModelClass):Int{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_ID, emp.userId)
        val success = db.delete(TABLE_CONTACTS,"id="+emp.userId,null)
        db.close()
        return success
    }
    //TODO 10 java : yaitu program di atas adalah pembuatan method untuk deleteEmployee yang isinya akan menghapus  data id,nama dan email di dalam database yang sudah di simpan

}
