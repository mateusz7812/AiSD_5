package com.company.Zad2;

import java.util.*;
import java.util.stream.Collectors;

public class ReducerTemplate {
    private Map<MyList, Integer> results = new HashMap<>();
    private Set<Integer> signs;

    public ReducerTemplate(Set<Integer> signsSet) {
        signs = signsSet;
    }

    public Integer Reduce(MyList list) {
        if (results.containsKey(list)) return results.get(list);
        int listSize = list.size();
        if (list.stream().allMatch(value -> value.equals(list.get(0)))) return listSize;

        Integer length = listSize;
        for (int i = 0; i < listSize - 1; i++) {
            List<Integer> pair = list.subList(i, i + 2);
            if (pair.get(0).equals(pair.get(1))) continue;

            List<Integer> otherSigns = GetSignsWithoutExistingInPair(pair);
            for (var sign : otherSigns) {
                var newList = CreateListFromParts(list.subList(0, i), sign, list.subList(i + 2, listSize));
                var newLength = Reduce(newList);
                if (newLength < length) length = newLength;
            }
        }

        results.put(list, length);
        return length;
    }

    private MyList CreateListFromParts(List<Integer> firstList, Integer number, List<Integer> secondList){
        return new MyList(){{addAll(firstList); add(number); addAll(secondList);}};
    }

    private List<Integer> GetSignsWithoutExistingInPair(List<Integer> pair) {
        return signs.stream().filter(o -> !pair.contains(o)).collect(Collectors.toList());
    }
}
