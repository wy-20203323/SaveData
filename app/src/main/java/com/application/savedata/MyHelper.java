package com.application.savedata;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;
import java.util.Map;


public class MyHelper extends SQLiteOpenHelper {

    public MyHelper(Context context) {
        super(context, "content.db", null, 1);
    }
//数据库第一次创建的时候执行

    @Override
    public void onCreate(SQLiteDatabase db) {
        //注意自增的主键名字必须是：_id
        db.execSQL("CREATE TABLE information(_id INTEGER PRIMARY KEY AUTOINCREMENT,name varchar(20),age varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
