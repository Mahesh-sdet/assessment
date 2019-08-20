package com.kpmg.technical.assessment.utils;

import java.util.Random;

public class RandomHelper {

    public int numberGenerator(int size) {
        Random random = new Random();
        int n = random.nextInt(size - 1);
        return n;
    }
}
