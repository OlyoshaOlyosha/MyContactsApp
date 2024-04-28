package org.example.data;
import java.util.Scanner;
public class Dao {
        public void loginAdmin() {
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.print("Введите логин: ");
                String login = sc.nextLine();

                System.out.print("Введите пароль: ");
                String password = sc.nextLine();
                if (login.equals("admin") & password.equals("admin")) {
                    System.out.print("\nВход в панель администратора");
                    // exportData();
                } else if (login.equals("/back") | password.equals("/back")) {
                    break;
                } else {
                    System.out.println("Неверный логин или пароль. Повторите попытку.\n");
                }
            }
        }

        public void exportData() {

        }

}
