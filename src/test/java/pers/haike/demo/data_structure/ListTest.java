package pers.haike.demo.data_structure;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ListTest {

    @Test
    public void testExtend() {
        List<Integer> list = new ArrayList<>();
        list.add(0);

        List<Integer> listAdd = new ArrayList<>();
        for (int i = 1; i < 10000; ++i) {
            listAdd.add(i);
        }

        // 以之前一半的size进行扩展，或者直接扩展add的大小
        list.addAll(listAdd);

        // 双向链表实现
        List<Integer> linkList = new LinkedList<>();
    }

    @Test
    public void testJava8StringMap() {
        List<String> lowerCases = Arrays.asList("a", "b", "c");
        lowerCases.stream().map((v) -> {return v.toUpperCase(); }).collect(Collectors.toList());
    }
}
