package pers.haike.demo.gc;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class ArrayGC {

    Random random = new Random();
    Set<String> stringSet = new HashSet<>();
    static Long value = 0L;

    private String getModelString() {
        StringBuilder builder =  new StringBuilder();
        for (int i = 0;  i< 100000; ++i) {
            builder.append(value++).append(" ");
        }
        return builder.toString();
    }

    public static void main(String args[]) {
        new ArrayGC().test();
    }

    public void test() {
        String arr[];
        for (int i = 0; i < 10; ++i) {
            arr = getModelString().split(" ");
//            for (int k = 0; k < arr.length;++k) {
//                stringSet.add(arr[k]);
//            }
            int index = Math.abs(random.nextInt())%arr.length;
            stringSet.add(arr[index]);
//            for (int k = 0 ; k < arr.length; ++k) {
//                arr[k] = null;
//            }
        }
        System.out.println("start input");
        Scanner scanner = new Scanner(System.in);
        String cmd  = scanner.nextLine();
        System.out.println("input cmd " + cmd);
        System.gc();
        System.out.println("string obj expect " + stringSet.size());
        scanner.nextLine();
    }
}
