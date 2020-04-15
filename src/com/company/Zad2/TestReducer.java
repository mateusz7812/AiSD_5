package com.company.Zad2;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class TestReducer {
    @Test
    public void Test1(){
        var reducer = new ReducerTemplate(Set.of(1, 2, 3));
        Integer result = reducer.Reduce(new MyList(List.of(3)));
        Assert.assertEquals(1, result.intValue());
    }

    @Test
    public void Test2(){
        var reducer = new ReducerTemplate(Set.of(1, 2, 3));
        Integer result = reducer.Reduce(new MyList(List.of(3, 1)));
        Assert.assertEquals(1, result.intValue());
    }

    @Test
    public void Test3(){
        var reducer = new ReducerTemplate(Set.of(1, 2, 3));
        Integer result = reducer.Reduce(new MyList(List.of(3, 3)));
        Assert.assertEquals(2, result.intValue());
    }

    @Test
    public void Test4(){
        var reducer = new ReducerTemplate(Set.of(1, 2, 3));
        Integer result = reducer.Reduce(new MyList(List.of(3, 1, 2)));
        Assert.assertEquals(2, result.intValue());
    }
}
