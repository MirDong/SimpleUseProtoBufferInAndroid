package com.dzk.protocolbuffersimpleuse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dzk.proto.StudentPB;
import com.google.protobuf.InvalidProtocolBufferException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         *   # com.dzk.proto.StudentPB$Student@56aab88c
         * age: 18
         * name: "jackie"
         * proto buff size: 10
         * proto buff byte array size: 10
         * 接收到Student序列化数据...
         * # com.dzk.proto.StudentPB$Student@56aab88c
         * age: 18
         * name: "jackie"
         * 相同的数据，json形式占用体积为: 24
         *
         * 相同数据下，json大小是Protocol buffer的2 倍多
         */

        //构建结构数据
        StudentPB.Student student = StudentPB.Student.newBuilder()
                .setName("jackie")
                .setAge(18)
                .build();
        //序列化后占用内存的大小
        int size = student.getSerializedSize();
        System.out.println(student.toString());
        System.out.println("proto buff size: " +size);
        //转化为byte  array，序列化
        byte[] bytes = student.toByteArray();
        System.out.println("proto buff byte array size: " +bytes.length);
        System.out.println("接收到Student序列化数据...");
        try {
            //反序列
            StudentPB.Student parsedStudent = StudentPB.Student.parseFrom(bytes);
            System.out.println(parsedStudent.toString());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

        System.out.println("相同的数据，json形式占用体积为: "  + "\"name\":\"jackie\",\"age\":18".getBytes().length);
    }
}