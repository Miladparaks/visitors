package model.da;

import model.entity.Person;
import model.entity.enums.Gender;
import model.entity.enums.Role;
import model.entity.enums.Status;
import model.tools.CRUD;
import model.tools.ConnectionProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDa implements AutoCloseable, CRUD<Person> {
    private static Connection connection;
    private static PreparedStatement preparedStatement;

    public PersonDa() throws SQLException {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }

    @Override
    public Person save(Person person) throws Exception {
        person.setId(ConnectionProvider.getConnectionProvider().getNextId("PERSON_SEQ"));
        preparedStatement = connection.prepareStatement(
                "INSERT INTO PERSON (ID, FIRSTNAME, LASTNAME, AGE, NATIONALID, EMAIL, GENDER, PHONENUMBER, PERSONSTATUS, PERSONBIRTHDATE, CITY, USERNAME, PASSWORD, ROLE, SERVICE_ID) VALUES" +
                        " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
        );
        preparedStatement.setInt(1, person.getId());
        preparedStatement.setString(2, person.getFirstName());
        preparedStatement.setString(3, person.getLastName());
        preparedStatement.setInt(4, person.getAge());
        preparedStatement.setString(5, person.getNationalId());
        preparedStatement.setString(6, person.getEmail());
        preparedStatement.setString(7, person.getGender().toString());
        preparedStatement.setString(8, person.getPhoneNumber());
        preparedStatement.setString(9, person.getStatus().toString());
        preparedStatement.setDate(10, Date.valueOf(person.getBirthDate()));
        preparedStatement.setString(11, person.getCity().toString());
        preparedStatement.setString(12, person.getUsername());
        preparedStatement.setString(13, person.getPassword());
        preparedStatement.setString(14, person.getRole().toString());
        preparedStatement.setInt(15, person.getMedicalService().getServiceId());
        preparedStatement.execute();
        return person;
    }

    @Override
    public Person edit(Person person) throws Exception {
        return null;
    }

    @Override
    public Person remove(int id) throws Exception {
        return null;
    }

    @Override
    public List<Person> findAll() throws Exception {
        return null;
    }

    @Override
    public Person findById(int id) throws Exception {
        return null;
    }


//    public void save(Person person) throws SQLException {
//
//
//    }
//
//
//    public List<Person> findByLastName(String lastname) throws SQLException {
//
//        List<Person>  personList = new ArrayList<>();
//
//        preparedStatement = connection.prepareStatement("select * from PERSON where lastname like ? order by ID ASC");
//        preparedStatement.setString(1, "%" + lastname + "%");
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//
//        while (resultSet.next()) {
//            Person person = Person
//                    .builder()
//                    .id(resultSet.getInt("PERSON_ID"))
//                    .firstName(resultSet.getString("FIRSTNAME"))
//                    .lastName(resultSet.getString("LASTNAME"))
//                    .nationalId(resultSet.getString("NATIONALID"))
//                    .email(resultSet.getString("EMAIL"))
//                    .gender(Gender.valueOf(resultSet.getString("GENDER")))
//                    .phoneNumber(resultSet.getString("PHONENUMBER"))
//                    .status(Status.valueOf(resultSet.getString("PERSONSTATUS")))
//                    .username(resultSet.getString("USERNAME"))
//                    .password(resultSet.getString("PASSWORD"))
//                    .build();
//
//            personList.add(person);
//        }
//        return personList;
//    }
//
//
//
//    public Person findByUsername(String username) throws SQLException {
//
//        preparedStatement = connection.prepareStatement("select * from PERSON where username like ? order by ID ASC");
//        preparedStatement.setString(1, "%" + username + "%");
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        Person person = null;
//
//        if (resultSet.next()) {
//            person = Person
//                    .builder()
//                    .id(resultSet.getInt("PERSON_ID"))
//                    .firstName(resultSet.getString("FIRSTNAME"))
//                    .lastName(resultSet.getString("LASTNAME"))
//                    .nationalId(resultSet.getString("NATIONALID"))
//                    .email(resultSet.getString("EMAIL"))
//                    .gender(Gender.valueOf(resultSet.getString("GENDER")))
//                    .phoneNumber(resultSet.getString("PHONENUMBER"))
//                    .status(Status.valueOf(resultSet.getString("PERSONSTATUS")))
//                    .username(resultSet.getString("USERNAME"))
//                    .password(resultSet.getString("PASSWORD"))
//                    .build();
//
//        }
//        return person;
//    }
//
//
//
//    public Person findByUserPass(String username, String password) throws SQLException {
//
//        preparedStatement = connection.prepareStatement("select * from PERSON where username like ? and password like ? order by ID ASC");
//        preparedStatement.setString(1, "%" + username + "%");
//        preparedStatement.setString(2, "%" + password + "%");
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        Person person = null;
//
//        if (resultSet.next()) {
//            person = Person
//                    .builder()
//                    .id(resultSet.getInt("PERSON_ID"))
//                    .firstName(resultSet.getString("FIRSTNAME"))
//                    .lastName(resultSet.getString("LASTNAME"))
//                    .nationalId(resultSet.getString("NATIONALID"))
//                    .email(resultSet.getString("EMAIL"))
//                    .gender(Gender.valueOf(resultSet.getString("GENDER")))
//                    .phoneNumber(resultSet.getString("PHONENUMBER"))
//                    .status(Status.valueOf(resultSet.getString("PERSONSTATUS")))
//                    .username(resultSet.getString("USERNAME"))
//                    .password(resultSet.getString("PASSWORD"))
//                    .build();
//
//        }
//        return person;
//    }
//
//    public Person findByRole(Role role) throws SQLException {
//
//        preparedStatement = connection.prepareStatement("select * from PERSON where role like ? order by ID ASC");
//        preparedStatement.setString(1, "%" + role + "%");
//
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        Person person = null;
//
//        if (resultSet.next()) {
//            person = Person
//                    .builder()
//                    .id(resultSet.getInt("PERSON_ID"))
//                    .firstName(resultSet.getString("FIRSTNAME"))
//                    .lastName(resultSet.getString("LASTNAME"))
//                    .nationalId(resultSet.getString("NATIONALID"))
//                    .email(resultSet.getString("EMAIL"))
//                    .gender(Gender.valueOf(resultSet.getString("GENDER")))
//                    .phoneNumber(resultSet.getString("PHONENUMBER"))
//                    .status(Status.valueOf(resultSet.getString("PERSONSTATUS")))
//                    .username(resultSet.getString("USERNAME"))
//                    .password(resultSet.getString("PASSWORD"))
//                    .build();
//
//        }
//        return person;
//    }
//
//    public Person findByService(String service) throws SQLException {
//
//        preparedStatement = connection.prepareStatement("select * from PERSON where services like ? order by ID ASC");
//        preparedStatement.setString(1, "%" + service + "%");
//
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        Person person = null;
//
//        if (resultSet.next()) {
//            person = Person
//                    .builder()
//                    .id(resultSet.getInt("PERSON_ID"))
//                    .firstName(resultSet.getString("FIRSTNAME"))
//                    .lastName(resultSet.getString("LASTNAME"))
//                    .nationalId(resultSet.getString("NATIONALID"))
//                    .email(resultSet.getString("EMAIL"))
//                    .gender(Gender.valueOf(resultSet.getString("GENDER")))
//                    .phoneNumber(resultSet.getString("PHONENUMBER"))
//                    .status(Status.valueOf(resultSet.getString("PERSONSTATUS")))
//                    .username(resultSet.getString("USERNAME"))
//                    .password(resultSet.getString("PASSWORD"))
//                    .build();
//
//        }
//        return person;
//    }
//
//    //Edit Section
//
////    public void edit(Person person) throws SQLException {
////        preparedStatement = connection.prepareStatement(
////                "UPDATE PERSON SET FIRSTNAME = ?, LASTNAME = ?, AGE = ?, NATIONALID = ?, EMAIL = ?, GENDER = ? , PHONENUMBER = ?, personStatus = ? , personBirthdate = ? , city = ? , username = ?, password = ? , role = ?, service_id = ? WHERE ID = ?"
////        );
////
////        preparedStatement.setString(1, person.getFirstName());
////        preparedStatement.setString(2, person.getLastName());
////        preparedStatement.setString(3, String.valueOf(person.getAge()));
////        preparedStatement.setString(4, person.getNationalId());
////        preparedStatement.setString(5, person.getEmail());
////        preparedStatement.setString(6, person.getGender().toString());
////        preparedStatement.setString(7, person.getPhoneNumber());
////        preparedStatement.setString(8, person.getStatus().toString());
////        preparedStatement.setDate(9, Date.valueOf(person.getBirthDate()));
////        preparedStatement.setString(10, person.getCity().toString());
////        preparedStatement.setString(11, person.getUsername());
////        preparedStatement.setString(12, person.getPassword());
////        preparedStatement.setString(13, person.getRole().toString());
////        preparedStatement.setInt(14, Integer.parseInt(person.getServices().toString()));
////        preparedStatement.setInt(15, person.getId());
////        preparedStatement.execute();
////
////    }
////
////    //Delete Section
////    public void remove(int id) throws SQLException {
////        preparedStatement = connection.prepareStatement(
////                "DELETE FROM PERSON WHERE ID = ?"
////        );
////
////        preparedStatement.setInt(1, id);
////        preparedStatement.execute();
////
////    }
////
////    public static List<Person> findAll() throws SQLException {
////        List<Person> personList = new ArrayList<>();
////
////        preparedStatement = connection.prepareStatement("SELECT * FROM PERSON ORDER BY PERSON_ID DESC");
////        ResultSet resultSet = preparedStatement.executeQuery();
////// اینا سبزارو از دیتا بیس قرار میخونیم؟
////        while (resultSet.next()) {
////            Person person = Person.builder()
////                    .id(resultSet.getInt("PERSON_ID"))
////                    .firstName(resultSet.getString("FIRSTNAME"))
////                    .lastName(resultSet.getString("LASTNAME"))
////                    .age(String.valueOf(resultSet.getInt("AGE")))
////                    .nationalId(resultSet.getString("NATIONALID"))
////                    .email(resultSet.getString("EMAIL"))
////                    .gender(Gender.valueOf(resultSet.getString("GENDER")))
////                    .phoneNumber(resultSet.getString("PHONENUMBER"))
////                    .status(Status.valueOf(resultSet.getString("PERSONSTATUS")))
////                    .birthDate(resultSet.getDate("PERSONBIRTHDATE").toLocalDate())
////                    .city(City.valueOf(resultSet.getString("CITY")))
////                    .username(resultSet.getString("USERNAME"))
////                    .password(resultSet.getString("PASSWORD"))
////                    .role(Role.valueOf(resultSet.getString("ROLE")))
////                    .services(Services.builder().serviceId(resultSet.getInt("ID")).build())
////                    .build();
////        }
////
////        return personList;
////
////    }
////
////
////    public Person findById(int id) throws SQLException {
////
////        preparedStatement = connection.prepareStatement("SELECT * FROM PERSON WHERE ID = ?");
////        preparedStatement.setInt(1, id);
////        ResultSet resultSet = preparedStatement.executeQuery();
////
////        Person person = null;
////        if (resultSet.next()) {
////            person = Person
////                    .builder()
////                    .id(resultSet.getInt("PERSON_ID"))
////                    .firstName(resultSet.getString("FIRSTNAME"))
////                    .lastName(resultSet.getString("LASTNAME"))
////                    .age(String.valueOf(resultSet.getInt("AGE")))
////                    .nationalId(resultSet.getString("NATIONALID"))
////                    .email(resultSet.getString("EMAIL"))
////                    .gender(Gender.valueOf(resultSet.getString("GENDER")))
////                    .phoneNumber(resultSet.getString("PHONENUMBER"))
////                    .status(Status.valueOf(resultSet.getString("PERSONSTATUS")))
////                    .birthDate(resultSet.getDate("PERSONBIRTHDATE").toLocalDate())
////                    .city(City.valueOf(resultSet.getString("CITY")))
////                    .username(resultSet.getString("USERNAME"))
////                    .password(resultSet.getString("PASSWORD"))
////                    .role(Role.valueOf(resultSet.getString("ROLE")))
////                    .services(Services.builder().serviceId(resultSet.getInt("Id")).build())
////                    .build();
////        }
////        return person;
////    }
////
//
//


    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }



}
