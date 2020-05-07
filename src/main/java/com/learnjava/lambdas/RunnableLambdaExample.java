package com.learnjava.lambdas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunnableLambdaExample {
    private static Logger logger = LoggerFactory.getLogger(RunnableLambdaExample.class);


    public static void main(String[] args) {

        System.out.println(RunnableLambdaExample.class.getResource("/logback.xml"));


        /**
         * Prior to Java 8
         */
        Runnable runnable = new Runnable(){
            @Override
            public void run() { ;
                logger.debug("Inside runnable 1 LOG");
            }
        };

        new Thread(runnable).start();

        // Java 8 lambda syntax.
        Runnable runnableLambda = () -> {
            System.out.println("Inside runnable 2");
            logger.debug("Inside runnable 3 LOG");
        };

        // Single statement/line variant. Curly braces are not needed.
        Runnable runnableLambda1 = () -> System.out.println("Inside runnable 3");

        new Thread(runnableLambda).start();
        new Thread(runnableLambda1).start();
        new Thread(() -> System.out.println("Inside runnable 4")).start();
        new Thread(() -> logger.debug("Inside runnable 4")).start();
    }
}
