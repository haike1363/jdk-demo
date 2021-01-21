package pers.haike.demo.reflect;

import org.junit.Test;

import java.lang.reflect.Field;

public class GetPrivateField {

    @Test
    public void test() throws Exception {
        PrivateField privateField = new PrivateField();

        Field field = PrivateField.class.getDeclaredField("name");
        field.setAccessible(true);
        String name = (String) field.get(privateField);
        System.out.println(name);
        field.set(privateField, "456");
        System.out.println(privateField.toString());
    }
}
