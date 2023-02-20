package com.alpha07.springmvcformtags.models;

public class Student {
    String firstName;
    String lastName;
    String email;
    String country;
    String favProgrammingLanguage;
    String[] languages;

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String getFavProgrammingLanguage() {
        return favProgrammingLanguage;
    }

    public void setFavProgrammingLanguage(String favProgrammingLanguage) {
        this.favProgrammingLanguage = favProgrammingLanguage;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
