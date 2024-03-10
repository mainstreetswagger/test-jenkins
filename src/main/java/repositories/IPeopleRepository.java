package repositories;

import dto.PersonDto;
import models.Person;

import java.util.List;

public interface IPeopleRepository {
    List<Person> getAll();
    int add(PersonDto person);
    boolean update(Person person);
    boolean delete(int id);
}
