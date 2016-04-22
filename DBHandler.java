package jmda.pocketfitness;

import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "fitnessApp.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME_1 = "Diet";
    private static final String TABLE_NAME_2 = "Exercise";
    private static final String TABLE_NAME_3 = "Sleep";

    public static final String KEY_ID = "_id";
    public static final String FOOD = "food";
    public static final String CALORIES = "calories";
    public static final String ACTIVITY = "activity";
    public static final String TIME_SPENT = "time_spent";
    public static final String DATE = "date";

    private static DBHandler instance = null;
    private SQLiteDatabase db = getWritableDatabase();

    public static DBHandler getInstance(Context context)
    {
        if (instance == null) {
            instance = new DBHandler(context);
        }

        return instance;
    }

    private DBHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String sql = "CREATE TABLE " + TABLE_NAME_1 + " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + FOOD + " TEXT, " + CALORIES + " LONG, " + DATE + " TEXT" + ");";
        db.execSQL(sql);

        String sql2 = "CREATE TABLE " + TABLE_NAME_2 + " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ACTIVITY + " TEXT, " + TIME_SPENT + " LONG, " + DATE + " TEXT" + ");";
        db.execSQL(sql2);

        String sql3 = "CREATE TABLE " + TABLE_NAME_3 + " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TIME_SPENT + " LONG, " + DATE + " TEXT" + ");";
        db.execSQL(sql3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_3);
        onCreate(db);
    }

    public void insertDiet(String food, long calories, String date)
    {
        ContentValues values = new ContentValues();

        values.put(FOOD, food);
        values.put(CALORIES, calories);
        values.put(DATE, date);

        db.insertOrThrow(TABLE_NAME_1, null, values);
    }

    public void insertExercise(String activity, long timeSpent, String date)
    {
        ContentValues values = new ContentValues();

        values.put(ACTIVITY, activity);
        values.put(TIME_SPENT, timeSpent);
        values.put(DATE, date);

        db.insertOrThrow(TABLE_NAME_2, null, values);
    }

    public void insertSleep(long timeSpent, String date)
    {
        ContentValues values = new ContentValues();

        values.put(TIME_SPENT, timeSpent);
        values.put(DATE, date);

        db.insertOrThrow(TABLE_NAME_3, null, values);
    }

    public ArrayList<Diet> getDietInfo()
    {
        ArrayList<Diet> list = new ArrayList<>();
        String[] from = {FOOD, CALORIES, DATE};
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME_1, from, null, null, null, null, "_id DESC");

        if (cursor.moveToFirst()) {
            do {
                Diet diet = new Diet(cursor.getString(0), cursor.getInt(1), cursor.getString(2));
                list.add(diet);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return list;
    }

    public ArrayList<Exercise> getExerciseInfo()
    {
        ArrayList<Exercise> list = new ArrayList<>();
        String[] from = {ACTIVITY, TIME_SPENT, DATE};
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME_2, from, null, null, null, null, "_id DESC");

        if (cursor.moveToFirst()) {
            do {
                Exercise exercise = new Exercise(cursor.getString(0), cursor.getInt(1), cursor.getString(2));
                list.add(exercise);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return list;
    }

    public ArrayList<Sleep> getSleepInfo()
    {
        ArrayList<Sleep> list = new ArrayList<>();
        String[] from = {TIME_SPENT, DATE};
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME_3, from, null, null, null, null, "_id DESC");

        if (cursor.moveToFirst()) {
            do {
                Sleep sleep = new Sleep(cursor.getInt(0), cursor.getString(1));
                list.add(sleep);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return list;
    }

    public long countDiet(){
        SQLiteDatabase db = getReadableDatabase();
        return DatabaseUtils.queryNumEntries(db, TABLE_NAME_1);
    }

    public long countExercise(){
        SQLiteDatabase db = getReadableDatabase();
        return DatabaseUtils.queryNumEntries(db, TABLE_NAME_2);
    }

    public long countSleep(){
        SQLiteDatabase db = getReadableDatabase();
        return DatabaseUtils.queryNumEntries(db, TABLE_NAME_3);
    }

    public void clearTable(String table)
    {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "DELETE FROM " + table;
        db.execSQL(sql);
    }
}