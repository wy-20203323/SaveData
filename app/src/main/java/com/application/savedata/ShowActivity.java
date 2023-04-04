package com.application.savedata;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

import java.util.List;
import java.util.Map;

public class ShowActivity extends AppCompatActivity {
    
    List<Object> listItems;
    private MyHelper myHelper;
    private Cursor cursor;
    private SimpleCursorAdapter adapter;
    private ListView viewById;
    String from[] = new String[]{"_id", "name", "age"};
    int[] to = new int[]{R.id.tv_id, R.id.tv_name, R.id.tv_age};
    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        myHelper = new MyHelper(this);
        viewById = (ListView) findViewById(R.id.lv);
        Show();

    }
//        viewById.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//
//                AlertDialog.Builder builder=new AlertDialog.Builder(ShowActivity.this);
//                builder.setMessage("确定删除?");
//                builder.setTitle("提示");
//                builder.setPositiveButton("确定",new DialogInterface.OnClickListener(){
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        if(listItems.remove(position)!=null){
//                            System.out.println("success");
//                        }else {
//                            System.out.println("failed");
//                        }
//                        simpleAdapter.notifyDataSetChanged();
//                        Toast.makeText(getBaseContext(), "删除列表项", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                builder.setNegativeButton("取消",new DialogInterface.OnClickListener(){
//
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });
//                builder.create().show();
//                return false;
//            }
//        });

    public void Show() {
        SQLiteDatabase db = myHelper.getWritableDatabase();
        cursor = db.query("information", null, null, null, null, null, null);
        adapter = new SimpleCursorAdapter(this, R.layout.activity_show, cursor, from, to, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        viewById.setAdapter(adapter);
        db.close();
    }

}