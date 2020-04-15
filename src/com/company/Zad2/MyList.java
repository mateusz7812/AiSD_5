package com.company.Zad2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyList extends ArrayList<Integer> {
    public MyList(List<Integer> partial) {
        super(partial);
    }

    public MyList() {
        super();
    }

    @Override
    public int hashCode() {
        ArrayList<Integer> list = new ArrayList<>(this);
        Collections.sort(list);
        return generateHashCode(list);
    }

    private static int generateHashCode(List<Integer> integers) {
        var stringBuilder = new StringBuilder("0");
        for (var value :
                integers) {
            stringBuilder.append(value);
        }
        var string = stringBuilder.toString();
        return Integer.parseInt(string);
    }
}
