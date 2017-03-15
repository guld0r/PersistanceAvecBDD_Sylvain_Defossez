package com.example.anthony.perssistanceavecbdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by anthony on 15/03/2017.
 */

public class ChapitreBDD {

    private SQLiteDatabase bdd;
    private ChapitreBaseSqlLite chapitres;
    private static final int NUM_COL_ID=0;


    public ChapitreBDD(Context context) {
        chapitres = new ChapitreBaseSqlLite(context,"Chapitres.db",null,3);
    }

    void openWrite(){
        bdd = chapitres.getWritableDatabase();
    }

    void openRead(){
        bdd= chapitres.getReadableDatabase();
    }
    public void close()
    {
        bdd.close();
    }
    public SQLiteDatabase getBdd()
    {
        return bdd;
    }

    public long insertChapter(Chapitre chapitre){
        ContentValues content = new ContentValues();
        content.put("nom",chapitre.getNom());
        content.put("description",chapitre.getDescription());
        return bdd.insertOrThrow("chapitre",null,content);
    }

    public long updtateChapter(int id,Chapitre chapitre) {
        ContentValues content = new ContentValues();
        content.put("description", chapitre.getDescription());
        content.put("nom", chapitre.getNom());


        return bdd.update("chapitre", content, "" + id, null);

    }
    public int removeChapter(String name){
        return bdd.delete("chapitre","nom ="+ name,null);
    }

    public Chapitre getChapter(String name){
        Cursor c = bdd.query("chapitre",new String[]{"id","nom","description"},"nom" + " LIKE \""+name+"\"",null,null,null,"nom");
        int j = c.getCount();
        if(c.getCount() == 0){
            c.close();
            return null;
        }
        //int k = c.getInt(0);
        Chapitre chapter = new Chapitre();
        chapter.setId(c.getInt(NUM_COL_ID));
        chapter.setNom(c.getString(1));
        chapter.setDescription(c.getString(2));
        c.close();
        return chapter;
    }

   

    public ArrayList<Chapitre> getAllChapters(){
        Cursor c = bdd.query("chapitre",new String[]{"id","nom","description"},null,null,null,null,"nom");
        if(c.getCount() == 0){
            c.close();
            return null;
        }
        ArrayList<Chapitre> chapl = new ArrayList<Chapitre>();
        while(c.moveToNext()){
            Chapitre chapter = new Chapitre();
            chapter.setId(c.getInt(c.getColumnIndex("id")));
            chapter.setNom(c.getString(c.getColumnIndex("nom")));
            chapter.setDescription(c.getString(c.getColumnIndex("description")));
            chapl.add(chapter);
        }
        c.close();
        return chapl;

    }

}
