package pers.haike.demo.data_structure;

import java.util.*;
import java.util.concurrent.*;

import org.junit.Test;

public class QueueTest {

    static class DelayElem implements Delayed {
        @Override
        public long getDelay(TimeUnit unit) {
            return 0;
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
    }
    @Test
    public void test() {
        Queue<Integer> linkedTransferQueue = new LinkedTransferQueue<>();

        // 1.不存任何数据，只做通讯用，类似eventbus,公平和不公平之分
        Queue<Integer> synchronousQueue = new SynchronousQueue<>();

        // 1.使用堆实现
        Queue<Integer> priorityQueue = new PriorityQueue<>();


        // 1.PriorityQueue+生产者消费者算法
        Queue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>();


        Queue<DelayElem> delayQueue = new DelayQueue();


    }
}
