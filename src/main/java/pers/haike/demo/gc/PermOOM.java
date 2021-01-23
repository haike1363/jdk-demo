package pers.haike.demo.gc;

import java.util.ArrayList;
import java.util.List;

public class PermOOM {

  // 方法区和运行时常量池溢出,8.0后不支持
  public static void main(String[] args) {
    List<String> stringList = new ArrayList<>();
    int i = 0;
    while (true) {
      stringList.add(String.valueOf(i++).intern());
    }
  }
}
