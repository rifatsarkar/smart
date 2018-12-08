package com.example.user.to_let;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends Fragment {
    DataBaseHelper dataBaseHelper;
    private EditText PhoneNumberEditTextId;
    private EditText passwordEditText;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.login,
                container, false);

        Button logInButtonId = view.findViewById(R.id.logInButtonId);
        PhoneNumberEditTextId = (EditText)view.findViewById(R.id.PhoneNumberEditTextId );
        passwordEditText = (EditText)view.findViewById(R.id.passWordEditTextId);

        dataBaseHelper = new DataBaseHelper(getActivity());
        SQLiteDatabase sqLiteDatabase =  dataBaseHelper.getWritableDatabase();


        logInButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Phonenumber = PhoneNumberEditTextId.getText().toString();
                String password = passwordEditText.getText().toString();


                if (v.getId()==R.id.logInButtonId){


                    Boolean result = dataBaseHelper.findPassword(Phonenumber,password);

                    if (result==true){
                        Intent intent = new Intent(getActivity(), Categories.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getActivity(), "Phone Number and password did not match..", Toast.LENGTH_SHORT).show();
                    }


                    if (Phonenumber.isEmpty()){
                        PhoneNumberEditTextId.setError("Phone Number Missing");
                        PhoneNumberEditTextId.requestFocus();
                    }

                    if (password.isEmpty()){
                        passwordEditText.setError("Password Missing");
                    }


                    if (Phonenumber.isEmpty()||password.isEmpty()){

                        Toast.makeText(getActivity(), "Invalid PhoneNumber and Password", Toast.LENGTH_LONG).show();

                    }


                }

                else if (v.getId()==R.id.signUpHereButtonId){
                    Toast.makeText(getActivity(), "Clicked on Signin", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getActivity(), Categories.class);
                    startActivity(intent);
                }


            }




        });





        return view;





    }
}
