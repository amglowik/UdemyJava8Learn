package com.learnjava.streams;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {


    public static int performMultiplication(List<Integer> integerList){

        return integerList.stream()
                //1
                //3
                //5
                //7
                .reduce(1,(a,b) -> a*b);

    }

    public static Optional<Integer> performMultiplicationWithoutIdentity(List<Integer> integerList){

        return integerList.stream()
                //1
                //3
                //5
                //7
                .reduce((a,b) -> a*b);

    }

    public static Optional<Student> getHighestGPAStudent(){

        return StudentDataBase.getAllStudents().stream()
                //students one by one
                .reduce((s1,s2)->(s1.getGpa()>s2.getGpa()) ? s1 : s2);
    }

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1,3,5,7);

        List<Integer> integers1 = new ArrayList<>();

        System.out.println(performMultiplication(integers));

        Optional<Integer> result = performMultiplicationWithoutIdentity(integers);

        System.out.println(result.isPresent());
        System.out.println(result.get());

        Optional<Integer> result1 = performMultiplicationWithoutIdentity(integers1);
        System.out.println(result1.isPresent());

        if(result1.isPresent()){
            System.out.println(result1.get());
        }

        Optional<Student> studentOptional = getHighestGPAStudent();
        if(getHighestGPAStudent().isPresent()){
            System.out.println(studentOptional.get());
        }

    }
}
