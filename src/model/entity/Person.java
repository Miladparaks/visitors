package model.entity;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import model.enums.City;
import model.enums.Gender;
import model.enums.Status;
import model.enums.Role;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String nationalId;
    private String email;
    private Gender gender;
    private String phoneNumber;
    private Status status;
    private LocalDate birthDate;
    private City city;
    private String username;
    private String password;
    private Role role;
    private Services services;


@Override
    public String toString(){
    Gson json = new Gson();
    return json.toJson(this);
}

}
