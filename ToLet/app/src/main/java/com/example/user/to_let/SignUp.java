package com.example.user.to_let;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends Fragment {
    private Button signUpButton,signIn;
    private EditText FirstNameEdittext,LastNameEdittext,
            EmailEdittext,PhonenumberEdittext, passwordEditText,DateEdittext;
    DataBaseHelper dataBaseHelper;


    UserDetails userDetails;

    public SignUp(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.signup, container, false);


        FirstNameEdittext = (EditText)v.findViewById(R.id.first_name_etxt);
        LastNameEdittext = (EditText)v.findViewById(R.id.last_name_etxt);
        EmailEdittext = (EditText) v.findViewById(R.id.email_etxt);
        PhonenumberEdittext= (EditText)v.findViewById(R.id.phoneNumber_etxt);
        passwordEditText = (EditText) v.findViewById(R.id.password_etxt);
        DateEdittext = (EditText) v.findViewById(R.id.ConfirmPassword_etxt);

        dataBaseHelper = new DataBaseHelper(getActivity());


        userDetails = new UserDetails();


        final Button sign_up_btn = v.findViewById(R.id.signUpHereButtonId);
        sign_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId()==R.id.signUpHereButtonId){

                    String FirstName = FirstNameEdittext.getText().toString();
                    String LastName = LastNameEdittext.getText().toString();
                    String Email = EmailEdittext.getText().toString();
                    String PhoneNumber = PhonenumberEdittext.getText().toString();
                    String Password = passwordEditText.getText().toString();
                    String Date = DateEdittext.getText().toString();

                    userDetails.setFirstName(FirstName);
                    userDetails.setLastName(LastName);
                    userDetails.setEmail(Email);
                    userDetails.setPhonenumber(PhoneNumber);
                    userDetails.setPassword(Password);
                    userDetails.setDate(Date);
                    if(FirstName.isEmpty()){
                        FirstNameEdittext.setError(" FirstName Missing");
                        FirstNameEdittext.requestFocus();
                    }
                    if(LastName.isEmpty()){
                        LastNameEdittext.setError("LastName Missing");
                        LastNameEdittext.requestFocus();
                    }
                    if(Email.isEmpty()){
                        EmailEdittext.setError("Email Missing");
                        EmailEdittext.requestFocus();
                    }
                    if(PhoneNumber.isEmpty()){
                        PhonenumberEdittext.setError("PhoneNumber Missing");
                        PhonenumberEdittext.requestFocus();
                    }
                    if(Password.isEmpty()){
                        passwordEditText.setError("Password Missing");
                        passwordEditText.requestFocus();
                    }
                    if(Date.isEmpty()){
                        DateEdittext.setError("Date Missing");
                        DateEdittext.requestFocus();
                    }

/*

        if (name.isEmpty()||email.isEmpty()||userName.isEmpty()||password.isEmpty()){
            Toast.makeText(this, "Data missing", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "SignUp Successfully", Toast.LENGTH_SHORT).show();
        }

*/


                    long rowId = dataBaseHelper.insertData(userDetails);


                    if (rowId > 0) {
                        Toast.makeText(getActivity(), "Row " + rowId + "is successfully inserted...", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "Row inserted failed.....", Toast.LENGTH_SHORT).show();
                    }
                }


                else if (v.getId()==R.id.logInButtonId){
                    LogIn logIn = new LogIn();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.mainLayout,
                            logIn,logIn.getTag()).commit();

                }


            }



        });


        return v;
    }
}
