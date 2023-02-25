/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLSV_OOP;

import java.util.Scanner;

/**
 *
 * @author Vermouth
 */
public class Student extends Person {

    String rollNo;
    double mark;
    String email;

    public Student() {

    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("; rollNo: " + rollNo + "; Mark: " + mark + "; Email: " + email);
        System.out.println("");
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void inputInfo() {
        super.inputInfo();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma sinh vien: ");
//      Nhap thong tin khi nao dung thi break

//        Code day du
//        while (true) {
//            String rollNoInput = sc.nextLine();
//            boolean check = setRollNo(rollNoInput);
//          B1 -> rut gon
//            boolean check = setRollNo(sc.nextLine());
//            if (check) {
//                break;
//            }
//          B2 -> rut gon
//            if (setRollNo(sc.nextLine())) {
//                break;
//            }
//        }
//          B3 -> Code clean
        while (!setRollNo(sc.nextLine()));

        System.out.println("Nhap diem sinh vien: ");
        while (true) {
            float markInput = Float.parseFloat(sc.nextLine());
            boolean check = setMark(markInput);
            if (check) {
                break;
            }
        }

        System.out.println("Nhap Email: ");
        while (true) {
//            Nhap dia chi email
            String emailInput = sc.nextLine();
//            chuyen dia chi email vao thuoc tinh email
            boolean check = setEmail(emailInput);
            if (check) {
                break;
            }
        }
    }

    public String getRollNo() {
        return rollNo;
    }

    public boolean setRollNo(String rollNo) {
//        nhap ma sv toi thieu 8 ki tu
        if (rollNo != null && rollNo.length() == 8) {
            this.rollNo = rollNo;
            return true;
        } else {
            System.err.println("Nhap lai ma sinh vien(ma sv toi thieu 8 ki tu): ");
            return false;
        }

    }

    public double getMark() {
        return mark;
    }

    public boolean setMark(double mark) {
//        DTB phai tu 0 - 10
        if (mark >= 0 && mark <= 10) {
            this.mark = mark;
            return true;
        } else {
            System.err.println("Nhap lai diem(diem >= 0 && diem <=10): ");
            return false;
        }
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
//        Email: phai co ki tu @ va k ton tai khoang trang
        if (email != null && email.contains("@") && !email.contains(" ")) {
            this.email = email;
            return true;
        } else {
            System.err.println("Nhap lai dia chi email: ");
            return false;
        }
    }

    public boolean checkScholarship() {
        return mark >= 8;
    }

}
