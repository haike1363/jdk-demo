package pers.haike.demo.jvm;

import org.junit.Test;

public class SystemEnv {


  @Test
  public void testGetEnv() {
    System.out.println(System.getenv().get("HAHA_"));
  }
}
