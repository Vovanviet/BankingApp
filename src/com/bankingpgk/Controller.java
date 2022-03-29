package com.bankingpgk;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    String username;
    String serial;
    String password;
    Double money;
    int countHis=0;
    List<TransactionHistory>histories=new ArrayList<>();
    Repository repository=new Repository();
    List<Account>accounts=repository.getDataGSON();
    Scanner sc=new Scanner(System.in);
    public void home(){
        Menu.mainMenu();
        int choose=sc.nextInt();
        switch (choose){
            case 1:
                login();
                break;
            case 2:
                createNewAccount();
                break;
            default:
                System.out.println("You are choose is not invalid!");
                Menu.mainMenu();
                break;
        }
    }
    public void login(){
        boolean checklogin=false;
        while (!checklogin){
            System.out.println("Enter username:");
            username=sc.next();
            int count=0;

            for (int i=0;i<accounts.size();i++) {
                if (username.equals(accounts.get(i).getUsername())) {
                    count++;
                    System.out.println("Enter Password:");
                    password = sc.next();
                    if (password.equals(accounts.get(i).getPassword())) {
                        loginSuccess();
                        checklogin = true;
                    } else {
                        loginFail();
                        break;
                    }
                }
            }if (count==0) System.out.println("Check again username!");
        }

    }
    public void loginSuccess(){
        System.out.println("Welcome "+username+",You can the performance:");
        Menu.loginSuccess();
        int choose=sc.nextInt();
        sc.nextLine();
        switch (choose){
            case 1:
                changeUsername();
                break;
            case 2:
                changeSerial();
                break;
            case 3:
                changePassword();
                break;
            case 4:
                money();
                break;
            case 5:
                home();
                break;
            case 6:
                System.out.println("See you again!");
                System.exit(1);
                break;
            default:break;
        }
    }
    public void changeUsername(){
        boolean check=false;

        while (!check){
            try {
                System.out.println("Enter new username:");
                String newUsername=sc.nextLine();
                for (int i=0;i<accounts.size();i++){
                    if (username.equals(accounts.get(i).getUsername())) {
                        if (!newUsername.equals(accounts.get(i).getUsername())){
                            accounts.get(i).setUsername(newUsername);
                            username=newUsername;
                            System.out.println("Change Username Success");
                            check=true;
                        }else {
                            throw new RuntimeException("Username Already exist");
                        }
                    }
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage()+",Please Enter Username");
            }
        }
        loginSuccess();
    }
    public void changePassword(){
        System.out.println("Enter old password:");
        password=sc.nextLine();
        int count=0;
        for (int i=0;i<accounts.size();i++){
            if (password.equals(accounts.get(i).getPassword()) &&username.equals(accounts.get(i).getUsername())) {
                count++;
                boolean check=false;
                String newPassword=null;
                while (!check){
                    try {
                        System.out.println("Enter new password:");
                        newPassword=Validate.validatePassword(sc.nextLine());
                        check=true;
                    }catch (RuntimeException e){
                        System.out.println(e);
                    }
                }
                accounts.get(i).setPassword(newPassword);
                System.out.println("Change Password Success,Please Login Again...");
                login();
                password=newPassword;

            }

        }if (count==0){
            System.out.println("Password is not correct");
        }
    }
    public void changeSerial(){
        boolean check=false;
        String newSerial=null;
        while (!check) {
            try {


                System.out.println("Enter new Email:");
                newSerial = Validate.validateSerial(sc.nextLine());
                for (int i = 0; i < accounts.size(); i++) {
                    if (username.equals(accounts.get(i).getUsername())) {
                        if (!newSerial.equals(accounts.get(i).getSeries_card())) {
                            accounts.get(i).setUsername(newSerial);
                            System.out.println("Change Serial Success");
                        } else {
                            throw new RuntimeException("Serial Already exist");
                        }
                    }
                }
                check = true;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage() + "Please Enter Serial");
            }
        }loginSuccess();
    }
    public void loginFail(){
        Menu.loginFail();
        int choose=sc.nextInt();
        sc.nextLine();
        switch (choose){
            case 1:
                System.out.println("Login Again");
                login();
                break;
            case 2:
                forgotPassword();
                break;
        }
    }
    public void forgotPassword(){
        System.out.println("Enter your serial:");
        String serial=sc.nextLine();
        int count=0;
        for (int i = 0; i < accounts.size(); i++) {
            if (serial.equals(accounts.get(i).getSeries_card())) {
                count++;
                boolean check=false;
                while (!check){
                    try {
                        System.out.println("Enter new serial:");
                        String newPassword=Validate.validatePassword(sc.nextLine());
                        accounts.get(i).setPassword(newPassword);
                        System.out.println("Change Password Success,Login Again");
                        check=true;
                        login();
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage()+",Please login again");
                    }
                }
            }
        }if (count==0){
            System.out.println("Serial is not correct, enter serial again");
            forgotPassword();
        }
    }
    public void money(){
        System.out.println("Welcome "+username+",You can the performance:");
        Menu.money();
        int choose=sc.nextInt();
        sc.nextLine();
        switch (choose){
            case 1:
                viewMoney();
                break;
            case 2:
                sendMoney();
                break;
            case 3:
                depositMoney();
                break;
            case 4:
                withdrawMoney();
                break;
            case 5:
                transactionHistory();
                break;
            case 6:
                loginSuccess();
                break;
            default:
                break;

        }
    }
    public void createNewAccount(){
        boolean check = false;
        long id = 0;
        String newUsername = null;
        String newSerial = null;
        String newPassword = null;
        Double current=0.0;
        while (!check) {
            try {
                id = accounts.size() + 1;
                System.out.println("Please enter username:");
                newUsername = sc.next();
                System.out.println("Please enter serial:");
                newSerial = Validate.validateSerial(sc.next());
                System.out.println("Enter password");
                newPassword = Validate.validatePassword(sc.next());
                for (int i = 0; i < accounts.size(); i++) {
                    if (newUsername.equals(accounts.get(i).getUsername())) {
                        throw new RuntimeException("Username Already exist");
                    }
                    if (newSerial.equals(accounts.get(i).getSeries_card())) {
                        throw new RuntimeException("Serial Already exist");
                    }
                }
                check = true;

            } catch (RuntimeException e) {
                System.out.println(e.getMessage() + ",Please perform again");
            }
        }
        accounts.add(new Account(id, newSerial,newUsername,newPassword,current));
        System.out.println("Sign up success");
        System.out.println("Login...");
        login();
    }

    public void viewMoney(){
        boolean check=false;
        System.out.println("Enter password:");
        password=sc.nextLine();
        while (!check) {
            try {
                for (int i = 0; i < accounts.size(); i++) {
                    if (username.equals(accounts.get(i).getUsername())){
                    if (password.equals(accounts.get(i).getPassword())) {

                        System.out.println("Current account:$"+accounts.get(i).getCurrent());
                        check=true;
                        money();

                    } else {
                        System.out.println("Password is not Incorrect");
                    }
                }
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage()+",Enter Password Again");
            }
        }
    }
    public void sendMoney() {
        boolean check = false;
        System.out.println("Enter Serial Card Number:");
        serial = sc.next();
        int count=0;

        while (!check) {
            try {
                for (int i = 0; i < accounts.size(); i++) {
                    if (serial.equals(accounts.get(i).getSeries_card())) {
                        System.out.println("Enter amount want to transfer:");
                        money = sc.nextDouble();
                        count++;
                        for (int j=0;j<accounts.size();j++){
                            if (username.equals(accounts.get(j).getUsername())){
                                if (accounts.get(j).getCurrent()-money>50){
                                    System.out.println("Enter password:");
                                    password=sc.next();
                                    if (password.equals(accounts.get(j).getPassword())) {
                                        //tien tru vao ng gui
                                        accounts.get(j).setCurrent(accounts.get(j).getCurrent() - money);
                                        //tien duoc cong vao ng nhan
                                        accounts.get(i).setCurrent(accounts.get(i).getCurrent()+ money);
                                        System.out.println("Success");
                                        String des="Success";
                                        countHis+=1;

                                        histories.add(new TransactionHistory(des,accounts.get(i).getSeries_card(),money));
                                        System.out.println(histories);
                                        check = true;
                                    }
                                }else {
                                    System.out.println("Current not correct");
                                }

                            }
                        }

                    }
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }if (count==0){
                System.out.println("Can not find serial");
            }
            money();
        }
    }
    public void withdrawMoney(){
            boolean check=false;
            int count=0;

            while (!check){
                try {
                    System.out.println("Enter the amount of money you want to withdraw: ");
                    money =sc.nextDouble();
                    for (int i=0;i<accounts.size();i++){
                        if (username.equals(accounts.get(i).getUsername())){
                            count++;
                            System.out.println("Enter password:");
                            password=sc.next();
                            if (password.equals(accounts.get(i).getPassword())) {
                                if (accounts.get(i).getCurrent() - money > 50) {
                                    accounts.get(i).setCurrent(accounts.get(i).getCurrent() - money);
                                    System.out.println("Current account:" + accounts.get(i).getCurrent());
                                    String des="Success";
                                    countHis+=1;

                                    histories.add(new TransactionHistory(des,accounts.get(i).getSeries_card(),money));
                                    System.out.println(histories);
                                    check = true;
                                    money();
                                } else {
                                    System.out.println("Current not correct");
                                }
                            }else {
                                System.out.println("Password invalid");
                            }
                        }
                    }
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
                if (count==0){
                    System.out.println("Current invalid");
                }
            }
    }

    public void depositMoney(){

        System.out.println("Enter deposit transfer:");
        money = sc.nextDouble();
        boolean check=false;
        while (!check){


        for (int i=0;i<accounts.size();i++) {
            if (username.equals(accounts.get(i).getUsername())) {
                accounts.get(i).setCurrent(accounts.get(i).getCurrent() + money);
//                System.out.println("Current account:"+accounts.get(i).getCurrent());
                String des="Success";
                countHis+=1;

                histories.add(new TransactionHistory(des,accounts.get(i).getSeries_card(),money));
                System.out.println(histories);

                check=true;
                money();
            }
            else {
                throw new RuntimeException("username invalid");
            }
        }
    }
    }
    public void transactionHistory(){
        for (int i=0;i<countHis;i++){

                System.out.println(histories.get(i).toString());

        }
    }

    public static String formatMoney(long money){
        DecimalFormat formater=new DecimalFormat("###,###,##0.00");
        return formater.format(money);
    }

}
