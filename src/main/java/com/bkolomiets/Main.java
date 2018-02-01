package com.bkolomiets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> h = new HashSet<>();
        h.add("Latte");
        h.add("Latte");
        h.add("Latte");

        List<String> h2 = new ArrayList<>();
        h2.addAll(h);

        for (String str : h2) {
            System.out.println(str + " " + h.size());
        }
    }
}
