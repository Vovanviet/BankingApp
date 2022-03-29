package com.bankingpgk;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TransactionHistory {
    private long id;
    private LocalDate dayTrading;
    private String description;
    private String beneficiaryAccount;
    private Double money;

    public TransactionHistory( String description, String beneficiaryAccount, Double money) {
        this.id = IdGenerate.getNewId();
        this.dayTrading = LocalDate.now();
        this.description = description;
        this.beneficiaryAccount = beneficiaryAccount;
        this.money = money;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDayTrading() {
        return dayTrading;
    }

    public void setDayTrading(LocalDate dayTrading) {
        this.dayTrading = dayTrading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBeneficiaryAccount() {
        return beneficiaryAccount;
    }

    public void setBeneficiaryAccount(String beneficiaryAccount) {
        this.beneficiaryAccount = beneficiaryAccount;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public  String toString() {
        DateTimeFormatter myFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "\n"+ " Id: " + id +"\n"+
                " Day Trading: " + dayTrading.format(myFormatter) +"\n"+
                " Description: " + description + "\n" +
                " Beneficiary Account: " + beneficiaryAccount +"\n"+
                " Money: " + Controller.formatMoney(money)+"VND"+"\n------------------------------------------" ;
    }
}
