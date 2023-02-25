/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLSV_OOP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Vermouth
 */
public class StudenTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();
        int choose;

        do {
            showMenu();
            System.out.println("Lựa chọn: ");
            choose = Integer.parseInt(sc.nextLine());

            switch (choose) {
                case 1:
                    int n;
                    System.out.println("Nhập số SV cần thêm: ");
                    n = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < n; i++) {
                        System.out.println("Nhap sinh vien thu " + i);
                        Student std = new Student();
                        std.inputInfo();

                        studentList.add(std);
                    }
                    break;
                case 2:
                    for (int i = 0; i < studentList.size(); i++) {
                        studentList.get(i).showInfo();
                    }
                    break;
                case 3:
                    int minIndex = 0,
                     maxIndex = 0; // luu vi tri min, max cua sv
                    double minMark,
                     maxMark;
                    minMark = studentList.get(0).getMark();
                    maxMark = studentList.get(0).getMark();

                    for (int i = 0; i < studentList.size(); i++) {
                        if (studentList.get(i).getMark() < minMark) {
                            minIndex = i;
                            minMark = studentList.get(i).getMark();
                        }
                        if (studentList.get(i).getMark() > maxMark) {
                            maxIndex = i;
                            maxMark = studentList.get(i).getMark();
                        }
                    }

                    System.out.println("Sinh vien co DTB cao nhat");
                    studentList.get(maxIndex).showInfo();
                    System.out.println("Sinh vien co DTB thap nhat");
                    studentList.get(minIndex).showInfo();
                    break;
                case 4:
                    System.out.println("Nhap Ma SV can tim kiem: ");
                    String rollNoSearch = sc.nextLine();
                    int count = 0;

                    for (Student student : studentList) {
                        if (student.getRollNo().equalsIgnoreCase(rollNoSearch)) {
                            student.showInfo();
                            count++;
                        }
                    }

                    if (count == 0) {
                        System.out.println("Khong tim thay SV nao!");
                    }
                    break;
                case 5:
//                    B1: Sap xep thong tin SV theo thu tu tuwf A-Z (ten)
                    Collections.sort(studentList, new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                            int cmp = o1.getName().compareTo(o2.getName());
                            if (cmp >= 0) {
                                return 1;
                            }
                            return -1;
                        }
                    });
//                    B2: Hien thi
                    for (int i = 0; i < studentList.size(); i++) {
                        studentList.get(i).showInfo();
                    }
                    break;
                case 6:
//                    B1: Sap xep thong tin SV theo thu tu tuwf A-Z (ten)
                    Collections.sort(studentList, new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                            return o1.getMark() >= o2.getMark() ? -1 : 1;
                        }
                    });
//                    B2: Hien thi
                    for (int i = 0; i < studentList.size(); i++) {
                        if (studentList.get(i).checkScholarship()) {
                            studentList.get(i).showInfo();
                        }
                    }
                    break;
                case 0:
                    System.out.println("Tam Biet!!!!");
                    break;
                default:
                    System.err.println("Nhap sai!!!");
                    break;
            }
        } while (choose != 0);
    }

    static void showMenu() {
        System.out.println("1. Nhap vao N sinh vien.");
        System.out.println("2. Hien thi thong tin sinh vien.");
        System.out.println("3. Hien thi max va min theo Diem trung binh.");
        System.out.println("4. Tim kiem theo Ma sinh vien.");
        System.out.println("5. Hien thi theo A-Z theo Ten sinh vien.");
        System.out.println("6. Hien thi sv dc hoc bong & sap xep theo thu tu giam dan.");
        System.out.println("0. Thoat.");
    }

}
