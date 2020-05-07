package com.learnjava.lambdas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;

public class ComparatorLambdaExample {
    private static Logger logger = LoggerFactory.getLogger(ComparatorLambdaExample.class);

    public static void main(String[] args) {

        /**
         * prior to Java 8
         */
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2); // 0 -> o1 = o2
                                        // -1 o1< o2
            }
        };

        logger.error("Result of the comparator is: " + comparator.compare(3,2));

        Comparator<Integer> comparatorLambda = (Integer a, Integer b) -> a.compareTo(b);

        logger.error("Result of the comparator using lambdas is: " + comparatorLambda.compare(3,2));

        Comparator<Integer> comparatorLambda1 = ( a, b) -> a.compareTo(b);

        logger.error("Result of the comparator using lambdas is: " + comparatorLambda1.compare(3,2));
    }
}
