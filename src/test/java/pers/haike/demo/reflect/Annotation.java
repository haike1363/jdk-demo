package pers.haike.demo.reflect;


import org.junit.Test;

public class Annotation {


    @Deprecated
    public void deprecatedCall() {

        System.out.println("deprecated");
    }
    @Override
    public String toString() {
        return super.toString();
    }

    @Test
    public void testCode() {
        deprecatedCall();
    }

    public void templateCall() {

    }

}