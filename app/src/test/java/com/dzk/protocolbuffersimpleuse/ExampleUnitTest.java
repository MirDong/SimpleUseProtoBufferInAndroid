package com.dzk.protocolbuffersimpleuse;

import com.dzk.proto.StudentPB;
import com.google.protobuf.InvalidProtocolBufferException;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
        StudentPB.Student student = StudentPB.Student.newBuilder()
                .setName("jackie")
                .setAge(18)
                .addNum(0)
                .addNum(1)
                .addNum(2)
                .addNum(3)
                .addNum(4)
                .addNum(5)
                .addNum(6)
                .addNum(7)
                .addNum(8)
                .addNum(9)
                .addNum(10)
                .build();
        int size = student.getSerializedSize();
        System.out.println(student.toString());
        System.out.println("proto buff size: " +size);
        byte[] bytes = student.toByteArray();
        System.out.println("proto buff byte array size: " +bytes.length);
        System.out.println("接收到Student序列化数据...");
        try {
            StudentPB.Student parsedStudent = StudentPB.Student.parseFrom(bytes);
            System.out.println(parsedStudent.toString());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

        System.out.println("相同的数据，json形式占用体积为: "  + "\"name\":\"jackie\",\"age\":18".getBytes().length);
    }
}