package pers.haike.demo.multi_thread;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    ReentrantLock reentrantLock = new ReentrantLock();

    @Test
    public void test() {
        reentrantLock.lock();
        reentrantLock.unlock();


    }
}
