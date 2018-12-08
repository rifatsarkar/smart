package com.example.user.to_let;

public class UserDetails {
    private String FirstName, LastName, Email, Phonenumber, Password, ConfirmPassword;

    public UserDetails() {

    }

    public UserDetails(String firstname, String lastName, String email, String phonenumber, String password, String confirmPassword) {
        FirstName = firstname;
        LastName = lastName;
        Email = email;
        Phonenumber = phonenumber;
        Password = password;
        ConfirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        Phonenumber = phonenumber;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getDate() {
        return ConfirmPassword;
    }

    public void setDate(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }
}
