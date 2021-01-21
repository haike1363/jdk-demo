package pers.haike.demo.data_structure;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

public class TreeSetTest {

    @Test
    public void test() {
        // 1.底层通过TreeMap来实现的，给TreeMap添加一个适配的Object作为value
        // 2.putAll有优化，如果是sorted，会做优化，子树插入后做blance就行
        Set<String> set = new TreeSet<>();
        Map<Integer, String> treeMap = new TreeMap<>();

        // 1.底层使用基于cas的跳跃表实现，真正的做到无锁
        // 2.size通过数点实现
        Map<Integer, String> concurrentTreeMap = new ConcurrentSkipListMap<>();
    }
}
