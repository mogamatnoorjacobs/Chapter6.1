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
import za.ac.cput.www.assignment6ver2.domain.Product;
import za.ac.cput.www.assignment6ver2.repository.ProductRepository;

/**
 * Created by fatimam on 2016-05-31.
 */
public class ProductRepositoryImpl extends SQLiteOpenHelper implements ProductRepository
{
    public static final String TABLE_NAME = "Product";
    private SQLiteDatabase db;

    public static final String COLUMN_PRODUCTID = "id";
    public static final String COLUMN_PRODUCTNAME = "productName";
    public static final String COLUMN_GENRE = "genre";
    public static final String COLUMN_PRICE = "price";

   // private Long id;

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_PRODUCTID  + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_PRODUCTNAME  + " TEXT NOT NULL , "
            + COLUMN_GENRE + " TEXT NOT NULL , "
            + COLUMN_PRICE + " TEXT NOT NULL , ";


    public ProductRepositoryImpl(Context context) {
        super(context, Database.DATABASE_NAME, null, Database.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Product create(Product entity) {
        return null;
    }

    @Override
    public Product findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_PRODUCTID,
                        COLUMN_PRODUCTNAME,
                        COLUMN_GENRE,
                        COLUMN_PRICE,
                },
                        COLUMN_PRODUCTID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Product product = new Product.Builder()
                    .prodID(cursor.getLong(cursor.getColumnIndex(COLUMN_PRODUCTID)))
                    .prodName(cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCTNAME)))
                    .prodGenre(cursor.getInt(cursor.getColumnIndex(COLUMN_GENRE)))
                    .prodPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)))
                    .build();

            return product;
        } else {
            return null;
        }
        }

    @Override
    public Product save(Product entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTID, entity.getProductID());
        values.put(COLUMN_PRODUCTNAME, entity.getProductName());
        values.put(COLUMN_GENRE, entity.getProductGenre());
        values.put(COLUMN_PRICE,entity.getPrice());


        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Product insertedEntity = new Product.Builder()
                .copy(entity)
                .build();
        return insertedEntity;
    }

    @Override
    public Product update(Product entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTID, entity.getProductID());
        values.put(COLUMN_PRODUCTNAME, entity.getProductName());
        values.put(COLUMN_GENRE, entity.getProductGenre());
        values.put(COLUMN_PRICE,entity.getPrice());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_PRODUCTID + " =? ",
                new String[]{String.valueOf(entity.getProductID())}
        );
        return entity;
    }

    @Override
    public Product delete(Product entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_PRODUCTID + " =? ",
                new String[]{String.valueOf(entity.getProductID())});
        return entity;
    }

    @Override
    public Set<Product> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Product> candidates = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Product candidate = new Product.Builder()
                        .prodID(cursor.getLong(cursor.getColumnIndex(COLUMN_PRODUCTID)))
                        .prodName(cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCTNAME)))
                        .prodGenre(cursor.getInt(cursor.getColumnIndex(COLUMN_GENRE)))
                        .prodPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)))
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
