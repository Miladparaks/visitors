package model.bl;


import model.da.PersonDa;
import model.entity.Person;
import model.tools.CRUD;
import lombok.Getter;


import java.util.List;

public class PersonBl implements CRUD<Person> {
    @Getter
    private static PersonBl personBl = new PersonBl();

    private PersonBl() {
    }

    @Override
    public Person save(Person person) throws Exception {
        try(PersonDa personDa= new PersonDa()){
            return personDa.save(person);
        }

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
}
