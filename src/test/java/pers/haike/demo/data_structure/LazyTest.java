package pers.haike.demo.data_structure;

import org.junit.Test;
import pers.haike.demo.Lazy;

public class LazyTest {

    static class A {
        public  A() {
            System.out.println("init A");
        }
    }

    static class B {
        public B() {

        }
        A getA() {
            return aLazy.getOrCompute(() -> new A());
        }
        private Lazy<A> aLazy = new Lazy<>();
    }

    @Test
    public void test() {
        B b = new B();
        System.out.println("inited b");
        A a = b.getA();
        a = b.getA();
    }


}
