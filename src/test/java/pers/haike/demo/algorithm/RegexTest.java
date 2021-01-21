package pers.haike.demo.algorithm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

public class RegexTest {

  //https://www.runoob.com/java/java-regular-expressions.html
  //https://www.cnblogs.com/xyou/p/7427779.html
  static void print(String regex, String text) {
    System.out.println("============================");
    System.out.println("regex: " + regex);
    System.out.println("text: " + text);
    boolean isMatch = Pattern.matches(regex, text);
    System.out.println("Pattern.matches: "+ isMatch);
    System.out.println("============================\n\n");
  }

  @Test
  public void testBase() {
    String string111 = "this is text";
    String string011 = "thisis text";
    String string012 = "this is  text";
    String p = "this\\s+is\\s+text";
    print(p, string011);
    print(p, string111);
    print(p, string012);

  }

  @Test
  public void testGroup() {
    // 捕获组是通过从左至右计算其开括号来编号。例如，在表达式（（A）（B（C））），有四个

    // 按指定模式在字符串查找
    String line = "This order was placed for QT3000! OK?";
    // 3个捕获组
    String pattern = "(\\D*)(\\d+)(.*)";
    // 创建 Pattern 对象
    Pattern r = Pattern.compile(pattern);

    // 现在创建 matcher 对象
    Matcher m = r.matcher(line);
    if (m.find( )) {
      System.out.println("Found value: " + m.group(0) );
      System.out.println("Found value: " + m.group(1) );
      System.out.println("Found value: " + m.group(2) );
      System.out.println("Found value: " + m.group(3) );
    } else {
      System.out.println("NO MATCH");
    }
  }

  @Test
  public void testGroup2() {
    String line = "host(11-2).org";
    String pattern = "(\\(|\\[|\\{)(\\d+)(\\-|\\~|\\,)(\\d+)(\\)|\\]|\\})";
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(line);

    if (m.find()) {
      for (int i = 1; i <= m.groupCount();++i) {
        System.out.println(m.group(i));
      }
    }
  }
  private final static Pattern VAR_PATTERN = Pattern
      .compile("(\\$\\{|\\{\\{|\\{)(\\w+)(\\}|\\}\\})");

  public static String parseVar(String string) {
    Matcher m = VAR_PATTERN.matcher(string);
    if (m.find() && m.groupCount() == 3) {
      return m.group(2);
    }
    return null;
  }

  @Test
  public void testGroup3() {
    System.out.println(parseVar("${abca11f}/afdsaf/1"));
    System.out.println(parseVar("{bcdfa}/afdsaf/1"));
    System.out.println(parseVar("{{345}}/afdsaf/1"));
  }
}
