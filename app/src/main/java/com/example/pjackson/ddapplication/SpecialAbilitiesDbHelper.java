package com.example.pjackson.ddapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SpecialAbilitiesDbHelper extends SQLiteOpenHelper
{

    public static final String LOG_TAG = RacesDbHelper.class.getSimpleName();
    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    public static final int DATABASE_VERSION = 1;
    /**
     * Name of the database file
     */
    private static final String DATABASE_NAME = "OfficialDnDStuff";

    public SpecialAbilitiesDbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_GRAPHS_TABLE = "CREATE TABLE SpecialAbilitiesDb ("
                + "SpecId INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "SpecName TEXT NOT NULL, "
                + "SpecDescription TEXT NOT NULL, "
                + "SpecEncoding TEXT);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_GRAPHS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

        // db.execSQL(SQL_CREATE_PETS_TABLE);
    }
}
