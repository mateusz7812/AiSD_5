package com.company.Zad2;

import java.util.*;
import java.util.stream.Collectors;

public class ReducerTemplate {
    private Map<MyList, Integer> results = new HashMap<>();
    private Set<Integer> values;

    public ReducerTemplate(Set<Integer> possibleValues){
        values = possibleValues;
    }

    public Integer Reduce(MyList list){
        if(results.containsKey(list)) return results.get(list);
        Integer length = list.size();
        if(list.stream().allMatch(value -> value.equals(list.get(0)))) return list.size();
        for (int i=0; i<list.size()-1; i++){
            List<Integer> pair = list.subList(i,i+2);
            if(pair.get(0).equals(pair.get(1))) continue;

            List<Integer> others = values.stream().filter(o -> !pair.contains(o)).collect(Collectors.toList());
            int finalI = i;
            var newLength = others.stream().map(value -> {
                var newList = new MyList(list.subList(0, finalI));
                newList.add(value);
                newList.addAll(list.subList(finalI+2, list.size()));
                return Reduce(newList);
            }).min(Integer::compareTo).orElseThrow();
            if(newLength < length) length = newLength;
        }

        results.put(list, length);
        return length;
    }
}
