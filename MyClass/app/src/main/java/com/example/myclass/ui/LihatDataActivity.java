package com.example.myclass.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.myclass.DataHelper;
import com.example.myclass.R;

public class LihatDataActivity extends AppCompatActivity {

    String[] daftar;
    ListView listView01;
    protected Cursor cursor;
    DataHelper dbcenter;
    public static LihatDataActivity data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        Button btn = findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LihatDataActivity.this,InputDataActivity.class);
                startActivity(intent);
            }
        });

        data = this;
        dbcenter = new DataHelper(this);
        RefreshList();
    }

    public void RefreshList(){
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor  = db.rawQuery("select * from biodata",null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();

        for (int cc = 0 ; cc < cursor.getCount() ; cc++){
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }

        listView01 = (ListView) findViewById(R.id.listView1);
        listView01.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,daftar));
        listView01.setSelected(true);
        listView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String selection = daftar[i];
                final CharSequence[] dialogitem = {"Lihat Data","Update Data","Hapus Data"};
                AlertDialog.Builder builder = new AlertDialog.Builder(LihatDataActivity.this);
                builder.setTitle("Pilihan");

                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0:
                                Intent intent = new Intent(getApplicationContext(),DetailDataActivity.class);
                                intent.putExtra("nama",selection);
                                startActivity(intent);
                                break;

                            case 1:
                                Intent intent1 = new Intent(getApplicationContext(),UpdateDataActivity.class);
                                intent1.putExtra("nama",selection);
                                startActivity(intent1);
                                break;

                            case 2:
                                SQLiteDatabase db = dbcenter.getWritableDatabase();
                                db.execSQL("delete from biodata where nama = '"+selection+"'");
                                RefreshList();
                                break;
                        }
                    }
                });

                builder.create().show();

            }
        });

        ((ArrayAdapter) listView01.getAdapter()).notifyDataSetInvalidated();
    }
}
