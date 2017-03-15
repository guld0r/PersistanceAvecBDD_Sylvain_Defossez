package com.example.anthony.perssistanceavecbdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by anthony on 15/03/2017.
 */

public class ChapitreBaseSqlLite extends SQLiteOpenHelper {

    public  static final String nom_Table = "chapitre";

    public  static final String ma_Colonne_Id = "id";
    public  static final String ma_Colonne_nom = "nom";
    public  static final String ma_Colonne_desc = "description";

    public  static final String CREATE_BDD = "CREATE TABLE " +nom_Table+" ("+ma_Colonne_Id+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+ma_Colonne_nom+" TEXT NOT NULL,"+ma_Colonne_desc+" varchar(255) NOT NULL )";


     public ChapitreBaseSqlLite(Context context, String name, SQLiteDatabase.CursorFactory factory,int version){
         super(context, name, factory, version);

     }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BDD);
           }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE chapitre");
        onCreate(db);

    }
}
