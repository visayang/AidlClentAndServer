package com.chad.work.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MyService extends Service {
    private String curMsg = "";
    private Student stu;

    @Override
    public IBinder onBind(Intent intent) {
//        throw new UnsupportedOperationException("Not yet implemented");
        return new IMyService();
    }

    public class IMyService extends IMyServerAidlInterface.Stub{

        @Override
        public void setMsg(String msg) throws RemoteException {
            curMsg = msg;
        }

        @Override
        public String getMsg() throws RemoteException {
            return TextUtils.isEmpty(curMsg)?"this is just a null point":curMsg;
        }

        @Override
        public Student getPerson() throws RemoteException {
            return stu==null?new Student("GGG"):stu;
        }

        @Override
        public void putStudent(Student ss) throws RemoteException {
            stu = ss;
        }

//        @Override
//        public void putStudent(Student ss) throws RemoteException {
//            Toast.makeText(MyService.this, "===", Toast.LENGTH_SHORT).show();
//            Log.i("123", ss.getName());
//        }

    }
}
