package org.example.logic;

import org.example.app.Dao;
import org.example.data.Contacts;
import org.example.data.Contact;

import java.util.Scanner;

public class Logic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Contacts cts = new Contacts();
        Contact ct = new Contact();

        while (true) {
            System.out.print("\n\n1. Получить список контактов.\n2. Позвонить контакту.\n3. Добавить контакт.\n4. Зайти в панель администратора.\n5. Выйти из программы.\n\nЧто вы хотите сделать?: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // Вывод списка всех контактов
                    cts.printListContacts();
                    break;
                case 2:
                    // Позвонить
                    cts.searchContact();
                    break;
                case 3:
                    // Добавить новый контакт
                    ct.setContact();
                    break;
                case 4:
                    // Вход в панель администратора
                    Dao.connectToData();
                    break;
                case 5:
                    // Выход из программы
                    System.out.println("До свидания!");
                    System.exit(0);
            }
        }
    }
}
