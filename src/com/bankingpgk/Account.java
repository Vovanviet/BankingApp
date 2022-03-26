package com.bankingpgk;

public class Account {
    private long id;
    private String username;
    private String serial_card;
    private String password;
    private double current;

    public Account(long id,String seriesCard, String username,  String password, double current) {
        this.id = id;
        this.username = username;
        this.serial_card = seriesCard;
        this.password = password;
        this.current = current;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSeries_card() {
        return serial_card;
    }

    public void setSeries_card(String series_card) {
        this.serial_card = series_card;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getCurrent() {
        return current;
    }

    public void setCurrent(double current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", seriesCard='" + serial_card + '\'' +
                ", password='" + password + '\'' +
                ", current=" + current +
                '}';
    }
}
