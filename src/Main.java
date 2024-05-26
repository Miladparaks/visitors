import model.da.PersonDa;
import model.entity.MedicalService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
//        Scanner sc = new Scanner(System.in);
        MedicalService medicalService = new MedicalService();
        medicalService.setServiceId(1);

        PersonDa personDa = new PersonDa();

//        Person person = Person
//                .builder()
//                .firstName("Alireza")
//                .lastName("Rasoli")
//                .age(35)
//                .nationalId("0084373493")
//                .email("m.para")
//                .gender(Gender.Male)
//                .phoneNumber("09125214118")
//                .status(Status.Enable)
//                .birthDate(LocalDate.now())
//                .city(City.Tehran)
//                .username("Alireza")
//                .password("5a!@knak;fda")
//                .role(Role.Doctor)
//                .services(services)
//                .build();

//        Person person = new Person();
//
//        System.out.println(personDa.findByUsername("mrmpgv"));

//        System.out.println(person);
    }


}