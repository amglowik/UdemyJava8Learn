package com.learnjava.streams_terminal;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class StreamGroupingByExample {

    public static void groupStudentsByGender(){

       Map<String, List<Student>> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGender));

        System.out.println(studentMap);
    }

    public static void customizedGroupingBy(){

        Map<String, List<Student>> studentMap = StudentDataBase.getAllStudents()
                .stream() //Stream<Students>
                .collect(groupingBy(student -> student.getGpa()>=3.8 ? "OUTSTANDING" : "AVERAGE"));

        System.out.println(studentMap);
    }

    public static void twoLevelGrouping_1(){

        Map<Integer,Map<String,List<Student>>> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,
                        groupingBy(student -> student.getGpa()>=3.8 ? "OUTSTANDING" : "AVERAGE")));

        System.out.println(studentMap);
    }

    public static void twoLevelGrouping_2(){

        Map<String,Integer> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getName,
                        summingInt(Student::getNoteBooks)));

        System.out.println(studentMap);
    }




    public static void main(String[] args) {

       // groupStudentsByGender();
        //customizedGroupingBy();
        //twoLevelGrouping_1();
        twoLevelGrouping_2();

    }
}
