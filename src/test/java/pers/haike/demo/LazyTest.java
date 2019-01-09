package pers.haike.demo;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


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

    @Test
    public void testSpringLazy() {
        org.springframework.data.util.Lazy<A> aLazy = new org.springframework.data.util.Lazy<>(
                () -> new A());
        System.out.println("inited aLazy");
        A a = aLazy.get();
        a = aLazy.get();
    }
}
