package com.example.joshu.fyp;

public class User {

    String  name, address, nric, gender, dateofbirth,
            email, mobile, parentscontact, parentsname, race, nationality, medical;
    boolean selected;
    int attendancevalue;

    public User() {
    }

    public String getMedical() {
        return medical;
    }

    public void setMedical(String medical) {
        this.medical = medical;
    }

    public int getAttendancevalue() {
        return attendancevalue;
    }

    public void setAttendancevalue(int attendancevalue) {
        this.attendancevalue = attendancevalue;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNric() {
        return nric;
    }

    public void setNric(String nric) {
        this.nric = nric;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getParentscontact() {
        return parentscontact;
    }

    public void setParentscontact(String parentscontact) {
        this.parentscontact = parentscontact;
    }

    public String getParentsname() {
        return parentsname;
    }

    public void setParentsname(String parentsname) {
        this.parentsname = parentsname;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
