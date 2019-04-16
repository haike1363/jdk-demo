package pers.haike.demo;

import java.lang.reflect.Method;
import org.junit.Test;

public class ClassLoaderTest {

    @Test
    public void test() throws Exception {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        ClassLoader classLoader = App.class.getClassLoader();
        System.out.println("App ClassLoader is:" + classLoader.toString());

        System.out.println("App Parent ClassLoader is:" + classLoader.getParent().toString());

        System.out.println(
            "App Parent Parent ClassLoader is:" + classLoader.getParent().getParent());

        Thread thread = new Thread(() -> {
            try {
                java.lang.Class myClass = Thread.currentThread().getContextClassLoader()
                    .loadClass("pers.haike.demo.classloader.MyLib");
                Object myObject = myClass.newInstance();
                Method myMethod = myClass.getDeclaredMethod("say", String.class);
                myMethod.invoke(myObject, "Thread World");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        final MyClassLoader myClassLoader = new MyClassLoader("./MyLib.class");
        java.lang.Class myClass = myClassLoader.loadClass("pers.haike.demo.classloader.MyLib");
        Object myObject = myClass.newInstance();
        Method myMethod = myClass.getDeclaredMethod("say", String.class);
        myMethod.invoke(myObject, "Main World");

        //Thread.currentThread().setContextClassLoader(myClassLoader);
        thread.setContextClassLoader(myClassLoader);
        thread.start();
        thread.join();
    }
}
