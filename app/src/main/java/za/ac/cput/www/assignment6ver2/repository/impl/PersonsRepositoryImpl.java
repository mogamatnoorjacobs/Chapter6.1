package za.ac.cput.www.assignment6ver2.repository.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashSet;
import java.util.Set;

import za.ac.cput.www.assignment6ver2.Database.Database;
import za.ac.cput.www.assignment6ver2.domain.Persons;
import za.ac.cput.www.assignment6ver2.repository.PersonsRespository;

/**
 * Created by fatimam on 2016-05-31.
 */
public class PersonsRepositoryImpl extends SQLiteOpenHelper implements PersonsRespository
{
    public static final String TABLE_NAME = "Person";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PERSONID = "personID";
    public static final String COLUMN_FIRSTNAME = "firstname";
    public static final String COLUMN_LASTNAME = "lastName";
    public static final String COLUMN_HOUSENUMBER = "houseNumber";
    public static final String COLUMN_ROAD = "road";
    public static final String COLUMN_AREA = "area";
    public static final String COLUMN_USERNAME="username";
    public static final String COLUMN_PASSWORD="password";
    private Long id;

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_PERSONID + " TEXT UNIQUE NOT NULL , "
            + COLUMN_FIRSTNAME + " TEXT NOT NULL , "
            + COLUMN_LASTNAME + " TEXT NOT NULL , "
            + COLUMN_HOUSENUMBER + " TEXT NOT NULL;"
            + COLUMN_ROAD +  " TEXT NOT NULL;"
            + COLUMN_AREA  + " TEXT NOT NULL;"
            + COLUMN_USERNAME +" TEXT NOT NULL;"
            + COLUMN_PASSWORD + " TEXT NOT NULL );";


    public PersonsRepositoryImpl(Context context) {
        super(context, Database.DATABASE_NAME, null, Database.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Persons create(Persons entity) {
        return null;
    }

    @Override
    public Persons findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_PERSONID,
                        COLUMN_FIRSTNAME,
                        COLUMN_LASTNAME,
                        COLUMN_HOUSENUMBER,
                        COLUMN_ROAD,
                        COLUMN_AREA,
                        COLUMN_USERNAME,
                        COLUMN_PASSWORD },
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Persons persons = new Persons.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .idNumber(cursor.getString(cursor.getColumnIndex(COLUMN_PERSONID)))
                    .name(cursor.getString(cursor.getColumnIndex(COLUMN_FIRSTNAME)))
                    .surname(cursor.getString(cursor.getColumnIndex(COLUMN_LASTNAME)))
                    .houseNum(cursor.getString(cursor.getColumnIndex(COLUMN_HOUSENUMBER)))
                    .roadName(cursor.getString(cursor.getColumnIndex(COLUMN_ROAD)))
                    .areaName(cursor.getString(cursor.getColumnIndex(COLUMN_AREA)))
                    .userName(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)))
                    .passWord(cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)))
                    .build();

            return persons;
        } else {
            return null;
        }
    }

    @Override
    public Persons save(Persons entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_PERSONID, entity.getIDNumber());
        values.put(COLUMN_FIRSTNAME, entity.getName());
        values.put(COLUMN_LASTNAME, entity.getSurname());
        values.put(COLUMN_HOUSENUMBER, entity.getHouseNumber());
        values.put(COLUMN_ROAD, entity.getRoad());
        values.put(COLUMN_AREA, entity.getArea());
        values.put(COLUMN_USERNAME, entity.getUsername());
        values.put(COLUMN_PASSWORD, entity.getPassword());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Persons insertedEntity = new Persons.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Persons update(Persons entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_PERSONID, entity.getIDNumber());
        values.put(COLUMN_FIRSTNAME, entity.getName());
        values.put(COLUMN_LASTNAME, entity.getSurname());
        values.put(COLUMN_HOUSENUMBER, entity.getHouseNumber());
        values.put(COLUMN_ROAD, entity.getRoad());
        values.put(COLUMN_AREA, entity.getArea());
        values.put(COLUMN_USERNAME, entity.getUsername());
        values.put(COLUMN_PASSWORD, entity.getPassword());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Persons delete(Persons entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Persons> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Persons> candidates = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Persons candidate = new Persons.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .idNumber(cursor.getString(cursor.getColumnIndex(COLUMN_PERSONID)))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_FIRSTNAME)))
                        .surname(cursor.getString(cursor.getColumnIndex(COLUMN_LASTNAME)))
                        .houseNum(cursor.getString(cursor.getColumnIndex(COLUMN_HOUSENUMBER)))
                        .roadName(cursor.getString(cursor.getColumnIndex(COLUMN_ROAD)))
                        .areaName(cursor.getString(cursor.getColumnIndex(COLUMN_AREA)))
                        .userName(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)))
                        .passWord(cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)))
                        .build();
                candidates.add(candidate);
            } while (cursor.moveToNext());
        }
        return candidates;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

}
