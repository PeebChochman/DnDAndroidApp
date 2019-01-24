package com.example.pjackson.ddapplication;

        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

/**
 * This class help to build sql database and crate a table for graph setting
 *
 * @author Hansheng Li
 */
public class RacesDbHelper extends SQLiteOpenHelper
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

    public RacesDbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_GRAPHS_TABLE = "CREATE TABLE RacesDb (" //special abilities, languages
                + "RacesId INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "Name TEXT NOT NULL, "
                + "AbilityScoreAdjustments TEXT NOT NULL, "
                + "AgeLimit INTEGER NOT NULL, "
                + "AlignmentBias TEXT NOT NULL, "
                + "Size TEXT NOT NULL, "
                + "Speed INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_GRAPHS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

        // db.execSQL(SQL_CREATE_PETS_TABLE);
    }
}
