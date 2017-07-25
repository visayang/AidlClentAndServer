package com.chad.work.test2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.work.myapplication.IMyServerAidlInterface;
import com.chad.work.myapplication.Student;

public class MainActivity extends AppCompatActivity {
    private IMyServerAidlInterface mService;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = IMyServerAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {

    }

    public void bind(View view) {
        Intent intent = new Intent();
        intent.setAction("com.chad.work.myapplication");
        //从 Android 5.0开始 隐式Intent绑定服务的方式已不能使用,所以这里需要设置Service所在服务端的包名
        intent.setPackage("com.chad.work.myapplication");
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    public void setValue(View view) {
//        try {
//            mService.setMsg("HELOLOLOLO");
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
        try {
            Toast.makeText(this, "=666="+mService.getPerson().toString()+"=666==", Toast.LENGTH_SHORT).show();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void getValue(View view) {
//        try {
//            String str = mService.getMsg();
//            Toast.makeText(this, "=666="+str+"=666==", Toast.LENGTH_SHORT).show();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
        try {
            mService.putStudent(new Student("YCG"));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (connection != null) {
            unbindService(connection);
        }
    }
}
