//package com.qa.utility;
//
//import org.testng.IAnnotationTransformer;
//import org.testng.annotations.ITestAnnotation;
//
//import java.lang.reflect.Constructor;
//import java.lang.reflect.Method;
//
//public class RetryListener implements IAnnotationTransformer {
//
//    @Override
//    public void transform(ITestAnnotation annotation, Class testClass,
//                          Constructor testConstructor, Method testMethod) {
//        annotation.setRetryAnalyzer(com.qa.utility.RetryAnalyzer.class);
//    }
//}

//package com.qa.utility;
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
//        if (testMethod != null && testMethod.getName().toLowerCase().contains("@retry")) {
//            annotation.setRetryAnalyzer(com.qa.utility.RetryAnalyzer.class);
//        }
//    }
//}
//
//package com.qa.utility;
//
//import org.testng.IAnnotationTransformer;
//import org.testng.annotations.ITestAnnotation;
//
//import java.lang.reflect.Constructor;
//import java.lang.reflect.Method;
//
//public class RetryListener implements IAnnotationTransformer {
//
//    private static final boolean RETRY_ENABLED = Boolean.parseBoolean(System.getProperty("enableRetry", "true"));
//
//    @Override
//    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
//
//        if (!RETRY_ENABLED) {
//            System.out.printf("🔁 Retry disabled via config. Skipping retry for [%s.%s]%n",
//                    safeClassName(testClass), safeMethodName(testMethod));
//            return;
//        }
//
//        // Apply RetryAnalyzer unconditionally (or based on your rules)
//        if (shouldRetry(testClass, testMethod)) {
//            annotation.setRetryAnalyzer(RetryAnalyzer.class);
//            System.out.printf("✅ RetryAnalyzer set for [%s.%s]%n",
//                    safeClassName(testClass), safeMethodName(testMethod));
//        } else {
//            System.out.printf("⏭️ Retry skipped for [%s.%s] (excluded by rule)%n",
//                    safeClassName(testClass), safeMethodName(testMethod));
//        }
//    }
//
//    private boolean shouldRetry(Class<?> testClass, Method testMethod) {
//        // Customize rules (e.g., by package, method name, etc.)
//        if (testClass == null || testMethod == null) return false;
//        return testClass.getPackage().getName().contains("tests")
//                && !testMethod.getName().toLowerCase().contains("noRetry");
//    }
//
//    private String safeClassName(Class<?> cls) {
//        return cls != null ? cls.getSimpleName() : "UnknownClass";
//    }
//
//    private String safeMethodName(Method method) {
//        return method != null ? method.getName() : "UnknownMethod";
//    }
//}
