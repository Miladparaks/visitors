package model.bl;


import model.da.PersonDa;
import model.entity.Person;
import model.entity.enums.Role;
import model.tools.CRUD;
import lombok.Getter;


import java.sql.SQLException;
import java.util.List;

public class PersonBl implements CRUD<Person> {
    @Getter
    private static PersonBl personBl = new PersonBl();

    private PersonBl() {
    }

    @Override
    public Person save(Person person) throws Exception {
        try (PersonDa personDa = new PersonDa()) {
            return personDa.save(person);
        }

    }

    @Override
    public Person edit(Person person) throws Exception {
        return null;
    }

    @Override
    public Person remove(int id) throws Exception {
        try (PersonDa personDa = new PersonDa()) {
            Person person = personDa.findById(id);

            if (person != null) {
                personDa.remove(id);
                return person;
            } else {
                throw new Exception();
            }
        }
    }

    @Override
    public List<Person> findAll() throws Exception {
        try (PersonDa personDa = new PersonDa()) {
            List<Person> personList = personDa.findAll();
            if (!personList.isEmpty()) {
                return personList;
            } else {
                throw new Exception();
            }

        }
    }

    @Override
    public Person findById(int id) throws Exception {
        try (PersonDa personDa = new PersonDa()) {
            Person person = personDa.findById(id);
            if (person != null) {
                return person;
            } else {
                throw new Exception();
            }
        }
    }

    public List<Person> findByLastName(String lastName) throws Exception {
        try (PersonDa personDa = new PersonDa()) {
            List<Person> personList = personDa.findByLastName(lastName);
            if (!personList.isEmpty()) {
                return personList;
            } else {
                throw new Exception();
            }
        }
    }

    public List<Person> findByUsername(String username) throws Exception {
        try (PersonDa personDa = new PersonDa()) {
            List<Person> personList = personDa.findByUsername(username);
            if (!personList.isEmpty()) {
                return personList;
            } else {
                throw new Exception();
            }

        }
    }

    public List<Person> findByUserPass(String username, String password) throws Exception {
        try (PersonDa personDa = new PersonDa()) {
            List<Person> personList = personDa.findByUserPass(username, password);
            if (!personList.isEmpty()) {
                return personList;
            } else {
                throw new Exception();
            }
        }
    }

    public Person findByRole(Role role) throws Exception {
        try (PersonDa personDa = new PersonDa()) {
            Person person = personDa.findByRole(role);
            if (person != null) {
                return person;
            } else {
                throw new Exception();
            }
        }


    }

    public Person findByService(String service) throws Exception {
        try (PersonDa personDa = new PersonDa()) {
            Person person = personDa.findByService(service);
            if (person != null) {
                return person;
            } else {
                throw new Exception();
            }
        }
    }


}
