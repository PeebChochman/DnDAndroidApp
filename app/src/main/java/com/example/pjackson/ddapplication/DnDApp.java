package com.example.pjackson.ddapplication;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

public class DnDApp extends Application
{
    public SQLiteDatabase mydatabase = openOrCreateDatabase("OfficialDnDStuff",MODE_PRIVATE,null);
    mydatabase.execSQL("CREATE TABLE IF NOT EXISTS TutorialsPoint(Username VARCHAR,Password VARCHAR);");
}
