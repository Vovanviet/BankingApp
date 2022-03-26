package com.bankingpgk;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class Repository {

    public List<Account>accounts;
    public List<Account>getDataGSON(){
        try {
            FileReader reader=new FileReader("account.json");
            Type objType=new TypeToken<List<Account>>(){

            }.getType();
            accounts=new Gson().fromJson(reader,objType);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return accounts;
    }
}