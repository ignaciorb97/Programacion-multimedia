package com.example.ExamenFinal2ºtrimestre


import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context


class DataManager(context: Context) {

    private val dbHelper = DatabaseHelper(context)

    fun addName(
        titulo: String,
        autor: String,
        genero: String,
        editorial: String,
        anio: String
    ) {
        val db = dbHelper.writableDatabase

        val values = ContentValues().apply {
            put(DatabaseHelper.COLUMN_TITULO, titulo)
            put(DatabaseHelper.COLUMN_AUTOR, autor)
            put(DatabaseHelper.COLUMN_GENERO, genero)
            put(DatabaseHelper.COLUMN_EDITORIAL, editorial)
            put(DatabaseHelper.COLUMN_ANIO, anio)
        }
        db.insert(DatabaseHelper.TABLE_NAME, null, values)
        db.close()
    }

    fun eliminarUser(){
        val db = dbHelper.writableDatabase
        db.execSQL("delete from ${DatabaseHelper.TABLE_NAME}")
        db.close()
    }


    @SuppressLint("Range")
    fun getAllNames(context: Context): String {
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM ${DatabaseHelper.TABLE_NAME}", null)
        val names = StringBuilder()
        while (cursor.moveToNext()) {
            val titulo = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_TITULO))
            val autor = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_AUTOR))
            val genero = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_GENERO))
            val editorial = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_EDITORIAL))
            val anio = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_ANIO))
            names.append("$titulo, $autor, $genero, $editorial, $anio,\n")
        }
        cursor.close()
        db.close()
        if (names.isEmpty()) {
            return "No hay nombres en la base de datos"
        }
        return names.toString()
    }
}