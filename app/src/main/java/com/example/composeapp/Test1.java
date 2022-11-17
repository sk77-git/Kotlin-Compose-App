package com.example.composeapp;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args){
        System.out.println("Hello World");
        Scanner scan = new Scanner(System.in);
        System.out.println("How many records do you want to enter?");
        int num= scan.nextInt();

        String[] nameArray = new String[num];
        char[] gradeArray = new char[num];
        for (int i=0; i<num; i++){
            System.out.println("Enter Record "+i+1+ ", Name and Grade");
            nameArray[i]= scan.nextLine();
            gradeArray[i]= scan.next().charAt(0);
        }
        for (int i=0; i<num; i++){
            System.out.println("Record "+i+1+" Name: "+ nameArray[i]+" Grade: "+gradeArray[i]);
        }

    }
}
