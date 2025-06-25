package com.qa.utility;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListener implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(com.qa.utility.RetryAnalyzer.class);
    }
}



//package com.qa.listeners;
//
//import org.testng.IAnnotationTransformer;
//import org.testng.ITestNGMethod;
//import org.testng.annotations.ITestAnnotation;
//import java.lang.reflect.Constructor;
//import java.lang.reflect.Method;
//
//public class RetryListener implements IAnnotationTransformer {
//    @Override
//    public void transform(ITestAnnotation annotation, Class testClass,
//                          Constructor testConstructor, Method testMethod) {
//        if (testMethod != null && testMethod.getName().contains("retry_login")) {
//            annotation.setRetryAnalyzer(com.qa.utility.RetryAnalyzer.class);
//        }
//    }
//}