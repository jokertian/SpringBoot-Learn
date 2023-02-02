package com.example.jpa.controller;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;

/**
 * @author 田朋朋
 * @since 2023/1/30
 */
public class MultiValueMapTest {
    public static void main(String[] args) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("1", "1");
        map.add("1", "2");
        map.add("1", "3");
        map.add("1", "4");
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        System.out.println(map);
    }
}