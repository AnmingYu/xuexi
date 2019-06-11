package com.example.administrator.myapplication;

import android.app.Application;
import android.util.Log;

import org.xutils.DbManager;
import org.xutils.db.table.TableEntity;
import org.xutils.x;

import java.io.File;

public class TRApplicaction extends Application {
    private DbManager db;

    public DbManager getDbManager() {
        return db;
    }

    @Override
    public void onCreate() {
        super.onCreate();
       x.Ext.init(this);
       x.Ext.setDebug(BuildConfig.DEBUG);// 是否输出debug日志, 开启debug会影响性能.
        localDatabase();
    }

    public void localDatabase(){
        DbManager.DaoConfig daoConfig=new DbManager.DaoConfig()
                .setDbName("mypp.db")

                .setDbVersion(1)
                //开启事务
                .setAllowTransaction(true)
                .setDbOpenListener(new DbManager.DbOpenListener() {
                    @Override
                    public void onDbOpened(DbManager db) {
                        //开启数据库支持多线程操作，提升性能，对写入加速提升巨大
                        db.getDatabase().enableWriteAheadLogging();
                    }
                })
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {

                    }
                })
                .setTableCreateListener(new DbManager.TableCreateListener() {
                    @Override
                    public void onTableCreated(DbManager db, TableEntity<?> table) {
                        Log.i("JAVA", "onTableCreated：" + table.getName());
                    }
                });
        db=x.getDb(daoConfig);

    }
}
