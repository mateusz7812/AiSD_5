package com.company.Zad1;

import java.util.Stack;

public class SimulationTemplate {
    private Stack<Integer> flowers;
    private int dayNumber;
    public SimulationTemplate(Stack<Integer> flowerStack){
        flowers = flowerStack;
    }

    public void Process(){
        int length;
        Integer last;
        while (true){
            length = flowers.size();
            Stack<Integer> temp = new Stack<>();
            last = null;
            while(!flowers.empty()){
                Integer flower = flowers.pop();
                if(last == null || last >= flower) {
                    temp.push(flower);
                }
                last = flower;
            }
            while(!temp.empty()) flowers.push(temp.pop());
            if(length == flowers.size()){
                break;
            }
            dayNumber ++;
        }
    }
    public int GetDayNumber(){
        return dayNumber;
    }
}
