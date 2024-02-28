package com.example.simulacroej1


import android.content.ContentValues
import android.content.Context


class DataManager(context: Context) {

    private val dbHelper = DatabaseHelper(context)

    fun addName(nombre: String, apellidos:String,direccion:String,cp:String,ciudad:String,provincia:String,telefono:String) {
        val db = dbHelper.writableDatabase

        val values = ContentValues().apply {
            put(DatabaseHelper.COLUMN_NAME, nombre)
            put(DatabaseHelper.COLUMN_APELLIDO, apellidos)
            put(DatabaseHelper.COLUMN_DIRECCION, direccion)
            put(DatabaseHelper.COLUMN_CP, cp)
            put(DatabaseHelper.COLUMN_CIUDAD, ciudad)
            put(DatabaseHelper.COLUMN_PROVINCIA, provincia)
            put(DatabaseHelper.COLUMN_TELEFONO, telefono)
        }
        db.insert(DatabaseHelper.TABLE_NAME, null, values)
        db.close()
    }

    fun eliminarUser(){
        val db = dbHelper.writableDatabase
        db.execSQL("delete from ${DatabaseHelper.TABLE_NAME}")
        db.close()
    }


    fun getAllNames(context: Context): String {
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM ${DatabaseHelper.TABLE_NAME}", null)
        val names = StringBuilder()
        while (cursor.moveToNext()) {
            val name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME))
            val apellido = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_APELLIDO))
            val direccion = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DIRECCION))
            val cp = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_CP))
            val ciudad = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_CIUDAD))
            val provincia = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_PROVINCIA))
            val telefono = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_TELEFONO))
            names.append("$name, $apellido, $direccion, $cp, $ciudad, $provincia, $telefono\n")
        }
        cursor.close()
        db.close()
        if (names.isEmpty()) {
            return "No hay nombres en la base de datos"
        }
        return names.toString()
    }
}