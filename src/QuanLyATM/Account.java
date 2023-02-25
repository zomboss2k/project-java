/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyATM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Vermouth
 */
public class Account implements IFileInfor{

    String fullName, stk, phoneNumber, address;
    int money;

    List<Receiver> receiverList = new ArrayList<>();
    List<Transfer> transferList = new ArrayList<>();

    public Account() {
    }

    public Account(String fullName, String stk, String phoneNumber, String address, int money) {
        this.fullName = fullName;
        this.stk = stk;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.money = money;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStk() {
        return stk;
    }

    public void setStk(String stk) {
        this.stk = stk;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ho ten: ");
        fullName = sc.nextLine();
        System.out.println("Nhap STK: ");
        stk = sc.nextLine();
        System.out.println("Nhap SDT: ");
        phoneNumber = sc.nextLine();
        System.out.println("Nhap dia chi: ");
        address = sc.nextLine();

        money = 0;
    }

    public void addReceiver() {
        Receiver receiver = new Receiver();
        receiver.input();
        receiverList.add(receiver);

//        Cong tien vao tai khoarn
        money += receiver.getMoney();
    }

    public void transfer() {
        Transfer transfer = new Transfer();
        transfer.input(money);
        transferList.add(transfer);

//        Cong tien vao tai khoarn
        money -= transfer.getMoney();
    }

    public void displayReceiverHistory() {
        System.out.println("Lich su nhan tien.");
        receiverList.forEach((receiver) -> {
            receiver.display();
        });
    }

    public void displayTransferHistory() {
        System.out.println("Lich su chuyen tien.");
        transferList.forEach((transfer) -> {
            transfer.display();
        });
    }

    @Override
    public String toString() {
        return "Account{" + "fullName=" + fullName + ", stk=" + stk + ", phoneNumber=" + phoneNumber + ", address=" + address + ", money=" + money + '}';
    }

    public void display() {
        System.out.println(toString());
//        displayReceiverHistory();
//        displayTransferHistory();
    }


    @Override
    public String getHeader() {
        return "Infor: ";
    }


    @Override
    public String getFileInfor() {
        return fullName + "," + stk + "," + phoneNumber + "," + address + "," + money;
    }

    public void putFileInfor(String str) {
        String[] param = str.split(",");
        fullName = param[0];
        stk = param[1];
        phoneNumber = param[2];
        address = param[3];
        money = Integer.parseInt(param[4]);

    }

    @Override
    public void puFileInfor(String data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
