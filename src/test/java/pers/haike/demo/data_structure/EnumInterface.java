package pers.haike.demo.data_structure;

import org.junit.Test;
import pers.haike.demo.EnumWithMethod;

import java.util.ArrayList;
import java.util.List;

public class EnumInterface {

    // 尽量返回长度为0的数组（List）而不是null
    public static final List<String> EMPTY_LIST = new ArrayList<>();

    @Test
    public void test() {
       System.out.print(EnumWithMethod.PLUS.apply(1, 2));
    }
}
