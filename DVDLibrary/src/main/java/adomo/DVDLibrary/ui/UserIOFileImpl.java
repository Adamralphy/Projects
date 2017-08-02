/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adomo.DVDLibrary.ui;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class UserIOFileImpl implements UserIO{
    
    Scanner sc = new Scanner(System.in);
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        String valueString = sc.nextLine();
        double value = Double.parseDouble(valueString);
        return value;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double value = readDouble(prompt);;
        while (value < min || value > max) {
            value = readDouble("Error, please enter a correct value between " + min + " and " + max);
        }

        return value;
    }

    @Override
    public float readFloat(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        String valueString = sc.nextLine();
        float value = Float.parseFloat(valueString);
        return value;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float value = readFloat(prompt);
        Scanner sc = new Scanner(System.in);
        while (value < min || value > max) {
            value = readFloat("Error, please enter a correct value between " + min + " and " + max);
        }

        return value;

    }

    @Override
    public int readInt(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        String valueString = sc.nextLine();
        int value = Integer.parseInt(valueString);
        return value;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int value = readInt(prompt);
        Scanner sc = new Scanner(System.in);
        while (value < min || value > max) {
            value = readInt("Error, please enter a correct value between " + min + " and " + max);
        }

        return value;
    }

    @Override
    public long readLong(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        String valueString = sc.nextLine();
        long value = Long.parseLong(valueString);
        return value;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long value = readLong(prompt);
        Scanner sc = new Scanner(System.in);
        while (value < min || value > max) {
            value = readLong("Error, please enter a correct value between " + min + " and " + max);
        }

        return value;
    }

    @Override
    public String readString(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        String valueString = sc.nextLine();
        return valueString;
    }
}
