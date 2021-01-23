package pers.haike.demo.jvm;

import java.util.ArrayList;
import java.util.List;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.junit.Test;

//https://www.jianshu.com/p/d9a1e1072f37
public class MemTest {

  @Test
  public void printObjectSize() {
    // https://www.cnblogs.com/ulysses-you/p/10060463.html
    // 开启指针压缩-XX:+UseCompressedOops 类指针为4字节
    // 大小为8字节的整倍数
    // 对象头8字节 + 类指针4字节 + 4字节padding
    Object b = new Object();

    // 对象头8字节 + 类指针4字节 + size4字节 + 3*实例引用4字节 + 4字节padding
    Object[] a = new ArrayList[3];


    System.out.println(ObjectSizeCalculator.getObjectSize(b));
    System.out.println(ObjectSizeCalculator.getObjectSize(a));

  }
}
