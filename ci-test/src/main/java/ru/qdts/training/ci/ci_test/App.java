package ru.qdts.training.ci.ci_test;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter your name, please");
        String name = scn.nextLine();
        scn.close();
        System.out.println("Hello, " + name + "!");
    }   
}
