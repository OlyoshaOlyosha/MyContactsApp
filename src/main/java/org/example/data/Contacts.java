package org.example.data;

import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.example.ConsoleTimer;

public class Contacts {

    // Вывод пользователю список контактов из базы данных
    public void printListContacts(){
        System.out.println("\nСписок всех контактов: ");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(".\\src\\main\\java\\org\\example\\data\\dataStorage.txt"));
            String line = reader.readLine();
            int i = 1;
            while (line != null) {
                System.out.println(i + ") " + line);
                line = reader.readLine();
                i ++;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    // Искать контакт в базе данных
    public void searchContact(){
        Scanner sc = new Scanner(System.in);

        printListContacts();
        System.out.print("\nВведите имя или номер телефона пользователя, которому нужно позвонить: ");

        String contactNameOrNumber = sc.nextLine();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(".\\src\\main\\java\\org\\example\\data\\dataStorage.txt"));
            String line = reader.readLine();
            int i = 1;
            while (line != null) {
                line = reader.readLine();
                if (line.contains(contactNameOrNumber)){
                    callContact(line);
                    break;
                }

                i ++;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Такого контакта нет.");
        }
    }

    // Позвонить контакту
    public void callContact(String contact){
        Random rd = new Random();
        ConsoleTimer ctimer = new ConsoleTimer();
        System.out.println("Звоним контакту: " + contact);

        int timer = 5;
        ctimer.startTimer(timer);

        // Ожидание завершения таймера
        try {
            Thread.sleep(timer * 1000 + 100); // Добавьте небольшой запас времени
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean pickedPhone = rd.nextBoolean();

        int endIndexNumber = contact.indexOf('+');
        String nameContact = contact.substring(0, endIndexNumber);
        if (pickedPhone == true){
            System.out.println("\nПользователь " + nameContact + "взял трубку.");
        }
        else{
            System.out.println("\nПользователь " + nameContact + "не взял трубку.");
        }
    }

}