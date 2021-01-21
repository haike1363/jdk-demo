package pers.haike.demo.data_structure;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {

    // 1.hashCode以及equals都会遍历所有的元素，谨慎使用
    @Test
    public void testHashMapInsert() {
        // 1.bucket里面元素多余8个的时候会自动切换为Tree，少于6个的时候变为List
        // 2.开始的bucket为16个，threshold=16*0.75=12，插入元素达到threshold时开始扩一倍
        // 3.扩容量时，将每个bucket里面的元素拆分为2部分，并保留加入的顺序
        // 4.拆分的时候tree会变为2个list，如果list小于6则直接挂载，如果还是大于8则转换为tree挂载
        // 5.2倍2倍的扩，也就可以方便的将一个bucket里面的元素概率大的拆分为相等2部分，保持平衡
        // 6.keySet,valueSet,entrySet并不会真正返回一个集合，而是hash的迭代器封装
        // 7.在,keySet,valueSet,entrySet读取数据时，modCount可用于迭代器检测在读的时候其他线程是否进行了修改
        // 8.删除是直接把kv都删掉
        Map<Integer, String> map = new HashMap<>();
    }

    @Test
    public void concurrentHashMap() {
        // 1.size()是通过数点来实现？
        // 2.插入时，如果空bucket用cas实现很快
        // 3.写入或者扩容时将锁的粒度拆分到bucket而已，而锁的实现如果没有太大的竞争，非常快的
        // 4.由于扩容时copybucket，写入也并不更改所以完全不影响查询
        // 5.如果bucket是list，则并发查询
        // 6.如果bucket是tree，使用读写锁，如果得到读锁，则使用二分查找，如果没有则使用线性扫描
        // 7.因此同一个bucket不能太大，且不要过多的进行写操作，建议用空间换时间，调整扩容因子为0.5?
        // 8.删除是采用replace null实现
        Map<Integer, String> map = new ConcurrentHashMap<>();
    }
}
