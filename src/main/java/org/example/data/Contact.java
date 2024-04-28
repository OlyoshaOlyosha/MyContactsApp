package org.example.data;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.example.data.Contacts;
public class Contact {
    private String name;
    private String phoneNumber;

    // Добавить контакт в базу данных
    public void setContact(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nДля добавления контакта напишите имя и номер телефона.");
        try {
            FileWriter writer = new FileWriter(".\\src\\main\\java\\org\\example\\data\\dataStorage.txt", true);
            System.out.print("Имя: ");
            name = sc.nextLine();
            System.out.print("Номер: ");
            phoneNumber = sc.nextLine();

            writer.write("\n" + name + " " + phoneNumber);
            writer.close();
            System.out.print("Контакт успешно добавлен.");
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
