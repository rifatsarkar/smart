package com.example.user.to_let;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int frValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mains);


        final Button loginsignup = findViewById(R.id.loginsignup);
        final TextView loginsignupText = findViewById(R.id.loginsignupText);

        final Button fbbutton = findViewById(R.id.fbbuton);
        final Button ggbutton = findViewById(R.id.ggbutton);

        LogIn logIn = new LogIn();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, logIn).commit();
        loginsignupText.setText("No acctount?");
        loginsignup.setText("Signup");


        loginsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getFrValue() == 1){
                    LogIn logIn = new LogIn();
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, logIn).commit();
                    loginsignupText.setText("No acctount?");
                    loginsignup.setText("Signup");
                    fbbutton.setText("Signup with Fb");
                    ggbutton.setText("Signup with GG");

                    setFrValue(0);

                } else {
                    SignUp signUp = new SignUp();
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, signUp).commit();
                    loginsignupText.setText("Has acctount?");
                    loginsignup.setText("Login");
                    fbbutton.setText("Login with Fb");
                    ggbutton.setText("Login with GG");

                    setFrValue(1);
                }




            }
        });


    }


    public int getFrValue() {
        return frValue;
    }

    public void setFrValue(int frValue) {
        this.frValue = frValue;
    }
}


