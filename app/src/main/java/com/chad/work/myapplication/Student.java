package com.chad.work.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Chad.Yang on 2017/7/25.
 */

public class Student implements Parcelable{
    private String name;

    protected Student(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }

    public Student() {
    }

    /**
     * 参数是一个Parcel,用它来存储与传输数据
     * @param dest
     */

    public void readFromParcel(Parcel dest) {
        //注意，此处的读值顺序应当是和writeToParcel()方法中一致的
        name = dest.readString();
    }
}
