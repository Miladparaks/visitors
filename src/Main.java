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

//        Person person = Person
//                .builder()
//
//                .firstName("Mahdi")
//                .lastName("Parsa")
//                .age(35)
//                .nationalId("0082341253")
//                .email("mr.mpgv@gmail.com")
//                .gender(Gender.Male)
//                .phoneNumber("09122711518")
//                .status(Status.Disable)
//                .birthDate(LocalDate.now())
//                .city(City.Ahvaz)
//                .username("mr.mpgv")
//                .password("5a!@knak;fda")
//                .role(Role.Admin)
//                .medicalService(medicalService)
//                .id(12)
//                .build();



//        personDa.edit(person);
//        personDa.findByAll();


//        !!!!!!!!!!!!!!!!!!!!!!!!!!

//        System.out.println(personDa.findByUsername("mr.mpgv"));
//        System.out.println(personDa.findById(13));
//        personDa.save(person);
//        personDa.remove(12);
//        System.out.println(personDa.findByLastName("Rasoli"));
//        System.out.println(personDa.findByUserPass("mr.mpgv", "5a!@knak;fda"));


//
//        System.out.println(person);
    }


}