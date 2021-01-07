package com.example.demo.util;

import com.example.demo.model.Calculation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Calculator {

    private static List<Integer> result;

        static void sumUpRecursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
            int s = 0;
            for (int x: partial) s += x;
            if (s == target) {
                result = partial;
            }
            if (s >= target)
                return;
            for(int i=0;i<numbers.size(); i++) {
                ArrayList<Integer> remaining = new ArrayList<>();
                int n = numbers.get(i);
                for (int j = i + 1; j < numbers.size(); j++) remaining.add(numbers.get(j));
                ArrayList<Integer> partialRec = new ArrayList<>(partial);
                partialRec.add(n);
                sumUpRecursive(remaining, target, partialRec);
            }
        }

        static void sumUp(ArrayList<Integer> numbers, int target) {
            sumUpRecursive(numbers,target,new ArrayList<>());
        }

        public static List<Integer> calculate(Calculation calculation) {
            Integer[] numbers = calculation.getValues().toArray(new Integer[0]);
            int total = calculation.getTotal();
            sumUp(new ArrayList<>(Arrays.asList(numbers)),total);
            return result;
        }
}
