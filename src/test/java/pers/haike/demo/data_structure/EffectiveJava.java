package pers.haike.demo.data_structure;

import org.junit.Test;

public class EffectiveJava {

    @Test
    public void useBaseTypeFirst () { // 基本类型优于装箱类型
        System.out.println(41 == 41);
        System.out.println(new Integer(41) == new Integer(41));
    }
}
