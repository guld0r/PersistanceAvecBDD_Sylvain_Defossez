package com.example.anthony.perssistanceavecbdd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ChapitreBDD bdd = new ChapitreBDD(this);
       bdd.openWrite();
       // bdd.openRead();
        //ChapitreBaseSqlLite TableChap = new ChapitreBaseSqlLite(getBaseContext(),"Chapitre.db",null,1);

        Chapitre chap1 = new Chapitre("lama","Le lama du perou au tibet");

        bdd.insertChapter(chap1);

        String test = bdd.getChapter("lama").toString();

        Toast.makeText(getBaseContext(),test ,Toast.LENGTH_SHORT).show();

        bdd.close();
;
    }


}
