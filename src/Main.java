import model.bl.MedicalServiceBl;
import model.bl.PersonBl;
import model.bl.TimingBl;
import model.da.PersonDa;
import model.entity.MedicalService;
import model.entity.Person;
import model.entity.Timing;
import model.entity.enums.Role;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) throws Exception {

        Timing timing = Timing
                .builder()
                .timeId(1)
                .startTime(LocalDateTime.of(2025,05,30,14,35,10))
                .endTime(LocalDateTime.of(2025,05,31,14,35,10))
                .doctor(Person.builder().id(12).build())
                .location("Room Number 25")
                .roomNumber(12)
                .build();

        System.out.println(TimingBl.getTimingBl().save(timing));


//        MedicalService medicalService = MedicalService
//                .builder()
//                .serviceId(12)
//                .serviceName("Dentist")
//                .serviceDescription("Focus on the teeth, gums, and mouth")
//                .serviceType("online")
//                .serviceStatus(false)
//                .build();
//
//        MedicalServiceBl.getMedicalServiceBl().save(medicalService);
//        System.out.println(medicalService);

//        MedicalServiceBl.getMedicalServiceBl().remove(13);
//        System.out.println(MedicalServiceBl.getMedicalServiceBl().findById(10));
//        System.out.println(MedicalServiceBl.getMedicalServiceBl().findAll());
//
//        System.out.println(MedicalServiceBl.getMedicalServiceBl().findByServiceName("CheckList"));
//
//        MedicalServiceBl.getMedicalServiceBl().edit(medicalService);

//        System.out.println(MedicalServiceBl.getMedicalServiceBl().findByServiceType("online"));


//        MedicalServiceBl.getMedicalServiceBl().save(medicalService);
//        System.out.println(medicalService);


//        Person person = Person
//                .builder()
//                .firstName("Ahmad")
//                .lastName("Mesbah")
//                .age(36)
//                .nationalId("012451214")
//                .email("ahmadMesbah@gmail.com")
//                .gender(Gender.Male)
//                .phone_number("09032154320")
//                .status(Status.Enable)
//                .birthDate(LocalDate.now())
//                .city(City.Ahvaz)
//                .username("mr.mpgv")
//                .password("5a!@knak;fda")
//                .role(Role.Admin)
//                .medicalService(medicalService)
//                .build();



//        System.out.println(PersonBl.getPersonBl().remove(14
//        ));
//
//        System.out.println(PersonBl.getPersonBl().findById(13));
//        System.out.println(PersonBl.getPersonBl().findByLastName("Rasoli"));
//        System.out.println(PersonBl.getPersonBl().findByUsername("mr.mpgv"));
//        System.out.println(PersonBl.getPersonBl().findByUserPass("mr.mpgv", "5a!@knak;fda"));
//        System.out.println(PersonBl.getPersonBl().findByService("1"));

//        System.out.println(PersonBl.getPersonBl().findAll());
//        System.out.println(PersonBl.getPersonBl().findByRole(Role.valueOf("Admin")));
//        System.out.println(PersonBl.getPersonBl().findByService(String.valueOf("1")));


    }


}