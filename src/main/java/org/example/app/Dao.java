package org.example.app;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public interface Dao {
    static void connectToData() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Введите логин: ");
            String login = sc.nextLine();

            System.out.print("Введите пароль: ");
            String password = sc.nextLine();
            if (login.equals("admin") & password.equals("admin")) {
                System.out.print("\nВход в панель администратора");
                actions();
            } else if (login.equals("/back") | password.equals("/back")) {
                break;
            } else {
                System.out.println("Неверный логин или пароль. Повторите попытку.\n");
            }
        }
    }

    // Экспорт БД
    static void exportData() {
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

    static void actions(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("\n\n1. Экспорт контактов.\n2. Выйти из программы.\n\nЧто вы хотите сделать?: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // Вывод списка всех контактов
                    exportData();
                    break;
                case 2:
                    // Выход из программы
                    System.out.println("До свидания!");
                    System.exit(0);
            }
        }
    }
}
