package com.neuro;

import java.util.Arrays;
import java.util.List;

public class Q1b {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("abc", "", "bcd", "aaa", "", "cde");

        long count = list.stream().filter(name -> name.startsWith("a")).count();
        long countEmpty = list.stream().filter(name -> name.isEmpty()).count();

        System.out.println(count);
        System.out.println(countEmpty);

    }
}