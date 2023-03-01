package com.alpha07.springmvcformtags.models;

import com.alpha07.springmvcformtags.GmailOnly;
import jakarta.validation.constraints.*;

public class Student {

    @NotNull(message = "Mandatory field")
    @Size(min = 1, message = "Mandatory field")
    String firstName;
    String lastName;
    @NotNull(message = "Mandatory field")
    @Min(value = 1, message = "Invalid value")
    @Max(value = 24, message = "Students above 24 are not eligible")
    Integer age; // Use wrapper class to access string trimming feature
    @GmailOnly(tag = "@nitk.edu.in", message = "Only university mails accepted")
    String email;
    String country;
    @NotNull(message = "Mandatory field")
    @Pattern(regexp = "^[1-9][0-9]{5}$", message = "Invalid pincode")
    String pincode;
    String favProgrammingLanguage;
    String[] languages;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getFavProgrammingLanguage() {
        return favProgrammingLanguage;
    }

    public void setFavProgrammingLanguage(String favProgrammingLanguage) {
        this.favProgrammingLanguage = favProgrammingLanguage;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }
}
