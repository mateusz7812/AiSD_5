package com.company.Zad1;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class TestZad1 {
    @Test
    public void Test1(){
        var simulation = new SimulationTemplate(new Stack<>());
        simulation.Process();
        Assert.assertEquals(0, simulation.GetDayNumber());
    }

    @Test
    public void Test2(){
        Stack<Integer> flowers = new Stack<>();
        flowers.push(10);
        flowers.push(5);
        flowers.push(0);
        var simulation = new SimulationTemplate(flowers);
        simulation.Process();
        Assert.assertEquals(1, simulation.GetDayNumber());
    }

    @Test
    public void Test3(){
        Stack<Integer> flowers = new Stack<>();
        flowers.push(0);
        flowers.push(5);
        flowers.push(10);
        var simulation = new SimulationTemplate(flowers);
        simulation.Process();
        Assert.assertEquals(0, simulation.GetDayNumber());
    }

    @Test
    public void Test4(){
        Stack<Integer> flowers = new Stack<>();
        flowers.push(6);
        flowers.push(3);
        flowers.push(4);
        flowers.push(5);
        flowers.push(2);
        flowers.push(6);
        flowers.push(4);
        flowers.push(5);
        flowers.push(11);
        flowers.push(10);
        var simulation = new SimulationTemplate(flowers);
        simulation.Process();
        Assert.assertEquals(3, simulation.GetDayNumber());
    }
}
