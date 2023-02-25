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
public class Receiver {

    int money;
    String note;
    Date createdAt;

    public Receiver() {
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreateAt(Date createAt) {
        this.createdAt = createdAt;
    }

    public void input() {
        System.out.println("Nhap thong tin nap tien: ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so tien can nap: ");
        money = Integer.parseInt(sc.nextLine());

        System.out.println("Nhap noi dung ghi chu: ");
        note = sc.nextLine();

        createdAt = new Date();
    }

    @Override
    public String toString() {
        return "Receiver{" + "money=" + money + ", note=" + note + ", createAt=" + getCreatedAtString() + '}';
    }
    
    public void display(){
        System.out.println(toString());
    }


    public String getCreatedAtString() {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
        String str = format.format(createdAt);
        return str;
    }

}
