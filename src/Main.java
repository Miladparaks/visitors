
import javafx.util.converter.LocalDateStringConverter;
import model.bl.PaymentBl;
import model.bl.TimingBl;

import model.bl.VisitBl;
import model.entity.Payment;
import model.entity.Person;
import model.entity.Timing;
import model.entity.Visit;
import model.entity.enums.Status;
import model.entity.enums.VisitType;

import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) throws Exception {
//  -------------------- Visit Test --------------------

        Visit visit = Visit
                .builder()
                .customer(Person.builder().id(11).build())
                .timing(Timing.builder().timeId(19).build())
                .visitTime(LocalDateTime.now())
                .duration(20)
                .payment(Payment.builder().paymentId(12).build())
                .status(Status.Disable)
                .Id(1)
                .build();

        //        System.out.println(VisitBl.getVisitBl().save(visit));
        System.out.println(VisitBl.getVisitBl().edit(visit));

//        System.out.println(VisitBl.getVisitBl().findById(1));
//        System.out.println(VisitBl.getVisitBl().findAll());

//        System.out.println(VisitBl.getVisitBl().remove(20));


//  -------------------- Payment Test --------------------
//        Payment payment = Payment
//                .builder()
//                .paymentTime(LocalDateTime.now())
//                .paymentStatus("From now on")
//                .paymentType(VisitType.Suspend)
//                .paymentId(13)
//                .build();

//        System.out.println(PaymentBl.getPaymentBl().save(payment));
//        System.out.println(PaymentBl.getPaymentBl().edit(payment));
//        System.out.println(PaymentBl.getPaymentBl().findById(12));
//        System.out.println(PaymentBl.getPaymentBl().remove(11));
//        System.out.println(PaymentBl.getPaymentBl().findAll());


//  -------------------- Payment Test --------------------

//  -------------------- Timing Test --------------------
//        Timing timing = Timing
//                .builder()
//                .startTime(LocalDateTime.now())
//                .endTime(LocalDateTime.now().plusMinutes(30))
//                .doctor(Person.builder().id(11).build())
//                .location("Second Floor")
//                .roomNumber(14)
//                .timeId(11)
//                .build();

//        System.out.println(TimingBl.getTimingBl().save(timing));
//        System.out.println(TimingBl.getTimingBl().edit(timing));
//        System.out.println(TimingBl.getTimingBl().findById(1));
//        System.out.println(TimingBl.getTimingBl().findAll());
//        System.out.println(TimingBl.getTimingBl().remove(2));
//  -------------------- Timing Test --------------------

//  -------------------- Medical Test --------------------

//        MedicalService medicalService = MedicalService
//                .builder()
//                .serviceId(12)
//                .serviceName("Dentist")
//                .serviceDescription("Focus on the teeth, gums, and mouth")
//                .serviceType("online")
//                .serviceStatus(false)
//                .build();

//        MedicalServiceBl.getMedicalServiceBl().save(medicalService);
//        System.out.println(medicalService);
//        MedicalServiceBl.getMedicalServiceBl().remove(13);
//        System.out.println(MedicalServiceBl.getMedicalServiceBl().findById(10));
//        System.out.println(MedicalServiceBl.getMedicalServiceBl().findAll());
//        System.out.println(MedicalServiceBl.getMedicalServiceBl().findByServiceName("CheckList"));
//        MedicalServiceBl.getMedicalServiceBl().edit(medicalService);
//        System.out.println(MedicalServiceBl.getMedicalServiceBl().findByServiceType("online"));
//        MedicalServiceBl.getMedicalServiceBl().save(medicalService);
//        System.out.println(medicalService);
//  -------------------- Medical Test --------------------

//  -------------------- Person Test --------------------
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

//        System.out.println(PersonBl.getPersonBl().remove(14));
//        System.out.println(PersonBl.getPersonBl().findById(13));
//        System.out.println(PersonBl.getPersonBl().findByLastName("Rasoli"));
//        System.out.println(PersonBl.getPersonBl().findByUsername("mr.mpgv"));
//        System.out.println(PersonBl.getPersonBl().findByUserPass("mr.mpgv", "5a!@knak;fda"));
//        System.out.println(PersonBl.getPersonBl().findByService("1"));
//        System.out.println(PersonBl.getPersonBl().findAll());
//        System.out.println(PersonBl.getPersonBl().findByRole(Role.valueOf("Admin")));
//        System.out.println(PersonBl.getPersonBl().findByService(String.valueOf("1")));

//  -------------------- Person Test --------------------
    }


}