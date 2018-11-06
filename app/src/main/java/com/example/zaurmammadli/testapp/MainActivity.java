package com.example.zaurmammadli.testapp;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LOGGG";
    private String accType = "com.company.demo.account.DEMOACCOUNT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.activity_main);

            AccountManager accountManager = AccountManager.get(this); //this is Activity
            Account account = new Account("zaurmammadli",accType);
            boolean success = accountManager.addAccountExplicitly(account,"123456",null);
            if(success){
                Log.d(TAG,"Account created");
            }else{
                Log.d(TAG,"Account creation failed. Look at previous logs to investigate");
            }

            Account[] accounts = accountManager.getAccounts();

            //accountManager.removeAccount(accounts[1], null, null);
            
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            startActivity(new Intent(MainActivity.this, com.useaccount.zaurmammadli.Accounter.SecondActivity.class));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
