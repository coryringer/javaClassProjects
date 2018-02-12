/*
 * Filename: RandomPhoneNum.java
 * Author: Cory Ringer
 * Date: 10 February 2018
 */ 

import java.util.Random;

public class RandomPhoneNum
{
    public static void main(String[] args)
    {
        // High limits for random phone number generator
        final int[] FIR_SET_HIGH_LIM = new int[]{7, 7, 7};
        final int[] SEC_SET_HIGH_LIM = new int[]{7, 4, 2};
        final int[] THIRD_SET_HIGH_LIM = new int[]{9, 9, 9, 9};
        int phoneNumber[];

        Random rand = new Random();

        // Area code
        for (int i = 0; i < 3; i++)
            System.out.print(rand.nextInt(FIR_SET_HIGH_LIM[i]));
        System.out.print("-");

        // First three digits
        for (int i = 0; i < 3; i++)
            System.out.print(rand.nextInt(SEC_SET_HIGH_LIM[i]));
        System.out.print("-");

        // Last four digits
        for (int i = 0; i < 4; i++)
            System.out.print(rand.nextInt(THIRD_SET_HIGH_LIM[0]));
    }   
}  