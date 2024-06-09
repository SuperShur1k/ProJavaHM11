package org.example.lesson11.hm11;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapHm {
    public static void main(String[] args) {
//        task1
        String[] s = {"Dima", "Masha"};
        String[] s2 = {"Dima", "Masha", "Sasha"};

        int[] i = {22, 23};

        System.out.println(makeMap(s, i));
        System.out.println(makeMap(s2, i));
//        task2
        List<String> strings = List.of("apple", "banana", "apple", "orange", "banana", "apple");

        System.out.println(mostFrequentString(strings));
    }//main

//    task1:
//     Создайте метод, принимающий на вход массив строк и массив целых одинаковой длины и возвращающий Map
//      public static Map makeMap(String [] strings, int [] ints)
//      Например: ["Dima", "Masha"], [23,33] -> [{"Dima":23}, {"Masha", 33}].

    public static Map makeMap(String[] strings, int[] ints) {
        Map<String, Integer> m = new TreeMap<>();
        if (strings.length != ints.length || strings.length == 0)
            return null;

        for (int i = 0; i < strings.length; i++) {
            m.put(strings[i], ints[i]);
        }
        return m;
    }

    ;

    //    task2
//    Верните самую часто встречающуюся строку в списке строк
//public static String mostFrequentString(List strings)
    public static String mostFrequentString(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            return null;
        }

        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String str : strings) {
            int count = frequencyMap.getOrDefault(str, 0);
            frequencyMap.put(str, count + 1);
        }

        String mostFrequentString = null;
        int maxFrequency = 0;
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostFrequentString = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }

        return mostFrequentString;
    }

}
