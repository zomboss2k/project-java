/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyATM;

import java.util.Scanner;

/**
 *
 * @author Vermouth
 */
public class Main {

    static Scanner sc = new Scanner(System.in);
    static Account account = null;

    public static void main(String[] args) {
        Login();
        System.out.println("oke");
        int choose;
        do {
            showMenu();
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    account = new Account();
                    account.input();
                    break;
                case 2:
                    if (account != null) {
                        account.addReceiver();
                        account.display();
                    } else {
                        System.err.println("TK khong ton tai!!!");
                    }
                    break;
                case 3:
                    if (account != null) {
                        account.transfer();
                        account.display();
                    } else {
                        System.err.println("TK khong ton tai!!!");
                    }
                    break;
                case 4:
                    if (account != null) {
                        account.displayReceiverHistory();
                    } else {
                        System.err.println("TK khong ton tai!!!");
                    }
                    break;
                case 5:
                    if (account != null) {
                        account.displayTransferHistory();
                    } else {
                        System.err.println("TK khong ton tai!!!");
                    }
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 0:
                    System.out.println("Thoat");
                    break;

                default:
                    System.out.println("Nhap sai!!!");
                    break;
            }
        } while (choose != 0);
    }

    static void showMenu() {
        System.out.println("1. Khoi Tao Tai Khoan!");
        System.out.println("2. Nap Tien");
        System.out.println("3. Chuyen Khoan");
        System.out.println("4. Xem lich su nap tien");
        System.out.println("5. Xem lich su gui tien");
        System.out.println("6. Luu tat ca thong tin");
        System.out.println("7. Doc du lieu");
        System.out.println("0. Thoat");
    }

    static void Login() {
        System.out.println("======WELCOME+=======");
        System.out.println("User Name: ");
        String username = sc.nextLine();

        System.out.println("Password: ");
        String password = sc.nextLine();

        if (username.equalsIgnoreCase("zomboss") && password.equals("letiendat")) {
            System.out.println("Login Success!!");
        } else {
            System.err.println("Login Fail!!!!");
            Login();
        }
    }
}
