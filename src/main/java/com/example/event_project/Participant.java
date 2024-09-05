package com.example.event_project;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Participant {
    private String name;
    private String email;
    private String contactNumber;

    public Participant(String name, String email, String contactNumber) {
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Email: " + email + ", Contact: " + contactNumber;
    }
}