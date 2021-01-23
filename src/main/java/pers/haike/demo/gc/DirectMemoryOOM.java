package pers.haike.demo.gc;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class DirectMemoryOOM {


  // -XX:MaxDirectMemorySize，默认与-Xmx一样
  public static void main(String[] args) {

    // 一般用于网络IO，磁盘IO等数据传输时使用，避免从java堆拷贝到本地堆
    List<ByteBuffer> bufferList = new ArrayList<>();
    try {
      while (true) {
        ByteBuffer byteBuffer = java.nio.ByteBuffer.allocateDirect(1024 * 1024);
        bufferList.add(byteBuffer);
        System.out.println("allocateDirect "+ byteBuffer.limit());
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

}
