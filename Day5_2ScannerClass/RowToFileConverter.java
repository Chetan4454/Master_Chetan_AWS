package com.Day5_2ScannerClass;

import java.io.*;
import java.util.Scanner;

public class RowToFileConverter {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter The Path TO Read The File: ");
        String fileRead = scanner.nextLine();

        System.out.println("Enter The Path for File To Write: ");
        String fileWrite = scanner.nextLine();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileRead));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileWrite))){
            String str;
            while ((str = bufferedReader.readLine())!= null){
                //It will print file data to the console
                System.out.println(str);

                //It will write to file
                bufferedWriter.write(str, 0,str.length());
                bufferedWriter.flush();
            }
            System.out.println("Rows printed to console and written in the file successfully");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }finally {
            scanner.close();
        }
    }
}