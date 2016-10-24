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
import za.ac.cput.www.assignment6ver2.domain.Shops;
import za.ac.cput.www.assignment6ver2.repository.ShopsRepository;

/**
 * Created by fatimam on 2016-05-31.
 */
public class ShopsRepositoryImpl  extends SQLiteOpenHelper implements ShopsRepository
{
    public static final String TABLE_NAME = "Shops";
    private SQLiteDatabase db;

    public static final String COLUMN_SHOPID = "shopID";
    public static final String COLUMN_SHOPNAME = "shopName";
    public static final String COLUMN_SHOPNUMBER = "shopNumber";
    public static final String COLUMN_ROAD = "road";
    public static final String COLUMN_AREA = "area";
    public static final String COLUMN_CATALOG = "catalog";

    // private Long id;

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_SHOPID  + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_SHOPNAME  + " TEXT NOT NULL , "
            + COLUMN_SHOPNUMBER + " TEXT NOT NULL , "
            + COLUMN_ROAD+ " TEXT NOT NULL , "
            + COLUMN_AREA + " TEXT NOT NULL , "
            + COLUMN_CATALOG + " TEXT NOT NULL , ";


    public ShopsRepositoryImpl(Context context) {
        super(context, Database.DATABASE_NAME, null, Database.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Shops create(Shops entity) {
        return null;
    }

    @Override
    public Shops findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_SHOPID,
                        COLUMN_SHOPNAME,
                        COLUMN_SHOPNUMBER,
                        COLUMN_ROAD,
                        COLUMN_AREA,
                        COLUMN_CATALOG,
                },
                COLUMN_SHOPID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Shops shops = new Shops.Builder()
                    .shopsID(cursor.getLong(cursor.getColumnIndex(COLUMN_SHOPID)))
                    .name(cursor.getString(cursor.getColumnIndex(COLUMN_SHOPNAME)))
                    .numberAddress(cursor.getString(cursor.getColumnIndex(COLUMN_SHOPNUMBER)))
                    .roadName(cursor.getString(cursor.getColumnIndex(COLUMN_ROAD)))
                    .areaName(cursor.getString(cursor.getColumnIndex(COLUMN_AREA)))
                    .catalogOption(cursor.getInt(cursor.getColumnIndex(COLUMN_CATALOG)))
                    .build();

            return shops;
        } else {
            return null;
        }
    }

    @Override
    public Shops save(Shops entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SHOPID, entity.getShopID());
        values.put(COLUMN_SHOPNAME, entity.getShopName());
        values.put(COLUMN_SHOPNUMBER, entity.getShopNumber());
        values.put(COLUMN_ROAD,entity.getRoad());
        values.put(COLUMN_AREA,entity.getArea());
        values.put(COLUMN_CATALOG,entity.getCatalog());


        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Shops insertedEntity = new Shops.Builder()
                .copy(entity)
                .build();
        return insertedEntity;
    }

    @Override
    public Shops update(Shops entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SHOPID, entity.getShopID());
        values.put(COLUMN_SHOPNAME, entity.getShopName());
        values.put(COLUMN_SHOPNUMBER, entity.getShopNumber());
        values.put(COLUMN_ROAD,entity.getRoad());
        values.put(COLUMN_AREA,entity.getArea());
        values.put(COLUMN_CATALOG,entity.getCatalog());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_SHOPID + " =? ",
                new String[]{String.valueOf(entity.getShopID())}
        );
        return entity;
    }

    @Override
    public Shops delete(Shops entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_SHOPID + " =? ",
                new String[]{String.valueOf(entity.getShopID())});
        return entity;
    }

    @Override
    public Set<Shops> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Shops> setShops = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Shops shops = new Shops.Builder()
                        .shopsID(cursor.getLong(cursor.getColumnIndex(COLUMN_SHOPID)))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_SHOPNAME)))
                        .numberAddress(cursor.getString(cursor.getColumnIndex(COLUMN_SHOPNUMBER)))
                        .roadName(cursor.getString(cursor.getColumnIndex(COLUMN_ROAD)))
                        .areaName(cursor.getString(cursor.getColumnIndex(COLUMN_ROAD)))
                        .catalogOption(cursor.getInt(cursor.getColumnIndex(COLUMN_ROAD)))
                        .build();
                setShops.add(shops);
            } while (cursor.moveToNext());
        }
        return setShops;
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
