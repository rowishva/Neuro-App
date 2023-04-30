package com.neuro;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q1a {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("abc", "bcde", "cdefj");

        String result = list.stream().map(name -> name.toUpperCase())
                .collect(Collectors.joining(","));

        System.out.println(result);

    }
}