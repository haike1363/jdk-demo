package pers.haike.demo.data_structure;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class DequeTest {

    @Test
    public void test () {
        // 1.array满了后是双倍扩展的，循环数组实现
        // 2.size一定是2的整倍数，如果传入length也会找到一个合适2的整倍数
        // 3.内部用head，tail索引记录头和尾节点
        Deque<Integer> dequeArray = new ArrayDeque<>();


        // 1.用户双端链表实现的
        // 2.扩容的时候不用拷贝
        Deque<Integer> dequeList = new LinkedList<>();



        // 1.采用生产者消费者算法
        // 2.默认无限容量，也可以设置容量
        // 3.当多个生产者消费者同时put，pull的时候，由于锁的竞争效率非常低，load爆增
        // 解决办法：可用非准确性size的queue来实现真正的高并发限制size的队列
        Deque<Integer> blockingDeque = new LinkedBlockingDeque<>();


        // 1.cas实现的双端队列，效率高
        // 2.size是通过数点实现
        Deque<Integer> concurrentDeque = new ConcurrentLinkedDeque<>();
    }
}
