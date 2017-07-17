package com.langyang.xjl.wholetestdemo.utils;

import android.app.Application;

import com.langyang.xjl.wholetestdemo.greenDao.gen.DaoMaster;
import com.langyang.xjl.wholetestdemo.greenDao.gen.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * @Author : xjl
 * @Created : 2016-12-11
 * @E-mail : xvjialing@outlook.com
 * @Version : 1.0
 */
public class App extends Application {

    public static final boolean ENCRYPTED=false;

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper=new DaoMaster.DevOpenHelper(this,ENCRYPTED ? "notes-db-encrypted" : "notes-db");
        Database database=ENCRYPTED?helper.getEncryptedWritableDb("super-secret"):helper.getWritableDb();
        daoSession =new DaoMaster(database).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
