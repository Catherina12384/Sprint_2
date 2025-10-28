package com.SpaceFinders.Sprint_2.Utility;

import java.util.Random;

public class GenerateOtp {
    public static int GenerateNDigitRandomNumber(int number){
        if(number <= 3){
            throw new IllegalArgumentException("For otp give number greater than 3");
        }
        if(number > 9){
            throw new IllegalArgumentException("For otp give number less than 9");
        }

        Random random = new Random();
        int min = (int) Math.pow(10, number - 1);
        int max = (int) Math.pow(10,number) - 1;
        int number_random = random.nextInt(max - min + 1);
        System.out.println(number_random);
        return number_random;
    }
}
