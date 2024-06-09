package controller;

import com.google.gson.Gson;
import model.bl.PersonBl;
import model.entity.MedicalService;
import model.entity.Person;
import model.entity.enums.City;
import model.entity.enums.Gender;
import model.entity.enums.Role;
import model.entity.enums.Status;

import javax.ws.rs.*;
import java.time.LocalDate;
import java.util.regex.Pattern;

import static model.tools.Validator.*;

public class PersonController {

    @Path("person")


    @GET
    @Produces
    public String getPerson() {
        Gson json = new Gson();
        return json.toJson(Person.builder()
                .id(10)
                .firstName("Milad")
                .lastName("Parsa")
                .build());
    }

    @POST
    public String save(
            @QueryParam("id") int id,
            @QueryParam("firstName") String firstName,
            @QueryParam("LastName") String lastName) {
        Gson json = new Gson();
        return json.toJson(Person.builder()
                .id(10)
                .firstName("Milad")
                .lastName("Parsa")
                .build());
    }

    public static String save(String firstName, String lastName, int age, String nationalId, String email, Gender gender, String phone_number, Status status, LocalDate birthDate, City city, String username, String password, Role role, MedicalService medicalService) {
        try {
            Person person = new Person();
            person.setFirstName(nameValidator(firstName, "Invalid First Name"));
            person.setLastName(nameValidator(lastName, "Invalid Last Name"));
            person.setAge(ageValidator(age, "Invalid Age, Age must be between 6 and 90"));
            person.setNationalId(nationalIdValidator(nationalId, "Invalid National ID"));
            person.setEmail(emailValidator(email, "Invalid Email Address"));
            person.setGender(gender);
            person.setPhone_number(phone_number);
            person.setStatus(status);
            person.setBirthDate(birthDate);
            person.setCity(city);
            person.setUsername(username);
            person.setPassword(password);
            person.setRole(role);
            person.setMedicalService(medicalService);
            PersonBl.getPersonBl().save(person);
            return "Person saved in DataBase";

        } catch (Exception e) {
            return e.getMessage();
        }

    }

//    public static String edit(String firstName, String lastName, int age, String nationalId, String email, Gender gender, String phone_number, Status status, LocalDate birthDate, City city, String username, String password, Role role, MedicalService medicalService) {
//        try {
//
//
//
//            return "Person updated in DataBase";
//
//        } catch (Exception e) {
//            return e.getMessage();
//        }
//    }
}
