package pers.haike.demo;

import org.junit.Test;

public class StringTest {

  @Test
  public void testIntern() {
    String value = "abc";
    value.intern();
  }

}
