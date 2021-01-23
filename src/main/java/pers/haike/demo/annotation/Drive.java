package pers.haike.demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Documented
// 目标对象
@Target({ElementType.TYPE, ElementType.METHOD})
// 指明使用了此注解的继承类能否继承此注解
@Inherited
// 可见类型
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation1 {
  String[] value() default "unknown";
}

@MyAnnotation1
class Base {

}

// https://www.runoob.com/w3cnote/java-annotation.html
public class Drive extends Base {

  @MyAnnotation1("girl")
  public void printGirl() {
    System.out.println("girl");
  }

  public static void main(String[] args) throws Exception {
    System.out.println("Drive:"
        + Drive.class.isAnnotationPresent(MyAnnotation1.class));

    Drive drive = new Drive();
    Class<Drive> driveClass = Drive.class;
    Method method = driveClass.getMethod("printGirl");
    method.invoke(drive);

    // 获取注解
    if (method.isAnnotationPresent(MyAnnotation1.class)) {
      MyAnnotation1 myAnnotation1 = method.getAnnotation(MyAnnotation1.class);
      String[] values = myAnnotation1.value();
      for (String v: values) {
        System.out.println("Annotation Value: "+ v);
      }
    }
    Annotation[] annotations = method.getAnnotations();
    for (Annotation annotation: annotations) {
      System.out.println(annotation.toString());
    }

  }
}
