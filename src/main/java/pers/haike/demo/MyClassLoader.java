package pers.haike.demo;

import java.nio.file.Files;
import java.nio.file.Paths;

//自定义一个classloader，建议覆盖findClass()
//因为查找逻辑是，先loadClass，按照双亲委托来load，失败才调用findClass
public class MyClassLoader extends ClassLoader {

    private String myLibPath;

    public MyClassLoader(String path) {
        myLibPath = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] data = Files.readAllBytes(Paths.get(myLibPath));
            return defineClass(name, data, 0, data.length);
        } catch (Exception e) {
        }

        return super.findClass(name);
    }
}
