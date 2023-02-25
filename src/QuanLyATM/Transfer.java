/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyATM;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Vermouth
 */
public class Transfer {

    String transferStk, note;
    int money;
    Date createdAt;

    public Transfer() {
    }

    public String getTransferStk() {
        return transferStk;
    }

    public void setTransferStk(String transferStk) {
        this.transferStk = transferStk;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void input(int maxMoney) {
        System.out.println("Nhap thong tin nap tien: ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap STK nhan: ");
        transferStk = sc.nextLine();

        for (;;) {
            System.out.println("Nhap so tien can nap: ");
            money = Integer.parseInt(sc.nextLine());
            if (money <= maxMoney) {
                break;
            }else{
                System.err.println("Tk cua ban k du");
            }
        }

        System.out.println("Nhap noi dung ghi chu: ");
        note = sc.nextLine();

        createdAt = new Date();
    }

    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Receiver{" + "money=" + money + ", note=" + note + ", createAt=" + getCreatedAtString() + '}';
    }

    public String getCreatedAtString() {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
        String str = format.format(createdAt);
        return str;
    }
}
