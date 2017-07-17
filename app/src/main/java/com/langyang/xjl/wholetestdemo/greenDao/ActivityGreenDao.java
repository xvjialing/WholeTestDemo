package com.langyang.xjl.wholetestdemo.greenDao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.langyang.xjl.wholetestdemo.R;
import com.langyang.xjl.wholetestdemo.greenDao.gen.DaoSession;
import com.langyang.xjl.wholetestdemo.greenDao.gen.MacDao;
import com.langyang.xjl.wholetestdemo.utils.App;

import org.greenrobot.greendao.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ActivityGreenDao extends AppCompatActivity {

    private DeviceAdapter deviceAdapter;
    private List<Mac> macList;

    private DaoSession daoSession;
    private Query<Mac> macQuery;
    private MacDao macDao;
    private Mac mac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_dao);

        daoSession = ((App) getApplication()).getDaoSession();
        macDao = daoSession.getMacDao();

        mac=new Mac(null,"123123");
        macDao.insert(mac);
        mac=new Mac(null,"fadfasdfad");
        macDao.insert(mac);
        mac=new Mac(null,"vasda");
        macDao.insert(mac);

        macQuery=macDao.queryBuilder().where(MacDao.Properties.Mac.eq("123123")).build();
        macList=macQuery.list();
        for (Mac mac1:macList
             ) {
            Long key=mac1.getId();
            macDao.deleteByKey(key);
        }

        mac=macDao.queryBuilder().where(MacDao.Properties.Mac.eq("fadfasdfad")).unique();
        Long id=mac.getId();
        macDao.update(new Mac(id,"mdlwqdmwq"));
    }
}
