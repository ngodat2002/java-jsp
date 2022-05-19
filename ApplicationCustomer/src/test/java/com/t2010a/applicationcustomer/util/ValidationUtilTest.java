package com.t2010a.applicationcustomer.util;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

class ValidationUtilTest {
        class Teacher {
        private String rollNumber;
        private String name;
        private int countCake;

    public Teacher(){

    }
            public Teacher(String rollNumber, String name, int countCake) {
                this.rollNumber = rollNumber;
                this.name = name;
                this.countCake = countCake;
            }

            public String getRollNumber() {
                return rollNumber;
            }

            public void setRollNumber(String rollNumber) {
                this.rollNumber = rollNumber;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getCountCake() {
                return countCake;
            }

            public void setCountCake(int countCake) {
                this.countCake = countCake;
            }

            @Override
            public String toString() {
                return "Teacher{" +
                        "rollNumber='" + rollNumber + '\'' +
                        ", name='" + name + '\'' +
                        ", countCake='" + countCake + '\'' +
                        '}';
            }
        }

    @Test
    public void countCakeByTeacher() throws IOException {
       ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream("text.txt");
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        HashMap<String,Teacher> teacherHashMap = new HashMap<>();
        for (String line; (line=reader.readLine()) != null;){
           String[] splitedLine = line.split(" ");
           if (splitedLine.length==4){
               String teacherId = splitedLine[0];
               String name = splitedLine[1];
               int countCake = Integer.parseInt(splitedLine[3]);
               Teacher teacher =  new Teacher(teacherId,name,countCake);
               //nếu như tồn tại giáo vine với cùng key thì lấy giá trị cũ ra
               if (teacherHashMap.containsKey(teacher.getRollNumber())){
                   Teacher oldTeacher = teacherHashMap.get(teacher.getRollNumber());
                  //update số lượng bánh mới
                   oldTeacher.setCountCake(oldTeacher.getCountCake()+teacher.getCountCake());
                   //đưa lại vào map
                   teacherHashMap.put(oldTeacher.getRollNumber(),oldTeacher);
               }else {
                   teacherHashMap.put(teacher.getRollNumber(),teacher);
               }
           }

        }
        ArrayList<Teacher> teacherArrayList = new ArrayList<>(teacherHashMap.values());
        for (Teacher teacher:
                teacherArrayList) {
            System.out.println(teacher.toString());
        }

    }

}