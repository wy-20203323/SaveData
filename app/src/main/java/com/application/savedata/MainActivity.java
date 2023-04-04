package com.application.savedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView viewById;
    private MyHelper myHelper;
    private SimpleCursorAdapter adapter;
    private Cursor cursor;
    //SimpleCursorAdapter所需要的参数
//    String from[] = new String[]{"_id", "name", "age"};
//    int[] to = new int[]{R.id.tv_id, R.id.tv_name, R.id.tv_age};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myHelper = new MyHelper(this);
        Button savaBtn=findViewById(R.id.save);
        viewById = (ListView) findViewById(R.id.lv);
        savaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = myHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                EditText et_name = (EditText) findViewById(R.id.et_name);
                EditText et_age = (EditText) findViewById(R.id.et_age);
                values.put("name", et_name.getText().toString().trim());
                values.put("age", et_age.getText().toString());
                long q = db.insert("information", "name", values);
                Toast.makeText(getApplicationContext(), "数据存入成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,ShowActivity.class);
                startActivity(intent);
            }
        });
    }


    public void save(View v) {
        //获得可读写数据库对象
        SQLiteDatabase db = myHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        EditText et_name = (EditText) findViewById(R.id.et_name);
        EditText et_age = (EditText) findViewById(R.id.et_age);
        values.put("name", et_name.getText().toString().trim());
        values.put("age", et_age.getText().toString());
        long q = db.insert("information", "name", values);
        Toast.makeText(this, "数据存入成功", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,ShowActivity.class);
        startActivity(intent);
//        数据库发生变化时更新listview
        cursor.requery();
        adapter.notifyDataSetChanged();
        db.close();
    }

//    public void clear(View v) {
//        SQLiteDatabase db = myHelper.getWritableDatabase();
//        db.delete("information", null, null);
//        //使自增的_id归零
//        db.delete("sqlite_sequence", null, null);
//        Toast.makeText(this, "数据库清除成功", Toast.LENGTH_SHORT).show();
//        cursor.requery();
//        adapter.notifyDataSetChanged();
//        db.close();
//    }
}
