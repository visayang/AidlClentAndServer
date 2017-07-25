// IMyServerAidlInterface.aidl
package com.chad.work.myapplication;

import com.chad.work.myapplication.Student;

interface IMyServerAidlInterface {
    void setMsg(String msg);
    String getMsg();
    Student getPerson();
    void putStudent(inout Student ss);
}
