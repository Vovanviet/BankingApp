package com.bankingpgk;

public class Menu {
    public static void mainMenu(){
        System.out.println("\nChoice:\n1.Login\n2.Sign Up\nYour Choice:");
    }
    public static void loginFail(){
        System.out.println("\nPassword is not correct!!!Your must be perform:\n1.Login\n2.Forgot Password\nYour Choice:");
    }
    public static void loginSuccess(){
        System.out.println("\nLogin Success \n **************Menu*****************\n1.Change Username\n2.Change Serial\n3.Change Password\n4.Money\n5.Logout\n6.Exit Application\nYour Choice:");
    }
    public static void money(){
        System.out.println("\n________Money________\n1.View current account\n2.Send Money\n3.Deposit Money\n4.Withdraw Money\n5.TransactionHistory\n6.Home\nYour Choice:");
    }
}
