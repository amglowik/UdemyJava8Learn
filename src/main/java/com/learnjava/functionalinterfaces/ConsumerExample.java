package com.learnjava.functionalinterfaces;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;
import com.learnjava.lambdas.RunnableLambdaExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    private static Logger logger = LoggerFactory.getLogger(ConsumerExample.class);
    static Consumer<Student> c2 = (student) -> logger.debug(student.toString());
    static Consumer<Student> c3 = (student) -> logger.debug(student.getName());
    static Consumer<Student> c4 = (student) -> logger.debug(student.getActivities().toString());

    static void printName(){
        ;
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(c2);
    }

    static void printNameAndActivities(){
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(c3.andThen(c4)); // Consumer chain comcept.
    }

    static void printNameAndActivitiesUsingCondition(){

        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach((student -> {
           if (student.getGradeLevel() >=3 && student.getGpa() >= 3.9){
               c3.andThen(c4).accept(student);
           }
        }));
    }

    public static void main(String[] args) {

        Consumer<String> c1 = (s) -> logger.debug(s.toUpperCase());

        c1.accept("java8");

        //printName();

        //printNameAndActivities();

        printNameAndActivitiesUsingCondition();

    }
}
