package com.my.etender;

public class Users {

    public String name;
    public String email;
    public String passw;
    public Users(String name, String email,String passw) {
        this.name = name;
        // this.image = image;
        this.email = email;
        this.passw = passw;

    }

    public Users(){

    }

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }

    public String getPass() {
        return passw;
    }
//
//    public String getImage() {
//        return image;
//    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPass(String passw) {
        this.passw = passw;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public void setImage(String image) {
//        this.image = image;
//    }
}
