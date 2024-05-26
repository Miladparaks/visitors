import model.da.PersonDa;
import model.entity.MedicalService;
import model.entity.Person;
import model.entity.enums.City;
import model.entity.enums.Gender;
import model.entity.enums.Role;
import model.entity.enums.Status;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {


        MedicalService medicalService = new MedicalService();
        medicalService.setServiceId(1);

        PersonDa personDa = new PersonDa();

        Person person = Person
                .builder()

                .firstName("Milad")
                .lastName("Parsa")
                .age(35)
                .nationalId("0084373493")
                .email("mr.mpgv@gmail.com")
                .gender(Gender.Male)
                .phoneNumber("09122711518")
                .status(Status.Enable)
                .birthDate(LocalDate.now())
                .city(City.Ahvaz)
                .username("mr.mpgv")
                .password("5a!@knak;fda")
                .role(Role.Admin)
                .medicalService(MedicalService.builder().serviceId(2).build())
                .id(12)
                .build();


//
//        System.out.println(personDa.findByUsername("mrmpgv"));

//        personDa.save(person);

        personDa.edit(person);

        System.out.println(person);
    }


}